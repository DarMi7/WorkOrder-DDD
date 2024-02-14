package com.workorder.infrastructure.persistence.dao.mysql.wo;

import com.workorder.infrastructure.persistence.dao.po.wo.NotePo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends CrudRepository<NotePo, Long> {

  void deleteAllByWoId(String woId);
}
