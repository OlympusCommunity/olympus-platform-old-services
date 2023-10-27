--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2022-06-18 11:57:51

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE olympus;
--
-- TOC entry 3563 (class 1262 OID 16395)
-- Name: olympus; Type: DATABASE; Schema: -; Owner: olympus_adm
--

CREATE DATABASE olympus WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';


ALTER DATABASE olympus OWNER TO olympus_adm;

\connect olympus

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16483)
-- Name: ol_cm_other; Type: SCHEMA; Schema: -; Owner: olympus_adm
--

CREATE SCHEMA ol_cm_other;


ALTER SCHEMA ol_cm_other OWNER TO olympus_adm;

--
-- TOC entry 3 (class 2615 OID 16484)
-- Name: ol_cm_page; Type: SCHEMA; Schema: -; Owner: olympus_adm
--

CREATE SCHEMA ol_cm_page;


ALTER SCHEMA ol_cm_page OWNER TO olympus_adm;

--
-- TOC entry 7 (class 2615 OID 16482)
-- Name: ol_cm_security; Type: SCHEMA; Schema: -; Owner: olympus_adm
--

CREATE SCHEMA ol_cm_security;


ALTER SCHEMA ol_cm_security OWNER TO olympus_adm;

--
-- TOC entry 4 (class 2615 OID 16480)
-- Name: ol_cm_session; Type: SCHEMA; Schema: -; Owner: olympus_adm
--

CREATE SCHEMA ol_cm_session;


ALTER SCHEMA ol_cm_session OWNER TO olympus_adm;

--
-- TOC entry 5 (class 2615 OID 16481)
-- Name: ol_cm_welcome; Type: SCHEMA; Schema: -; Owner: olympus_adm
--

CREATE SCHEMA ol_cm_welcome;


ALTER SCHEMA ol_cm_welcome OWNER TO olympus_adm;

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


ALTER TABLE ol_cm_other.sc_ol_cm_status_id OWNER TO olympus_adm;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16487)
-- Name: tb_ol_cm_country; Type: TABLE; Schema: ol_cm_other; Owner: olympus_adm
--

CREATE TABLE ol_cm_other.tb_ol_cm_country (
    country_id bigint NOT NULL,
    abv character varying(4) NOT NULL,
    country_name character varying(50) NOT NULL,
    pref_tel character varying(4) NOT NULL
);


ALTER TABLE ol_cm_other.tb_ol_cm_country OWNER TO olympus_adm;

--
-- TOC entry 216 (class 1259 OID 16492)
-- Name: tb_ol_cm_status; Type: TABLE; Schema: ol_cm_other; Owner: olympus_adm
--

CREATE TABLE ol_cm_other.tb_ol_cm_status (
    status_id bigint NOT NULL,
    status_desc character varying(50) NOT NULL
);


ALTER TABLE ol_cm_other.tb_ol_cm_status OWNER TO olympus_adm;

--
-- TOC entry 217 (class 1259 OID 16503)
-- Name: sc_ol_cm_com_cat_id; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_com_cat_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_com_cat_id OWNER TO olympus_adm;

--
-- TOC entry 218 (class 1259 OID 16504)
-- Name: sc_ol_cm_com_prof_id; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_com_prof_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_com_prof_id OWNER TO olympus_adm;

--
-- TOC entry 219 (class 1259 OID 16505)
-- Name: sc_ol_cm_level_id; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_level_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_level_id OWNER TO olympus_adm;

--
-- TOC entry 220 (class 1259 OID 16506)
-- Name: sc_ol_cm_profile_theme; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_profile_theme
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_profile_theme OWNER TO olympus_adm;

--
-- TOC entry 221 (class 1259 OID 16507)
-- Name: sc_ol_cm_role_id; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_role_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_role_id OWNER TO olympus_adm;

--
-- TOC entry 222 (class 1259 OID 16508)
-- Name: sc_ol_cm_social_pt; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_social_pt
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_social_pt OWNER TO olympus_adm;

--
-- TOC entry 223 (class 1259 OID 16509)
-- Name: sc_ol_cm_sub_theme_id; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_sub_theme_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_sub_theme_id OWNER TO olympus_adm;

--
-- TOC entry 224 (class 1259 OID 16510)
-- Name: sc_ol_cm_theme_id; Type: SEQUENCE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_page.sc_ol_cm_theme_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_page.sc_ol_cm_theme_id OWNER TO olympus_adm;

