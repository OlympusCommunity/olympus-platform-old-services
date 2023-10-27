package com.zycryx.olympus.infrastructure.dto.audit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.olympus.platform.enums.ActionAuditEnum;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuditRequestDTO {

    private String userId;
    @JsonInclude(Include.NON_NULL)
    private ActionAuditEnum actionDesc;
    @JsonInclude(Include.NON_NULL)
    private String browser;
    private String ipReceiver;
    private String reason;

}
