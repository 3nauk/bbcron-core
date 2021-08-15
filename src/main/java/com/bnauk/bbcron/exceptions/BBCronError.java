package com.bnauk.bbcron.exceptions;

import java.sql.Time;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
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