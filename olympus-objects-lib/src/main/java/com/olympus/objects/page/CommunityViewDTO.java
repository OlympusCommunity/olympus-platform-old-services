package com.olympus.objects.page;

import java.math.BigDecimal;
import java.util.List;
import com.olympus.objects.session.ProfileViewDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommunityViewDTO {

	private String communityId;

	private String cmName;

	private String cmDesc;

	private BigDecimal cmScore;

	private Long cmViews;

	private Long cmMembers;
	
	private List<ThemeDTO> themes;
	
	private List<ProfileViewDTO> profiles;
	
	private List<RoleDTO> roles;

}
