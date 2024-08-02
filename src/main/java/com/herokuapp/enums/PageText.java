package com.herokuapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum for have the static text in the pages. */
@Getter
@AllArgsConstructor
public enum PageText {
  HEADER_CONTACT("Contact List"),
  SUBTITLE_CONTACT("Click on any contact to view the Contact Details");

  private final String text;
}
