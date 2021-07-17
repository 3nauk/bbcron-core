package com.bnauk.bbcron.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class BBCronError {

  /**
   * Timestamp Response
   */
  private Long timestamp;

  /**
   * Status Code
   */
  private int status;

  /**
   * Exception name
   */
  private String name;

  /**
   * Message associated
   */
  private String message;

  /**
   * Status name
   */
  private String statusName;


}
