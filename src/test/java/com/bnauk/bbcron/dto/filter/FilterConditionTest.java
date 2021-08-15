package com.bnauk.bbcron.dto.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilterConditionTest {

  private FilterCondition condition;

  @BeforeEach
  public void createCondition() {
    condition = FilterCondition.builder().field("fullName").operator(FilterOperationEnum.EQUAL)
        .value("John Doe").build();
  }

  @Test
  public void getField() {
    assertEquals("fullName", condition.getField());
  }

  @Test
  public void getValue() {
    assertEquals("John Doe", condition.getValue());
  }

  @Test
  public void getOperator() {
    assertEquals(FilterOperationEnum.EQUAL, condition.getOperator());
  }

  @Test
  public void test_toString(){
    assertEquals("FilterCondition(field=fullName, operator=eq, value=John Doe)", condition.toString());
  }

}