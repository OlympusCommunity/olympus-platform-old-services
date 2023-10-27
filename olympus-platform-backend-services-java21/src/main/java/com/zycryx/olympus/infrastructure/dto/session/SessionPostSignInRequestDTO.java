package com.zycryx.olympus.infrastructure.dto.session;

import com.zycryx.olympus.util.constants.ValidationConstant;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SessionPostSignInRequestDTO {

    @NotNull(message = "usernameOrEmail" + ValidationConstant.MESSAGE_NOT_NULL)
    @NotBlank(message = "usernameOrEmail" + ValidationConstant.MESSAGE_NOT_BLANK)
    @NotEmpty(message = "usernameOrEmail" + ValidationConstant.MESSAGE_NOT_EMPTY)
    private String usernameOrEmail;

    @NotNull(message = "password" + ValidationConstant.MESSAGE_NOT_NULL)
    @NotBlank(message = "password" + ValidationConstant.MESSAGE_NOT_BLANK)
    @NotEmpty(message = "password" + ValidationConstant.MESSAGE_NOT_EMPTY)
    @Size(max = 24, min = 8)
    private String password;
}
