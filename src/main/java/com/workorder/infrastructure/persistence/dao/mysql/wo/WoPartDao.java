package com.workorder.infrastructure.persistence.dao.mysql.wo;

import com.workorder.infrastructure.persistence.dao.po.wo.WoPartPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoPartDao extends CrudRepository<WoPartPo, Long> {

  void deleteAllByWoId(String woId);
}
