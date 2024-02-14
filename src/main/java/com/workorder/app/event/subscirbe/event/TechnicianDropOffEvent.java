package com.workorder.app.event.subscirbe.event;

import com.workorder.infrastructure.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author darmi
 */
@Data
@AllArgsConstructor
public class TechnicianDropOffEvent {

  private Long vehicleNumber;

  public static TechnicianDropOffEvent deserialize(String eventData) {
    return ObjectUtil.jsonToObject(eventData, TechnicianDropOffEvent.class);
  }
}