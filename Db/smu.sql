--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-07-11 21:46:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 33547)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 5043 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS '';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 33569)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    aluno_id integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    celular character varying(20),
    data_nascimento date,
    matricula character varying(30) NOT NULL,
    senha character varying(255) NOT NULL,
    curso_id integer
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33568)
-- Name: aluno_aluno_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aluno_aluno_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aluno_aluno_id_seq OWNER TO postgres;

--
-- TOC entry 5045 (class 0 OID 0)
-- Dependencies: 221
-- Name: aluno_aluno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aluno_aluno_id_seq OWNED BY public.aluno.aluno_id;


--
-- TOC entry 223 (class 1259 OID 33586)
-- Name: aluno_disciplina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno_disciplina (
    aluno_id integer NOT NULL,
    disciplina_id integer NOT NULL
);


ALTER TABLE public.aluno_disciplina OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 33678)
-- Name: atividade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atividade (
    atividade_id integer NOT NULL,
    monitoria_id integer,
    titulo character varying(255) NOT NULL,
    descricao text,
    link_formulario text NOT NULL
);


ALTER TABLE public.atividade OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 33677)
-- Name: atividade_atividade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.atividade_atividade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.atividade_atividade_id_seq OWNER TO postgres;

--
-- TOC entry 5046 (class 0 OID 0)
-- Dependencies: 231
-- Name: atividade_atividade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.atividade_atividade_id_seq OWNED BY public.atividade.atividade_id;


--
-- TOC entry 233 (class 1259 OID 33691)
-- Name: atividade_resposta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atividade_resposta (
    atividade_id integer NOT NULL,
    aluno_id integer NOT NULL,
    data_resposta timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    link_resposta text
);


ALTER TABLE public.atividade_resposta OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 33823)
-- Name: comentario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comentario (
    comentario_id integer NOT NULL,
    texto text NOT NULL,
    nota integer,
    data timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    aluno_id integer,
    monitoria_id integer
);


ALTER TABLE public.comentario OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 33822)
-- Name: comentario_comentario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comentario_comentario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.comentario_comentario_id_seq OWNER TO postgres;

--
-- TOC entry 5047 (class 0 OID 0)
-- Dependencies: 238
-- Name: comentario_comentario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comentario_comentario_id_seq OWNED BY public.comentario.comentario_id;


--
-- TOC entry 218 (class 1259 OID 33550)
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    curso_id integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 33549)
-- Name: curso_curso_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.curso_curso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.curso_curso_id_seq OWNER TO postgres;

--
-- TOC entry 5048 (class 0 OID 0)
-- Dependencies: 217
-- Name: curso_curso_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.curso_curso_id_seq OWNED BY public.curso.curso_id;


--
-- TOC entry 220 (class 1259 OID 33557)
-- Name: disciplina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.disciplina (
    disciplina_id integer NOT NULL,
    nome character varying(100) NOT NULL,
    curso_id integer
);


ALTER TABLE public.disciplina OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33556)
-- Name: disciplina_disciplina_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.disciplina_disciplina_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.disciplina_disciplina_id_seq OWNER TO postgres;

--
-- TOC entry 5049 (class 0 OID 0)
-- Dependencies: 219
-- Name: disciplina_disciplina_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.disciplina_disciplina_id_seq OWNED BY public.disciplina.disciplina_id;


--
-- TOC entry 230 (class 1259 OID 33664)
-- Name: material; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.material (
    material_id integer NOT NULL,
    monitoria_id integer,
    titulo character varying(255) NOT NULL,
    descricao text,
    link text,
    caminho_arquivo text
);


ALTER TABLE public.material OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 33663)
-- Name: material_material_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.material_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.material_material_id_seq OWNER TO postgres;

--
-- TOC entry 5050 (class 0 OID 0)
-- Dependencies: 229
-- Name: material_material_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.material_material_id_seq OWNED BY public.material.material_id;


--
-- TOC entry 235 (class 1259 OID 33777)
-- Name: mensagem; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mensagem (
    mensagem_id integer NOT NULL,
    conteudo text NOT NULL,
    data_hora timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    aluno_id integer,
    monitor_id integer,
    monitoria_id integer
);


ALTER TABLE public.mensagem OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 33776)
-- Name: mensagem_mensagem_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mensagem_mensagem_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.mensagem_mensagem_id_seq OWNER TO postgres;

