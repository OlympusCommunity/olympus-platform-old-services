package com.olympus.platform.controller.impl;

import com.olympus.platform.controller.I18nController;
import com.olympus.platform.service.I18nServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class I18nControllerImpl implements I18nController {

    private final I18nServiceInterface i18nService;

    public I18nControllerImpl(I18nServiceInterface i18nService) {
        this.i18nService = i18nService;
    }

    @Override
    public ResponseEntity<String> getValueController(String key, String lang) {
        return ResponseEntity.ok(i18nService.getValueByLanguageAndKeyService(key, lang));
    }
}
