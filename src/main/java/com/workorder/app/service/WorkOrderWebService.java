package com.workorder.app.service;

import com.workorder.app.assembler.WorkOrderAssembler;
import com.workorder.app.dto.WorkOrderResponseDto;
import com.workorder.app.facade.TaskAdaptor;
import com.workorder.domain.wo.repository.facade.WorkOrderRepository;
import com.workorder.infrastructure.persistence.dao.po.wo.WoTaskPo;
import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * web的增删改业务
 *
 * @author darmi
 */
@Service
public class WorkOrderWebService {

    @Autowired
    private WorkOrderRepository workOrderRepository;
    @Autowired
    private TaskAdaptor taskAdaptor;

    public WorkOrderResponseDto findWoById(String id) {
        WorkOrderPo workOrderPo = workOrderRepository.findWoById(id);
        List<Long> taskIds = workOrderPo.getTasks().stream()
                .map(WoTaskPo::getId)
                .collect(Collectors.toList());
        return WorkOrderAssembler.toDto(workOrderPo, taskAdaptor.getTasks(taskIds));
    }

}
