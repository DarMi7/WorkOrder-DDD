package com.workorder.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {

  private static final int SUCCESS = 200;

  private static final String OK = "OK";

  /**
   * return message (mainly for error)
   */
  private String msg;

  private int code;

  /**
   * return data
   */
  private T data;

  public static <T> Result<T> ok(T data) {
    return new Result<>(OK, SUCCESS, data);
  }

  public static <T> Result<T> ok() {
    return new Result<>(OK, SUCCESS, null);
  }

  private Result(String msg, int code, T data) {
    this.msg = msg;
    this.code = code;
    this.data = data;
  }

}
