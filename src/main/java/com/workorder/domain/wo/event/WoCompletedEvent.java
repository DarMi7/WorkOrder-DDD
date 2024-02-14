package com.workorder.domain.wo.event;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.workorder.domain.wo.entity.WoPart;
import com.workorder.domain.wo.entity.vb.WoStatus;
import com.workorder.infrastructure.config.KafkaConfig;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author darmi
 */
@Getter
@Setter
public class WoCompletedEvent extends DomainEvent {

  private WoStatus woStatus;

  public static WoCompletedEvent create(List<WoPart> woParts) {
    WoCompletedEvent woCompletedEvent = new WoCompletedEvent();
    Snowflake snowflake = IdUtil.createSnowflake(0, 0);
    woCompletedEvent.setId(snowflake.nextIdStr());
    woCompletedEvent.setTopic(KafkaConfig.WO_COMPLETED_EVENT);
    woCompletedEvent.setData(JSON.toJSONString(woParts));
    woCompletedEvent.setWoStatus(WoStatus.COMPLETE);
    return woCompletedEvent;
  }

}
