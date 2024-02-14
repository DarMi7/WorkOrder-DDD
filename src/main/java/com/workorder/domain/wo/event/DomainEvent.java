package com.workorder.domain.wo.event;

import java.util.Date;
import javax.persistence.GeneratedValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

/**
 * @author darmi
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DomainEvent {

  @Id
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @GeneratedValue(generator = "idGenerator")
  String id;
  Date timeStamp;
  String source;
  String data;
  String topic;
}
