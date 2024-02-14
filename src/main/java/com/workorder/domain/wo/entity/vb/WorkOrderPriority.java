package com.workorder.domain.wo.entity.vb;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WorkOrderPriority {
  HIGH(0, 4), MEDIUM(4, 7), LOW(7, Integer.MAX_VALUE);
  Integer from;
  Integer to;
}