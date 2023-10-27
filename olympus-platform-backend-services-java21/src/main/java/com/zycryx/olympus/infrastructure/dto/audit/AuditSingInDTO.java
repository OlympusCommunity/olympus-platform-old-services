package com.zycryx.olympus.infrastructure.dto.audit;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class AuditSingInDTO {
    private String ipReceiver;
    private String reason;
    private String browser;
    private Date date;
    private String userId;
}
