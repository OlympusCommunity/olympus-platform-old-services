
-- CREAR DATABASE 

CREATE DATABASE olympus;

------------------------------------------------------------------------------------ CREATE ROLE -------------------------------------------------------------------------------------
-- DROP ROLE olympus_own;

CREATE ROLE olympus_own WITH 
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	LOGIN
	REPLICATION
	NOBYPASSRLS
	CONNECTION LIMIT UNLIMITED;

-- Permissions

GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_other.tb_ol_cm_countries TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_com_themes TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_communities TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_levels TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_mg TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_roles TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_socials TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_socials_pt TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_sub_themes TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_page.tb_ol_cm_themes TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_security.tb_ol_cm_keys TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_security.tb_ol_cm_messages TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_session.tb_ol_cm_profiles TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_session.tb_ol_cm_telephones TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_session.tb_ol_cm_types TO olympus_own WITH GRANT OPTION;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLE ol_cm_session.tb_ol_cm_users TO olympus_own WITH GRANT OPTION;

------------------------------------------------------------------------------------ SCHEMA OTHER ---------------------------------------------------------------------------------

-- DROP SCHEMA ol_cm_other;

CREATE SCHEMA ol_cm_other AUTHORIZATION olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_com_cat_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_com_cat_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_com_cat_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_com_cat_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_com_prof_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_com_prof_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_com_prof_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_com_prof_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_country_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_country_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_country_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_country_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_level_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_level_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_level_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_level_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_role_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_role_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_role_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_role_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_security_keys;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_security_keys
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_security_keys OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_security_keys TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_security_msn_keys;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_security_msn_keys
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_security_msn_keys OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_security_msn_keys TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_social_pt;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_social_pt
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_social_pt OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_social_pt TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_sub_theme_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_sub_theme_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_sub_theme_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_sub_theme_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_tel_profile;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_tel_profile
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_tel_profile OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_tel_profile TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_theme_id;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_theme_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_theme_id OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_theme_id TO olympus_own;

-- DROP SEQUENCE ol_cm_other.sc_ol_cm_type_user;

CREATE SEQUENCE ol_cm_other.sc_ol_cm_type_user
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE ol_cm_other.sc_ol_cm_type_user OWNER TO olympus_own;
GRANT ALL ON SEQUENCE ol_cm_other.sc_ol_cm_type_user TO olympus_own;
-- ol_cm_other.tb_ol_cm_countries definition

-- Drop table

-- DROP TABLE ol_cm_other.tb_ol_cm_countries;

CREATE TABLE ol_cm_other.tb_ol_cm_countries (
	country_id int8 NOT NULL,
	abv varchar(4) NOT NULL,
	"name" varchar(50) NOT NULL,
	pref_tel varchar(4) NOT NULL,
	CONSTRAINT tb_ol_cm_countries_pkey PRIMARY KEY (country_id),
	CONSTRAINT uk_6n2v6o3vfn05p2d2lak5ket2s UNIQUE (abv),
	CONSTRAINT uk_pyrli3qcohj5ogdkr4lre60xx UNIQUE (name)
);

-- Permissions

ALTER TABLE ol_cm_other.tb_ol_cm_countries OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_other.tb_ol_cm_countries TO olympus_own;

-- Permissions

GRANT ALL ON SCHEMA ol_cm_other TO olympus_own;

------------------------------------------------------------------------------------ SCHEMA PAGE ---------------------------------------------------------------------------------

-- DROP SCHEMA ol_cm_page;

CREATE SCHEMA ol_cm_page AUTHORIZATION olympus_own;
-- ol_cm_page.tb_ol_cm_communities definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_communities;

