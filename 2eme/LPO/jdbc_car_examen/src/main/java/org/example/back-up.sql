--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2025-01-24 20:11:28

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 35606)
-- Name: car; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.car (
    plate character varying NOT NULL,
    color character varying NOT NULL,
    brand character varying NOT NULL,
    model character varying NOT NULL,
    registration_year integer NOT NULL
);


ALTER TABLE public.car OWNER TO postgres;

--
-- TOC entry 4831 (class 0 OID 35606)
-- Dependencies: 215
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.car (plate, color, brand, model, registration_year) FROM stdin;
\.


--
-- TOC entry 4687 (class 2606 OID 35612)
-- Name: car car_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_pkey PRIMARY KEY (plate);


-- Completed on 2025-01-24 20:11:28

--
-- PostgreSQL database dump complete
--

