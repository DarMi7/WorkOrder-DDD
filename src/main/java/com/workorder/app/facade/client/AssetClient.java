package com.workorder.app.facade.client;

import com.workorder.app.dto.AssetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asset-service", url = "${asset.service.url}", path = "/assets", contextId = "asset")
public interface AssetClient {

  @GetMapping("/iotNumber/{iotNumber}")
  AssetDto getByIotNumber(@PathVariable("iotNumber") Long iotNumber);

}
