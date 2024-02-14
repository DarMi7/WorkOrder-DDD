package com.workorder.infrastructure.persistence.dao.mysql.wo;

import com.workorder.domain.wo.event.DomainEvent;
import com.workorder.infrastructure.persistence.dao.po.wo.DomainEventPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderEventDao extends CrudRepository<DomainEventPo, Long> {

  void save(DomainEvent domainEvent);
}
