package com.workorder.app.assembler;

import com.workorder.app.dto.MrRequestDto;
import com.workorder.app.dto.TaskDto;
import com.workorder.app.dto.WorkOrderRequestDto;
import com.workorder.app.dto.WorkOrderResponseDto;
import com.workorder.domain.wo.entity.WorkOrder;
import com.workorder.domain.wo.entity.vb.WoTask;
import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author darmi
 */
public class WorkOrderAssembler {

  public static WorkOrderResponseDto toDto(WorkOrderPo workOrderPo, List<TaskPo> tasks) {
    WorkOrderResponseDto workOrderResponseDto = new WorkOrderResponseDto();
    workOrderResponseDto.setId(workOrderPo.getId());
    workOrderResponseDto.setTasks(TaskAssembler.toDtoList(tasks));
    return workOrderResponseDto;
  }

  public static WorkOrder toDo(WorkOrderRequestDto workOrderRequestDto, List<TaskDto> taskList) {
    WorkOrder workOrder = new WorkOrder();
    workOrder.setId(workOrderRequestDto.getId());
    workOrder.setTasks(toWoTaskList(taskList));
    return workOrder;
  }

  public static WorkOrder mrToDo(MrRequestDto mrRequestDto, String assetId) {
    WorkOrder workOrder = new WorkOrder();
    workOrder.setTitle(mrRequestDto.getTitle());
    workOrder.setAreaId(mrRequestDto.getAreaId());
    workOrder.setAssetId(assetId);
    workOrder.setCurrentNote(mrRequestDto.getCurrentNote());
    return workOrder;
  }

  public static List<WoTask> toWoTaskList(List<TaskDto> taskList) {
    return taskList.stream()
        .map(e -> new WoTask(e.getId(), e.getName(), e.getPoint()))
        .collect(Collectors.toList());
  }

}
