package com.herokuapp.utils;

import com.herokuapp.api.dtos.ContactDto;
import com.herokuapp.api.dtos.NewUserResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

/** Utility class to save context user info. */
@UtilityClass
public final class DataContext {

  @Getter @Setter private static NewUserResponse user;
  @Getter @Setter private static String password;
  @Getter @Setter private static List<ContactDto> contacts = new ArrayList<>();

  /** Dispose the test data. */
  public static void disposeData() {
    user = null;
    password = null;
    contacts = new ArrayList<>();
  }
}
