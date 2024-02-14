package com.workorder.infrastructure.persistence.dao.po.task;

import com.workorder.domain.task.entity.vb.TaskType;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author darmi
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_task")
public class TaskPo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  String id;

  Integer points;

  String name;

  @Enumerated(value = EnumType.STRING)
  TaskType taskType;

  Date created;

  Date updated;
}
