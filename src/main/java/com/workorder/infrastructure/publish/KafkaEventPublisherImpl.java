package com.workorder.infrastructure.publish;

import com.workorder.app.event.publish.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author darmi
 */
@Component
public class KafkaEventPublisherImpl implements EventPublisher {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void push(String topic, String data) {
    kafkaTemplate.send(topic, data);
  }

}
