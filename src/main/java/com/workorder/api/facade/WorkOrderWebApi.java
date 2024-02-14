package com.workorder.api.facade;

import com.workorder.api.Result;
import com.workorder.app.dto.WorkOrderResponseDto;
import com.workorder.app.service.WorkOrderWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author darmi
 */
@RestController
@RequestMapping("/web/wos")
public class WorkOrderWebApi {

  @Autowired
  private WorkOrderWebService workOrderWebService;

  @GetMapping("/{id}")
  public Result<WorkOrderResponseDto> findWoById(@PathVariable("id") String id) {
    return Result.ok(workOrderWebService.findWoById(id));
  }

}
