package com.workorder.app.event.subscirbe;

import static com.workorder.infrastructure.config.KafkaConfig.TECHNICIAN_DROP_OFF;

import com.workorder.app.dto.AssetDto;
import com.workorder.app.event.subscirbe.event.TechnicianDropOffEvent;
import com.workorder.app.facade.AssetAdaptor;
import com.workorder.domain.wo.service.WorkOrderDomainService;
import com.workorder.infrastructure.util.ObjectUtil;
import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author darmi
 */
@Component
public class KafkaEventListener {

  @Autowired
  private Executor listenerWorkExecutor;
  @Autowired
  private WorkOrderDomainService workOrderDomainService;
  @Autowired
  private AssetAdaptor assetAdaptor;

  @KafkaListener(topics = {TECHNICIAN_DROP_OFF})
  public void handlerTechnicianDropOffEvent(String event) {
    TechnicianDropOffEvent technicianDropOffEvent = ObjectUtil.jsonToObject(event,
        TechnicianDropOffEvent.class);
    AssetDto asset = assetAdaptor.getAsset(technicianDropOffEvent.getVehicleNumber());
    listenerWorkExecutor.execute(() -> workOrderDomainService.handleVehicleDropOff(asset.getId()));
  }

}
