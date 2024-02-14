package com.workorder.infrastructure.persistence.impl;

import com.workorder.domain.wo.repository.facade.TaskRepository;
import com.workorder.infrastructure.persistence.dao.mysql.task.TaskDao;
import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author darmi
 */
@Component
public class TaskRepositoryImpl implements TaskRepository {

  @Autowired
  private TaskDao taskDao;

  @Override
  public List<TaskPo> findTaskListByIdList(List<Long> idList) {
    Iterable<TaskPo> taskPoIterable = taskDao.findAllById(idList);
    List<TaskPo> taskList = new LinkedList<>();
    taskPoIterable.forEach(taskList::add);
    return taskList;
  }

}
