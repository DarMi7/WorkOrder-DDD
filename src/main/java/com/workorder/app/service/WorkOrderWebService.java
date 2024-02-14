package com.workorder.app.service;

import com.workorder.app.assembler.WorkOrderAssembler;
import com.workorder.app.dto.WorkOrderResponseDto;
import com.workorder.domain.wo.repository.facade.TaskRepository;
import com.workorder.domain.wo.repository.facade.WorkOrderRepository;
import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import com.workorder.infrastructure.persistence.dao.po.wo.WoTaskPo;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * web的增删改业务
 *
 * @author darmi
 */
@Service
public class WorkOrderWebService {

  @Autowired
  private WorkOrderRepository workOrderRepository;
  @Autowired
  private TaskRepository taskRepository;

  public WorkOrderResponseDto findWoById(String id) {
    WorkOrderPo workOrderPo = workOrderRepository.findWoById(id);
    List<Long> taskIdList = workOrderPo.getTasks().stream()
        .map(WoTaskPo::getId)
        .collect(Collectors.toList());
    List<TaskPo> taskPoList = taskRepository.findTaskListByIdList(taskIdList);
    return WorkOrderAssembler.toDto(workOrderPo, taskPoList);
  }

}
