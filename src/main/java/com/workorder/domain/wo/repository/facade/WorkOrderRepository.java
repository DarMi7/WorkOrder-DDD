package com.workorder.domain.wo.repository.facade;

import com.workorder.domain.wo.event.DomainEvent;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;

public interface WorkOrderRepository {

  String save(WorkOrderPo workOrderPo);

  WorkOrderPo findWoById(String id);

  WorkOrderPo findWoByAssetId(String assetId);

  void update(WorkOrderPo workOrderPo);

  void saveEvent(DomainEvent completedEvent);
}
