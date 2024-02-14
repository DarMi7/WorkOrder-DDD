package com.workorder.infrastructure.persistence.dao.mysql.wo;

import com.workorder.infrastructure.persistence.dao.po.wo.WorkOrderPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author darmi
 */
@Repository
public interface WorkOrderDao extends CrudRepository<WorkOrderPo, String> {

  WorkOrderPo findByAssetId(String assetId);
}
