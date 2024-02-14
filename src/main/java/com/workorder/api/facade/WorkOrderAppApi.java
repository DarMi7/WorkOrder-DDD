package com.workorder.api.facade;

import com.workorder.api.Result;
import com.workorder.app.dto.MrRequestDto;
import com.workorder.app.dto.WorkOrderRequestDto;
import com.workorder.app.service.WorkOrderAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author darmi
 */
@RestController
@RequestMapping("/app/wos")
public class WorkOrderAppApi {

  @Autowired
  private WorkOrderAppService appService;

  @GetMapping("/{id}")
  public Result<String> createMr(@RequestBody @Validated MrRequestDto mrRequestDto) {
    return Result.ok(appService.createMr(mrRequestDto));
  }

  @PostMapping("/{id}/to-work-order")
  public Result<String> toWorkOrder(@RequestBody @Validated WorkOrderRequestDto workOrderRequestDto,
      @PathVariable("id") String id) {
    appService.toWorkOrder(workOrderRequestDto, id);
    return Result.ok();
  }

  @PostMapping("/{id}/start")
  public Result<String> start(@PathVariable("id") String id) {
    appService.start(id);
    return Result.ok();
  }

  @PostMapping("/{id}/pause")
  public Result<String> pause(@PathVariable("id") String id) {
    appService.pause(id);
    return Result.ok();
  }

  @PostMapping("/{id}/complete")
  public Result<String> complete(@PathVariable("id") String id) {
    appService.complete(id);
    return Result.ok();
  }


}
