package com.workorder.infrastructure.persistence.dao.mysql.wo;

import com.workorder.infrastructure.persistence.dao.po.wo.WoTaskPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoTaskDao extends CrudRepository<WoTaskPo, String> {

}
