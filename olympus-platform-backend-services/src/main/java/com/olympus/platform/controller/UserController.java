package com.olympus.platform.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "user", tags = {"User Controller"})
@RequestMapping(value = "/api/services/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserController {



}
