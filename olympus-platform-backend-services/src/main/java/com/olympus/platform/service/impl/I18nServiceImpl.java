package com.olympus.platform.service.impl;

import com.olympus.platform.constants.ValidationConstant;
import com.olympus.platform.entity.I18nEntity;
import com.olympus.platform.repository.I18nRepository;
import com.olympus.platform.service.I18nServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class I18nServiceImpl implements I18nServiceInterface {

    private final I18nRepository i18nRepository;

    @Override
    public String getValueByLanguageAndKeyService(String key, String langCode) {
        return i18nRepository.findByKeyAndLangCodeId(key, langCode).map(I18nEntity::getValue).orElse(ValidationConstant.VALUE_NOT_FOUND);
    }
}
