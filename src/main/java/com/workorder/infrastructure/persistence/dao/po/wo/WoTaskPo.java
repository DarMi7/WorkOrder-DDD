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
@Setter
@Getter
@Entity
@Table(name = "tb_work_task")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WoTaskPo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String woId;

  String name;

  Date created;

  Date updated;

  public WoTaskPo(String woId, String name) {
    this.woId = woId;
    this.name = name;
  }

}