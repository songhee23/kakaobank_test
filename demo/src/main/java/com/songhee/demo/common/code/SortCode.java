package com.songhee.demo.common.code;

import com.songhee.demo.common.code.converter.CodeValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortCode implements CodeValue {
  Accuracy("accuracy"),
  Latest("latest");

  private String code;

  public static SortCode find(String description) {
    return Arrays.stream(values())
        .filter(sortCode -> sortCode.code.equals(description))
        .findAny()
        .orElse(null);
  }
}
