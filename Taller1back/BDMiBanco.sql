PGDMP         :                y            mibanco    13.2    13.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16571    mibanco    DATABASE     c   CREATE DATABASE mibanco WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE mibanco;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            ?           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            ?            1259    16581    accounts    TABLE     ?   CREATE TABLE public.accounts (
    id character varying NOT NULL,
    amount double precision NOT NULL,
    customerid character varying,
    openedat date NOT NULL
);
    DROP TABLE public.accounts;
       public         heap    postgres    false    3            ?            1259    16573 	   customers    TABLE     ?   CREATE TABLE public.customers (
    id character varying NOT NULL,
    name character varying,
    lastname character varying,
    email character varying
);
    DROP TABLE public.customers;
       public         heap    postgres    false    3            ?            1259    49365    transactions    TABLE     ?   CREATE TABLE public.transactions (
    id bigint NOT NULL,
    accountid character varying,
    type character varying,
    amount double precision,
    datetransaction date
);
     DROP TABLE public.transactions;
       public         heap    postgres    false    3            ?          0    16581    accounts 
   TABLE DATA           D   COPY public.accounts (id, amount, customerid, openedat) FROM stdin;
    public          postgres    false    201            ?          0    16573 	   customers 
   TABLE DATA           >   COPY public.customers (id, name, lastname, email) FROM stdin;
    public          postgres    false    200            ?          0    49365    transactions 
   TABLE DATA           T   COPY public.transactions (id, accountid, type, amount, datetransaction) FROM stdin;
    public          postgres    false    202            .           2606    16588    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    201            ,           2606    16580    customers custumers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT custumers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT custumers_pkey;
       public            postgres    false    200            0           2606    49376    transactions transactions_pk 
   CONSTRAINT     Z   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pk PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_pk;
       public            postgres    false    202            ?   @   x?]??? ????΁s?%?ׁ?C|g???)??X???azNX?????cQ?v??f???7??+      ?   W   x?34?4?L?I?J????K???1?uH?/*J??K???24????)?,V??/???)A???t?K)J-????+ɯL?L?EV???? ??!O      ?   x   x???A
?0???/?????/^Bp%?Y???>???u 8{?KS??P?S?r?MJm?O?qW?=?Gv?)??{??????V()???"?GFE??C?&?&?8?g2??e??&??L?_M??9wǽu          ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16571    mibanco    DATABASE     c   CREATE DATABASE mibanco WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE mibanco;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            ?           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            ?            1259    16581    accounts    TABLE     ?   CREATE TABLE public.accounts (
    id character varying NOT NULL,
    amount double precision NOT NULL,
    customerid character varying,
    openedat date NOT NULL
);
    DROP TABLE public.accounts;
       public         heap    postgres    false    3            ?            1259    16573 	   customers    TABLE     ?   CREATE TABLE public.customers (
    id character varying NOT NULL,
    name character varying,
    lastname character varying,
    email character varying
);
    DROP TABLE public.customers;
       public         heap    postgres    false    3            ?            1259    49365    transactions    TABLE     ?   CREATE TABLE public.transactions (
    id bigint NOT NULL,
    accountid character varying,
    type character varying,
    amount double precision,
    datetransaction date
);
     DROP TABLE public.transactions;
       public         heap    postgres    false    3            ?          0    16581    accounts 
   TABLE DATA           D   COPY public.accounts (id, amount, customerid, openedat) FROM stdin;
    public          postgres    false    201   ?       ?          0    16573 	   customers 
   TABLE DATA           >   COPY public.customers (id, name, lastname, email) FROM stdin;
    public          postgres    false    200   J        ?          0    49365    transactions 
   TABLE DATA           T   COPY public.transactions (id, accountid, type, amount, datetransaction) FROM stdin;
    public          postgres    false    202   a        .           2606    16588    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    201            ,           2606    16580    customers custumers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT custumers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT custumers_pkey;
       public            postgres    false    200            0           2606    49376    transactions transactions_pk 
   CONSTRAINT     Z   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pk PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_pk;
       public            postgres    false    202           