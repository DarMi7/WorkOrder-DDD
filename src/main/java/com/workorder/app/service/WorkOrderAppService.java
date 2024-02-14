package com.workorder.app.service;

import com.workorder.app.assembler.WorkOrderAssembler;
import com.workorder.app.dto.AssetDto;
import com.workorder.app.dto.MrRequestDto;
import com.workorder.app.dto.TaskDto;
import com.workorder.app.dto.WorkOrderRequestDto;
import com.workorder.app.facade.AssetAdaptor;
import com.workorder.domain.wo.LogicException;
import com.workorder.domain.wo.entity.WorkOrder;
import com.workorder.domain.wo.service.TaskDomainService;
import com.workorder.domain.wo.service.WorkOrderDomainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author darmi
 */
@Service
public class WorkOrderAppService {

  @Autowired
  private WorkOrderDomainService workOrderDomainService;
  @Autowired
  private TaskDomainService taskDomainService;
  @Autowired
  private AssetAdaptor assetAdaptor;

  public String createMr(MrRequestDto mrRequestDto) {
    AssetDto asset = assetAdaptor.getAsset(mrRequestDto.getVehicleNumber());
    if (asset == null) {
      throw new LogicException(40001, "Asset is not exited", null);
    }
    WorkOrder workOrder = WorkOrderAssembler.mrToDo(mrRequestDto, asset.getId());
    return workOrderDomainService.createMr(workOrder);
  }

  public void toWorkOrder(WorkOrderRequestDto workOrderDto, String id) {
    List<TaskDto> taskList = taskDomainService.find(workOrderDto.getTaskIds());
    WorkOrder workOrder = WorkOrderAssembler.toDo(workOrderDto, taskList);
    workOrder.setId(id);
    workOrderDomainService.toWorkOrder(workOrder);
  }

  public void start(String id) {
    workOrderDomainService.start(id);
  }

  public void pause(String id) {
    workOrderDomainService.pause(id);
  }

  public void complete(String id) {
    workOrderDomainService.complete(id);
  }

}
