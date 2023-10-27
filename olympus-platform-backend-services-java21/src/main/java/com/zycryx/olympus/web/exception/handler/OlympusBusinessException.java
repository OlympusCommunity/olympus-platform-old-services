package com.zycryx.olympus.web.exception.handler;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OlympusBusinessException extends RuntimeException {

  private static final long serialVersionUID = 2883857331236752874L;
  private String code;
  private HttpStatus status;

  public OlympusBusinessException(String code, HttpStatus status, String message) {
    super(message);
    this.code = code;
    this.status = status;
  }

  public OlympusBusinessException(String message) {
    super(message);
  }
}
