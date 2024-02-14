package com.workorder.infrastructure.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 * @author darmi
 */
public class ObjectUtil {

  private static final Gson gson = new Gson();

  public static <T> T jsonToObject(String str, Class<T> type) {
    return gson.fromJson(str, type);
  }

  public static <T> String objectToJson(T object) {
    return gson.toJson(object);
  }

  public static <T> T jsonToObject(String str, Type type) {
    return gson.fromJson(str, type);
  }
}
