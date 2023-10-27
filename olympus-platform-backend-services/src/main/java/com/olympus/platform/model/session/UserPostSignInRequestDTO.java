package com.olympus.platform.model.session;

import com.olympus.platform.constants.ValidationConstant;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode
public class UserPostSignInRequestDTO {

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
