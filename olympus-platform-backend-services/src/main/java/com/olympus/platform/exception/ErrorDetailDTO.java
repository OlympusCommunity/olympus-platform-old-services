package com.olympus.platform.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorDetailDTO {

  @JsonProperty("status")
  private HttpStatus status;

  @JsonProperty("timestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  @JsonProperty("message")
  private String message;

  @JsonProperty("debug_mensage")
  private String debugMessage;

  @JsonProperty("uri")
  private String uriRequested;

  @JsonProperty("sub_errors")
  private List<SubErrorDetailDTO> subErrors;

  private ErrorDetailDTO() {
    timestamp = LocalDateTime.now();
  }

  public ErrorDetailDTO(HttpStatus status) {
    this();
    this.status = status;
  }

  public ErrorDetailDTO(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.message = "Unexpected error";
    this.debugMessage = ex.getLocalizedMessage();
  }

  public ErrorDetailDTO(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }
}
