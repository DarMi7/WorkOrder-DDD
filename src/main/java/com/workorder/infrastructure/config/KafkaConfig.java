package com.workorder.infrastructure.config;

/**
 * @author darmi
 */
public class KafkaConfig {

  public static final String WO_CREATED_EVENT = "wo:created:event";
  public static final String WO_STARTED_EVENT = "wo:started:event";
  public static final String WO_PAUSED_EVENT = "wo:paused:event";
  public static final String WO_COMPLETED_EVENT = "wo:completed:event";
  public static final String TECHNICIAN_DROP_OFF = "tech:drop-off:event";
}
