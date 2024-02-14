package com.workorder.infrastructure.persistence.dao.po.wo;

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

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@Table(name = "tb_work_part")
public class WoPartPo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String woId;
  String sku;
  String name;
  Integer count;

  public WoPartPo(String woId, String sku, String name, Integer count) {
    this.woId = woId;
    this.sku = sku;
    this.name = name;
    this.count = count;
  }
}
