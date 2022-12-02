--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

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
-- Name: admins; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admins (
    admin_id integer NOT NULL,
    date_of_register timestamp without time zone,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255)
);


ALTER TABLE public.admins OWNER TO postgres;

--
-- Name: admins_admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admins_admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.admins_admin_id_seq OWNER TO postgres;

--
-- Name: admins_admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admins_admin_id_seq OWNED BY public.admins.admin_id;


--
-- Name: baskets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.baskets (
    customer_id integer NOT NULL,
    product_id integer NOT NULL
);


ALTER TABLE public.baskets OWNER TO postgres;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    category_id integer NOT NULL,
    category_name character varying(255)
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_category_id_seq OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_category_id_seq OWNED BY public.categories.category_id;


--
-- Name: colors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.colors (
    color_id integer NOT NULL,
    color_name character varying(255)
);


ALTER TABLE public.colors OWNER TO postgres;

--
-- Name: colors_color_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.colors_color_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.colors_color_id_seq OWNER TO postgres;

--
-- Name: colors_color_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.colors_color_id_seq OWNED BY public.colors.color_id;


--
-- Name: customer_locations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer_locations (
    customer_id integer NOT NULL,
    location_id integer NOT NULL
);


ALTER TABLE public.customer_locations OWNER TO postgres;

--
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    customer_id integer NOT NULL,
    date_of_register timestamp without time zone,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    identity_number character varying(255),
    is_active boolean,
    phone_number character varying(255),
    last_location_id integer
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customers_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customers_customer_id_seq OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;


--
-- Name: discount_codes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discount_codes (
    discount_code_id integer NOT NULL,
    discount_code_amount integer,
    discount_code character varying(255),
    discount_price integer
);


ALTER TABLE public.discount_codes OWNER TO postgres;

--
-- Name: discount_codes_discount_code_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discount_codes_discount_code_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.discount_codes_discount_code_id_seq OWNER TO postgres;

--
-- Name: discount_codes_discount_code_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.discount_codes_discount_code_id_seq OWNED BY public.discount_codes.discount_code_id;


--
-- Name: favorites; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favorites (
    product_id integer NOT NULL,
    customer_id integer NOT NULL
);


ALTER TABLE public.favorites OWNER TO postgres;

--
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.images (
    image_id integer NOT NULL,
    img_url character varying(255),
    product_id integer
);


ALTER TABLE public.images OWNER TO postgres;

--
-- Name: images_image_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.images_image_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.images_image_id_seq OWNER TO postgres;

--
-- Name: images_image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.images_image_id_seq OWNED BY public.images.image_id;


--
-- Name: locations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.locations (
    location_id integer NOT NULL,
    address character varying(255),
    city character varying(255),
    post_code character varying(255),
    location_title character varying(255),
    town character varying(255)
);


ALTER TABLE public.locations OWNER TO postgres;

--
-- Name: locations_location_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.locations_location_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.locations_location_id_seq OWNER TO postgres;

--
-- Name: locations_location_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.locations_location_id_seq OWNED BY public.locations.location_id;


--
-- Name: order_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_detail (
    order_detail_id integer NOT NULL,
    amount integer,
    order_id integer,
    product_id integer,
    size_id integer
);


ALTER TABLE public.order_detail OWNER TO postgres;

--
-- Name: order_detail_order_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_detail_order_detail_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_detail_order_detail_id_seq OWNER TO postgres;

--
-- Name: order_detail_order_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_detail_order_detail_id_seq OWNED BY public.order_detail.order_detail_id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    order_id integer NOT NULL,
    creation_date timestamp without time zone,
    total_price integer,
    billing_location_id integer,
    customer_id integer,
    discount_code_id integer,
    location_id integer
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_order_id_seq OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_order_id_seq OWNED BY public.orders.order_id;


--
-- Name: product_sizes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_sizes (
    product_id integer NOT NULL,
    size_id integer NOT NULL
);


ALTER TABLE public.product_sizes OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    product_id integer NOT NULL,
    discount_percentage integer,
    gender character varying(255),
    name character varying(255),
    price integer,
    category_id integer,
    color_id integer,
    typology_id integer
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_product_id_seq OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_product_id_seq OWNED BY public.products.product_id;


--
-- Name: refunds; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.refunds (
    refund_id integer NOT NULL,
    cause oid,
    is_online boolean,
    refund_date timestamp without time zone,
    customer_id integer,
    order_detail_id integer
);


ALTER TABLE public.refunds OWNER TO postgres;

--
-- Name: refunds_refund_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.refunds_refund_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.refunds_refund_id_seq OWNER TO postgres;

--
-- Name: refunds_refund_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.refunds_refund_id_seq OWNED BY public.refunds.refund_id;


--
-- Name: sizes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sizes (
    size_id integer NOT NULL,
    size_name character varying(255)
);


ALTER TABLE public.sizes OWNER TO postgres;

--
-- Name: stocks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stocks (
    stock_id integer NOT NULL,
    count integer,
    product_id integer,
    size_id integer
);


ALTER TABLE public.stocks OWNER TO postgres;

--
-- Name: stocks_stock_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stocks_stock_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stocks_stock_id_seq OWNER TO postgres;

--
-- Name: stocks_stock_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.stocks_stock_id_seq OWNED BY public.stocks.stock_id;


--
-- Name: typologies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.typologies (
    typology_id integer NOT NULL,
    gender character varying(255),
    typology_name character varying(255),
    category_id integer
);


ALTER TABLE public.typologies OWNER TO postgres;

--
-- Name: typologies_typology_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.typologies_typology_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.typologies_typology_id_seq OWNER TO postgres;

--
-- Name: typologies_typology_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.typologies_typology_id_seq OWNED BY public.typologies.typology_id;


--
-- Name: admins admin_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins ALTER COLUMN admin_id SET DEFAULT nextval('public.admins_admin_id_seq'::regclass);


--
-- Name: categories category_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN category_id SET DEFAULT nextval('public.categories_category_id_seq'::regclass);