--
-- TOC entry 225 (class 1259 OID 16511)
-- Name: tb_ol_cm_com_theme; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_com_theme (
    com_cat_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    status boolean NOT NULL,
    community_id character varying(35) NOT NULL,
    sub_theme_id bigint NOT NULL,
    theme_id bigint NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_com_theme OWNER TO olympus_adm;

--
-- TOC entry 226 (class 1259 OID 16516)
-- Name: tb_ol_cm_community; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_community (
    community_id character varying(35) NOT NULL,
    cm_desc character varying(50000),
    cm_name character varying(1000) NOT NULL,
    cm_photo bytea,
    cm_photo_path character varying(1000),
    cm_score numeric(4,2),
    cm_views bigint,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    status boolean NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_community OWNER TO olympus_adm;

--
-- TOC entry 227 (class 1259 OID 16523)
-- Name: tb_ol_cm_level; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_level (
    level_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    level_name character varying(50) NOT NULL,
    status boolean NOT NULL,
    sub_level bigint NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_level OWNER TO olympus_adm;

--
-- TOC entry 228 (class 1259 OID 16528)
-- Name: tb_ol_cm_mg; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_mg (
    com_prof_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    status boolean NOT NULL,
    community_id character varying(35) NOT NULL,
    profile_id character varying(27) NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_mg OWNER TO olympus_adm;

--
-- TOC entry 229 (class 1259 OID 16533)
-- Name: tb_ol_cm_profile_theme; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_profile_theme (
    prof_theme_id bigint NOT NULL,
    profile_id character varying(27) NOT NULL,
    sub_theme_id bigint NOT NULL,
    theme_id bigint NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_profile_theme OWNER TO olympus_adm;

--
-- TOC entry 230 (class 1259 OID 16538)
-- Name: tb_ol_cm_role; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_role (
    role_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    role_desc character varying(1000) NOT NULL,
    role_name character varying(50) NOT NULL,
    status boolean NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_role OWNER TO olympus_adm;

--
-- TOC entry 231 (class 1259 OID 16545)
-- Name: tb_ol_cm_social; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_social (
    social_id bigint NOT NULL,
    social_name character varying(50) NOT NULL,
    social_button character varying(50) NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_social OWNER TO olympus_adm;

--
-- TOC entry 232 (class 1259 OID 16550)
-- Name: tb_ol_cm_socials_pt; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_socials_pt (
    social_pt_id bigint NOT NULL,
    create_at timestamp without time zone NOT NULL,
    social_pt_click bigint NOT NULL,
    social_pt_desc character varying(1000) NOT NULL,
    social_pt_link character varying(1000) NOT NULL,
    social_pt_views bigint NOT NULL,
    status boolean NOT NULL,
    community_id character varying(35) NOT NULL,
    social_id bigint NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_socials_pt OWNER TO olympus_adm;

--
-- TOC entry 233 (class 1259 OID 16557)
-- Name: tb_ol_cm_sub_themes; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_sub_themes (
    sub_theme_id bigint NOT NULL,
    sub_theme_desc character varying(1000) NOT NULL,
    sub_theme_name character varying(100) NOT NULL,
    theme_id bigint NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_sub_themes OWNER TO olympus_adm;

--
-- TOC entry 234 (class 1259 OID 16564)
-- Name: tb_ol_cm_theme; Type: TABLE; Schema: ol_cm_page; Owner: olympus_adm
--

CREATE TABLE ol_cm_page.tb_ol_cm_theme (
    theme_id bigint NOT NULL,
    theme_desc character varying(1000) NOT NULL,
    theme_name character varying(100) NOT NULL
);


ALTER TABLE ol_cm_page.tb_ol_cm_theme OWNER TO olympus_adm;

--
-- TOC entry 235 (class 1259 OID 16585)
-- Name: sc_ol_cm_com_cat_id; Type: SEQUENCE; Schema: ol_cm_security; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_security.sc_ol_cm_com_cat_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_security.sc_ol_cm_com_cat_id OWNER TO olympus_adm;

--
-- TOC entry 236 (class 1259 OID 16586)
-- Name: sc_ol_cm_security_audit; Type: SEQUENCE; Schema: ol_cm_security; Owner: olympus_adm
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
-- Name: sc_ol_cm_security_keys; Type: SEQUENCE; Schema: ol_cm_security; Owner: olympus_adm
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
-- Name: sc_ol_cm_security_msn_keys; Type: SEQUENCE; Schema: ol_cm_security; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_security.sc_ol_cm_security_msn_keys
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_security.sc_ol_cm_security_msn_keys OWNER TO olympus_adm;

--
-- TOC entry 239 (class 1259 OID 16589)
-- Name: tb_ol_cm_audit; Type: TABLE; Schema: ol_cm_security; Owner: olympus_adm
--

CREATE TABLE ol_cm_security.tb_ol_cm_audit (
    action_id bigint NOT NULL,
    action_desc character varying(1000) NOT NULL,
    audit_id bigint NOT NULL,
    browser character varying(100),
    date timestamp without time zone NOT NULL,
    ip_receiver character varying(16),
    reason character varying(100) NOT NULL,
    user_id character varying(25) NOT NULL
);


ALTER TABLE ol_cm_security.tb_ol_cm_audit OWNER TO olympus_adm;

--
-- TOC entry 240 (class 1259 OID 16596)
-- Name: tb_ol_cm_keys; Type: TABLE; Schema: ol_cm_security; Owner: olympus_adm
--

CREATE TABLE ol_cm_security.tb_ol_cm_keys (
    id_sk bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    iv_key character varying(16) NOT NULL,
    key_pass character varying(1000) NOT NULL,
    salt_key character varying(32) NOT NULL,
    user_id character varying(25) NOT NULL
);


ALTER TABLE ol_cm_security.tb_ol_cm_keys OWNER TO olympus_adm;

--
-- TOC entry 241 (class 1259 OID 16603)
-- Name: tb_ol_cm_messages; Type: TABLE; Schema: ol_cm_security; Owner: olympus_adm
--

CREATE TABLE ol_cm_security.tb_ol_cm_messages (
    id_sk bigint NOT NULL,
    create_at timestamp without time zone NOT NULL,
    key_messages character varying(1000) NOT NULL,
    user_id character varying(25) NOT NULL
);


ALTER TABLE ol_cm_security.tb_ol_cm_messages OWNER TO olympus_adm;

--
-- TOC entry 242 (class 1259 OID 16618)
-- Name: sc_ol_cm_tel_profile; Type: SEQUENCE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_session.sc_ol_cm_tel_profile
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_session.sc_ol_cm_tel_profile OWNER TO olympus_adm;

--
-- TOC entry 243 (class 1259 OID 16619)
-- Name: sc_ol_cm_type_user; Type: SEQUENCE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE SEQUENCE ol_cm_session.sc_ol_cm_type_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ol_cm_session.sc_ol_cm_type_user OWNER TO olympus_adm;

--
-- TOC entry 244 (class 1259 OID 16620)
-- Name: tb_ol_cm_profile; Type: TABLE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE TABLE ol_cm_session.tb_ol_cm_profile (
    profile_id character varying(27) NOT NULL,
    alias character varying(50),
    birthdate timestamp without time zone,
    city character varying(50) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    long_info character varying(50000),
    prof_name character varying(50) NOT NULL,
    nickname character varying(100),
    profile_photo bytea,
    short_info character varying(1000),
    status boolean NOT NULL,
    surname character varying(50) NOT NULL,
    country_id bigint NOT NULL,
    user_id character varying(25) NOT NULL
);


ALTER TABLE ol_cm_session.tb_ol_cm_profile OWNER TO olympus_adm;

--
-- TOC entry 245 (class 1259 OID 16627)
-- Name: tb_ol_cm_telephone; Type: TABLE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE TABLE ol_cm_session.tb_ol_cm_telephone (
    tel_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    num_tel character varying(20) NOT NULL,
    status boolean NOT NULL,
    country_id bigint NOT NULL,
    profile_id character varying(27) NOT NULL
);


ALTER TABLE ol_cm_session.tb_ol_cm_telephone OWNER TO olympus_adm;

--
-- TOC entry 246 (class 1259 OID 16632)
-- Name: tb_ol_cm_user_typeuser; Type: TABLE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE TABLE ol_cm_session.tb_ol_cm_user_typeuser (
    user_id character varying(25) NOT NULL,
    type_id bigint NOT NULL
);


ALTER TABLE ol_cm_session.tb_ol_cm_user_typeuser OWNER TO olympus_adm;

--
-- TOC entry 247 (class 1259 OID 16635)
-- Name: tb_ol_cm_users; Type: TABLE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE TABLE ol_cm_session.tb_ol_cm_users (
    user_id character varying(25) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    email character varying(50) NOT NULL,
    password character varying(1000) NOT NULL,
    status boolean NOT NULL,
    username character varying(50) NOT NULL
);


ALTER TABLE ol_cm_session.tb_ol_cm_users OWNER TO olympus_adm;

--
-- TOC entry 248 (class 1259 OID 16642)
-- Name: tb_ol_cm_usertype; Type: TABLE; Schema: ol_cm_session; Owner: olympus_adm
--

CREATE TABLE ol_cm_session.tb_ol_cm_usertype (
    type_id bigint NOT NULL,
    type_abv character varying(2),
    alias character varying(50) NOT NULL,
    type_desc character varying(1000) NOT NULL,
    type_name character varying(50) NOT NULL,
    num_limit bigint NOT NULL
);


ALTER TABLE ol_cm_session.tb_ol_cm_usertype OWNER TO olympus_adm;

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

--
-- TOC entry 251 (class 1259 OID 16665)
-- Name: tb_ol_cm_representer; Type: TABLE; Schema: ol_cm_welcome; Owner: olympus_adm
--

CREATE TABLE ol_cm_welcome.tb_ol_cm_representer (
    representer_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    representer_desc character varying(1000),
    representer_img bytea,
    representer_lang character varying(2),
    representer_name character varying(50) NOT NULL,
    representer_role character varying(50),
    status boolean NOT NULL
);


ALTER TABLE ol_cm_welcome.tb_ol_cm_representer OWNER TO olympus_adm;

--
-- TOC entry 252 (class 1259 OID 16672)
-- Name: tb_ol_cm_welcome; Type: TABLE; Schema: ol_cm_welcome; Owner: olympus_adm
--

CREATE TABLE ol_cm_welcome.tb_ol_cm_welcome (
    welcome_id bigint NOT NULL,
    card1_sub_tiitle character varying(1000) NOT NULL,
    card1_tiitle character varying(50) NOT NULL,
    card2_sub_tiitle character varying(1000) NOT NULL,
    card2_tiitle character varying(50) NOT NULL,
    card3_sub_tiitle character varying(1000) NOT NULL,
    card3_tiitle character varying(50) NOT NULL,
    card4_sub_tiitle character varying(1000) NOT NULL,
    card4_tiitle character varying(50) NOT NULL,
    community_tiitle character varying(50) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone,
    desc_community character varying(1000) NOT NULL,
    desc_profile character varying(1000) NOT NULL,
    desc_sub character varying(1000) NOT NULL,
    desc_team character varying(1000) NOT NULL,
    desc_theme character varying(1000) NOT NULL,
    updated_at timestamp without time zone,
    main_sub_tiitle character varying(1000) NOT NULL,
    main_tiitle character varying(1000) NOT NULL,
    other_text1 character varying(50) NOT NULL,
    other_text2 character varying(1000) NOT NULL,
    profile_tittle character varying(50) NOT NULL,
    status boolean NOT NULL,
    sub_tittle character varying(50) NOT NULL,
    team_tiitle character varying(50) NOT NULL,
    theme_tittle character varying(50) NOT NULL,
    welcome_lang character varying(2)
);


ALTER TABLE ol_cm_welcome.tb_ol_cm_welcome OWNER TO olympus_adm;

--
-- TOC entry 3520 (class 0 OID 16487)
-- Dependencies: 215
-- Data for Name: tb_ol_cm_country; Type: TABLE DATA; Schema: ol_cm_other; Owner: olympus_adm
--

COPY ol_cm_other.tb_ol_cm_country (country_id, abv, country_name, pref_tel) FROM stdin;
\.


--
-- TOC entry 3521 (class 0 OID 16492)
-- Dependencies: 216
-- Data for Name: tb_ol_cm_status; Type: TABLE DATA; Schema: ol_cm_other; Owner: olympus_adm
--

COPY ol_cm_other.tb_ol_cm_status (status_id, status_desc) FROM stdin;
\.


--
-- TOC entry 3530 (class 0 OID 16511)
-- Dependencies: 225
-- Data for Name: tb_ol_cm_com_theme; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_com_theme (com_cat_id, created_at, deleted_at, updated_at, status, community_id, sub_theme_id, theme_id) FROM stdin;
\.


--
-- TOC entry 3531 (class 0 OID 16516)
-- Dependencies: 226
-- Data for Name: tb_ol_cm_community; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_community (community_id, cm_desc, cm_name, cm_photo, cm_photo_path, cm_score, cm_views, created_at, deleted_at, updated_at, status) FROM stdin;
\.


--
-- TOC entry 3532 (class 0 OID 16523)
-- Dependencies: 227
-- Data for Name: tb_ol_cm_level; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_level (level_id, created_at, deleted_at, updated_at, level_name, status, sub_level) FROM stdin;
\.


--
-- TOC entry 3533 (class 0 OID 16528)
-- Dependencies: 228
-- Data for Name: tb_ol_cm_mg; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_mg (com_prof_id, created_at, deleted_at, updated_at, status, community_id, profile_id, role_id) FROM stdin;
\.


--
-- TOC entry 3534 (class 0 OID 16533)
-- Dependencies: 229
-- Data for Name: tb_ol_cm_profile_theme; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_profile_theme (prof_theme_id, profile_id, sub_theme_id, theme_id) FROM stdin;
\.


--
-- TOC entry 3535 (class 0 OID 16538)
-- Dependencies: 230
-- Data for Name: tb_ol_cm_role; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_role (role_id, created_at, deleted_at, updated_at, role_desc, role_name, status) FROM stdin;
\.


--
-- TOC entry 3536 (class 0 OID 16545)
-- Dependencies: 231
-- Data for Name: tb_ol_cm_social; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_social (social_id, social_name, social_button) FROM stdin;
\.


--
-- TOC entry 3537 (class 0 OID 16550)
-- Dependencies: 232
-- Data for Name: tb_ol_cm_socials_pt; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_socials_pt (social_pt_id, create_at, social_pt_click, social_pt_desc, social_pt_link, social_pt_views, status, community_id, social_id) FROM stdin;
\.


--
-- TOC entry 3538 (class 0 OID 16557)
-- Dependencies: 233
-- Data for Name: tb_ol_cm_sub_themes; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_sub_themes (sub_theme_id, sub_theme_desc, sub_theme_name, theme_id) FROM stdin;
\.


--
-- TOC entry 3539 (class 0 OID 16564)
-- Dependencies: 234
-- Data for Name: tb_ol_cm_theme; Type: TABLE DATA; Schema: ol_cm_page; Owner: olympus_adm
--

COPY ol_cm_page.tb_ol_cm_theme (theme_id, theme_desc, theme_name) FROM stdin;
\.


--
-- TOC entry 3544 (class 0 OID 16589)
-- Dependencies: 239
-- Data for Name: tb_ol_cm_audit; Type: TABLE DATA; Schema: ol_cm_security; Owner: olympus_adm
--

COPY ol_cm_security.tb_ol_cm_audit (action_id, action_desc, audit_id, browser, date, ip_receiver, reason, user_id) FROM stdin;
\.


--
-- TOC entry 3545 (class 0 OID 16596)
-- Dependencies: 240
-- Data for Name: tb_ol_cm_keys; Type: TABLE DATA; Schema: ol_cm_security; Owner: olympus_adm
--

COPY ol_cm_security.tb_ol_cm_keys (id_sk, created_at, iv_key, key_pass, salt_key, user_id) FROM stdin;
\.


--
-- TOC entry 3546 (class 0 OID 16603)
-- Dependencies: 241
-- Data for Name: tb_ol_cm_messages; Type: TABLE DATA; Schema: ol_cm_security; Owner: olympus_adm
--

COPY ol_cm_security.tb_ol_cm_messages (id_sk, create_at, key_messages, user_id) FROM stdin;
\.


--
-- TOC entry 3549 (class 0 OID 16620)
-- Dependencies: 244
-- Data for Name: tb_ol_cm_profile; Type: TABLE DATA; Schema: ol_cm_session; Owner: olympus_adm
--

COPY ol_cm_session.tb_ol_cm_profile (profile_id, alias, birthdate, city, created_at, deleted_at, updated_at, long_info, prof_name, nickname, profile_photo, short_info, status, surname, country_id, user_id) FROM stdin;
\.


--
-- TOC entry 3550 (class 0 OID 16627)
-- Dependencies: 245
-- Data for Name: tb_ol_cm_telephone; Type: TABLE DATA; Schema: ol_cm_session; Owner: olympus_adm
--

COPY ol_cm_session.tb_ol_cm_telephone (tel_id, created_at, deleted_at, updated_at, num_tel, status, country_id, profile_id) FROM stdin;
\.


--
-- TOC entry 3551 (class 0 OID 16632)
-- Dependencies: 246
-- Data for Name: tb_ol_cm_user_typeuser; Type: TABLE DATA; Schema: ol_cm_session; Owner: olympus_adm
--

COPY ol_cm_session.tb_ol_cm_user_typeuser (user_id, type_id) FROM stdin;
\.


--
-- TOC entry 3552 (class 0 OID 16635)
-- Dependencies: 247
-- Data for Name: tb_ol_cm_users; Type: TABLE DATA; Schema: ol_cm_session; Owner: olympus_adm
--

COPY ol_cm_session.tb_ol_cm_users (user_id, created_at, deleted_at, updated_at, email, password, status, username) FROM stdin;
\.


--
-- TOC entry 3553 (class 0 OID 16642)
-- Dependencies: 248
-- Data for Name: tb_ol_cm_usertype; Type: TABLE DATA; Schema: ol_cm_session; Owner: olympus_adm
--

COPY ol_cm_session.tb_ol_cm_usertype (type_id, type_abv, alias, type_desc, type_name, num_limit) FROM stdin;
2	CM	ROLE_CM	Usuario de tipo comunidad, en el cual representa a un conjunto de personas en un grupo social.	COMMUNITY	1000
3	BS	ROLE_BS	Usuario de tipo de negocios, en el cual representa a una empresa o negocio.	BUSINESS	1000
4	AD	ROLE_ADMIN	Usuario de tipo administrador, con acceso total a la plataforma.	ADMIN	100
5	QA	ROLE_QA	Usuario de tipo calificador.	QUALITY	10
6	MS	ROLE_MASTER	Usuario maestro con acceso especial a la plataforma	MASTER	1
1	PS	ROLE_PERS	Usuario de tipo personal para cada individuo que gestione comunidades sociales.	PERSONAL	10000
\.


--
-- TOC entry 3556 (class 0 OID 16665)
-- Dependencies: 251
-- Data for Name: tb_ol_cm_representer; Type: TABLE DATA; Schema: ol_cm_welcome; Owner: olympus_adm
--

COPY ol_cm_welcome.tb_ol_cm_representer (representer_id, created_at, deleted_at, updated_at, representer_desc, representer_img, representer_lang, representer_name, representer_role, status) FROM stdin;
1	2022-06-18 00:49:01.813	\N	2022-06-18 00:49:01.813	Soy el fundaor de Olympus, me dedico al desarrollo de software y ciberseguridad. Mi misión con Olympus, es fortalecer los lazos a distancia de todas las personas que viven lejos, con la posibilidad de conocerce.	\N	\N	Julius Sauco	Fundador	t
2	2022-06-18 00:49:01.832	\N	2022-06-18 00:49:01.832	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.	\N	\N	Anne Marie Dociu	People Management	t
3	2022-06-18 00:49:01.836	\N	2022-06-18 00:49:01.836	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.	\N	\N	Dylan Pereira	Marketing Management	t
4	2022-06-18 00:49:01.843	\N	2022-06-18 00:49:01.843	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.	\N	\N	Panda Aurora	Team Solutions	t
\.


--
-- TOC entry 3557 (class 0 OID 16672)
-- Dependencies: 252
-- Data for Name: tb_ol_cm_welcome; Type: TABLE DATA; Schema: ol_cm_welcome; Owner: olympus_adm
--

COPY ol_cm_welcome.tb_ol_cm_welcome (welcome_id, card1_sub_tiitle, card1_tiitle, card2_sub_tiitle, card2_tiitle, card3_sub_tiitle, card3_tiitle, card4_sub_tiitle, card4_tiitle, community_tiitle, created_at, deleted_at, desc_community, desc_profile, desc_sub, desc_team, desc_theme, updated_at, main_sub_tiitle, main_tiitle, other_text1, other_text2, profile_tittle, status, sub_tittle, team_tiitle, theme_tittle, welcome_lang) FROM stdin;
1	En la plataforma Olympus encontrarás grupos de WhatsApp, Facebook, Telegram e Instagram.	Únete a comunidades	Abre campo, publicate y promocionate en los grupos anexados a Olympus.	Promociona y publica	Crea tu comunidad con sus grupos en una red social y hazla popular.	Haz tu grupo social popular	Conoce a personas del mundo de tú mismo interés para el intercambio cultural.	Diviertete y más...	COMUNIDADES	2022-06-18 00:49:01.716	\N	Olympus presenta sus mejores comunidades, destacados por sus temáticas y diferenciados por sus dinámicas, inclúyete en una de estas comunidades, conoce personas con objetivos y metas en común.	Las personas son importantes, cada persona tiene una manera de expresarse, es por ello que en Olympus se toma en cuenta cada perfil, sus comunidades creadas, las comunidades a los que se han unido. Encuentra a personas con objetivos en común.	El mantenimiento, funcionamiento y administración de tu comunidad es importante cuando varias personas tienen el mismo interés en ello y cuando tu comunidad es popular. Es por ello que te brindamos diferentes planes de subscripción.	Estamos siempre en contacto y resolvemos tus dudas comunicandote con nostros. Estamos pendiente de todos los grupos anexados al Olympus con la condición de ser estrictos en todo el reglamento de los grupos asociados y del Olympus.	Cada comunidad social tiene una temática en la cual destaca o abunda. Cada temática esta bien definida y organizada para que la búsqueda de comunidades sea mucho más cómoda. Sugiere nuevos temas para que las comunidades se acomoden en un tema.	2022-06-18 00:49:01.716	Gestión de redes de grupos sociales y comunidades más grandes del mundo.	Bienvenido al Imperio Olympus			PERFILES	t	SUBSCRIPCIÓN	EQUIPO	TEMAS	ES
\.


--
-- TOC entry 3564 (class 0 OID 0)
-- Dependencies: 213
-- Name: sc_ol_cm_country_id; Type: SEQUENCE SET; Schema: ol_cm_other; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_other.sc_ol_cm_country_id', 1, false);


--
-- TOC entry 3565 (class 0 OID 0)
-- Dependencies: 214
-- Name: sc_ol_cm_status_id; Type: SEQUENCE SET; Schema: ol_cm_other; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_other.sc_ol_cm_status_id', 1, false);


--
-- TOC entry 3566 (class 0 OID 0)
-- Dependencies: 217
-- Name: sc_ol_cm_com_cat_id; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_com_cat_id', 1, false);


--
-- TOC entry 3567 (class 0 OID 0)
-- Dependencies: 218
-- Name: sc_ol_cm_com_prof_id; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_com_prof_id', 1, false);


--
-- TOC entry 3568 (class 0 OID 0)
-- Dependencies: 219
-- Name: sc_ol_cm_level_id; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_level_id', 1, false);


--
-- TOC entry 3569 (class 0 OID 0)
-- Dependencies: 220
-- Name: sc_ol_cm_profile_theme; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_profile_theme', 1, false);


--
-- TOC entry 3570 (class 0 OID 0)
-- Dependencies: 221
-- Name: sc_ol_cm_role_id; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_role_id', 1, false);


--
-- TOC entry 3571 (class 0 OID 0)
-- Dependencies: 222
-- Name: sc_ol_cm_social_pt; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_social_pt', 1, false);


--
-- TOC entry 3572 (class 0 OID 0)
-- Dependencies: 223
-- Name: sc_ol_cm_sub_theme_id; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_sub_theme_id', 1, false);


--
-- TOC entry 3573 (class 0 OID 0)
-- Dependencies: 224
-- Name: sc_ol_cm_theme_id; Type: SEQUENCE SET; Schema: ol_cm_page; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_page.sc_ol_cm_theme_id', 1, false);


--
-- TOC entry 3574 (class 0 OID 0)
-- Dependencies: 235
-- Name: sc_ol_cm_com_cat_id; Type: SEQUENCE SET; Schema: ol_cm_security; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_security.sc_ol_cm_com_cat_id', 1, false);


--
-- TOC entry 3575 (class 0 OID 0)
-- Dependencies: 236
-- Name: sc_ol_cm_security_audit; Type: SEQUENCE SET; Schema: ol_cm_security; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_security.sc_ol_cm_security_audit', 1, false);


--
-- TOC entry 3576 (class 0 OID 0)
-- Dependencies: 237
-- Name: sc_ol_cm_security_keys; Type: SEQUENCE SET; Schema: ol_cm_security; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_security.sc_ol_cm_security_keys', 1, false);


--
-- TOC entry 3577 (class 0 OID 0)
-- Dependencies: 238
-- Name: sc_ol_cm_security_msn_keys; Type: SEQUENCE SET; Schema: ol_cm_security; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_security.sc_ol_cm_security_msn_keys', 1, false);


--
-- TOC entry 3578 (class 0 OID 0)
-- Dependencies: 242
-- Name: sc_ol_cm_tel_profile; Type: SEQUENCE SET; Schema: ol_cm_session; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_session.sc_ol_cm_tel_profile', 1, false);


--
-- TOC entry 3579 (class 0 OID 0)
-- Dependencies: 243
-- Name: sc_ol_cm_type_user; Type: SEQUENCE SET; Schema: ol_cm_session; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_session.sc_ol_cm_type_user', 1, false);


--
-- TOC entry 3580 (class 0 OID 0)
-- Dependencies: 249
-- Name: sc_ol_cm_representer_id; Type: SEQUENCE SET; Schema: ol_cm_welcome; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_welcome.sc_ol_cm_representer_id', 4, true);


--
-- TOC entry 3581 (class 0 OID 0)
-- Dependencies: 250
-- Name: sc_ol_cm_welcome_id; Type: SEQUENCE SET; Schema: ol_cm_welcome; Owner: olympus_adm
--

SELECT pg_catalog.setval('ol_cm_welcome.sc_ol_cm_welcome_id', 1, true);


--
-- TOC entry 3270 (class 2606 OID 16491)
-- Name: tb_ol_cm_country tb_ol_cm_country_pkey; Type: CONSTRAINT; Schema: ol_cm_other; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_other.tb_ol_cm_country
    ADD CONSTRAINT tb_ol_cm_country_pkey PRIMARY KEY (country_id);


--
-- TOC entry 3276 (class 2606 OID 16496)
-- Name: tb_ol_cm_status tb_ol_cm_status_pkey; Type: CONSTRAINT; Schema: ol_cm_other; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_other.tb_ol_cm_status
    ADD CONSTRAINT tb_ol_cm_status_pkey PRIMARY KEY (status_id);


--
-- TOC entry 3272 (class 2606 OID 16498)
-- Name: tb_ol_cm_country uk_c9t168dv0xjknlwbfnqg9iei8; Type: CONSTRAINT; Schema: ol_cm_other; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_other.tb_ol_cm_country
    ADD CONSTRAINT uk_c9t168dv0xjknlwbfnqg9iei8 UNIQUE (abv);


--
-- TOC entry 3278 (class 2606 OID 16502)
-- Name: tb_ol_cm_status uk_hbc3hkbcwpsbmddynpg5stwt; Type: CONSTRAINT; Schema: ol_cm_other; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_other.tb_ol_cm_status
    ADD CONSTRAINT uk_hbc3hkbcwpsbmddynpg5stwt UNIQUE (status_desc);


--
-- TOC entry 3274 (class 2606 OID 16500)
-- Name: tb_ol_cm_country uk_pu78nd7cmaax2lnvi4fackijd; Type: CONSTRAINT; Schema: ol_cm_other; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_other.tb_ol_cm_country
    ADD CONSTRAINT uk_pu78nd7cmaax2lnvi4fackijd UNIQUE (country_name);


--
-- TOC entry 3280 (class 2606 OID 16515)
-- Name: tb_ol_cm_com_theme tb_ol_cm_com_theme_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_com_theme
    ADD CONSTRAINT tb_ol_cm_com_theme_pkey PRIMARY KEY (com_cat_id);


--
-- TOC entry 3282 (class 2606 OID 16522)
-- Name: tb_ol_cm_community tb_ol_cm_community_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_community
    ADD CONSTRAINT tb_ol_cm_community_pkey PRIMARY KEY (community_id);


--
-- TOC entry 3286 (class 2606 OID 16527)
-- Name: tb_ol_cm_level tb_ol_cm_level_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_level
    ADD CONSTRAINT tb_ol_cm_level_pkey PRIMARY KEY (level_id);


--
-- TOC entry 3290 (class 2606 OID 16532)
-- Name: tb_ol_cm_mg tb_ol_cm_mg_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_mg
    ADD CONSTRAINT tb_ol_cm_mg_pkey PRIMARY KEY (com_prof_id);


--
-- TOC entry 3292 (class 2606 OID 16537)
-- Name: tb_ol_cm_profile_theme tb_ol_cm_profile_theme_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_profile_theme
    ADD CONSTRAINT tb_ol_cm_profile_theme_pkey PRIMARY KEY (prof_theme_id);


--
-- TOC entry 3294 (class 2606 OID 16544)
-- Name: tb_ol_cm_role tb_ol_cm_role_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_role
    ADD CONSTRAINT tb_ol_cm_role_pkey PRIMARY KEY (role_id);


--
-- TOC entry 3298 (class 2606 OID 16549)
-- Name: tb_ol_cm_social tb_ol_cm_social_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_social
    ADD CONSTRAINT tb_ol_cm_social_pkey PRIMARY KEY (social_id);


--
-- TOC entry 3302 (class 2606 OID 16556)
-- Name: tb_ol_cm_socials_pt tb_ol_cm_socials_pt_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_socials_pt
    ADD CONSTRAINT tb_ol_cm_socials_pt_pkey PRIMARY KEY (social_pt_id);


--
-- TOC entry 3306 (class 2606 OID 16563)
-- Name: tb_ol_cm_sub_themes tb_ol_cm_sub_themes_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_sub_themes
    ADD CONSTRAINT tb_ol_cm_sub_themes_pkey PRIMARY KEY (sub_theme_id);


--
-- TOC entry 3310 (class 2606 OID 16570)
-- Name: tb_ol_cm_theme tb_ol_cm_theme_pkey; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_theme
    ADD CONSTRAINT tb_ol_cm_theme_pkey PRIMARY KEY (theme_id);


--
-- TOC entry 3300 (class 2606 OID 16578)
-- Name: tb_ol_cm_social uk_2sya53iwfr5oo7yvp7fm97eib; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_social
    ADD CONSTRAINT uk_2sya53iwfr5oo7yvp7fm97eib UNIQUE (social_name);


--
-- TOC entry 3304 (class 2606 OID 16580)
-- Name: tb_ol_cm_socials_pt uk_87j844je3tv4xs89xcigimiic; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_socials_pt
    ADD CONSTRAINT uk_87j844je3tv4xs89xcigimiic UNIQUE (social_pt_link);


--
-- TOC entry 3288 (class 2606 OID 16574)
-- Name: tb_ol_cm_level uk_9wfs38q56ykq82iegxdx1rbxq; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_level
    ADD CONSTRAINT uk_9wfs38q56ykq82iegxdx1rbxq UNIQUE (level_name);


--
-- TOC entry 3312 (class 2606 OID 16584)
-- Name: tb_ol_cm_theme uk_gu2ykk0mp5yr5tswq05o8asqr; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_theme
    ADD CONSTRAINT uk_gu2ykk0mp5yr5tswq05o8asqr UNIQUE (theme_name);


--
-- TOC entry 3308 (class 2606 OID 16582)
-- Name: tb_ol_cm_sub_themes uk_hp6eo0u67lyfkpm5q4asfge43; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_sub_themes
    ADD CONSTRAINT uk_hp6eo0u67lyfkpm5q4asfge43 UNIQUE (sub_theme_name);


--
-- TOC entry 3296 (class 2606 OID 16576)
-- Name: tb_ol_cm_role uk_j87n7eiwpcm50qurtcdly6ye; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_role
    ADD CONSTRAINT uk_j87n7eiwpcm50qurtcdly6ye UNIQUE (role_name);


--
-- TOC entry 3284 (class 2606 OID 16572)
-- Name: tb_ol_cm_community uk_sklxo4mrn5j5maf097cviiuuf; Type: CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_community
    ADD CONSTRAINT uk_sklxo4mrn5j5maf097cviiuuf UNIQUE (cm_name);


--
-- TOC entry 3314 (class 2606 OID 16595)
-- Name: tb_ol_cm_audit tb_ol_cm_audit_pkey; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_audit
    ADD CONSTRAINT tb_ol_cm_audit_pkey PRIMARY KEY (audit_id);


--
-- TOC entry 3316 (class 2606 OID 16602)
-- Name: tb_ol_cm_keys tb_ol_cm_keys_pkey; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_keys
    ADD CONSTRAINT tb_ol_cm_keys_pkey PRIMARY KEY (id_sk);


--
-- TOC entry 3324 (class 2606 OID 16609)
-- Name: tb_ol_cm_messages tb_ol_cm_messages_pkey; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_messages
    ADD CONSTRAINT tb_ol_cm_messages_pkey PRIMARY KEY (id_sk);


--
-- TOC entry 3318 (class 2606 OID 16613)
-- Name: tb_ol_cm_keys uk_6mhnc2hdc8ii66d0d8gllwgpt; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_keys
    ADD CONSTRAINT uk_6mhnc2hdc8ii66d0d8gllwgpt UNIQUE (key_pass);


--
-- TOC entry 3326 (class 2606 OID 16617)
-- Name: tb_ol_cm_messages uk_7n1u9ncx563xd55x1udh3coym; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_messages
    ADD CONSTRAINT uk_7n1u9ncx563xd55x1udh3coym UNIQUE (key_messages);


--
-- TOC entry 3320 (class 2606 OID 16611)
-- Name: tb_ol_cm_keys uk_ctpqrsoevtevimdduhcntx63; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_keys
    ADD CONSTRAINT uk_ctpqrsoevtevimdduhcntx63 UNIQUE (iv_key);


--
-- TOC entry 3322 (class 2606 OID 16615)
-- Name: tb_ol_cm_keys uk_djd04q5sljukeb99cjydv6eve; Type: CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_keys
    ADD CONSTRAINT uk_djd04q5sljukeb99cjydv6eve UNIQUE (salt_key);


--
-- TOC entry 3328 (class 2606 OID 16626)
-- Name: tb_ol_cm_profile tb_ol_cm_profile_pkey; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_profile
    ADD CONSTRAINT tb_ol_cm_profile_pkey PRIMARY KEY (profile_id);


--
-- TOC entry 3332 (class 2606 OID 16631)
-- Name: tb_ol_cm_telephone tb_ol_cm_telephone_pkey; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_telephone
    ADD CONSTRAINT tb_ol_cm_telephone_pkey PRIMARY KEY (tel_id);


--
-- TOC entry 3336 (class 2606 OID 16641)
-- Name: tb_ol_cm_users tb_ol_cm_users_pkey; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_users
    ADD CONSTRAINT tb_ol_cm_users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3342 (class 2606 OID 16648)
-- Name: tb_ol_cm_usertype tb_ol_cm_usertype_pkey; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_usertype
    ADD CONSTRAINT tb_ol_cm_usertype_pkey PRIMARY KEY (type_id);


--
-- TOC entry 3344 (class 2606 OID 16662)
-- Name: tb_ol_cm_usertype uk_aty3m49rglpyjlnuylr1uk3y1; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_usertype
    ADD CONSTRAINT uk_aty3m49rglpyjlnuylr1uk3y1 UNIQUE (type_name);


--
-- TOC entry 3346 (class 2606 OID 16658)
-- Name: tb_ol_cm_usertype uk_b6kf65u48nbgcf3sjc4qlfb96; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_usertype
    ADD CONSTRAINT uk_b6kf65u48nbgcf3sjc4qlfb96 UNIQUE (type_abv);


--
-- TOC entry 3338 (class 2606 OID 16656)
-- Name: tb_ol_cm_users uk_bejg0hhp8onp8t0519tynk1pk; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_users
    ADD CONSTRAINT uk_bejg0hhp8onp8t0519tynk1pk UNIQUE (username);


--
-- TOC entry 3330 (class 2606 OID 16650)
-- Name: tb_ol_cm_profile uk_ncd03hn529ipul20os2mxci4n; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_profile
    ADD CONSTRAINT uk_ncd03hn529ipul20os2mxci4n UNIQUE (nickname);


--
-- TOC entry 3340 (class 2606 OID 16654)
-- Name: tb_ol_cm_users uk_nnk9vgg5tuc3n75inbvq78l3d; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_users
    ADD CONSTRAINT uk_nnk9vgg5tuc3n75inbvq78l3d UNIQUE (email);


--
-- TOC entry 3348 (class 2606 OID 16660)
-- Name: tb_ol_cm_usertype uk_t4ysb0x140hfyhu0el4g2q27n; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_usertype
    ADD CONSTRAINT uk_t4ysb0x140hfyhu0el4g2q27n UNIQUE (alias);


--
-- TOC entry 3334 (class 2606 OID 16652)
-- Name: tb_ol_cm_user_typeuser ukkrflrxy915aiv0vvmlrde8gjp; Type: CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_user_typeuser
    ADD CONSTRAINT ukkrflrxy915aiv0vvmlrde8gjp UNIQUE (user_id, type_id);


--
-- TOC entry 3350 (class 2606 OID 16671)
-- Name: tb_ol_cm_representer tb_ol_cm_representer_pkey; Type: CONSTRAINT; Schema: ol_cm_welcome; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_welcome.tb_ol_cm_representer
    ADD CONSTRAINT tb_ol_cm_representer_pkey PRIMARY KEY (representer_id);


--
-- TOC entry 3356 (class 2606 OID 16678)
-- Name: tb_ol_cm_welcome tb_ol_cm_welcome_pkey; Type: CONSTRAINT; Schema: ol_cm_welcome; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_welcome.tb_ol_cm_welcome
    ADD CONSTRAINT tb_ol_cm_welcome_pkey PRIMARY KEY (welcome_id);


--
-- TOC entry 3352 (class 2606 OID 16682)
-- Name: tb_ol_cm_representer uk_jiwh85h9gn4bc8g11h8ly0pgq; Type: CONSTRAINT; Schema: ol_cm_welcome; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_welcome.tb_ol_cm_representer
    ADD CONSTRAINT uk_jiwh85h9gn4bc8g11h8ly0pgq UNIQUE (representer_name);


--
-- TOC entry 3354 (class 2606 OID 16680)
-- Name: tb_ol_cm_representer uk_mqta3lh5vxrn3kcjq2q626f3c; Type: CONSTRAINT; Schema: ol_cm_welcome; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_welcome.tb_ol_cm_representer
    ADD CONSTRAINT uk_mqta3lh5vxrn3kcjq2q626f3c UNIQUE (representer_img);


--
-- TOC entry 3366 (class 2606 OID 16728)
-- Name: tb_ol_cm_socials_pt fk_ol_cm_community_social_platform; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_socials_pt
    ADD CONSTRAINT fk_ol_cm_community_social_platform FOREIGN KEY (community_id) REFERENCES ol_cm_page.tb_ol_cm_community(community_id);


--
-- TOC entry 3357 (class 2606 OID 16683)
-- Name: tb_ol_cm_com_theme fk_ol_cm_community_theme; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_com_theme
    ADD CONSTRAINT fk_ol_cm_community_theme FOREIGN KEY (community_id) REFERENCES ol_cm_page.tb_ol_cm_community(community_id);


--
-- TOC entry 3360 (class 2606 OID 16698)
-- Name: tb_ol_cm_mg fk_ol_cm_mg_ct; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_mg
    ADD CONSTRAINT fk_ol_cm_mg_ct FOREIGN KEY (community_id) REFERENCES ol_cm_page.tb_ol_cm_community(community_id);


--
-- TOC entry 3362 (class 2606 OID 16708)
-- Name: tb_ol_cm_mg fk_ol_cm_mg_profile; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_mg
    ADD CONSTRAINT fk_ol_cm_mg_profile FOREIGN KEY (role_id) REFERENCES ol_cm_page.tb_ol_cm_role(role_id);


--
-- TOC entry 3361 (class 2606 OID 16703)
-- Name: tb_ol_cm_mg fk_ol_cm_mg_role; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_mg
    ADD CONSTRAINT fk_ol_cm_mg_role FOREIGN KEY (profile_id) REFERENCES ol_cm_session.tb_ol_cm_profile(profile_id);


--
-- TOC entry 3363 (class 2606 OID 16713)
-- Name: tb_ol_cm_profile_theme fk_ol_cm_prof_theme_prof; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_profile_theme
    ADD CONSTRAINT fk_ol_cm_prof_theme_prof FOREIGN KEY (profile_id) REFERENCES ol_cm_session.tb_ol_cm_profile(profile_id);


--
-- TOC entry 3364 (class 2606 OID 16718)
-- Name: tb_ol_cm_profile_theme fk_ol_cm_prof_theme_subtheme; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_profile_theme
    ADD CONSTRAINT fk_ol_cm_prof_theme_subtheme FOREIGN KEY (sub_theme_id) REFERENCES ol_cm_page.tb_ol_cm_sub_themes(sub_theme_id);


--
-- TOC entry 3365 (class 2606 OID 16723)
-- Name: tb_ol_cm_profile_theme fk_ol_cm_prof_theme_theme; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_profile_theme
    ADD CONSTRAINT fk_ol_cm_prof_theme_theme FOREIGN KEY (theme_id) REFERENCES ol_cm_page.tb_ol_cm_theme(theme_id);


--
-- TOC entry 3367 (class 2606 OID 16733)
-- Name: tb_ol_cm_socials_pt fk_ol_cm_social_platform_network; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_socials_pt
    ADD CONSTRAINT fk_ol_cm_social_platform_network FOREIGN KEY (social_id) REFERENCES ol_cm_page.tb_ol_cm_social(social_id);


--
-- TOC entry 3359 (class 2606 OID 16693)
-- Name: tb_ol_cm_com_theme fk_ol_cm_theme_community; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_com_theme
    ADD CONSTRAINT fk_ol_cm_theme_community FOREIGN KEY (theme_id) REFERENCES ol_cm_page.tb_ol_cm_theme(theme_id);


--
-- TOC entry 3358 (class 2606 OID 16688)
-- Name: tb_ol_cm_com_theme fk_ol_cm_theme_community_sub_theme; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_com_theme
    ADD CONSTRAINT fk_ol_cm_theme_community_sub_theme FOREIGN KEY (sub_theme_id) REFERENCES ol_cm_page.tb_ol_cm_sub_themes(sub_theme_id);


--
-- TOC entry 3368 (class 2606 OID 16738)
-- Name: tb_ol_cm_sub_themes fk_ol_cm_theme_sub_theme; Type: FK CONSTRAINT; Schema: ol_cm_page; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_page.tb_ol_cm_sub_themes
    ADD CONSTRAINT fk_ol_cm_theme_sub_theme FOREIGN KEY (theme_id) REFERENCES ol_cm_page.tb_ol_cm_theme(theme_id);


--
-- TOC entry 3369 (class 2606 OID 16743)
-- Name: tb_ol_cm_audit fk_ol_cm_audit_action; Type: FK CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_audit
    ADD CONSTRAINT fk_ol_cm_audit_action FOREIGN KEY (action_id) REFERENCES ol_cm_security.tb_ol_cm_audit(audit_id);


--
-- TOC entry 3370 (class 2606 OID 16748)
-- Name: tb_ol_cm_audit fk_ol_cm_audit_user; Type: FK CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_audit
    ADD CONSTRAINT fk_ol_cm_audit_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


--
-- TOC entry 3372 (class 2606 OID 16758)
-- Name: tb_ol_cm_messages fk_ol_cm_profile_user; Type: FK CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_messages
    ADD CONSTRAINT fk_ol_cm_profile_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


--
-- TOC entry 3371 (class 2606 OID 16753)
-- Name: tb_ol_cm_keys fk_ol_cm_security_key_user; Type: FK CONSTRAINT; Schema: ol_cm_security; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_security.tb_ol_cm_keys
    ADD CONSTRAINT fk_ol_cm_security_key_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


--
-- TOC entry 3373 (class 2606 OID 16763)
-- Name: tb_ol_cm_profile fk_ol_cm_profile_country; Type: FK CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_profile
    ADD CONSTRAINT fk_ol_cm_profile_country FOREIGN KEY (country_id) REFERENCES ol_cm_other.tb_ol_cm_country(country_id);


--
-- TOC entry 3374 (class 2606 OID 16768)
-- Name: tb_ol_cm_profile fk_ol_cm_profile_user; Type: FK CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_profile
    ADD CONSTRAINT fk_ol_cm_profile_user FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


--
-- TOC entry 3375 (class 2606 OID 16773)
-- Name: tb_ol_cm_telephone fk_ol_cm_tel_country; Type: FK CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_telephone
    ADD CONSTRAINT fk_ol_cm_tel_country FOREIGN KEY (country_id) REFERENCES ol_cm_other.tb_ol_cm_country(country_id);


--
-- TOC entry 3376 (class 2606 OID 16778)
-- Name: tb_ol_cm_telephone fk_ol_cm_tel_profile; Type: FK CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_telephone
    ADD CONSTRAINT fk_ol_cm_tel_profile FOREIGN KEY (profile_id) REFERENCES ol_cm_session.tb_ol_cm_profile(profile_id);


--
-- TOC entry 3378 (class 2606 OID 16788)
-- Name: tb_ol_cm_user_typeuser fked8x7qeoe9xt26cjuf75f1vh2; Type: FK CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_user_typeuser
    ADD CONSTRAINT fked8x7qeoe9xt26cjuf75f1vh2 FOREIGN KEY (user_id) REFERENCES ol_cm_session.tb_ol_cm_users(user_id);


--
-- TOC entry 3377 (class 2606 OID 16783)
-- Name: tb_ol_cm_user_typeuser fkevfa5owscixb9x8090c8x5ac0; Type: FK CONSTRAINT; Schema: ol_cm_session; Owner: olympus_adm
--

ALTER TABLE ONLY ol_cm_session.tb_ol_cm_user_typeuser
    ADD CONSTRAINT fkevfa5owscixb9x8090c8x5ac0 FOREIGN KEY (type_id) REFERENCES ol_cm_session.tb_ol_cm_usertype(type_id);


-- Completed on 2022-06-18 11:57:51

--
-- PostgreSQL database dump complete
--

