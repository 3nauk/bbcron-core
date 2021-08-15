package com.bnauk.bbcron.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

/**
 * Page Response for BBCron Controller
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
public class PageResponse<T> {

  /**
   * Total pages
   */
  private int totalPages;

  /**
   * Total Items
   */
  private long totalItems;

  /**
   * Current Page
   */
  private int currentPage;

  /**
   * boolean to indicate if is First Page
   */
  private boolean first;

  /**
   * boolean to indicate if is Last Page
   */
  private boolean last;

  /**
   * Number Items per page
   */
  private int itemsPerPage;

  /**
   * Page Size
   */
  private int pageSize;

  /**
   * Items as List
   */
  private List<T> items;

  /**
   * Set Items as page
   *
   * @param pg   as {@link Page<T>}
   * @param elts as {@link List<T>}
   */
  public void setPageStats(Page<T> pg, List<T> elts) {
    first = pg.isFirst();
    last = pg.isLast();
    currentPage = pg.getNumber() + 1;
    pageSize = pg.getSize();
    totalPages = pg.getTotalPages();
    totalItems = pg.getTotalElements();
    itemsPerPage = pg.getNumberOfElements();
    items = elts;
  }
}