--
-- Name: colors color_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colors ALTER COLUMN color_id SET DEFAULT nextval('public.colors_color_id_seq'::regclass);


--
-- Name: customers customer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);


--
-- Name: discount_codes discount_code_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount_codes ALTER COLUMN discount_code_id SET DEFAULT nextval('public.discount_codes_discount_code_id_seq'::regclass);


--
-- Name: images image_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images ALTER COLUMN image_id SET DEFAULT nextval('public.images_image_id_seq'::regclass);


--
-- Name: locations location_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locations ALTER COLUMN location_id SET DEFAULT nextval('public.locations_location_id_seq'::regclass);


--
-- Name: order_detail order_detail_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail ALTER COLUMN order_detail_id SET DEFAULT nextval('public.order_detail_order_detail_id_seq'::regclass);


--
-- Name: orders order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN order_id SET DEFAULT nextval('public.orders_order_id_seq'::regclass);


--
-- Name: products product_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN product_id SET DEFAULT nextval('public.products_product_id_seq'::regclass);


--
-- Name: refunds refund_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refunds ALTER COLUMN refund_id SET DEFAULT nextval('public.refunds_refund_id_seq'::regclass);


--
-- Name: stocks stock_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stocks ALTER COLUMN stock_id SET DEFAULT nextval('public.stocks_stock_id_seq'::regclass);


--
-- Name: typologies typology_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typologies ALTER COLUMN typology_id SET DEFAULT nextval('public.typologies_typology_id_seq'::regclass);


--
-- Data for Name: admins; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admins (admin_id, date_of_register, email, first_name, last_name, password) FROM stdin;
1	2022-12-02 15:06:34	tunahan@gmail.com	Tunahan	Kanpolat	123
2	2022-12-02 15:06:55	yüksel@gmail.com	Yüksel	Baltacıoğlu	123
3	2022-12-02 15:07:18	emre@gmail.com	Emre	Özkaya	123
\.


--
-- Data for Name: baskets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.baskets (customer_id, product_id) FROM stdin;
2	1
5	1
5	2
3	1
6	1
2	2
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categories (category_id, category_name) FROM stdin;
1	Giyim
2	Ayakkabı
3	Aksesuar
\.


--
-- Data for Name: colors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.colors (color_id, color_name) FROM stdin;
1	Beyaz
2	Kırmızı
3	Kahverengi
4	Siyah
5	Mavi
6	Gri
7	Bej
8	Pembe
9	Violet
10	Sarı
11	Yeşil
12	Turuncu
\.


