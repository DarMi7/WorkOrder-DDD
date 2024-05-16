package com.workorder.infrastructure.persistence.dao.po.wo;

import com.workorder.domain.wo.entity.vb.WoStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author darmi
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_work_order")
public class WorkOrderPo {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    String id;

    Integer totalPoints;

    @Enumerated(value = EnumType.STRING)
    WoStatus status;

    @Transient
    List<WoTaskPo> tasks;

    @Transient
    List<WoPartPo> parts;

    Long areaId;

    @Transient
    List<IntervalPo> historyIntervals;

    String assetId;

    String title;

    Boolean vandalized;

    Boolean isDeleted;

    String note;

    @Transient
    List<NotePo> historyNotes;

    Date created;

    Date updated;
}
