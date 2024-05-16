package com.workorder.app.facade.client;

import com.workorder.app.dto.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "task-service", url = "${task.service.url}", path = "/tasks", contextId = "taskClient")
public interface TaskClient {
    List<TaskDto> getTasks(List<Long> ids);
}