CREATE TABLE ol_cm_page.tb_ol_cm_communities (
	community_id varchar(35) NOT NULL,
	cm_desc varchar(50000) NOT NULL,
	cm_name varchar(1000) NOT NULL,
	cm_score numeric(4, 2) NOT NULL,
	cm_views int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	status bool NOT NULL,
	CONSTRAINT tb_ol_cm_communities_pkey PRIMARY KEY (community_id),
	CONSTRAINT uk_ouwp78a4b3o204l4f8ms3pjjf UNIQUE (cm_name)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_communities OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_communities TO olympus_own;


-- ol_cm_page.tb_ol_cm_levels definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_levels;

CREATE TABLE ol_cm_page.tb_ol_cm_levels (
	level_id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	level_name varchar(50) NOT NULL,
	status bool NOT NULL,
	sub_level int8 NOT NULL,
	CONSTRAINT tb_ol_cm_levels_pkey PRIMARY KEY (level_id),
	CONSTRAINT uk_7lxn0vce25bsp6rm7881g8agl UNIQUE (level_name)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_levels OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_levels TO olympus_own;


-- ol_cm_page.tb_ol_cm_roles definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_roles;

CREATE TABLE ol_cm_page.tb_ol_cm_roles (
	role_id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	role_desc varchar(1000) NOT NULL,
	role_name varchar(50) NOT NULL,
	status bool NOT NULL,
	CONSTRAINT tb_ol_cm_roles_pkey PRIMARY KEY (role_id),
	CONSTRAINT uk_fysu86yhc2nd1hp09a5xpheaq UNIQUE (role_name)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_roles OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_roles TO olympus_own;


-- ol_cm_page.tb_ol_cm_socials definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_socials;

CREATE TABLE ol_cm_page.tb_ol_cm_socials (
	social_id int8 NOT NULL,
	social_name varchar(50) NOT NULL,
	CONSTRAINT tb_ol_cm_socials_pkey PRIMARY KEY (social_id),
	CONSTRAINT uk_sedfyvc3ivlyor3pst4ipsrd7 UNIQUE (social_name)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_socials OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_socials TO olympus_own;


-- ol_cm_page.tb_ol_cm_themes definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_themes;

CREATE TABLE ol_cm_page.tb_ol_cm_themes (
	theme_id int8 NOT NULL,
	theme_desc varchar(100) NOT NULL,
	CONSTRAINT tb_ol_cm_themes_pkey PRIMARY KEY (theme_id),
	CONSTRAINT uk_ol13l873bi7tf2cs00h7ig78e UNIQUE (theme_desc)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_themes OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_themes TO olympus_own;


-- ol_cm_page.tb_ol_cm_socials_pt definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_socials_pt;

CREATE TABLE ol_cm_page.tb_ol_cm_socials_pt (
	social_pt_id int8 NOT NULL,
	create_at timestamp NOT NULL,
	social_pt_click int8 NOT NULL,
	social_pt_desc varchar(1000) NOT NULL,
	social_pt_link varchar(1000) NOT NULL,
	social_pt_views int8 NOT NULL,
	status bool NOT NULL,
	community_id varchar(35) NOT NULL,
	social_id int8 NOT NULL,
	CONSTRAINT tb_ol_cm_socials_pt_pkey PRIMARY KEY (social_pt_id),
	CONSTRAINT uk_87j844je3tv4xs89xcigimiic UNIQUE (social_pt_link),
	CONSTRAINT fk_ol_cm_community_social_platform FOREIGN KEY (community_id) REFERENCES ol_cm_page.tb_ol_cm_communities(community_id),
	CONSTRAINT fk_ol_cm_social_platform_network FOREIGN KEY (social_id) REFERENCES ol_cm_page.tb_ol_cm_socials(social_id)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_socials_pt OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_socials_pt TO olympus_own;


-- ol_cm_page.tb_ol_cm_sub_themes definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_sub_themes;

CREATE TABLE ol_cm_page.tb_ol_cm_sub_themes (
	sub_theme_id int8 NOT NULL,
	sub_theme_desc varchar(100) NOT NULL,
	theme_id int8 NOT NULL,
	CONSTRAINT tb_ol_cm_sub_themes_pkey PRIMARY KEY (sub_theme_id),
	CONSTRAINT uk_l8lgovhkmxd5ojcvs7bmq1ffw UNIQUE (sub_theme_desc),
	CONSTRAINT fk_ol_cm_theme_sub_theme FOREIGN KEY (theme_id) REFERENCES ol_cm_page.tb_ol_cm_themes(theme_id)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_sub_themes OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_sub_themes TO olympus_own;


-- ol_cm_page.tb_ol_cm_com_themes definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_com_themes;

CREATE TABLE ol_cm_page.tb_ol_cm_com_themes (
	com_cat_id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	community_id varchar(35) NOT NULL,
	sub_theme_id int8 NOT NULL,
	theme_id int8 NOT NULL,
	CONSTRAINT tb_ol_cm_com_themes_pkey PRIMARY KEY (com_cat_id),
	CONSTRAINT fk_ol_cm_community_theme FOREIGN KEY (community_id) REFERENCES ol_cm_page.tb_ol_cm_communities(community_id),
	CONSTRAINT fk_ol_cm_theme_community FOREIGN KEY (theme_id) REFERENCES ol_cm_page.tb_ol_cm_themes(theme_id),
	CONSTRAINT fk_ol_cm_theme_community_sub_theme FOREIGN KEY (sub_theme_id) REFERENCES ol_cm_page.tb_ol_cm_sub_themes(sub_theme_id)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_com_themes OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_com_themes TO olympus_own;


-- ol_cm_page.tb_ol_cm_mg definition

-- Drop table

-- DROP TABLE ol_cm_page.tb_ol_cm_mg;

CREATE TABLE ol_cm_page.tb_ol_cm_mg (
	com_prof_id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	community_id varchar(35) NOT NULL,
	profile_id varchar(27) NOT NULL,
	role_id int8 NOT NULL,
	CONSTRAINT tb_ol_cm_mg_pkey PRIMARY KEY (com_prof_id)
);

-- Permissions

ALTER TABLE ol_cm_page.tb_ol_cm_mg OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_page.tb_ol_cm_mg TO olympus_own;


-- ol_cm_page.tb_ol_cm_mg foreign keys

ALTER TABLE ol_cm_page.tb_ol_cm_mg ADD CONSTRAINT fk_ol_cm_mg_ct FOREIGN KEY (community_id) REFERENCES ol_cm_page.tb_ol_cm_communities(community_id);
ALTER TABLE ol_cm_page.tb_ol_cm_mg ADD CONSTRAINT fk_ol_cm_mg_profile FOREIGN KEY (role_id) REFERENCES ol_cm_page.tb_ol_cm_roles(role_id);
ALTER TABLE ol_cm_page.tb_ol_cm_mg ADD CONSTRAINT fk_ol_cm_mg_role FOREIGN KEY (profile_id) REFERENCES ol_cm_session.tb_ol_cm_profiles(profile_id);

-- Permissions

GRANT ALL ON SCHEMA ol_cm_page TO olympus_own;

------------------------------------------------------------------------------------ SCHEMA SECURITY ---------------------------------------------------------------------------------

-- DROP SCHEMA ol_cm_security;

CREATE SCHEMA ol_cm_security AUTHORIZATION olympus_own;
-- ol_cm_security.tb_ol_cm_keys definition

-- Drop table

-- DROP TABLE ol_cm_security.tb_ol_cm_keys;

CREATE TABLE ol_cm_security.tb_ol_cm_keys (
	id_sk int8 NOT NULL,
	create_at timestamp NOT NULL,
	iv_key varchar(16) NOT NULL,
	key_pass varchar(1000) NOT NULL,
	salt_key varchar(32) NOT NULL,
	user_id varchar(25) NOT NULL,
	CONSTRAINT tb_ol_cm_keys_pkey PRIMARY KEY (id_sk),
	CONSTRAINT uk_6mhnc2hdc8ii66d0d8gllwgpt UNIQUE (key_pass),
	CONSTRAINT uk_ctpqrsoevtevimdduhcntx63 UNIQUE (iv_key),
	CONSTRAINT uk_djd04q5sljukeb99cjydv6eve UNIQUE (salt_key)
);

-- Permissions

ALTER TABLE ol_cm_security.tb_ol_cm_keys OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_security.tb_ol_cm_keys TO olympus_own;


-- ol_cm_security.tb_ol_cm_messages definition

-- Drop table

-- DROP TABLE ol_cm_security.tb_ol_cm_messages;

CREATE TABLE ol_cm_security.tb_ol_cm_messages (
	id_sk int8 NOT NULL,
	create_at timestamp NOT NULL,
	key_messages varchar(1000) NOT NULL,
	user_id varchar(25) NOT NULL,
	CONSTRAINT tb_ol_cm_messages_pkey PRIMARY KEY (id_sk),
	CONSTRAINT uk_7n1u9ncx563xd55x1udh3coym UNIQUE (key_messages)
);

-- Permissions

ALTER TABLE ol_cm_security.tb_ol_cm_messages OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_security.tb_ol_cm_messages TO olympus_own;


-- ol_cm_security.tb_ol_cm_keys foreign keys

ALTER TABLE ol_cm_security.tb_ol_cm_keys ADD CONSTRAINT fk_ol_cm_profile_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


-- ol_cm_security.tb_ol_cm_messages foreign keys

ALTER TABLE ol_cm_security.tb_ol_cm_messages ADD CONSTRAINT fk_ol_cm_profile_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);

-- Permissions

GRANT ALL ON SCHEMA ol_cm_security TO olympus_own;

------------------------------------------------------------------------------------ SCHEMA PAGE -------------------------------------------------------------------------------------

-- DROP SCHEMA ol_cm_session;

CREATE SCHEMA ol_cm_session AUTHORIZATION olympus_own;
-- ol_cm_session.tb_ol_cm_types definition

-- Drop table

-- DROP TABLE ol_cm_session.tb_ol_cm_types;

CREATE TABLE ol_cm_session.tb_ol_cm_types (
	type_id int8 NOT NULL,
	alias varchar(2) NOT NULL,
	"name" varchar(50) NOT NULL,
	num_limit int8 NOT NULL,
	CONSTRAINT tb_ol_cm_types_pkey PRIMARY KEY (type_id),
	CONSTRAINT uk_d3o72je2ohsaxsh581fx73xue UNIQUE (alias),
	CONSTRAINT uk_syy588o2enijucao6wh4w16af UNIQUE (name)
);

-- Permissions

ALTER TABLE ol_cm_session.tb_ol_cm_types OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_session.tb_ol_cm_types TO olympus_own;


-- ol_cm_session.tb_ol_cm_users definition

-- Drop table

-- DROP TABLE ol_cm_session.tb_ol_cm_users;

CREATE TABLE ol_cm_session.tb_ol_cm_users (
	user_id varchar(25) NOT NULL,
	email varchar(50) NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	"password" varchar(1000) NOT NULL,
	status bool NOT NULL,
	username varchar(50) NOT NULL,
	type_id int8 NOT NULL,
	CONSTRAINT tb_ol_cm_users_pkey PRIMARY KEY (user_id),
	CONSTRAINT fk_ol_cm_user_type FOREIGN KEY (type_id) REFERENCES ol_cm_session.tb_ol_cm_types(type_id)
);

-- Permissions

ALTER TABLE ol_cm_session.tb_ol_cm_users OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_session.tb_ol_cm_users TO olympus_own;


-- ol_cm_session.tb_ol_cm_profiles definition

-- Drop table

-- DROP TABLE ol_cm_session.tb_ol_cm_profiles;

CREATE TABLE ol_cm_session.tb_ol_cm_profiles (
	profile_id varchar(27) NOT NULL,
	alias varchar(50) NULL,
	"date" timestamp NULL,
	city varchar(50) NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	info varchar(50) NULL,
	"name" varchar(50) NOT NULL,
	nickname varchar(100) NULL,
	status bool NOT NULL,
	surname varchar(50) NOT NULL,
	country_id int8 NOT NULL,
	user_id varchar(25) NOT NULL,
	CONSTRAINT tb_ol_cm_profiles_pkey PRIMARY KEY (profile_id)
);

-- Permissions

ALTER TABLE ol_cm_session.tb_ol_cm_profiles OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_session.tb_ol_cm_profiles TO olympus_own;


-- ol_cm_session.tb_ol_cm_telephones definition

-- Drop table

-- DROP TABLE ol_cm_session.tb_ol_cm_telephones;

CREATE TABLE ol_cm_session.tb_ol_cm_telephones (
	tel_id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NULL,
	num_tel varchar(20) NOT NULL,
	status bool NOT NULL,
	country_id int8 NOT NULL,
	profile_id varchar(27) NOT NULL,
	CONSTRAINT tb_ol_cm_telephones_pkey PRIMARY KEY (tel_id)
);

-- Permissions

ALTER TABLE ol_cm_session.tb_ol_cm_telephones OWNER TO olympus_own;
GRANT ALL ON TABLE ol_cm_session.tb_ol_cm_telephones TO olympus_own;


-- ol_cm_session.tb_ol_cm_profiles foreign keys

ALTER TABLE ol_cm_session.tb_ol_cm_profiles ADD CONSTRAINT fk_ol_cm_profile_country FOREIGN KEY (country_id) REFERENCES ol_cm_other.tb_ol_cm_countries(country_id);
ALTER TABLE ol_cm_session.tb_ol_cm_profiles ADD CONSTRAINT fk_ol_cm_profile_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


-- ol_cm_session.tb_ol_cm_telephones foreign keys

ALTER TABLE ol_cm_session.tb_ol_cm_telephones ADD CONSTRAINT fk_ol_cm_tel_country FOREIGN KEY (country_id) REFERENCES ol_cm_other.tb_ol_cm_countries(country_id);
ALTER TABLE ol_cm_session.tb_ol_cm_telephones ADD CONSTRAINT fk_ol_cm_tel_profile FOREIGN KEY (profile_id) REFERENCES ol_cm_session.tb_ol_cm_profiles(profile_id);

-- Permissions

GRANT ALL ON SCHEMA ol_cm_session TO olympus_own;
