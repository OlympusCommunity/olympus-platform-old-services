-- Creación de usuario olympus_adm
DROP ROLE IF EXISTS olympus_adm;
CREATE ROLE olympus_adm SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN REPLICATION BYPASSRLS PASSWORD '4HwxhgLV5cBGR*vt^RNhQNk*';

-- Ceación de base de datos con el usuario olympus_adm
DROP DATABASE IF EXISTS olympus;
CREATE DATABASE olympus
    WITH
    OWNER = olympus_adm
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
-- Creación de esquemas por proyecto

-- ESQUEMA PARA BIENVENIDA Y MENSAJES DE LA PLATAFORMA
DROP SCHEMA IF EXISTS ol_cm_welcome CASCADE;
CREATE SCHEMA ol_cm_welcome AUTHORIZATION olympus_adm;

-- ESQUEMA PARA LAS SESSIONES
DROP SCHEMA IF EXISTS ol_cm_session CASCADE;
CREATE SCHEMA ol_cm_session AUTHORIZATION olympus_adm;

-- ESQUEMA PARA LA SEGURIDAD
DROP SCHEMA IF EXISTS ol_cm_security CASCADE;
CREATE SCHEMA ol_cm_security AUTHORIZATION olympus_adm;

-- ESQUEMA PARA LA PLATAFORMA
DROP SCHEMA IF EXISTS ol_cm_paltform CASCADE;
CREATE SCHEMA ol_cm_paltform AUTHORIZATION olympus_adm;

-- ESQUEMA PARA OTROS DATOS
DROP SCHEMA IF EXISTS ol_cm_other CASCADE;
CREATE SCHEMA ol_cm_other AUTHORIZATION olympus_adm;

-- ESQUEMA PARA LA ADMINISTRACION DE LA PLATAFORMA
DROP SCHEMA IF EXISTS ol_mt_admin CASCADE;
CREATE SCHEMA ol_mt_admin AUTHORIZATION olympus_adm;

-- ESQUEMA PARA LA CALIDAD
DROP SCHEMA IF EXISTS ol_mt_quality CASCADE;
CREATE SCHEMA ol_mt_quality AUTHORIZATION olympus_adm;

----------------------------------------------------------------------------------------------------------------------------
-- ACCEDER AL ESQUEMA DE BIENVENIDA Y MENSAJES
SET SCHEMA 'ol_cm_welcome';

-- CREACION DE TABLAS PARA EL ESQUEMA DE BIENVENIDA
--
-- TOC entry 251 (class 1259 OID 16665)
-- Name: tb_ol_cm_representer; Type: TABLE; Schema: ol_cm_welcome; Owner: olympus_adm
--

CREATE TABLE ol_cm_welcome.tb_ol_cm_representer (
    representer_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP DEFAULT NULL,
    updated_at TIMESTAMP DEFAULT NULL,
    representer_desc VARCHAR(1000),
    representer_img BYTEA DEFAULT NULL,
    representer_lang VARCHAR(2),
    representer_name VARCHAR(50) NOT NULL,
    representer_role VARCHAR(50),
    status BOOLEAN NOT NULL DEFAULT TRUE,
	CONSTRAINT "pk_tb_ol_cm_representer" PRIMARY KEY (representer_id),
	CONSTRAINT "uq_tb_ol_cm_representer_name" UNIQUE (representer_name)
);

ALTER TABLE ol_cm_welcome.tb_ol_cm_representer OWNER TO olympus_adm;

--
-- TOC entry 252 (class 1259 OID 16672)
-- Name: tb_ol_cm_welcome; Type: TABLE; Schema: ol_cm_welcome; Owner: olympus_adm
--

