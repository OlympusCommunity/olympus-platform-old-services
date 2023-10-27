package com.olympus.platform.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuditDTO {

  private String ipReceiver;
  private String reason;
  private String browser;
  private Date date;
  private String userId;
}
