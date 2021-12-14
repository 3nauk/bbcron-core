package com.bnauk.bbcron.core.repository.support;

import static com.mongodb.assertions.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bnauk.bbcron.core.dto.filter.FilterCondition;
import com.bnauk.bbcron.core.dto.filter.FilterOperationEnum;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.Query;

class GenericFilterCriteriaBuilderTest {

  List<FilterCondition> andConditions;

  List<FilterCondition> orConditions;
  private GenericFilterCriteriaBuilder genericFilterCriteriaBuilder;

  @BeforeEach
  void setUp() {
    andConditions = new ArrayList<>();
    orConditions = new ArrayList<>();
    genericFilterCriteriaBuilder = new GenericFilterCriteriaBuilder();
  }

  @Test
  void addCondition() {
    andConditions.add(
        FilterCondition.builder()
            .field("name")
            .value("JohnDoe")
            .operator(FilterOperationEnum.EQUAL)
            .build());
    orConditions.add(
        FilterCondition.builder()
            .field("age")
            .value("34")
            .operator(FilterOperationEnum.GREATER_THAN)
            .build());
    assertNotNull(genericFilterCriteriaBuilder.addCondition(andConditions, orConditions));
    assertTrue(
        genericFilterCriteriaBuilder
            .addCondition(andConditions, orConditions)
            .getClass()
            .equals(Query.class));
  }

  @Test
  void addCondition_with_and_criteria_empty() {
    orConditions.add(
        FilterCondition.builder()
            .field("age")
            .value("34")
            .operator(FilterOperationEnum.GREATER_THAN)
            .build());
    assertNotNull(genericFilterCriteriaBuilder.addCondition(andConditions, orConditions));
    assertTrue(
        genericFilterCriteriaBuilder
            .addCondition(andConditions, orConditions)
            .getClass()
            .equals(Query.class));
  }

  @Test
  void addCondition_with_or_criteria_empty() {
    andConditions.add(
        FilterCondition.builder()
            .field("age")
            .value("34")
            .operator(FilterOperationEnum.GREATER_THAN)
            .build());
    assertNotNull(genericFilterCriteriaBuilder.addCondition(andConditions, orConditions));
    assertTrue(
        genericFilterCriteriaBuilder
            .addCondition(andConditions, orConditions)
            .getClass()
            .equals(Query.class));
  }

  @Test
  void addCondition_with_criteria_empty() {
    assertNotNull(genericFilterCriteriaBuilder.addCondition(andConditions, orConditions));
    assertTrue(
        genericFilterCriteriaBuilder
            .addCondition(andConditions, orConditions)
            .getClass()
            .equals(Query.class));
  }

  @Test
  void addCondition_with_invalid_function() {
    andConditions.add(
        FilterCondition.builder()
            .field("name")
            .value("JohnDoe")
            .operator(FilterOperationEnum.EQUAL)
            .build());
    andConditions.add(
        FilterCondition.builder()
            .field("age")
            .value("34")
            .operator(FilterOperationEnum.IS)
            .build());
    assertThrows(
        IllegalArgumentException.class,
        () -> genericFilterCriteriaBuilder.addCondition(andConditions, orConditions));
  }
}