--
-- Data for Name: customer_locations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer_locations (customer_id, location_id) FROM stdin;
2	54
3	69
4	52
5	66
6	79
7	10
8	18
9	100
10	71
11	63
12	45
13	97
14	59
15	53
16	35
17	61
18	9
19	24
20	82
21	47
22	25
23	86
24	23
25	33
26	32
27	67
28	59
29	71
30	60
31	9
32	11
33	62
34	88
35	50
36	10
37	84
38	36
39	34
40	90
41	29
42	13
43	100
44	57
45	59
46	82
47	12
48	56
49	98
50	82
51	6
52	68
53	55
54	26
55	65
56	18
57	31
58	60
59	57
60	46
61	74
62	54
63	16
64	56
65	1
66	71
67	99
68	37
69	85
70	84
71	88
72	16
73	99
74	45
75	32
76	43
77	91
78	22
79	35
80	94
81	25
82	98
83	63
84	88
85	2
86	23
87	57
88	65
89	90
90	26
91	65
92	99
93	7
94	27
95	1
96	50
97	83
98	11
99	57
2	3
2	4
2	5
\.


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customers (customer_id, date_of_register, email, first_name, last_name, password, identity_number, is_active, phone_number, last_location_id) FROM stdin;
2	2022-11-03 09:48:28	rfluck1@gnu.org	Rab	Fluck	MaO3SHnvS	1327399911	t	621-385-4318	54
3	2022-04-30 06:44:29	hgymblett3@com.com	Hubey	Gymblett	DCWv9wrS3uD	5925973720	f	568-961-5440	69
4	2022-01-20 13:26:17	ncarette4@a8.net	Neville	Carette	q4kMbM	2498468641	f	912-291-6936	52
5	2022-09-10 02:20:23	rproffer5@scribd.com	Richie	Proffer	JMyjP3FRS	0706427947	t	881-766-1392	66
6	2022-01-20 19:55:22	dkupper6@yahoo.com	Dill	Kupper	yKlOTja	3302672101	t	868-981-2490	79
7	2022-09-09 06:55:44	cfell7@statcounter.com	Con	Fell	UlB2wc	3941135635	t	273-831-9162	10
8	2022-10-17 03:38:28	gashleigh8@theatlantic.com	Gherardo	Ashleigh	DYGEQ0b4KL	7926986186	f	928-620-3745	18
9	2022-05-15 05:30:57	ecridlin9@skyrock.com	Ernst	Cridlin	l7ccN0JG5	0988222930	t	242-397-1779	100
10	2022-02-16 08:14:24	jjowitta@ycombinator.com	Joletta	Jowitt	WcE4M7mOSu	0792140818	f	427-977-9460	71
11	2022-01-21 05:08:08	bskellsb@myspace.com	Bernadine	Skells	huvUBYWfI	2889474097	t	570-381-2358	63
12	2022-07-17 02:02:57	bcoullc@princeton.edu	Brannon	Coull	Ve2WjfI59zcY	9342606008	t	390-862-1757	45
13	2022-11-02 11:57:09	cbeastalld@japanpost.jp	Cordula	Beastall	JMbU5KJ	6669213239	f	691-312-2700	97
14	2022-08-27 08:12:33	aloomese@tinyurl.com	Alfi	Loomes	rBTXLECe	2888931109	f	369-234-7343	59
15	2021-12-28 16:43:23	tschwaigerf@example.com	Tine	Schwaiger	5YQCvt56vbh	3172832783	f	193-796-0203	53
16	2022-06-01 12:28:36	hbottrellg@gizmodo.com	Heriberto	Bottrell	Oxwwx6pPp	7237061666	f	936-247-0449	35
17	2022-07-26 11:55:00	pgellibrandh@123-reg.co.uk	Paulita	Gellibrand	WcycGgCnsOY3	1264609930	t	494-907-5057	61
18	2022-04-01 18:21:15	emacnockateri@a8.net	Elisha	MacNockater	DNrXhLXZ	2283317819	f	220-387-9618	9
19	2021-12-24 13:11:26	elountj@issuu.com	Elli	Lount	NgIQlsQexoco	3586210353	t	822-930-8296	24
20	2022-06-20 18:44:35	bbendsonk@indiatimes.com	Barclay	Bendson	fxqwwUXW40Pk	3283474060	t	876-991-0270	82
21	2021-12-16 15:23:25	fbemlottl@aboutads.info	Francisco	Bemlott	WNTltCREB4J	4460421100	t	518-207-3257	47
22	2022-03-22 12:34:29	cdurbannm@bloglines.com	Channa	Durbann	sGKg9m	7357854523	f	470-726-4555	25
23	2022-03-04 14:03:02	cpopleyn@jigsy.com	Claudelle	Popley	XnI4m914wFiv	2682855016	t	501-645-5188	86
24	2022-01-10 20:30:15	gbartolomiviso@ucoz.ru	Giusto	Bartolomivis	JZYPrvLu0	7111100301	f	554-739-6422	23
25	2022-09-15 17:46:54	vrubip@prnewswire.com	Vince	Rubi	RzMMK1Fv	7734844553	f	621-487-8787	33
26	2022-08-25 07:49:58	hmccorrieq@telegraph.co.uk	Hillier	McCorrie	0MWei8	0560797796	t	342-230-0794	32
27	2022-07-17 01:49:49	rdeblaser@linkedin.com	Renault	De Blase	s5SVjD	5937526198	t	111-366-9694	67
28	2022-05-25 18:23:43	emcneils@booking.com	Elysha	McNeil	UtUKZ0xto	5618159872	f	317-247-5075	59
29	2022-05-28 19:12:32	bwilkint@hud.gov	Birch	Wilkin	rfNq3aTeYEM1	0700645853	t	172-961-3910	71
30	2022-05-25 10:55:30	ffantonettiu@mapquest.com	Florette	Fantonetti	V7QMPSBsH	1950393224	t	173-816-8903	60
31	2022-04-27 11:35:22	sgasnollv@walmart.com	Stacee	Gasnoll	igiyxq	3209918678	t	134-299-2669	9
32	2022-07-01 17:13:50	ghoudmontw@free.fr	Grethel	Houdmont	iwqSHw5	5416709898	f	468-909-0235	11
33	2022-11-09 18:10:56	tbellewx@sourceforge.net	Teresita	Bellew	siJ3AsnZy0l	1436523478	f	568-648-0856	62
34	2022-06-25 06:11:42	htournayy@huffingtonpost.com	Henrie	Tournay	LRQHjWixOm	0953926192	f	303-657-0336	88
35	2022-03-13 07:04:02	sgriswaitez@dot.gov	Stanton	Griswaite	M1hyLjO	7418003250	t	830-519-7395	50
36	2022-06-25 05:43:17	gheffernan10@ft.com	Gabby	Heffernan	s8HHqsZYOs	8802917256	t	775-108-8554	10
37	2022-11-25 12:29:55	rwitnall11@whitehouse.gov	Reina	Witnall	ZggNVP	0435375350	t	371-530-3125	84
38	2021-12-11 15:51:17	gsamper12@wufoo.com	Gates	Samper	j81JJ697x	4161079273	t	212-104-3751	36
39	2022-02-07 12:22:23	moehme13@craigslist.org	Mab	Oehme	LuCAsrMCwj0V	1813049599	f	773-916-7442	34
40	2022-06-23 09:48:15	bmarcos14@state.tx.us	Brynna	Marcos	eFTV1wP	9754633762	f	761-732-3448	90
41	2022-01-05 01:10:52	cskevington15@google.com.au	Carey	Skevington	rS8muPJDvE	2697546464	f	624-544-8296	29
42	2022-02-16 00:56:32	smapples16@springer.com	Sherlocke	Mapples	hTGbQu	9594793317	f	514-385-5523	13
43	2022-08-21 20:30:46	ckivell17@1688.com	Carmelia	Kivell	qYetUi5	4018865716	t	735-387-8842	100
44	2022-07-30 07:40:26	ceves18@google.com.hk	Cordy	Eves	uBt77stGIk	7049923877	t	289-791-7117	57
45	2022-01-18 20:11:43	klarret19@thetimes.co.uk	Kale	Larret	tGMbt2A7B4	6065599921	t	736-258-1655	59
46	2022-09-17 00:41:02	cshackelton1a@gmpg.org	Claudine	Shackelton	mfbNrS	0817254269	t	161-497-0969	82
47	2022-02-07 20:40:13	tdarycott1b@cnbc.com	Tabbie	Darycott	hpRJi4ibY	7152014914	f	939-253-9766	12
48	2022-06-17 05:17:46	tcastelletto1c@omniture.com	Tabatha	Castelletto	iqJEf6	8336131841	f	821-838-9129	56
49	2022-02-11 18:19:30	hmcgraw1d@oakley.com	Helaine	McGraw	uEZo7b	5551498425	f	696-857-2487	98
50	2022-08-10 22:37:49	alatham1e@naver.com	Austine	Latham	fWgd3iId6n	5431461591	t	931-306-2715	82
51	2022-04-21 04:28:27	sloynton1f@twitter.com	Sammy	Loynton	gSHyP8ChSfC	4923796502	t	961-179-9531	6
52	2022-04-20 21:10:31	gcardinal1g@slate.com	Gwenny	Cardinal	4YFkotWaSvoa	5381223226	f	878-525-9082	68
53	2022-08-26 04:11:05	egullick1h@godaddy.com	Euphemia	Gullick	AG33VHR	6468465826	f	410-525-4302	55
54	2022-05-18 04:24:51	karkill1i@cornell.edu	Kirby	Arkill	VTz9DkQu6	0064163598	f	988-872-6506	26
55	2022-10-16 11:19:43	mgrinishin1j@geocities.jp	Meryl	Grinishin	ivrjJe2HW	4453743483	f	258-277-4791	65
56	2021-12-15 00:14:18	sstreetfield1k@ibm.com	Sophronia	Streetfield	Is4gFlP	8580426901	f	944-540-5976	18
57	2022-11-02 13:42:31	aromney1l@gov.uk	Anetta	Romney	KSAw2cBmLUg6	6420722543	t	810-626-1979	31
58	2022-07-23 02:00:29	aclelland1m@umn.edu	Ashely	Clelland	EerobHu	1728577454	t	128-555-5170	60
59	2022-05-27 06:38:19	bmacnish1n@seattletimes.com	Ben	MacNish	lfgPAF	1651583854	t	352-103-6962	57
60	2022-05-07 06:00:56	agunny1o@sakura.ne.jp	Adriane	Gunny	AsXh1qV	1509521291	f	188-471-1845	46
61	2022-02-04 11:17:34	cdanis1p@bigcartel.com	Cayla	Danis	0UtaUzY	0235107565	f	809-459-5445	74
62	2022-09-21 02:41:52	msyde1q@multiply.com	Mendy	Syde	mI4qCy3ks9A	5030221263	t	400-704-6348	54
63	2022-11-21 19:18:37	crenney1r@discovery.com	Christoforo	Renney	5RI8KAykomxg	7605662742	f	399-683-3720	16
64	2022-03-05 08:10:45	cnormanville1s@meetup.com	Cecily	Normanville	m2dPwGqOubiX	1482310198	t	268-287-8032	56
65	2022-07-27 06:40:44	gtravers1t@reuters.com	Guthrie	Travers	qciV4b	9754803617	t	885-368-3810	1
66	2022-09-12 03:59:00	aechallier1u@mapy.cz	Ayn	Echallier	blZ1oodys	5002675417	t	206-650-9718	71
67	2022-05-16 13:23:41	rsaldler1v@newsvine.com	Roana	Saldler	cd4tvzC9Tgtx	6951126275	t	799-886-1372	99
68	2022-07-19 13:32:13	lhindrick1w@wp.com	Lorne	Hindrick	NHIfHWQocES	2739100698	t	224-706-7711	37
69	2022-04-02 23:45:38	mfrancesc1x@seesaa.net	Mar	Francesc	6jK0sIlqaL	7604234933	t	413-425-2230	85
70	2022-03-23 02:12:27	bstreatley1y@booking.com	Bing	Streatley	rSEXdEGLOt1	3464710998	f	542-919-5289	84
71	2022-06-04 06:28:24	nfeltham1z@zimbio.com	Nickola	Feltham	94SY7YPJ0W8	2822154511	t	383-631-7546	88
72	2022-10-31 22:31:30	swingatt20@studiopress.com	Shanta	Wingatt	vWvaBxH0	7611498363	t	186-750-9840	16
73	2022-01-22 16:32:47	bwickwarth21@omniture.com	Brandais	Wickwarth	6T4Ifsk	5809914624	f	925-817-2651	99
74	2022-07-15 07:57:46	dskocroft22@harvard.edu	Dedra	Skocroft	G4Ole2AnI	2088781145	f	716-185-3752	45
75	2022-03-09 11:14:19	dtonner23@nydailynews.com	Dallon	Tonner	d4dMcEG	5142286243	f	433-766-0416	32
76	2022-02-25 09:56:59	jrosenblatt24@google.cn	Josey	Rosenblatt	dtIVaCPiaN	4914876906	f	799-361-8910	43
77	2022-01-13 16:36:45	wevenett25@stanford.edu	Woodman	Evenett	k36cuXI	9573252856	t	965-668-1397	91
78	2022-05-12 19:36:12	roquirk26@intel.com	Reagan	O' Quirk	al8Wgf	5683806011	t	663-637-5054	22
79	2022-10-15 03:33:13	wkerrigan27@github.io	Worthington	Kerrigan	wSNPGOJncs36	0791726703	f	810-320-8363	35
80	2022-03-17 18:05:44	obycraft28@dagondesign.com	Orel	Bycraft	KpVFIFYQOtN	8583621780	f	830-954-8271	94
81	2022-03-06 01:45:46	pdillicate29@google.co.uk	Pierrette	Dillicate	pHmNzIXLW	1084688093	t	711-662-5685	25
82	2022-05-28 02:04:57	acorker2a@adobe.com	Aleda	Corker	bFCpfJE	5489486511	f	303-217-8736	98
83	2021-12-21 04:43:31	jcretney2b@liveinternet.ru	Jecho	Cretney	80ZbJp	1191166988	f	831-384-9684	63
84	2022-01-01 06:34:33	ldeplacido2c@springer.com	Lorri	Deplacido	pTY3cFymV	4767920698	f	991-898-3609	88
85	2022-01-20 02:01:03	rallwell2d@springer.com	Rockey	Allwell	5r8t00eqx	1121871267	f	714-358-5510	2
86	2022-09-11 07:11:47	ndearing2e@ebay.co.uk	Nance	Dearing	yWrMdb	5045116193	t	822-850-2303	23
87	2021-12-05 10:12:40	ebroadbridge2f@nymag.com	Ezechiel	Broadbridge	jk8Jh5UfVuh	1250844223	t	932-344-9037	57
88	2022-05-26 00:59:50	tklasing2g@51.la	Timoteo	Klasing	RcWo8sVH	7605416768	t	184-493-8503	65
89	2022-10-15 16:53:20	ktethacot2h@hugedomains.com	Kale	Tethacot	L5wmigBxJzc	3136510895	t	619-697-7613	90
90	2022-01-12 01:24:59	ogamil2i@mayoclinic.com	Opaline	Gamil	OIY1J5	1652368736	t	102-788-7794	26
91	2022-02-22 08:55:08	edaftor2j@cdc.gov	Eziechiele	Daftor	NnKoHyDqw	6357012300	t	322-926-2244	65
92	2022-11-20 02:30:56	pstocks2k@icio.us	Phedra	Stocks	Icu9ueBER	4789676307	t	588-619-6345	99
93	2022-11-10 11:20:36	cwyvill2l@pinterest.com	Clim	Wyvill	GUR6KC2Mgw	8989504791	f	604-877-9097	7
94	2022-05-22 18:44:34	ssuccamore2m@goodreads.com	Sissy	Succamore	hGweuCZEjx5	3991885743	t	859-328-0621	27
95	2022-02-27 17:28:46	eskeath2n@etsy.com	Even	Skeath	qxE4MKlJ7	4258597848	t	752-356-9893	1
96	2022-07-26 19:44:50	tcovil2o@nih.gov	Thebault	Covil	KWhvc5ZsNuVK	3713682305	t	702-629-0533	50
97	2022-06-19 01:57:43	zconniam2p@furl.net	Zared	Conniam	CxYaRDFax	7766703203	f	626-290-1700	83
98	2022-04-08 15:59:55	lbenz2q@imageshack.us	Latisha	Benz	HhPW8gfnCyk	5119082602	f	689-389-8818	11
99	2022-03-22 13:55:58	otrytsman2r@oracle.com	Otho	Trytsman	z8ZFeTJLjxEt	9116114663	f	669-169-6180	57
\.


