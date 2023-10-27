package com.olympus.platform.controller;

import com.olympus.platform.model.representative.RepresentativeGetResponseDTO;
import com.olympus.platform.model.representative.RepresentativePutRequestDTO;
import com.olympus.platform.model.representative.RepresentativePutResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;

@Api(value = "representatives", tags = {"Welcome Representatives"})
@RequestMapping(value = "/api/principal/v1/representative", produces = MediaType.APPLICATION_JSON_VALUE)
public interface RepresentativeController {

    /**
     * Get Olympus representatives
     *
     * @return RepresentativeGetResponseDTO
     */
    @ApiOperation(
            value = "Get Olympus representatives"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = RepresentativeGetResponseDTO.class),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<RepresentativeGetResponseDTO>> getRepresentativesController ();

    /**
     * Update Olympus representatives
     *
     * @return RepresentativePutResponseDTO
     */
    @ApiOperation(
            value = "Update Olympus representatives"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = RepresentativePutResponseDTO.class),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<RepresentativePutResponseDTO> updateRepresentativeController (@Valid @RequestBody RepresentativePutRequestDTO representerPutRequestDTO);

}
