package com.workorder.domain.task.entity;

import java.util.Date;
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
public class Task {

  String id;

  String name;

  Integer point;

  Date created;

  Date updated;

}
