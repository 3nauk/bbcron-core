package com.bnauk.bbcron.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

class PageResponseTest {

  private PageResponse response;
  private BBCronPage page;
  private List<String> items;

  @BeforeEach
  void createPageResponse() {
    page = new BBCronPage();
    response = new PageResponse();
    items = new ArrayList(2);
    items.add("Hello");
    items.add("world");
  }

  @Test
  void setPageStats() {

    response.setPageStats(page, items);
    assertEquals(1, response.getCurrentPage());
    assertEquals(items, response.getItems());
    assertEquals(10, response.getTotalPages());
    assertEquals(100, response.getTotalItems());
    assertEquals(1, response.getCurrentPage());
    assertEquals(10, response.getPageSize());
    assertEquals(25, response.getItemsPerPage());
    assertEquals(true, response.isFirst());
    assertEquals(false, response.isLast());
  }

}
class BBCronPage implements Page<BBCronPage> {
  @Override
  public int getTotalPages() {
    return 10;
  }

  @Override
  public long getTotalElements() {
    return 100;
  }

  @Override
  public <U> Page<U> map(Function<? super BBCronPage, ? extends U> converter) {
    return null;
  }

  @Override
  public int getNumber() {
    return 0;
  }

  @Override
  public int getSize() {
    return 10;
  }

  @Override
  public int getNumberOfElements() {
    return 25;
  }

  @Override
  public List<BBCronPage> getContent() {
    return null;
  }

  @Override
  public boolean hasContent() {
    return false;
  }

  @Override
  public Sort getSort() {
    return null;
  }

  @Override
  public boolean isFirst() {
    return true;
  }

  @Override
  public boolean isLast() {
    return false;
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public boolean hasPrevious() {
    return false;
  }

  @Override
  public Pageable nextPageable() {
    return null;
  }

  @Override
  public Pageable previousPageable() {
    return null;
  }

  @Override
  public Iterator<BBCronPage> iterator() {
    return null;
  }
}