--
-- Data for Name: discount_codes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discount_codes (discount_code_id, discount_code_amount, discount_code, discount_price) FROM stdin;
1	45	iSTeTFxAODY	31
2	45	Wrcjkpg5y	33
3	98	yC87ftUusDFS	40
4	6	rNJc93ldx	44
5	24	9OzoWPCe	17
6	18	fw2f8BgH	50
7	99	ljuxt5Enb0y	14
8	76	6Ih38YIT	25
9	5	18Ay72G2rVp	19
10	59	ZnJsbKvhUx	43
11	31	f2QOfR	40
12	93	90DP2P9m	25
13	99	6c2X863T5VP	43
14	40	s3Db20	38
15	84	TM3pxZq5R7	17
16	75	R0OcRaD	33
17	36	z1g98QB5pzpz	32
18	23	XgixHbZ	23
19	54	msxYBrexx	29
20	53	znOswG	21
21	74	2DQ6xp0N8ZK	17
22	41	P1vYqcJix3	21
23	61	pk69RZiB25r	36
24	92	q9OrGExtq	48
25	41	4sNPrXClJ	33
26	39	zbATFYJt2Ab	31
27	5	QXwB7pB	14
28	59	d8PnGASE1	45
29	56	M0zJjbVkGr	48
30	52	5Xoxqwq9L	21
31	58	4DP34J	40
32	68	PU7xHw	48
33	47	RLtGtzL5	45
34	8	ZfLHqrq1	21
35	37	qVIE4i	22
36	19	CapRypu	37
37	42	AJKVq3	36
38	10	X1BLV9xMz4zk	18
39	13	iXAgI5ffT	43
40	46	Bc0iZZgUT	15
41	42	AFj9w8sxbTL	40
42	17	A0pdPbhVYa	45
43	48	jgC1ie1o	46
44	23	Qq3gOz	13
45	93	Ujbhwxv4mC	33
46	53	C6igoT	36
47	7	185A1iV	35
48	31	F0wrVHJ	26
49	11	ln1DwV	16
50	83	Iz7D1dgnrctK	23
51	44	3fZTsg7	34
52	25	2lvRTk08Uilt	22
53	81	zjxG6joe	30
54	11	EvBUoYXat	30
55	14	s4vyTn	40
56	32	gznEjtU	29
57	33	fWzHpEwZzx	10
58	71	cLKSD6	48
59	20	VP6CpaYc4UNX	41
60	41	Ajo5GCkdI6V	36
61	78	gHOxy1rL1	45
62	60	q4k7tB5	44
63	52	4v4Te8e	26
64	95	6T6QpTVAD6AY	12
65	34	kQEO5abheB8G	33
66	37	vYDgwxUgKk	37
67	54	zoQCgsV6Qg	26
68	52	Lo7VZJ56Zgc	22
69	87	GsHAqLKo	21
70	67	y8j4ze7yrU9f	39
71	4	TT9a0UoRSd	42
72	69	HfOIY2Z	45
73	42	XCYf7d9Kh	36
74	16	1Y4Ors	27
75	2	tWzwBGJ	33
76	6	CK1jTs4O	14
77	86	EqCQL20uUq0m	12
78	8	xRHmgclOo1Fg	29
79	96	ylk7MgH	22
80	24	kZSVAS	34
81	38	ZUR6ZPL	44
82	98	ng5RsNMwEk	17
83	96	TkXrPlYj	49
84	80	ncQBacWVca	31
85	46	tbJBnRc4	19
86	59	GbNrO5Dyw	47
87	48	8f64Swl	32
88	73	l9WEIsM0mn	26
89	9	YGsKxVBSfH	48
90	31	jOJFO6V9	49
91	9	shCqd1N4YqOU	31
92	10	H5k3dPb61NDF	15
93	16	BMJMbQ	18
94	93	yhhDxE	22
95	74	CV0ghcE7QcX	48
96	86	0Z8Wi6nIU9	30
97	79	t8CVbMgc8Dqg	26
98	59	7S548qU	21
99	79	pl4wJI	31
100	74	Itef7aQR	42
\.


