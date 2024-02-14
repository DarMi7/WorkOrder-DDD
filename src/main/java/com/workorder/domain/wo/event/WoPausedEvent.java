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
public class WoPausedEvent extends DomainEvent {

  private WoStatus woStatus;

  public static WoPausedEvent create(String woId) {
    WoPausedEvent woPausedEvent = new WoPausedEvent();
    Snowflake snowflake = IdUtil.createSnowflake(0, 0);
    woPausedEvent.setId(snowflake.nextIdStr());
    woPausedEvent.setTopic(KafkaConfig.WO_PAUSED_EVENT);
    woPausedEvent.setData(woId);
    woPausedEvent.setWoStatus(WoStatus.PAUSE);
    return woPausedEvent;
  }

}
