package com.olympus.platform.model.error;

import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@EqualsAndHashCode
public class ErrorDTO<T> implements Serializable {

    private static final long serialVersionUID = 763533633829442930L;

    private ZonedDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private transient List<T> errors;

}
