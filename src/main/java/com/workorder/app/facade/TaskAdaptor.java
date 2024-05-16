package com.workorder.app.facade;

import com.workorder.app.dto.TaskDto;
import com.workorder.app.facade.client.TaskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskAdaptor {
    @Autowired
    private TaskClient taskClient;

    public List<TaskDto> getTasks(List<Long> ids) {
        return taskClient.getTasks(ids);
    }
}
