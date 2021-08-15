package com.bnauk.bbcron.service;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bnauk.bbcron.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilterBuilderServiceTest {

  private FilterBuilderService filterBuilderService;

  @BeforeEach
  void init() {
    filterBuilderService = new FilterBuilderService();
  }

  @Test
  void createFilterCondition() {
    String criteria = "firstName|eq|john&secondName|eq|John";
    assertTrue(filterBuilderService.createFilterCondition(criteria).size() == 2);
  }

  @Test
  void create_filter_condition_not_valid() {
    String criteria = "firstName|eq";
    assertThrows(BadRequestException.class,
        () -> filterBuilderService.createFilterCondition(criteria));
  }

  @Test
  void get_pageable_information() {
    //int size, int page, String orde
    assertNotNull(filterBuilderService.getPageable(10, 1, "name|ASC"));
    assertNotNull(filterBuilderService.getPageable(10, 1, "name|DESC"));
    assertThrows(BadRequestException.class,
        () -> filterBuilderService.getPageable(10, 1, "name|NOT_FOUND"));
  }

  @Test
  void get_pageable_with_order_not_informed(){
    assertNotNull(filterBuilderService.getPageable(10, 1, null));
  }
}