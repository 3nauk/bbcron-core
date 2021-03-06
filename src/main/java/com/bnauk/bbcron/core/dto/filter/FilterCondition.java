package com.bnauk.bbcron.core.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 *
 * <h2>FilterCondition</h2>
 *
 * @author benauca
 *     <p>Description: Filter Condition Class
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FilterCondition {

  /** Field */
  private String field;

  /** Operator {@link FilterOperationEnum} */
  private FilterOperationEnum operator;

  /** Value to Search */
  private Object value;
}