--
-- TOC entry 5051 (class 0 OID 0)
-- Dependencies: 234
-- Name: mensagem_mensagem_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mensagem_mensagem_id_seq OWNED BY public.mensagem.mensagem_id;


--
-- TOC entry 225 (class 1259 OID 33602)
-- Name: monitor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.monitor (
    monitor_id integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    celular character varying(20),
    data_nascimento date,
    matricula character varying(30) NOT NULL,
    senha character varying(255) NOT NULL,
    curso_id integer,
    disciplina_id integer,
    codigo_verificacao character varying(255) NOT NULL
);


ALTER TABLE public.monitor OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 33601)
-- Name: monitor_monitor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.monitor_monitor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.monitor_monitor_id_seq OWNER TO postgres;

--
-- TOC entry 5052 (class 0 OID 0)
-- Dependencies: 224
-- Name: monitor_monitor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.monitor_monitor_id_seq OWNED BY public.monitor.monitor_id;


--
-- TOC entry 227 (class 1259 OID 33625)
-- Name: monitoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.monitoria (
    monitoria_id integer NOT NULL,
    monitor_id integer,
    curso_id integer,
    disciplina_id integer,
    codigo_disciplina character varying(20),
    horario character varying(50) NOT NULL,
    link text
);


ALTER TABLE public.monitoria OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 33648)
-- Name: monitoria_aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.monitoria_aluno (
    monitoria_id integer NOT NULL,
    aluno_id integer NOT NULL
);


ALTER TABLE public.monitoria_aluno OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 33624)
-- Name: monitoria_monitoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.monitoria_monitoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.monitoria_monitoria_id_seq OWNER TO postgres;

--
-- TOC entry 5053 (class 0 OID 0)
-- Dependencies: 226
-- Name: monitoria_monitoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.monitoria_monitoria_id_seq OWNED BY public.monitoria.monitoria_id;


--
-- TOC entry 237 (class 1259 OID 33802)
-- Name: notificacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notificacao (
    notificacao_id integer NOT NULL,
    mensagem text NOT NULL,
    lida boolean DEFAULT false,
    data_envio timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    aluno_id integer,
    monitor_id integer
);


ALTER TABLE public.notificacao OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 33801)
-- Name: notificacao_notificacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notificacao_notificacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.notificacao_notificacao_id_seq OWNER TO postgres;

--
-- TOC entry 5054 (class 0 OID 0)
-- Dependencies: 236
-- Name: notificacao_notificacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notificacao_notificacao_id_seq OWNED BY public.notificacao.notificacao_id;


--
-- TOC entry 4801 (class 2604 OID 33572)
-- Name: aluno aluno_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno ALTER COLUMN aluno_id SET DEFAULT nextval('public.aluno_aluno_id_seq'::regclass);


--
-- TOC entry 4805 (class 2604 OID 33681)
-- Name: atividade atividade_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade ALTER COLUMN atividade_id SET DEFAULT nextval('public.atividade_atividade_id_seq'::regclass);


--
-- TOC entry 4812 (class 2604 OID 33826)
-- Name: comentario comentario_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario ALTER COLUMN comentario_id SET DEFAULT nextval('public.comentario_comentario_id_seq'::regclass);


--
-- TOC entry 4799 (class 2604 OID 33553)
-- Name: curso curso_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso ALTER COLUMN curso_id SET DEFAULT nextval('public.curso_curso_id_seq'::regclass);


--
-- TOC entry 4800 (class 2604 OID 33560)
-- Name: disciplina disciplina_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina ALTER COLUMN disciplina_id SET DEFAULT nextval('public.disciplina_disciplina_id_seq'::regclass);


--
-- TOC entry 4804 (class 2604 OID 33667)
-- Name: material material_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.material ALTER COLUMN material_id SET DEFAULT nextval('public.material_material_id_seq'::regclass);


--
-- TOC entry 4807 (class 2604 OID 33780)
-- Name: mensagem mensagem_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem ALTER COLUMN mensagem_id SET DEFAULT nextval('public.mensagem_mensagem_id_seq'::regclass);


--
-- TOC entry 4802 (class 2604 OID 33605)
-- Name: monitor monitor_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitor ALTER COLUMN monitor_id SET DEFAULT nextval('public.monitor_monitor_id_seq'::regclass);