CREATE TABLE ol_cm_welcome.tb_ol_cm_welcome (
    welcome_id BIGINT NOT NULL,
    card1_sub_tiitle VARCHAR(1000) NOT NULL,
    card1_tiitle VARCHAR(50) NOT NULL,
    card2_sub_tiitle VARCHAR(1000) NOT NULL,
    card2_tiitle VARCHAR(50) NOT NULL,
    card3_sub_tiitle VARCHAR(1000) NOT NULL,
    card3_tiitle VARCHAR(50) NOT NULL,
    card4_sub_tiitle VARCHAR(1000) NOT NULL,
    card4_tiitle VARCHAR(50) NOT NULL,
    community_tiitle VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP DEFAULT NULL,
    desc_community VARCHAR(1000) NOT NULL,
    desc_profile VARCHAR(1000) NOT NULL,
    desc_sub VARCHAR(1000) NOT NULL,
    desc_team VARCHAR(1000) NOT NULL,
    desc_theme VARCHAR(1000) NOT NULL,
    updated_at TIMESTAMP DEFAULT NULL,
    main_sub_tiitle VARCHAR(1000) NOT NULL,
    main_tiitle VARCHAR(1000) NOT NULL,
    other_text1 VARCHAR(50) NOT NULL,
    other_text2 VARCHAR(1000) NOT NULL,
    profile_tittle VARCHAR(50) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE,
    sub_tittle VARCHAR(50) NOT NULL,
    team_tiitle VARCHAR(50) NOT NULL,
    theme_tittle VARCHAR(50) NOT NULL,
    welcome_lang VARCHAR(2) NOT NULL DEFAULT 'ES',
    CONSTRAINT "pk_tb_ol_cm_welcome" PRIMARY KEY (welcome_id)
);

ALTER TABLE ol_cm_welcome.tb_ol_cm_welcome OWNER TO olympus_adm;

-- CREACION DE SECUENCIAS PARA EL ESQUEMA DE BIENVENIDA
--
-- TOC entry 249 (class 1259 OID 16663)
-- Name: sc_ol_cm_representer_id; Type: SEQUENCE; Schema: ol_cm_welcome; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_welcome.sc_ol_cm_representer_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ol_cm_welcome.sc_ol_cm_representer_id OWNER TO olympus_adm;

--
-- TOC entry 250 (class 1259 OID 16664)
-- Name: sc_ol_cm_welcome_id; Type: SEQUENCE; Schema: ol_cm_welcome; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_welcome.sc_ol_cm_welcome_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ol_cm_welcome.sc_ol_cm_welcome_id OWNER TO olympus_adm;

-------------------------------------------------------------------------------------------------------------------------
-- ACCEDER AL ESQUEMA DE SEGURIDAD
SET SCHEMA 'ol_cm_security';

-- CREAR TABLAS PARA EL ESQUEMA DE SEGURIDAD
--
-- TOC entry 239 (class 1259 OID 16589)
-- Name: tb_ol_cm_audit; Type: TABLE; Schema: ol_cm_security; Owner: -
--

CREATE TABLE ol_cm_security.tb_ol_cm_audit (
    action_id BIGINT NOT NULL,
    action_desc VARCHAR(1000) NOT NULL,
    audit_id BIGINT NOT NULL,
    browser VARCHAR(100),
    date_audit TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ip_receiver VARCHAR(16),
    reason VARCHAR(100) NOT NULL,
    user_id VARCHAR(25) NOT null,
    CONSTRAINT "pk_tb_ol_cm_audit" PRIMARY KEY (action_id)
);

ALTER TABLE ol_cm_security.tb_ol_cm_audit OWNER TO olympus_adm;
--
-- TOC entry 240 (class 1259 OID 16596)
-- Name: tb_ol_cm_keys; Type: TABLE; Schema: ol_cm_security; Owner: -
--

CREATE TABLE ol_cm_security.tb_ol_cm_keys (
    id_sk BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    iv_key VARCHAR(16) NOT NULL,
    key_pass VARCHAR(1000) NOT NULL,
    salt_key VARCHAR(32) NOT NULL,
    user_id VARCHAR(25) NOT NULL,
    CONSTRAINT "pk_tb_ol_cm_keys" PRIMARY KEY (id_sk)
);

