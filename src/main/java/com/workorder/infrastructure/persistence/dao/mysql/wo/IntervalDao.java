package com.workorder.infrastructure.persistence.dao.mysql.wo;

import com.workorder.infrastructure.persistence.dao.po.wo.IntervalPo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalDao extends CrudRepository<IntervalPo, Long> {

  List<IntervalPo> findAllByWoId(String woId);

  void deleteAllByWoId(String woId);
}
