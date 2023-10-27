package com.olympus.platform.service;

import com.olympus.platform.model.representative.RepresentativeGetResponseDTO;
import com.olympus.platform.model.representative.RepresentativePutRequestDTO;
import com.olympus.platform.model.representative.RepresentativePutResponseDTO;
import java.util.List;

public interface RepresentativeServiceInterface {

    RepresentativePutResponseDTO updateRepresentativeService(
            RepresentativePutRequestDTO representativePutRequestDTO);

    List<RepresentativeGetResponseDTO> getRepresentativesService();

}
