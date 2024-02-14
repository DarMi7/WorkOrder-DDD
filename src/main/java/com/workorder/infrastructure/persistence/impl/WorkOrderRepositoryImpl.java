package com.workorder.infrastructure.persistence.impl;

import com.workorder.domain.wo.event.DomainEvent;
import com.workorder.domain.wo.repository.facade.WorkOrderRepository;
import com.workorder.infrastructure.persistence.dao.mysql.wo.IntervalDao;
import com.workorder.infrastructure.persistence.dao.mysql.wo.NoteDao;
import com.workorder.infrastructure.persistence.dao.mysql.wo.WoPartDao;
import com.workorder.infrastructure.persistence.dao.mysql.wo.WoTaskDao;
import com.workorder.infrastructure.persistence.dao.mysql.wo.WorkOrderDao;
import com.workorder.infrastructure.persistence.dao.mysql.wo.WorkOrderEventDao;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author darmi
 */
@Component
public class WorkOrderRepositoryImpl implements WorkOrderRepository {

  @Autowired
  private WorkOrderDao workOrderDao;
  @Autowired
  private IntervalDao intervalDao;
  @Autowired
  private NoteDao noteDao;
  @Autowired
  private WoPartDao woPartDao;
  @Autowired
  private WoTaskDao taskDao;
  @Autowired
  private WorkOrderEventDao workOrderEventDao;

  @Override
  public String save(WorkOrderPo workOrderPo) {
    WorkOrderPo wo = workOrderDao.save(workOrderPo);
    if (!CollectionUtils.isEmpty(wo.getHistoryIntervals())) {
      intervalDao.saveAll(wo.getHistoryIntervals());
    }
    if (!CollectionUtils.isEmpty(wo.getHistoryNotes())) {
      noteDao.saveAll(wo.getHistoryNotes());
    }
    if (!CollectionUtils.isEmpty(wo.getTasks())) {
      taskDao.saveAll(wo.getTasks());
    }
    if (!CollectionUtils.isEmpty(wo.getParts())) {
      woPartDao.saveAll(wo.getParts());
    }
    return wo.getId();
  }

  @Override
  public WorkOrderPo findWoById(String id) {
    WorkOrderPo workOrderPo = workOrderDao.findById(id).orElse(null);
    if (workOrderPo != null) {
      workOrderPo.setHistoryIntervals(intervalDao.findAllByWoId(id));
    }
    return workOrderPo;
  }

  @Override
  public WorkOrderPo findWoByAssetId(String assetId) {
    return workOrderDao.findByAssetId(assetId);
  }

  @Override
  public void update(WorkOrderPo workOrderPo) {

    workOrderDao.findById(workOrderPo.getId()).ifPresent(e -> {
      BeanUtils.copyProperties(e, workOrderPo);
      workOrderDao.save(workOrderPo);

      if (CollectionUtils.isEmpty(workOrderPo.getHistoryNotes())) {
        workOrderPo.getHistoryNotes().forEach(n -> n.setWoId(e.getId()));
        noteDao.saveAll(workOrderPo.getHistoryNotes());
      }

      if (CollectionUtils.isEmpty(workOrderPo.getHistoryIntervals())) {
        workOrderPo.getHistoryNotes().forEach(n -> n.setWoId(e.getId()));
        intervalDao.saveAll(workOrderPo.getHistoryIntervals());
      }

      if (!CollectionUtils.isEmpty(workOrderPo.getParts())) {
        workOrderPo.getParts().forEach(n -> n.setWoId(e.getId()));
        woPartDao.deleteAllByWoId(workOrderPo.getId());
        woPartDao.saveAll(workOrderPo.getParts());
      }
    });
  }

  @Override
  public void saveEvent(DomainEvent domainEvent) {
    workOrderEventDao.save(domainEvent);
  }

}