--
-- TOC entry 4803 (class 2604 OID 33628)
-- Name: monitoria monitoria_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria ALTER COLUMN monitoria_id SET DEFAULT nextval('public.monitoria_monitoria_id_seq'::regclass);


--
-- TOC entry 4809 (class 2604 OID 33805)
-- Name: notificacao notificacao_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notificacao ALTER COLUMN notificacao_id SET DEFAULT nextval('public.notificacao_notificacao_id_seq'::regclass);


--
-- TOC entry 5020 (class 0 OID 33569)
-- Dependencies: 222
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno (aluno_id, nome, email, celular, data_nascimento, matricula, senha, curso_id) FROM stdin;
\.


--
-- TOC entry 5021 (class 0 OID 33586)
-- Dependencies: 223
-- Data for Name: aluno_disciplina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno_disciplina (aluno_id, disciplina_id) FROM stdin;
\.


--
-- TOC entry 5030 (class 0 OID 33678)
-- Dependencies: 232
-- Data for Name: atividade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atividade (atividade_id, monitoria_id, titulo, descricao, link_formulario) FROM stdin;
\.


--
-- TOC entry 5031 (class 0 OID 33691)
-- Dependencies: 233
-- Data for Name: atividade_resposta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atividade_resposta (atividade_id, aluno_id, data_resposta, link_resposta) FROM stdin;
\.


--
-- TOC entry 5037 (class 0 OID 33823)
-- Dependencies: 239
-- Data for Name: comentario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comentario (comentario_id, texto, nota, data, aluno_id, monitoria_id) FROM stdin;
\.


--
-- TOC entry 5016 (class 0 OID 33550)
-- Dependencies: 218
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (curso_id, nome) FROM stdin;
\.


--
-- TOC entry 5018 (class 0 OID 33557)
-- Dependencies: 220
-- Data for Name: disciplina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.disciplina (disciplina_id, nome, curso_id) FROM stdin;
\.


--
-- TOC entry 5028 (class 0 OID 33664)
-- Dependencies: 230
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.material (material_id, monitoria_id, titulo, descricao, link, caminho_arquivo) FROM stdin;
\.


--
-- TOC entry 5033 (class 0 OID 33777)
-- Dependencies: 235
-- Data for Name: mensagem; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mensagem (mensagem_id, conteudo, data_hora, aluno_id, monitor_id, monitoria_id) FROM stdin;
\.


--
-- TOC entry 5023 (class 0 OID 33602)
-- Dependencies: 225
-- Data for Name: monitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.monitor (monitor_id, nome, email, celular, data_nascimento, matricula, senha, curso_id, disciplina_id, codigo_verificacao) FROM stdin;
\.


--
-- TOC entry 5025 (class 0 OID 33625)
-- Dependencies: 227
-- Data for Name: monitoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.monitoria (monitoria_id, monitor_id, curso_id, disciplina_id, codigo_disciplina, horario, link) FROM stdin;
\.


--
-- TOC entry 5026 (class 0 OID 33648)
-- Dependencies: 228
-- Data for Name: monitoria_aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.monitoria_aluno (monitoria_id, aluno_id) FROM stdin;
\.


--
-- TOC entry 5035 (class 0 OID 33802)
-- Dependencies: 237
-- Data for Name: notificacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notificacao (notificacao_id, mensagem, lida, data_envio, aluno_id, monitor_id) FROM stdin;
\.


--
-- TOC entry 5055 (class 0 OID 0)
-- Dependencies: 221
-- Name: aluno_aluno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aluno_aluno_id_seq', 1, false);


--
-- TOC entry 5056 (class 0 OID 0)
-- Dependencies: 231
-- Name: atividade_atividade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.atividade_atividade_id_seq', 1, false);


--
-- TOC entry 5057 (class 0 OID 0)
-- Dependencies: 238
-- Name: comentario_comentario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comentario_comentario_id_seq', 1, false);


--
-- TOC entry 5058 (class 0 OID 0)
-- Dependencies: 217
-- Name: curso_curso_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.curso_curso_id_seq', 1, false);


--
-- TOC entry 5059 (class 0 OID 0)
-- Dependencies: 219
-- Name: disciplina_disciplina_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.disciplina_disciplina_id_seq', 1, false);


--
-- TOC entry 5060 (class 0 OID 0)
-- Dependencies: 229
-- Name: material_material_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.material_material_id_seq', 1, false);


