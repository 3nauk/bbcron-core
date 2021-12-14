package com.bnauk.bbcron.user.exceptions;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BBCronErrorTest {

  BBCronError error;

  @BeforeEach
  void setUp() {
    error =
        BBCronError.builder()
            .message("This is the message")
            .name("BBCRon Error")
            .status(200)
            .statusName("OK")
            .timestamp(Instant.now().getEpochSecond())
            .build();
  }

  @Test
  void get_bbcron_info() {
    assertNotNull(error);
    assertEquals(200, error.getStatus());
    assertEquals("OK", error.getStatusName());
    assertEquals("This is the message", error.getMessage());
    assertEquals("BBCRon Error", error.getName());
    assertNotNull(error.getTimestamp());
  }
}
