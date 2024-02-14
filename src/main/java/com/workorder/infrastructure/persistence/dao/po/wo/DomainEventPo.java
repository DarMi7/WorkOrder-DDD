package com.workorder.infrastructure.persistence.dao.po.wo;

import java.util.Date;
import javax.persistence.Entity;
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
@Table(name = "tb_domain_event")
public class DomainEventPo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  Date timeStamp;
  String source;
  String data;
  String topic;

}
