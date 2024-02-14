package com.workorder.app.event.publish;

/**
 * @author darmi
 */
public interface EventPublisher {

  void push(String topic, String data);
}
