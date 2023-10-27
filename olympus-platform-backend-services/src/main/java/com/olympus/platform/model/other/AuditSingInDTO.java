package com.olympus.platform.model.other;

import java.util.Date;
import lombok.*;

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
