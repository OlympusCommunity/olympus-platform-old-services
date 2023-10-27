package com.olympus.objects.page;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ThemeCommunityDTO {
	
	Long themeId;
	
	List<Long> subThemes;

}
