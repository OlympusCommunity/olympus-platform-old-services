package com.olympus.platform.controller.impl;

import com.olympus.platform.controller.RepresentativeController;
import com.olympus.platform.model.representative.RepresentativeGetResponseDTO;
import com.olympus.platform.model.representative.RepresentativePutRequestDTO;
import com.olympus.platform.model.representative.RepresentativePutResponseDTO;
import com.olympus.platform.service.RepresentativeServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Log4j2
public class RepresentativeControllerImpl implements RepresentativeController {

    private RepresentativeServiceInterface representativeServiceInterface;

    /**
     * Get Olympus representatives
     *
     * @return RepresentativeGetResponseDTO
     */
    @Override
    public ResponseEntity<List<RepresentativeGetResponseDTO>> getRepresentativesController() {
        return ResponseEntity.ok().body(representativeServiceInterface.getRepresentativesService());
    }

    /**
     * Update Olympus representatives
     *
     * @return RepresentativePutResponseDTO
     */
    @Override
    public ResponseEntity<RepresentativePutResponseDTO> updateRepresentativeController(RepresentativePutRequestDTO representativePutRequestDTO) {
        return ResponseEntity.ok().body(representativeServiceInterface.updateRepresentativeService(representativePutRequestDTO));
    }
}
