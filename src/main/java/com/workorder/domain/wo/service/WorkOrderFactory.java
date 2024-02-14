package com.workorder.domain.wo.service;

import com.workorder.domain.wo.entity.Interval;
import com.workorder.domain.wo.entity.WorkOrder;
import com.workorder.infrastructure.persistence.dao.po.wo.IntervalPo;
import com.workorder.infrastructure.persistence.dao.po.wo.NotePo;
import com.workorder.infrastructure.persistence.dao.po.wo.WoPartPo;
import com.workorder.infrastructure.persistence.dao.po.wo.WoTaskPo;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author darmi
 */
public class WorkOrderFactory {

  public static WorkOrder toDo(WorkOrderPo workOrderPo) {
    WorkOrder workOrder = new WorkOrder();
    workOrder.setAreaId(workOrderPo.getAreaId());
    List<Interval> intervals = getIntervalList(workOrderPo.getHistoryIntervals(),
        workOrder.getId());
    workOrder.setHistoryIntervals(intervals);
    return workOrder;
  }

  public static WorkOrderPo toPo(WorkOrder workOrder) {
    WorkOrderPo workOrderPo = new WorkOrderPo();
    workOrderPo.setAreaId(workOrderPo.getAreaId());
    workOrderPo.setId(workOrder.getId());
    workOrderPo.setHistoryIntervals(getIntervalPoList(workOrder));
    workOrderPo.setHistoryNotes(getNotePo(workOrder));
    workOrderPo.setParts(getPartPoList(workOrder));
    workOrderPo.setTasks(getTaskList(workOrder));
    return workOrderPo;
  }

  private static List<WoTaskPo> getTaskList(WorkOrder wo) {
    return wo.getTasks().stream()
        .map(e -> new WoTaskPo(wo.getId(), e.getName()))
        .collect(Collectors.toList());
  }

  private static List<WoPartPo> getPartPoList(WorkOrder wo) {
    return wo.getParts().stream()
        .map(e -> new WoPartPo(wo.getId(), e.getSku(), e.getName(), e.getCount()))
        .collect(Collectors.toList());
  }

  private static List<NotePo> getNotePo(WorkOrder wo) {
    return wo.getHistoryNotes().stream()
        .map(e -> new NotePo(wo.getId(), e.getType(), e.getContent(), e.getCreated()))
        .collect(Collectors.toList());
  }

  private static List<Interval> getIntervalList(List<IntervalPo> intervalPos, String woId) {
    return intervalPos.stream()
        .map(e -> new Interval(woId, e.getStart(), e.getEnd(), e.getMechId()))
        .collect(Collectors.toList());
  }

  private static List<IntervalPo> getIntervalPoList(WorkOrder wo) {
    return wo.getHistoryIntervals().stream()
        .map(e -> new IntervalPo(wo.getId(), e.getStart(), e.getEnd(), e.getMechId()))
        .collect(Collectors.toList());
  }

}
