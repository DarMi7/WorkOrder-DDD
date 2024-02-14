package com.workorder.domain.wo.service;

import com.workorder.app.event.publish.EventPublisher;
import com.workorder.domain.wo.LogicException;
import com.workorder.domain.wo.entity.WorkOrder;
import com.workorder.domain.wo.entity.vb.WoStatus;
import com.workorder.domain.wo.event.WoCompletedEvent;
import com.workorder.domain.wo.event.WoPausedEvent;
import com.workorder.domain.wo.event.WoStartedEvent;
import com.workorder.domain.wo.repository.facade.WorkOrderRepository;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author darmi
 */
@Service
public class WorkOrderDomainService {

  @Autowired
  private WorkOrderRepository workOrderRepository;
  @Autowired
  private EventPublisher eventPublisher;

  public String createMr(WorkOrder workOrder) {
    workOrder.createMr();
    return workOrderRepository.save(WorkOrderFactory.toPo(workOrder));
  }

  public void toWorkOrder(WorkOrder workOrder) {
    WorkOrderPo workOrderPo = workOrderRepository.findWoById(workOrder.getId());
    if (WoStatus.MAINTENANCE_REQUEST != workOrderPo.getStatus()) {
      throw new LogicException(40001, "Wo is not exsited", null);
    }
    workOrder.toWorkOrder();
    workOrder.addHistoryIntervals();
    workOrder.addHistoryNotes();
    workOrderRepository.update(WorkOrderFactory.toPo(workOrder));
  }

  /**
   * 实体配合完成领域内的业务
   *
   * @param id 工单id
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public void complete(String id) {
    //1.在领域服务层验证数据是否存在。
    WorkOrderPo workOrderPo = checkWoExisted(id);
    //2.然后转换为领域对象完成领域业务。
    WorkOrder workOrder = WorkOrderFactory.toDo(workOrderPo);
    workOrder.complete();
    workOrderRepository.save(WorkOrderFactory.toPo(workOrder));
    //3. 保存 领域事件
    WoCompletedEvent woCompletedEvent = WoCompletedEvent.create(workOrder.getParts());
    //4. push 领域事件
    workOrderRepository.saveEvent(woCompletedEvent);
    eventPublisher.push(woCompletedEvent.getTopic(), woCompletedEvent.getData());
  }

  public void start(String id) {
    //1.在领域服务层验证数据是否存在。
    WorkOrderPo workOrderPo = checkWoExisted(id);
    //2.然后转换为领域对象完成领域业务。
    WorkOrder workOrder = WorkOrderFactory.toDo(workOrderPo);
    workOrder.start();
    workOrder.addHistoryIntervals();
    workOrderRepository.save(WorkOrderFactory.toPo(workOrder));
    //3. 保存 领域事件
    WoStartedEvent woStartedEvent = WoStartedEvent.create(workOrder.getId());
    workOrderRepository.saveEvent(woStartedEvent);
    //4. push 领域事件
    eventPublisher.push(woStartedEvent.getTopic(), woStartedEvent.getData());

  }

  public void pause(String id) {
    //1.在领域服务层验证数据是否存在。
    WorkOrderPo workOrderPo = checkWoExisted(id);
    //2.然后转换为领域对象完成领域业务。
    WorkOrder workOrder = WorkOrderFactory.toDo(workOrderPo);
    workOrder.pause();
    workOrder.addHistoryIntervals();
    workOrderRepository.save(WorkOrderFactory.toPo(workOrder));
    //3. 保存 领域事件
    WoPausedEvent woPausedEvent = WoPausedEvent.create(workOrder.getId());
    workOrderRepository.saveEvent(woPausedEvent);
    //4. push 领域事件
    eventPublisher.push(woPausedEvent.getTopic(), woPausedEvent.getData());
  }

  @Transactional(rollbackFor = Exception.class)
  public void handleVehicleDropOff(String assetId) {
    WorkOrderPo workOrderPo = workOrderRepository.findWoByAssetId(assetId);
    if (WoStatus.OPEN != workOrderPo.getStatus()) {
      throw new LogicException(40001, "Wo is not existed", null);
    }
    complete(workOrderPo.getId());
  }

  private WorkOrderPo checkWoExisted(String id) {
    WorkOrderPo workOrderPo = workOrderRepository.findWoById(id);
    if (WoStatus.OPEN != workOrderPo.getStatus()) {
      throw new LogicException(40001, "Wo is not existed", null);
    }
    return workOrderPo;
  }

}
