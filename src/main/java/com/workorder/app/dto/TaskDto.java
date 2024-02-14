package com.workorder.app.dto;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {

  String id;

  Integer point;

  String name;

  Date created;

  Date updated;

  public TaskDto(String id, Integer point) {
    this.id = id;
    this.point = point;
  }
}
