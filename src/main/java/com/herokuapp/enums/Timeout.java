package com.herokuapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum to model the timeout in some wait methods. */
@Getter
@AllArgsConstructor
public enum Timeout {
  LOW_TIME(1),
  MINOR_TIME(2),
  MEDIUM_TIME(5),
  HIGH_TIME(10),
  VERY_HIGH_TIME(20);

  private final int time;
}
