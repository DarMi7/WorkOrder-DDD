package com.workorder.infrastructure.persistence.dao.po.wo;

import com.workorder.domain.wo.entity.vb.NoteType;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author darmi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_work_note")
public class NotePo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String woId;
  NoteType type;
  String note;
  Date created;

  public NotePo(String woId, NoteType type, String note, Date created) {
    this.woId = woId;
    this.type = type;
    this.note = note;
    this.created = created;
  }
}