--
-- TOC entry 5061 (class 0 OID 0)
-- Dependencies: 234
-- Name: mensagem_mensagem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mensagem_mensagem_id_seq', 1, false);


--
-- TOC entry 5062 (class 0 OID 0)
-- Dependencies: 224
-- Name: monitor_monitor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.monitor_monitor_id_seq', 1, false);


--
-- TOC entry 5063 (class 0 OID 0)
-- Dependencies: 226
-- Name: monitoria_monitoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.monitoria_monitoria_id_seq', 1, false);


--
-- TOC entry 5064 (class 0 OID 0)
-- Dependencies: 236
-- Name: notificacao_notificacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notificacao_notificacao_id_seq', 1, false);


--
-- TOC entry 4825 (class 2606 OID 33590)
-- Name: aluno_disciplina aluno_disciplina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno_disciplina
    ADD CONSTRAINT aluno_disciplina_pkey PRIMARY KEY (aluno_id, disciplina_id);


--
-- TOC entry 4819 (class 2606 OID 33578)
-- Name: aluno aluno_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_email_key UNIQUE (email);


--
-- TOC entry 4821 (class 2606 OID 33580)
-- Name: aluno aluno_matricula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_matricula_key UNIQUE (matricula);


--
-- TOC entry 4823 (class 2606 OID 33576)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (aluno_id);


--
-- TOC entry 4839 (class 2606 OID 33685)
-- Name: atividade atividade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade
    ADD CONSTRAINT atividade_pkey PRIMARY KEY (atividade_id);


--
-- TOC entry 4841 (class 2606 OID 33698)
-- Name: atividade_resposta atividade_resposta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade_resposta
    ADD CONSTRAINT atividade_resposta_pkey PRIMARY KEY (atividade_id, aluno_id);


--
-- TOC entry 4847 (class 2606 OID 33831)
-- Name: comentario comentario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT comentario_pkey PRIMARY KEY (comentario_id);


--
-- TOC entry 4815 (class 2606 OID 33555)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (curso_id);


--
-- TOC entry 4817 (class 2606 OID 33562)
-- Name: disciplina disciplina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (disciplina_id);


--
-- TOC entry 4837 (class 2606 OID 33671)
-- Name: material material_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.material
    ADD CONSTRAINT material_pkey PRIMARY KEY (material_id);


--
-- TOC entry 4843 (class 2606 OID 33785)
-- Name: mensagem mensagem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem
    ADD CONSTRAINT mensagem_pkey PRIMARY KEY (mensagem_id);


--
-- TOC entry 4827 (class 2606 OID 33611)
-- Name: monitor monitor_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_email_key UNIQUE (email);


--
-- TOC entry 4829 (class 2606 OID 33613)
-- Name: monitor monitor_matricula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_matricula_key UNIQUE (matricula);


--
-- TOC entry 4831 (class 2606 OID 33609)
-- Name: monitor monitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_pkey PRIMARY KEY (monitor_id);


--
-- TOC entry 4835 (class 2606 OID 33652)
-- Name: monitoria_aluno monitoria_aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria_aluno
    ADD CONSTRAINT monitoria_aluno_pkey PRIMARY KEY (monitoria_id, aluno_id);


--
-- TOC entry 4833 (class 2606 OID 33632)
-- Name: monitoria monitoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria
    ADD CONSTRAINT monitoria_pkey PRIMARY KEY (monitoria_id);


--
-- TOC entry 4845 (class 2606 OID 33811)
-- Name: notificacao notificacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notificacao
    ADD CONSTRAINT notificacao_pkey PRIMARY KEY (notificacao_id);


--
-- TOC entry 4849 (class 2606 OID 33581)
-- Name: aluno aluno_curso_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.curso(curso_id);


--
-- TOC entry 4850 (class 2606 OID 33591)
-- Name: aluno_disciplina aluno_disciplina_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno_disciplina
    ADD CONSTRAINT aluno_disciplina_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(aluno_id);


--
-- TOC entry 4851 (class 2606 OID 33596)
-- Name: aluno_disciplina aluno_disciplina_disciplina_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno_disciplina
    ADD CONSTRAINT aluno_disciplina_disciplina_id_fkey FOREIGN KEY (disciplina_id) REFERENCES public.disciplina(disciplina_id);


--
-- TOC entry 4860 (class 2606 OID 33686)
-- Name: atividade atividade_monitoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade
    ADD CONSTRAINT atividade_monitoria_id_fkey FOREIGN KEY (monitoria_id) REFERENCES public.monitoria(monitoria_id);


