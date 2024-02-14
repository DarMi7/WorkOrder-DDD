package com.workorder.app.dto;

import com.workorder.domain.wo.entity.Note;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class MrRequestDto {

  @NotNull
  Long areaId;
  @NotNull
  Long vehicleNumber;
  @NotEmpty
  String title;
  @NotNull
  Boolean vandalized;
  @Valid
  @NotNull
  Note currentNote;
}
