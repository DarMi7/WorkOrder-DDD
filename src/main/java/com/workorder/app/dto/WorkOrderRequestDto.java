package com.workorder.app.dto;

import com.workorder.domain.wo.entity.Note;
import com.workorder.domain.wo.entity.WoPart;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author darmi
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkOrderRequestDto {

  @NotEmpty
  String id;
  @NotEmpty
  List<Long> taskIds;
  @NotEmpty
  List<WoPart> parts;

  Note currentNote;

}
