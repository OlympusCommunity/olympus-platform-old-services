package com.olympus.platform.service.impl;

import com.olympus.platform.constants.ValidationConstant;
import com.olympus.platform.entity.RepresentativeEntity;
import com.olympus.platform.mapper.RepresentativeMapper;
import com.olympus.platform.model.representative.RepresentativeGetResponseDTO;
import com.olympus.platform.model.representative.RepresentativePutRequestDTO;
import com.olympus.platform.model.representative.RepresentativePutResponseDTO;
import com.olympus.platform.repository.RepresentativeRepository;
import com.olympus.platform.service.RepresentativeServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class RepresentativeServiceImpl implements RepresentativeServiceInterface {

    @Autowired private RepresentativeRepository representativeRepository;

    /**
     * @param representativePutRequestDTO
     * @return
     */
    @Override
    public RepresentativePutResponseDTO updateRepresentativeService (RepresentativePutRequestDTO representativePutRequestDTO) {
        log.info(String.format("updateRepresentativeService %s", ValidationConstant.START_SERVICE));

        RepresentativeEntity representativeEntity =
                representativeRepository
                        .findById(representativePutRequestDTO.getRepresentativeId())
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                String.format(
                                                        "Representative not found with id: %s",
                                                        representativePutRequestDTO.getRepresentativeId())));

        RepresentativeEntity representativeUpdate =
                representativeRepository.save(RepresentativeMapper.INSTANCE.mappingUpdateRepresentativeEntity(
                        representativePutRequestDTO, representativeEntity));

        log.info(String.format("updateRepresentativeService %s", ValidationConstant.FINAL_SERVICE));
        return RepresentativePutResponseDTO.builder()
                .representativeId(representativeUpdate.getRepresentativeId())
                .editionDate(new Date())
                .build();
    }

    /**
     * @return
     */
    @Override
    public List<RepresentativeGetResponseDTO> getRepresentativesService() {
        log.info(String.format("getRepresentativeService %s", ValidationConstant.START_SERVICE));

        List<RepresentativeEntity> representatives = representativeRepository.findAll();

        log.info(String.format("getRepresentativeService %s", ValidationConstant.FINAL_SERVICE));
        return RepresentativeMapper.INSTANCE.mappingRepresentativesGetResponseList(representatives);
    }
}
