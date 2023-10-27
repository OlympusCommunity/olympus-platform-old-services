package com.olympus.platform.model.session;

import com.olympus.platform.constants.ValidationConstant;
import lombok.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProfileInformationDTO {

    @NotNull(message = "name" + ValidationConstant.MESSAGE_NOT_NULL)
    @NotBlank(message = "name" + ValidationConstant.MESSAGE_NOT_BLANK)
    @NotEmpty(message = "name" + ValidationConstant.MESSAGE_NOT_EMPTY)
    private String name;

    @NotNull(message = "name" + ValidationConstant.MESSAGE_NOT_NULL)
    @NotBlank(message = "name" + ValidationConstant.MESSAGE_NOT_BLANK)
    @NotEmpty(message = "name" + ValidationConstant.MESSAGE_NOT_EMPTY)
    private String surname;

    private String shortInfo;
    private String longInfo;
    private String alias;
    private String nickname;
    private String birthday;

    private List<ThelephoneDTO> thelephones;

}
