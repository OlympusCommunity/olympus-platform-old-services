INSERT INTO ol_cm_other.tb_ol_cm_countries (country_id,abv,"name",pref_tel) VALUES
	 (1,'PER','PERU','+51'),
	 (2,'USA','UNITED STATES','+1');
	 
INSERT INTO ol_cm_page.tb_ol_cm_roles (role_id,create_at,update_at,role_desc,role_name,status) VALUES
	 (1,'2021-08-11 17:24:42.013',NULL,'Fundador de una comunidad','FOUNDER',true),
	 (2,'2021-08-11 17:25:28.263',NULL,'Participante de una comunidad','PARTICIPANT',true),
	 (3,'2021-08-11 17:25:42.83',NULL,'Rol por defecto','DEFAULT',true),
	 (4,'2021-08-11 17:26:04.66',NULL,'Perfil Baneado','BANNED',true),
	 (5,'2021-08-11 17:26:14.584',NULL,'Perfil eliminado','DELETE',true);

INSERT INTO ol_cm_session.tb_ol_cm_types (type_id,alias,"name",num_limit) VALUES
	 (1,'PS','PERSONAL',1000),
	 (2,'CM','COMMUNITY',1000),
	 (3,'BS','BUSINESS',100),
	 (4,'MS','MASTER',10);