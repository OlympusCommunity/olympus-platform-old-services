package com.olympus.platform.service;

import com.olympus.platform.model.RepresenterGetResponseDTO;
import com.olympus.platform.model.RepresenterPutRequestDTO;
import com.olympus.platform.model.RepresenterPutResponseDTO;
import java.util.List;

public interface RepresenterService {

  RepresenterPutResponseDTO updateRepresenterService(
      RepresenterPutRequestDTO representerPutRequestDTO);

  List<RepresenterGetResponseDTO> getRepresentersService();
}
