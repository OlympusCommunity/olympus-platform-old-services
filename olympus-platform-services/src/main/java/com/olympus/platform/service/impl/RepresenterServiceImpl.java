package com.olympus.platform.service.impl;

import com.olympus.platform.entity.RepresenterEntity;
import com.olympus.platform.mapper.RepresenterMapper;
import com.olympus.platform.model.RepresenterGetResponseDTO;
import com.olympus.platform.model.RepresenterPutRequestDTO;
import com.olympus.platform.model.RepresenterPutResponseDTO;
import com.olympus.platform.repository.RepresenterRepository;
import com.olympus.platform.service.RepresenterService;
import com.olympus.platform.util.Constants;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RepresenterServiceImpl implements RepresenterService {

  @Autowired private RepresenterRepository representerRepository;

  @Override
  public RepresenterPutResponseDTO updateRepresenterService(
      RepresenterPutRequestDTO representerPutRequestDTO) {
    log.info(String.format("updateRepresenterService %s", Constants.START_SERVICE));

    RepresenterEntity representerEntity =
        representerRepository
            .findById(representerPutRequestDTO.getRepresenterId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "Representative not found with id: %s",
                            representerPutRequestDTO.getRepresenterId())));

    RepresenterEntity representerUpdate =
        representerRepository.save(
            RepresenterMapper.INSTANCE.mappingUpdateRepresenterEntity(
                representerPutRequestDTO, representerEntity));

    log.info(String.format("updateRepresenterService %s", Constants.FINAL_SERVICE));
    return RepresenterPutResponseDTO.builder()
        .representerId(representerUpdate.getRepresenterId())
        .editionDate(new Date())
        .build();
  }

  @Override
  public List<RepresenterGetResponseDTO> getRepresentersService() {
    log.info(String.format("getRepresentersService %s", Constants.START_SERVICE));

    List<RepresenterEntity> representers = representerRepository.findAll();

    log.info(String.format("getRepresentersService %s", Constants.FINAL_SERVICE));
    return RepresenterMapper.INSTANCE.mappingRepresentersGetResponseList(representers);
  }
}