ALTER TABLE ol_cm_security.tb_ol_cm_keys OWNER TO olympus_adm;
--
-- TOC entry 241 (class 1259 OID 16603)
-- Name: tb_ol_cm_messages; Type: TABLE; Schema: ol_cm_security; Owner: -
--

CREATE TABLE ol_cm_security.tb_ol_cm_messages (
    id_ms_sk BIGINT NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    key_messages VARCHAR(1000) NOT NULL,
    user_id VARCHAR(25) NOT NULL,
    CONSTRAINT "pk_tb_ol_cm_messages" PRIMARY KEY (id_ms_sk)
);

ALTER TABLE ol_cm_security.tb_ol_cm_messages OWNER TO olympus_adm;

-- CREAR SECUENCIAS PARA EL ESQUEMA DE SEGURIDAD
--
-- TOC entry 236 (class 1259 OID 16586)
-- Name: sc_ol_cm_security_audit; Type: SEQUENCE; Schema: ol_cm_security; Owner: -
--

CREATE SEQUENCE ol_cm_security.sc_ol_cm_security_audit
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ol_cm_security.sc_ol_cm_security_audit OWNER TO olympus_adm;
--
-- TOC entry 237 (class 1259 OID 16587)
-- Name: sc_ol_cm_security_keys; Type: SEQUENCE; Schema: ol_cm_security; Owner: -
--

CREATE SEQUENCE ol_cm_security.sc_ol_cm_security_keys
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ol_cm_security.sc_ol_cm_security_keys OWNER TO olympus_adm;

--
-- TOC entry 238 (class 1259 OID 16588)
-- Name: sc_ol_cm_security_msn_keys; Type: SEQUENCE; Schema: ol_cm_security; Owner: -
--

CREATE SEQUENCE ol_cm_security.sc_ol_cm_security_msn_keys
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
   
ALTER TABLE ol_cm_security.sc_ol_cm_security_msn_keys OWNER TO olympus_adm;
---------------------------------------------------------------------------------------------------------------------------
-- ACCEDER AL ESQUEMA DE OTROS DATOS
SET SCHEMA 'ol_cm_other';

-- CREAR TABLAS DEL ESQUEMA DE OTROS DATOS
--
-- TOC entry 215 (class 1259 OID 16487)
-- Name: tb_ol_cm_country; Type: TABLE; Schema: ol_cm_other; Owner: olympus_adm
--

CREATE TABLE ol_cm_other.tb_ol_cm_country (
    country_id BIGINT NOT NULL,
    abv VARCHAR(4) NOT NULL,
    country_name VARCHAR(50) NOT NULL,
    pref_tel VARCHAR(4) NOT null,
    CONSTRAINT "pk_tb_ol_cm_country" PRIMARY KEY (country_id),
    CONSTRAINT "uq_tb_ol_cm_country_name" UNIQUE (country_name)
);

ALTER TABLE ol_cm_other.tb_ol_cm_country OWNER TO olympus_adm;
--
-- TOC entry 216 (class 1259 OID 16492)
-- Name: tb_ol_cm_status; Type: TABLE; Schema: ol_cm_other; Owner: olympus_adm
--

CREATE TABLE ol_cm_other.tb_ol_cm_status (
    status_id BIGINT NOT NULL,
    status_desc VARCHAR(50) NOT null,
    CONSTRAINT "pk_tb_ol_cm_status" PRIMARY KEY (status_id),
    CONSTRAINT "uq_tb_ol_cm_status_desc" UNIQUE (status_desc)
);

ALTER TABLE ol_cm_other.tb_ol_cm_status OWNER TO olympus_adm;

-- CREAR SECUENCIAS DEL ESQUEMA DE OTROS DATOS
--
-- TOC entry 213 (class 1259 OID 16485)
-- Name: sc_ol_cm_country_id; Type: SEQUENCE; Schema: ol_cm_other; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_other.sc_ol_cm_country_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ol_cm_other.sc_ol_cm_country_id OWNER TO olympus_adm;

