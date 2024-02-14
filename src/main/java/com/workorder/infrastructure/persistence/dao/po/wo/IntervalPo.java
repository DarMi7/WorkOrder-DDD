package com.workorder.infrastructure.persistence.dao.po.wo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_work_interval")
public class IntervalPo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String woId;
  Date start;
  Date end;
  Long mechId;

  public IntervalPo(String woId, Date start, Date end, Long mechId) {
    this.woId = woId;
    this.start = start;
    this.end = end;
    this.mechId = mechId;
  }
}
