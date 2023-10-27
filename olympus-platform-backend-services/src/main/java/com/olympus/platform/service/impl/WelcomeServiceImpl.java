package com.olympus.platform.service.impl;

import com.olympus.platform.constants.ValidationConstant;
import com.olympus.platform.entity.RepresentativeEntity;
import com.olympus.platform.entity.WelcomeEntity;
import com.olympus.platform.mapper.RepresentativeMapper;
import com.olympus.platform.mapper.WelcomeMapper;
import com.olympus.platform.model.welcome.*;
import com.olympus.platform.repository.RepresentativeRepository;
import com.olympus.platform.repository.WelcomeRepository;
import com.olympus.platform.service.WelcomeServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class WelcomeServiceImpl implements WelcomeServiceInterface {

    @Autowired private RepresentativeRepository representativeRepository;
    @Autowired private WelcomeRepository welcomeRepository;

    /**
     * @param welcomePostRequestDTO
     * @return
     */
    @Override
    public WelcomePostResponseDTO createWelcomeMessageService(WelcomePostRequestDTO welcomePostRequestDTO) {
        log.info(String.format("createWelcomMessageService %s", ValidationConstant.START_SERVICE));

        WelcomeEntity welcomeSaved =
                welcomeRepository.save(
                        WelcomeMapper.INSTANCE.convertToWelcomeEntity(welcomePostRequestDTO));

        welcomePostRequestDTO
                .getRepresentatives()
                .forEach(
                        representative -> {
                            representativeRepository.save(
                                    RepresentativeMapper.INSTANCE.mappingRepresentativeEntity(representative));
                        });

        log.info(String.format("createWelcomeMessageService %s", ValidationConstant.FINAL_SERVICE));

        return WelcomePostResponseDTO.builder()
                .welcomeId(welcomeSaved.getWelcomeId())
                .welcomeDate(welcomeSaved.getCreationDate())
                .build();
    }

    /**
     * @return
     */
    @Override
    public WelcomeGetResponseDTO getWelcomeMessageService() {
        log.info(String.format("getWelcomeMessageService %s", ValidationConstant.START_SERVICE));

        WelcomeEntity welcomeEntity =
                welcomeRepository
                        .findById(ValidationConstant.LONG_1)
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                String.format(
                                                        "This welcome message not found with id: %s", ValidationConstant.LONG_1)));

        List<RepresentativeEntity> representatives = representativeRepository.findFirstFourById();
        log.info(String.format("getWelcomeMessageService %s", ValidationConstant.FINAL_SERVICE));

        return WelcomeMapper.INSTANCE.convertToWelcomeGetResponse(welcomeEntity, representatives);
    }

    /**
     * @param welcomePutRequestDTO
     * @return
     */
    @Override
    public WelcomePutResponseDTO updateWelcomeMessageService(WelcomePutRequestDTO welcomePutRequestDTO) {
        log.info(String.format("updateWelcomeMessageService %s", ValidationConstant.START_SERVICE));

        WelcomeEntity welcomeEntity =
                welcomeRepository
                        .findById(welcomePutRequestDTO.getWelcomeId())
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                String.format(
                                                        "This welcome message not found with id: %s",
                                                        welcomePutRequestDTO.getWelcomeId())));

        WelcomeEntity welcomeUpdated =
                welcomeRepository.save(
                        WelcomeMapper.INSTANCE.mappingUpdateWelcomeEntity(
                                welcomePutRequestDTO, welcomeEntity.getCreationDate(), welcomeEntity.getStatus()));

        log.info(String.format("updateWelcomeMessageService %s", ValidationConstant.FINAL_SERVICE));
        return WelcomePutResponseDTO.builder()
                .welcomeId(welcomeUpdated.getWelcomeId())
                .editionDate(new Date())
                .build();
    }
}
