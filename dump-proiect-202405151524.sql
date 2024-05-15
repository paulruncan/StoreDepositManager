--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2024-05-15 15:24:01

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
-- TOC entry 222 (class 1259 OID 33655)
-- Name: bill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bill (
    id integer NOT NULL,
    customername character varying NOT NULL,
    productname character varying NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.bill OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 33658)
-- Name: bill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.bill ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.bill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 33627)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id integer NOT NULL,
    name character varying NOT NULL,
    mail character varying
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 33626)
-- Name: newtable_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.customer ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.newtable_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 33646)
-- Name: orderm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orderm (
    id integer NOT NULL,
    customername character varying NOT NULL,
    productname character varying NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.orderm OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33649)
-- Name: order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.orderm ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 33637)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer NOT NULL,
    name character varying NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33640)
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4797 (class 0 OID 33655)
-- Dependencies: 222
-- Data for Name: bill; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (1, 'andrei', 'apa', 20);
INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (2, 'andrei', 'apa', 20);
INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (3, 'fasdfasd', 'ananas', 24);
INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (4, 'asdasda', 'ananas', 24);
INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (5, 'dadada', 'ananas', 54);
INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (6, 'Paul Runcan', 'strawberry', 25);
INSERT INTO public.bill OVERRIDING SYSTEM VALUE VALUES (7, 'Paul Runcan', 'strawberry', 25);


--
-- TOC entry 4792 (class 0 OID 33627)
-- Dependencies: 216
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer OVERRIDING SYSTEM VALUE VALUES (70, 'Paul Runcan', 'paul.runcan34@gmail.com');


--
-- TOC entry 4795 (class 0 OID 33646)
-- Dependencies: 220
-- Data for Name: orderm; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (1, 'adasda', 'dasdasfa', 123);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (2, 'georgica', 'gole', 12);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (3, 'dfasdfasdf', 'sampon', 12);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (4, 'georgica', 'gole', 10);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (5, 'adsadas', 'gole', 10);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (6, '1313123sadsasd', 'ananas', 250);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (7, 'fasfasfasf', 'ananas', 250);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (8, '2131231', 'ananas', 250);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (9, '2131231', 'ananas', 250);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (10, '2131231', 'ananas', 250);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (11, '1313123sadsasd', 'sampon', 20);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (12, 'fasdfasd', 'ananas', 24);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (13, 'asdasda', 'ananas', 24);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (14, 'dadada', 'ananas', 54);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (15, 'Paul Runcan', 'strawberry', 25);
INSERT INTO public.orderm OVERRIDING SYSTEM VALUE VALUES (16, 'Paul Runcan', 'strawberry', 25);


--
-- TOC entry 4793 (class 0 OID 33637)
-- Dependencies: 218
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product OVERRIDING SYSTEM VALUE VALUES (9, 'ananas', 1648);
INSERT INTO public.product OVERRIDING SYSTEM VALUE VALUES (10, 'mere', 2423);
INSERT INTO public.product OVERRIDING SYSTEM VALUE VALUES (8, 'ampons', 80);
INSERT INTO public.product OVERRIDING SYSTEM VALUE VALUES (12, 'strawberry', 0);


--
-- TOC entry 4804 (class 0 OID 0)
-- Dependencies: 223
-- Name: bill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bill_id_seq', 7, true);


--
-- TOC entry 4805 (class 0 OID 0)
-- Dependencies: 215
-- Name: newtable_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.newtable_id_seq', 70, true);


--
-- TOC entry 4806 (class 0 OID 0)
-- Dependencies: 221
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_id_seq', 16, true);


--
-- TOC entry 4807 (class 0 OID 0)
-- Dependencies: 219
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 12, true);


-- Completed on 2024-05-15 15:24:01

--
-- PostgreSQL database dump complete
--

