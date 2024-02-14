package com.workorder.app.dto;

import com.workorder.domain.wo.entity.Interval;
import com.workorder.domain.wo.entity.Note;
import com.workorder.domain.wo.entity.WoPart;
import com.workorder.domain.wo.entity.vb.WoStatus;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkOrderResponseDto {

  String id;

  Integer totalPoints;

  WoStatus status;

  List<TaskDto> tasks;

  List<WoPart> parts;

  Long areaId;

  Interval currentInterval;

  List<Interval> historyIntervals;

  String assetId;

  String title;

  Boolean vandalized;

  Boolean isDeleted;

  Note currentNote;

  List<Note> historyNotes;

  Date created;

  Date updated;
}
