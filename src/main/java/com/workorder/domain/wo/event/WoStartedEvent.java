package com.workorder.domain.wo.event;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.workorder.domain.wo.entity.vb.WoStatus;
import com.workorder.infrastructure.config.KafkaConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * @author darmi
 */
@Getter
@Setter
public class WoStartedEvent extends DomainEvent {

  private WoStatus woStatus;

  public static WoStartedEvent create(String woId) {
    WoStartedEvent woStartedEvent = new WoStartedEvent();
    Snowflake snowflake = IdUtil.createSnowflake(0, 0);
    woStartedEvent.setId(snowflake.nextIdStr());
    woStartedEvent.setTopic(KafkaConfig.WO_STARTED_EVENT);
    woStartedEvent.setData(woId);
    woStartedEvent.setWoStatus(WoStatus.START);
    return woStartedEvent;
  }

}
