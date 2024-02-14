package com.workorder.domain.wo.service;

import com.workorder.app.assembler.TaskAssembler;
import com.workorder.app.dto.TaskDto;
import com.workorder.domain.wo.repository.facade.TaskRepository;
import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author darmi
 */
@Service
public class TaskDomainService {

  @Autowired
  private TaskRepository taskRepository;

  public List<TaskDto> find(List<Long> idList) {
    List<TaskPo> taskListByIdList = taskRepository.findTaskListByIdList(idList);
    return TaskAssembler.toDtoList(taskListByIdList);
  }

}
