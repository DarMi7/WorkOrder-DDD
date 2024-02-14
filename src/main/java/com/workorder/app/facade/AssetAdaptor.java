package com.workorder.app.facade;

import com.workorder.app.dto.AssetDto;
import com.workorder.app.facade.client.AssetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author darmi
 */
@Component
public class AssetAdaptor {

  @Autowired
  private AssetClient assetClient;

  public AssetDto getAsset(Long iotNumber) {
    return assetClient.getByIotNumber(iotNumber);
  }

}