--
-- TOC entry 4861 (class 2606 OID 33704)
-- Name: atividade_resposta atividade_resposta_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade_resposta
    ADD CONSTRAINT atividade_resposta_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(aluno_id);


--
-- TOC entry 4862 (class 2606 OID 33699)
-- Name: atividade_resposta atividade_resposta_atividade_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade_resposta
    ADD CONSTRAINT atividade_resposta_atividade_id_fkey FOREIGN KEY (atividade_id) REFERENCES public.atividade(atividade_id);


--
-- TOC entry 4868 (class 2606 OID 33832)
-- Name: comentario comentario_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT comentario_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(aluno_id);


--
-- TOC entry 4869 (class 2606 OID 33837)
-- Name: comentario comentario_monitoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT comentario_monitoria_id_fkey FOREIGN KEY (monitoria_id) REFERENCES public.monitoria(monitoria_id);


--
-- TOC entry 4848 (class 2606 OID 33563)
-- Name: disciplina disciplina_curso_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.curso(curso_id);


--
-- TOC entry 4859 (class 2606 OID 33672)
-- Name: material material_monitoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.material
    ADD CONSTRAINT material_monitoria_id_fkey FOREIGN KEY (monitoria_id) REFERENCES public.monitoria(monitoria_id);


--
-- TOC entry 4863 (class 2606 OID 33786)
-- Name: mensagem mensagem_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem
    ADD CONSTRAINT mensagem_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(aluno_id);


--
-- TOC entry 4864 (class 2606 OID 33791)
-- Name: mensagem mensagem_monitor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem
    ADD CONSTRAINT mensagem_monitor_id_fkey FOREIGN KEY (monitor_id) REFERENCES public.monitor(monitor_id);


--
-- TOC entry 4865 (class 2606 OID 33796)
-- Name: mensagem mensagem_monitoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem
    ADD CONSTRAINT mensagem_monitoria_id_fkey FOREIGN KEY (monitoria_id) REFERENCES public.monitoria(monitoria_id);


--
-- TOC entry 4852 (class 2606 OID 33614)
-- Name: monitor monitor_curso_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.curso(curso_id);


--
-- TOC entry 4853 (class 2606 OID 33619)
-- Name: monitor monitor_disciplina_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_disciplina_id_fkey FOREIGN KEY (disciplina_id) REFERENCES public.disciplina(disciplina_id);


--
-- TOC entry 4857 (class 2606 OID 33658)
-- Name: monitoria_aluno monitoria_aluno_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria_aluno
    ADD CONSTRAINT monitoria_aluno_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(aluno_id);


--
-- TOC entry 4858 (class 2606 OID 33653)
-- Name: monitoria_aluno monitoria_aluno_monitoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria_aluno
    ADD CONSTRAINT monitoria_aluno_monitoria_id_fkey FOREIGN KEY (monitoria_id) REFERENCES public.monitoria(monitoria_id);


--
-- TOC entry 4854 (class 2606 OID 33638)
-- Name: monitoria monitoria_curso_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria
    ADD CONSTRAINT monitoria_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.curso(curso_id);


--
-- TOC entry 4855 (class 2606 OID 33643)
-- Name: monitoria monitoria_disciplina_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria
    ADD CONSTRAINT monitoria_disciplina_id_fkey FOREIGN KEY (disciplina_id) REFERENCES public.disciplina(disciplina_id);


--
-- TOC entry 4856 (class 2606 OID 33633)
-- Name: monitoria monitoria_monitor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.monitoria
    ADD CONSTRAINT monitoria_monitor_id_fkey FOREIGN KEY (monitor_id) REFERENCES public.monitor(monitor_id);


--
-- TOC entry 4866 (class 2606 OID 33812)
-- Name: notificacao notificacao_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notificacao
    ADD CONSTRAINT notificacao_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(aluno_id);


--
-- TOC entry 4867 (class 2606 OID 33817)
-- Name: notificacao notificacao_monitor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notificacao
    ADD CONSTRAINT notificacao_monitor_id_fkey FOREIGN KEY (monitor_id) REFERENCES public.monitor(monitor_id);


--
-- TOC entry 5044 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;


-- Completed on 2025-07-11 21:46:46

--
-- PostgreSQL database dump complete
--

