package com.workorder.domain.wo.entity;

import com.workorder.domain.wo.entity.vb.NoteType;
import com.workorder.domain.wo.entity.vb.WoStatus;
import com.workorder.domain.wo.entity.vb.WoTask;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
public class WorkOrder {

  static final int MAX_POINT = 18;

  String id;

  Integer totalPoints;

  WoStatus status;

  List<WoTask> tasks;

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

  public void createMr() {
    status = WoStatus.MAINTENANCE_REQUEST;
    created = new Date();
    updated = new Date();
  }

  public void toWorkOrder() {
    this.status = WoStatus.OPEN;
    if (currentNote != null) {
      currentNote.setType(NoteType.MECH);
      currentNote.setWoId(id);
    }
    this.totalPoints = calculatePoint();
  }

  public void start() {
    status = WoStatus.START;
    currentInterval.setStart(new Date());
    currentInterval.setWoId(id);
  }

  public void pause() {
    status = WoStatus.PAUSE;
    currentInterval.setWoId(id);
    currentInterval.setEnd(new Date());
  }

  public void complete() {
    status = WoStatus.COMPLETE;
  }


  public void addHistoryIntervals() {
    if (historyIntervals == null) {
      historyIntervals = new LinkedList<>();
    }
    historyIntervals.add(currentInterval);
  }

  public int calculatePoint() {
    Integer totalPoint = tasks.stream()
        .map(WoTask::getPoint)
        .reduce(0, Integer::sum);
    return Math.min(totalPoint, MAX_POINT);
  }

  public void addHistoryNotes() {
    if (historyNotes == null) {
      historyNotes = new LinkedList<>();
    }
    historyNotes.add(currentNote);
  }
}