--
-- Data for Name: favorites; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.favorites (product_id, customer_id) FROM stdin;
1	2
1	5
2	5
1	3
1	6
2	2
\.


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.images (image_id, img_url, product_id) FROM stdin;
1	https://static.bershka.net/4/photos2/2022/I/0/2/p/5464/335/800/90debedabbd513740511d2dcd19af58b-5464335800_2_3_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	1
2	https://static.bershka.net/4/photos2/2022/I/0/2/p/5464/335/800/b6d4c180b80fd80b67d54302cfc0377f-5464335800_1_1_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	1
3	https://static.bershka.net/4/photos2/2022/I/0/2/p/5464/335/800/18798458f6a9c93c8080ea65636c9eff-5464335800_2_1_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	1
4	https://static.bershka.net/4/photos2/2022/I/0/2/p/5464/335/800/274db2d3c63e9b129f49a2dd76aa11c8-5464335800_2_2_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	1
5	https://static.bershka.net/4/photos2/2022/I/0/2/p/7572/700/400/f468a9c3bc64f965077793dca8e07215-7572700400_1_1_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	2
6	https://static.bershka.net/4/photos2/2022/I/0/2/p/7572/700/400/fb39527f28ae39dc620e1897efe1b638-7572700400_2_1_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	2
7	https://static.bershka.net/4/photos2/2022/I/0/2/p/7572/700/400/a8a41e9f7fbf562146bb49095570d80c-7572700400_2_2_0.jpg?imwidth=1920&impolicy=bershka-itxmedium&imformat=chrome	2
\.


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.locations (location_id, address, city, post_code, location_title, town) FROM stdin;
1	135 Tomscot Pass	Cartago	30703	EV	\N
2	7 Boyd Center	Concepcion	7213	EV	\N
3	3 Fairview Way	Pandan	5712	EV	\N
4	97 Havey Hill	Bolikhan	5712	EV	\N
5	35 Pine View Crossing	Batad	5016	EV	\N
6	38 Sunnyside Park	Ciemas	5016	EV	\N
7	1966 Parkside Way	Chupa	186670	EV	\N
8	263 Carioca Terrace	Qiawan	186670	EV	\N
9	6 Merrick Center	Baleber	186670	EV	\N
10	36509 Sheridan Hill	Bayt ‘Awwā	186670	EV	\N
11	742 Gale Trail	Mandalasari	186670	EV	\N
12	41 Derek Center	Majunying	186670	EV	\N
13	02016 Dakota Court	Houston	77234	EV	\N
14	60602 Myrtle Hill	Los Juríes	3763	EV	\N
15	93708 Eliot Road	Ōdachō-ōda	699-2211	EV	\N
16	062 Mayer Trail	Jincheng	699-2211	EV	\N
17	98274 Lyons Pass	Tabou	699-2211	EV	\N
18	5 Mifflin Parkway	Mirzec	27-220	EV	\N
19	0119 Moland Plaza	Tobias Fornier	5716	EV	\N
20	6980 Waubesa Center	Doloon	5716	EV	\N
21	9101 Towne Drive	Bajo Pichanaqui	5716	EV	\N
22	91347 Pankratz Way	Ensanche Luperón	11806	EV	\N
23	706 Daystar Trail	Kroczyce	42-425	EV	\N
24	446 Maryland Center	Aurora	7020	EV	\N
25	38163 Scott Park	Makiwalo	1743	EV	\N
26	244 Golf View Trail	Sollefteå	881 30	EV	\N
27	3492 Sunfield Road	Kapshagay	881 30	EV	\N
28	08870 Waubesa Center	Sandaoba	881 30	EV	\N
29	96 Brickson Park Court	Emmaboda	361 31	EV	\N
30	05 Debs Park	Blendis	361 31	EV	\N
31	1 Cambridge Avenue	Francos	2635-230	EV	\N
32	2 Macpherson Lane	Kvitok	665081	EV	\N
33	43564 Tony Court	Grängesberg	772 30	EV	\N
34	0 Grim Pass	Wuxiang	772 30	EV	\N
35	373 Forest Run Avenue	Velyka Bahachka	772 30	EV	\N
36	61 Jenna Place	Narutochō-mitsuishi	779-0311	EV	\N
37	6 South Street	San Miguel	51700	EV	\N
38	746 Mesta Parkway	Korczew	08-108	EV	\N
39	2 Shelley Drive	Mloko	08-108	EV	\N
40	8 Valley Edge Crossing	Uritsk	663594	EV	\N
41	605 Schlimgen Center	Leku	663594	EV	\N
42	95642 Dahle Drive	Mayma	659780	EV	\N
43	88729 Delladonna Court	Yangying	659780	EV	\N
44	567 Haas Junction	Ponong	5040	EV	\N
45	29637 Warner Avenue	Buzuluk	461059	EV	\N
46	467 Hudson Road	Caotan	461059	EV	\N
47	29 Hazelcrest Parkway	Wushi	461059	EV	\N
48	179 Summit Park	Novopokrovskaya	353029	EV	\N
49	5 Doe Crossing Road	Lukolela	353029	EV	\N
50	4 Scoville Point	Vanadzor	353029	EV	\N
51	41819 Caliangt Plaza	Pingyi	353029	EV	\N
52	53 Dennis Way	Huangbu	353029	EV	\N
53	4685 Chive Way	Sankanan	8701	EV	\N
54	6422 Drewry Point	Ballsh	8701	EV	\N
55	942 Blaine Center	Maydolong	6802	EV	\N
56	09 Corscot Junction	Kaminoyama	988-0413	EV	\N
57	5 Sullivan Alley	Orivesi	35301	EV	\N
58	98 Bobwhite Point	Magaozhuang	35301	EV	\N
59	62601 Chive Plaza	Surenavan	35301	EV	\N
60	05956 Crescent Oaks Parkway	Amieira	7050-511	EV	\N
61	57 Main Court	Kalá Déndra	7050-511	EV	\N
62	08 Vermont Crossing	Bodĭ	7050-511	EV	\N
63	1 Hudson Place	Qalyūb	7050-511	EV	\N
64	4881 Macpherson Court	Huangnaihai	7050-511	EV	\N
65	75353 Walton Road	Fengshan	7050-511	EV	\N
66	780 Ohio Terrace	Dikou	7050-511	EV	\N
67	14880 Forest Run Point	North Bay	7050-511	EV	\N
68	517 Nova Street	Zhangatas	7050-511	EV	\N
69	6694 Fisk Circle	Reims	7050-511	EV	\N
70	758 Carioca Point	Ngorongoro	7050-511	EV	\N
71	3 Forest Run Alley	Zhijiang	7050-511	EV	\N
72	642 Brickson Park Circle	Xihe	7050-511	EV	\N
73	6478 Lakewood Gardens Circle	Ubatuba	11680-000	EV	\N
74	491 Menomonie Circle	Hihyā	11680-000	EV	\N
75	0 Reinke Drive	Tiniguiban	2106	EV	\N
76	7 Bashford Road	Monte Mor	13190-000	EV	\N
77	532 Kensington Terrace	Sasebo	859-6411	EV	\N
78	048 Almo Junction	Tallaght	D24	EV	\N
79	03 Jackson Lane	Braga	4700-005	EV	\N
80	0 Arkansas Road	Biały Bór	78-425	EV	\N
81	92888 Shoshone Point	Zhoujia	78-425	EV	\N
82	414 Dayton Plaza	Vermil	4805-550	EV	\N
83	28590 Badeau Plaza	Thepharak	85130	EV	\N
84	01 Boyd Point	Desa Gegempalan	78-425	EV	\N
85	5109 Dexter Center	Longbei	78-425	EV	\N
86	792 Golden Leaf Court	Shizunai-furukawachō	942-0213	EV	\N
87	192 Dixon Hill	Fafe	4820-009	EV	\N
88	953 Pearson Hill	Zaragoza	04015	EV	\N
89	9 School Point	Al Ḩammāmāt	04015	EV	\N
90	619 Mockingbird Point	Gaotang	04015	EV	\N
91	612 Golf Center	Agbani	04015	EV	\N
92	62 Morning Trail	Chipinge	04015	EV	\N
93	2 Becker Avenue	Belsk Duży	05-622	EV	\N
94	4479 Melvin Terrace	Humaitá	98670-000	EV	\N
95	6044 Stang Lane	Hayil	98670-000	EV	\N
96	9130 East Way	Izmaylovo	662686	EV	\N
97	053 Grasskamp Road	Waeng Yai	40330	EV	\N
98	75 Raven Point	Yinghai	40330	EV	\N
99	09 Paget Court	Fucheng	40330	EV	\N
100	5 Manitowish Avenue	Tocok	4335	EV	\N
\.


