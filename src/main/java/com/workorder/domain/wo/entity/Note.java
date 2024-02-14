package com.workorder.domain.wo.entity;

import com.workorder.domain.wo.entity.vb.NoteType;
import com.workorder.infrastructure.persistence.dao.po.wo.NotePo;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Note {

  String woId;
  NoteType type;
  @NotEmpty
  String content;
  Date created;

  public static NotePo toPo(Note note) {
    NotePo notePo = new NotePo();
    notePo.setNote(note.getContent());
    return notePo;
  }
}