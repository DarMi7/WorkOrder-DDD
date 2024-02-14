package com.workorder.domain.wo.repository.facade;

import com.workorder.infrastructure.persistence.dao.po.task.TaskPo;
import java.util.List;

public interface TaskRepository {

  List<TaskPo> findTaskListByIdList(List<Long> idList);
}
