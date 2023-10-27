package com.olympus.empire.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olympus.empire.domain.SubThemeEntity;
import com.olympus.empire.domain.ThemeEntity;
import com.olympus.empire.mapper.ThemeMapper;
import com.olympus.empire.repository.SubThemeRepository;
import com.olympus.empire.repository.ThemeRepository;
import com.olympus.empire.service.ThemeService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.page.SubThemeDTO;
import com.olympus.objects.page.ThemeDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	private ThemeRepository themeRepository;
	@Autowired
	private SubThemeRepository subThemeRepository;

	@Override
	public void guardarTema(ThemeDTO themeDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		
		log.info("Inicio del método: guardarUsuario");
		log.info("Atributos(ThemeDTO): " + themeDTO.toString());
		
		try {
			
			if (null == themeRepository.findByThemeDesc(themeDTO.getThemeName())) {
				
				ThemeEntity themeEntitySaved =
						themeRepository.save(ThemeMapper.INSTANCE.convertThemeDTO2ThemeEntity(themeDTO));
				
				for (SubThemeDTO subTheme : themeDTO.getSubThemes()) {
					subThemeRepository.save(
							ThemeMapper.INSTANCE.convertSubThemeDTO2SubThemeEntity(subTheme, themeEntitySaved));
				}

			}
			else {
				log.error("Error, Conflictos al registrar la tematica");
				throw new ResourceConflictException("La tematica con el nombre: " + themeDTO.getThemeName()
						+ "ya está registrado");
			}
			
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarTema");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
	}

	@Override
	public ThemeDTO obtenerTemaWithSubTemas(Long themeId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		
		log.info("Inicio del método: guardarUsuario");
		log.info("Atributos(themeId): " + themeId);
		
		ThemeDTO themeDTO = null;
		
		try {
			
			 ThemeEntity themeEntity = themeRepository.findById(themeId)
					 .orElseThrow(() -> new ResourceNotFoundException("Tematica no registrada en la bd"));
			 
			 themeDTO = ThemeMapper.INSTANCE.getMappedThemeView(subThemeRepository.findByTheme(themeEntity), themeEntity);
		} catch (Exception ex) {
			log.error("Error consultando del método: obtenerTemaWithSubTemas");
			log.error("Exception: " + ex.getMessage());
		}
		
		return themeDTO;

	}

	@Override
	public void eliminarTema(Long themeId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		
		log.info("Inicio del método: guardarUsuario");
		log.info("Atributos(themeId): " + themeId);
		
		try {
			
			ThemeEntity themeEntity = themeRepository.findById(themeId)
					.orElseThrow(() -> new ResourceNotFoundException("Tematica no registrada en la bd"));
			
			List<SubThemeEntity> subThemesEntities = subThemeRepository.findByTheme(themeEntity);

			subThemeRepository.deleteAll(subThemesEntities);
			themeRepository.delete(themeEntity);
			
		} catch (Exception ex) {
			log.error("Error consultando del método: eliminarTema");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
	}

	@Override
	public void agregarSubThemeAlTema(Long themeId, List<SubThemeDTO> listaSubThemes)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		
		log.info("Inicio del método: agregarSubThemeAlTema");
		log.info("Atributos(themeId): " + themeId);
		log.info("Elementos(subThemesDTO): " + listaSubThemes.size());
		
		try {
			
			ThemeEntity themeEntity = themeRepository.findById(themeId)
					 .orElseThrow(() -> new ResourceNotFoundException("Tematica no registrada en la bd"));
			
			for (SubThemeDTO subTheme : listaSubThemes) {
				subThemeRepository.save(
						ThemeMapper.INSTANCE.convertSubThemeDTO2SubThemeEntity(subTheme, themeEntity));
			}
			
		} catch (Exception ex) {
			log.error("Error consultando del método: agregarSubThemeAlTema");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
	}

}