--
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_detail (order_detail_id, amount, order_id, product_id, size_id) FROM stdin;
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (order_id, creation_date, total_price, billing_location_id, customer_id, discount_code_id, location_id) FROM stdin;
\.


--
-- Data for Name: product_sizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_sizes (product_id, size_id) FROM stdin;
1	1
1	2
1	3
1	4
1	5
1	6
2	1
2	2
2	3
2	4
2	5
2	6
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (product_id, discount_percentage, gender, name, price, category_id, color_id, typology_id) FROM stdin;
1	0	MALE	Wide leg 90's jean	600	1	4	13
2	0	MALE	Desenli kapüşonlu sweatshirt	500	1	5	5
\.


--
-- Data for Name: refunds; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.refunds (refund_id, cause, is_online, refund_date, customer_id, order_detail_id) FROM stdin;
\.


--
-- Data for Name: sizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sizes (size_id, size_name) FROM stdin;
1	XS
2	S
3	M
4	L
5	XL
6	XXL
\.


--
-- Data for Name: stocks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stocks (stock_id, count, product_id, size_id) FROM stdin;
1	5	1	1
2	9	1	2
3	8	1	3
4	9	1	4
5	1	1	5
6	2	1	6
7	9	2	1
8	2	2	2
9	5	2	3
10	3	2	4
11	9	2	5
12	7	2	6
\.