--
-- TOC entry 214 (class 1259 OID 16486)
-- Name: sc_ol_cm_status_id; Type: SEQUENCE; Schema: ol_cm_other; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_other.sc_ol_cm_status_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-------------------------------------------------------------------------------------------------------------------------
-- ACCEDER AL ESQUEMA DE SESIONES
SET SCHEMA 'ol_cm_session';

-- CREACION DE TABLAS DEL ESQUEMA DE SESIONES

------------------------------- CREACION DE LA TABLA DE TIPOS DE USUARIOS ----------------------------
--
-- TOC entry 248 (class 1259 OID 16642)
-- Name: tb_ol_cm_usertype; Type: TABLE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE TABLE ol_cm_session.tb_ol_cm_usertype (
    type_id BIGINT NOT NULL,
    type_abv VARCHAR(2) NOT NULL,
    alias VARCHAR(50) NOT NULL,
    type_desc VARCHAR(1000) NOT NULL,
    type_name VARCHAR(50) NOT NULL,
    num_limit BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT "pk_tb_ol_cm_usertype" PRIMARY KEY (type_id),
    CONSTRAINT "uq_tb_ol_cm_usertype_type_name" UNIQUE (type_name)
);

-- PERMISOS DE TABLA
ALTER TABLE ol_cm_session.tb_ol_cm_usertype OWNER TO olympus_adm;

--
-- TOC entry 243 (class 1259 OID 16619)
-- Name: sc_ol_cm_type_user; Type: SEQUENCE; Schema: ol_cm_session; Owner: -
--

CREATE SEQUENCE ol_cm_session.sc_ol_cm_type_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
   
-- DAR PERMISOS A LA SECUENCIA
ALTER TABLE ol_cm_other.sc_ol_cm_country_id OWNER TO olympus_adm;

-- INSERCIÓN DE DATOS PARA LOS TIPOS DE USUARIOS
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (1, 'PS', 'ROLE_PERS', 'Usuario de tipo personal para cada individuo que gestione comunidades sociales.', 'USUARIO PERSONAL', 10000);
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (2, 'CM', 'ROLE_CM', 'Usuario de tipo comunidad, en el cual representa a un conjunto de personas en un grupo social.', 'COMUNIDAD', 1000);
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (3, 'BS', 'ROLE_BS', 'Usuario de tipo de negocios, en el cual representa a una empresa o negocio.', 'NEGOCIOS', 1000);
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (4, 'AD', 'ROLE_ADMIN', 'Usuario de tipo administrador, con acceso total a la plataforma.', 'ADMINISTRADOR', 100);
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (5, 'FN', 'ROLE_FIN', 'Usuario de tipo de finanzas, con acceso a la monetización y finanzas de la plataforma.', 'FINANZAS', 100);
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (6, 'QA', 'ROLE_QA', 'Usuario de tipo calificador.', 'CALIFICADOR', 10);
INSERT INTO ol_cm_session.tb_ol_cm_usertype VALUES (7, 'MS', 'ROLE_MASTER', 'Usuario maestro con acceso especial a la plataforma', 'MASTER', 1);
------------------------------- FIN DE CRECIÓN DE LA TABLA DE TIPOS DE USUARIOS ----------------------------

--------------------------------------- CREACION DE LA TABLA DE USUARIOS -----------------------------------
--
-- TOC entry 247 (class 1259 OID 16635)
-- Name: tb_ol_cm_users; Type: TABLE; Schema: ol_cm_session; Owner: -
--

CREATE TABLE ol_cm_session.tb_ol_cm_users (
    user_id VARCHAR(25) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    us_password VARCHAR(1000) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP DEFAULT NULL,
    updated_at TIMESTAMP DEFAULT NULL,
    CONSTRAINT "pk_tb_ol_cm_users" PRIMARY KEY (user_id),
    CONSTRAINT "uq_tb_ol_cm_users_username" UNIQUE (username),
    CONSTRAINT "uq_tb_ol_cm_users_email" UNIQUE (email),
);
