package com.olympus.platform.service.impl;

import com.olympus.platform.entity.RepresenterEntity;
import com.olympus.platform.entity.WelcomeEntity;
import com.olympus.platform.mapper.RepresenterMapper;
import com.olympus.platform.mapper.WelcomeMapper;
import com.olympus.platform.model.WelcomeGetResponseDTO;
import com.olympus.platform.model.WelcomePostRequestDTO;
import com.olympus.platform.model.WelcomePostResponseDTO;
import com.olympus.platform.model.WelcomePutRequestDTO;
import com.olympus.platform.model.WelcomePutResponseDTO;
import com.olympus.platform.repository.RepresenterRepository;
import com.olympus.platform.repository.WelcomeRepository;
import com.olympus.platform.service.WelcomeService;
import com.olympus.platform.util.Constants;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class WelcomeServiceImpl implements WelcomeService {

  @Autowired private WelcomeRepository welcomeRepository;
  @Autowired private RepresenterRepository representerRepository;

  @Override
  public WelcomePostResponseDTO createWelcomMessageService(
      WelcomePostRequestDTO welcomePostRequestDTO) {
    log.info(String.format("createWelcomMessageService %s", Constants.START_SERVICE));

    WelcomeEntity welcomeSaved =
        welcomeRepository.save(
            WelcomeMapper.INSTANCE.convertToWelcomeEntity(welcomePostRequestDTO));

    welcomePostRequestDTO
        .getRepresenters()
        .forEach(
            representer -> {
              representerRepository.save(
                  RepresenterMapper.INSTANCE.mappingRepresenterEntity(representer));
            });

    log.info(String.format("createWelcomMessageService %s", Constants.FINAL_SERVICE));

    return WelcomePostResponseDTO.builder()
        .welcomeId(welcomeSaved.getWelcomeId())
        .welcomeDate(welcomeSaved.getCreationDate())
        .build();
  }

  @Override
  public WelcomeGetResponseDTO getWelcomeMessageService() {
    log.info(String.format("getWelcomeMessageService %s", Constants.START_SERVICE));

    WelcomeEntity welcomeEntity =
        welcomeRepository
            .findById(Constants.LONG_1)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "This welcome message not found with id: %s", Constants.LONG_1)));

    List<RepresenterEntity> representers = representerRepository.findFirstFourById();
    log.info(String.format("getWelcomeMessageService %s", Constants.FINAL_SERVICE));

    return WelcomeMapper.INSTANCE.convertToWelcomeGetResponse(welcomeEntity, representers);
  }

  @Override
  public WelcomePutResponseDTO updateWelcomeMessageService(
      WelcomePutRequestDTO welcomePutRequestDTO) {
    log.info(String.format("updateWelcomeMessageService %s", Constants.START_SERVICE));

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

    log.info(String.format("updateWelcomeMessageService %s", Constants.FINAL_SERVICE));
    return WelcomePutResponseDTO.builder()
        .welcomeId(welcomeUpdated.getWelcomeId())
        .editionDate(new Date())
        .build();
  }
}
