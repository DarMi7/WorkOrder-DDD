package com.workorder.infrastructure.persistence.dao.mysql.task;

import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import org.springframework.data.repository.CrudRepository;

public interface TaskDao extends CrudRepository<TaskPo, Long> {

}
