package com.workorder.app.assembler;

import com.workorder.app.dto.TaskDto;
import com.workorder.domain.task.entity.Task;
import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author darmi
 */
public class TaskAssembler {


  public static List<TaskDto> toDtoList(List<TaskPo> tasks) {
    return tasks.stream().map(e -> new TaskDto(e.getId(), e.getPoints()))
        .collect(Collectors.toList());
  }

  public static TaskDto toDto(Task task) {
    return new TaskDto(task.getId(), task.getPoint(), task.getName(), task.getCreated(),
        task.getUpdated());
  }

}