--
-- Data for Name: typologies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.typologies (typology_id, gender, typology_name, category_id) FROM stdin;
1	UNISEX	Kaban	1
2	UNISEX	Ceket	1
3	FEMALE	Blazer	1
4	UNISEX	Yelek	1
5	UNISEX	Sweatshirt	1
6	FEMALE	Triko	1
7	UNISEX	Kazak	1
8	FEMALE	Elbise	1
9	UNISEX	Tişört	1
10	UNISEX	Gömlek	1
11	UNISEX	Kargo	1
12	UNISEX	Pantolon	1
13	UNISEX	Jean	1
14	FEMALE	Takım Elbise	1
15	FEMALE	Etek	1
16	FEMALE	Çizme	2
17	UNISEX	Spor Ayakkabı	2
18	FEMALE	Topuklu Ayakkabı	2
19	FEMALE	Düz Ayakkabı	2
20	FEMALE	Topuklu Sandalet	2
21	UNISEX	Sandalet	2
22	FEMALE	Platform	2
23	UNISEX	Çanta	3
24	UNISEX	Bijuteri	3
25	FEMALE	Atkı	3
26	UNISEX	Şapka	3
27	UNISEX	Kemer	3
28	UNISEX	Gözlük	3
29	UNISEX	Çorap	3
30	FEMALE	Saç Aksesuarı	3
31	FEMALE	Parfüm	3
32	UNISEX	Şişme Mont	1
33	UNISEX	Eşofman Takımı	1
34	MALE	Bot	2
35	MALE	Klasik Ayakkabı	2
36	MALE	İç Giyim	3
\.


--
-- Name: admins_admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admins_admin_id_seq', 3, true);


--
-- Name: categories_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_category_id_seq', 3, true);


--
-- Name: colors_color_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.colors_color_id_seq', 12, true);


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customers_customer_id_seq', 99, true);


--
-- Name: discount_codes_discount_code_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discount_codes_discount_code_id_seq', 100, true);


--
-- Name: images_image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.images_image_id_seq', 7, true);


--
-- Name: locations_location_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.locations_location_id_seq', 100, true);


--
-- Name: order_detail_order_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_detail_order_detail_id_seq', 1, false);


--
-- Name: orders_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_order_id_seq', 1, false);


--
-- Name: products_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_product_id_seq', 2, true);


--
-- Name: refunds_refund_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.refunds_refund_id_seq', 1, false);


--
-- Name: stocks_stock_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.stocks_stock_id_seq', 12, true);


--
-- Name: typologies_typology_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.typologies_typology_id_seq', 36, true);


--
-- Name: admins admins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins
    ADD CONSTRAINT admins_pkey PRIMARY KEY (admin_id);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- Name: colors colors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colors
    ADD CONSTRAINT colors_pkey PRIMARY KEY (color_id);


