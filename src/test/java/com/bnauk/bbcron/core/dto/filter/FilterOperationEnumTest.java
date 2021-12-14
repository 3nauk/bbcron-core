package com.bnauk.bbcron.user.dto.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FilterOperationEnumTest {

  @Test
  void fromValue() {
    assertEquals(FilterOperationEnum.fromValue("eq"), FilterOperationEnum.EQUAL);
    assertEquals(FilterOperationEnum.fromValue("not_Exist_as_filter"), null);
    assertEquals(FilterOperationEnum.fromValue("eq").toString(), "eq");
  }
}