--
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);


--
-- Name: discount_codes discount_codes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discount_codes
    ADD CONSTRAINT discount_codes_pkey PRIMARY KEY (discount_code_id);


--
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT images_pkey PRIMARY KEY (image_id);


--
-- Name: locations locations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (location_id);


--
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (order_detail_id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);


--
-- Name: refunds refunds_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refunds
    ADD CONSTRAINT refunds_pkey PRIMARY KEY (refund_id);


--
-- Name: sizes sizes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sizes
    ADD CONSTRAINT sizes_pkey PRIMARY KEY (size_id);


--
-- Name: stocks stocks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stocks
    ADD CONSTRAINT stocks_pkey PRIMARY KEY (stock_id);


--
-- Name: typologies typologies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typologies
    ADD CONSTRAINT typologies_pkey PRIMARY KEY (typology_id);


--
-- Name: product_sizes fk3bqabm2nc8yyl9to7fo8trak4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_sizes
    ADD CONSTRAINT fk3bqabm2nc8yyl9to7fo8trak4 FOREIGN KEY (size_id) REFERENCES public.sizes(size_id);


--
-- Name: products fk3knlk7kdbiii5hn3jg28vlon9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk3knlk7kdbiii5hn3jg28vlon9 FOREIGN KEY (typology_id) REFERENCES public.typologies(typology_id);


--
-- Name: product_sizes fk4isa0j51hpdn7cx04m831jic4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_sizes
    ADD CONSTRAINT fk4isa0j51hpdn7cx04m831jic4 FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: order_detail fk64s0y27ydsqyr41ovs1kwpkd9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fk64s0y27ydsqyr41ovs1kwpkd9 FOREIGN KEY (size_id) REFERENCES public.sizes(size_id);


--
-- Name: favorites fk6sgu5npe8ug4o42bf9j71x20c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favorites
    ADD CONSTRAINT fk6sgu5npe8ug4o42bf9j71x20c FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: customers fk733e3affsw3lbgmr5ys5mkwvm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT fk733e3affsw3lbgmr5ys5mkwvm FOREIGN KEY (last_location_id) REFERENCES public.locations(location_id);


--
-- Name: refunds fk7y0og2o70syatqx6ackgbw4o3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refunds
    ADD CONSTRAINT fk7y0og2o70syatqx6ackgbw4o3 FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);


--
-- Name: orders fk8xumyehdyhksg6ijsi6ib9mar; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk8xumyehdyhksg6ijsi6ib9mar FOREIGN KEY (location_id) REFERENCES public.locations(location_id);


--
-- Name: order_detail fkc7q42e9tu0hslx6w4wxgomhvn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkc7q42e9tu0hslx6w4wxgomhvn FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: typologies fkd3vc0iqrppyq36jmm5jwp2c5f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typologies
    ADD CONSTRAINT fkd3vc0iqrppyq36jmm5jwp2c5f FOREIGN KEY (category_id) REFERENCES public.categories(category_id);


--
-- Name: baskets fkd9n51h863f9df2m0js5v3slv4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.baskets
    ADD CONSTRAINT fkd9n51h863f9df2m0js5v3slv4 FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);


--
-- Name: products fkebociq5k3b2tkcxh3q5dg4eed; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkebociq5k3b2tkcxh3q5dg4eed FOREIGN KEY (color_id) REFERENCES public.colors(color_id);


--
-- Name: refunds fkel4p0qd3uasj736a8xrrmcvm5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.refunds
    ADD CONSTRAINT fkel4p0qd3uasj736a8xrrmcvm5 FOREIGN KEY (order_detail_id) REFERENCES public.order_detail(order_detail_id);


--
-- Name: orders fkf31jqtsy70cb3p4nqysbv8s2v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkf31jqtsy70cb3p4nqysbv8s2v FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);


--
-- Name: stocks fkff7be959jyco0iukc1dcjj9qm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stocks
    ADD CONSTRAINT fkff7be959jyco0iukc1dcjj9qm FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: images fkghwsjbjo7mg3iufxruvq6iu3q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT fkghwsjbjo7mg3iufxruvq6iu3q FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: stocks fkh5yb2o1gwnxpc7qqd7u54qyjg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stocks
    ADD CONSTRAINT fkh5yb2o1gwnxpc7qqd7u54qyjg FOREIGN KEY (size_id) REFERENCES public.sizes(size_id);


--
-- Name: orders fkhaeicim18wl3ulyubn9u2rsem; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkhaeicim18wl3ulyubn9u2rsem FOREIGN KEY (billing_location_id) REFERENCES public.locations(location_id);


--
-- Name: customer_locations fkhhxqrtg9mub3jgh58j438db9f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_locations
    ADD CONSTRAINT fkhhxqrtg9mub3jgh58j438db9f FOREIGN KEY (location_id) REFERENCES public.locations(location_id);


--
-- Name: favorites fkipk6i6da281si71callklgsbx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favorites
    ADD CONSTRAINT fkipk6i6da281si71callklgsbx FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);


--
-- Name: customer_locations fklae2k6ae2a8y5tfvh2duq3jg6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_locations
    ADD CONSTRAINT fklae2k6ae2a8y5tfvh2duq3jg6 FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);


--
-- Name: products fkog2rp4qthbtt2lfyhfo32lsw9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id) REFERENCES public.categories(category_id);


--
-- Name: orders fkoy0b1l8aagkyus4cbrb4f3vj0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkoy0b1l8aagkyus4cbrb4f3vj0 FOREIGN KEY (discount_code_id) REFERENCES public.discount_codes(discount_code_id);


--
-- Name: baskets fkpj8ae6deicwsnvyj3cl254l3t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.baskets
    ADD CONSTRAINT fkpj8ae6deicwsnvyj3cl254l3t FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: order_detail fkrws2q0si6oyd6il8gqe2aennc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkrws2q0si6oyd6il8gqe2aennc FOREIGN KEY (order_id) REFERENCES public.orders(order_id);


--
-- PostgreSQL database dump complete
--

