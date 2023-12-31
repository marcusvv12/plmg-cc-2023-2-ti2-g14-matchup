PGDMP     *                
    {            matchup    15.4    15.4 8    7           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            8           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            9           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            :           1262    16499    matchup    DATABASE     ~   CREATE DATABASE matchup WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE matchup;
                postgres    false            �            1259    16582 	   bloqueios    TABLE     |   CREATE TABLE public.bloqueios (
    id integer NOT NULL,
    idusuariobloqueador integer,
    idusuariobloqueado integer
);
    DROP TABLE public.bloqueios;
       public         heap    postgres    false            �            1259    16581    bloqueios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bloqueios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.bloqueios_id_seq;
       public          postgres    false    225            ;           0    0    bloqueios_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.bloqueios_id_seq OWNED BY public.bloqueios.id;
          public          postgres    false    224            �            1259    16541    correspondencias    TABLE     �   CREATE TABLE public.correspondencias (
    id integer NOT NULL,
    idusuario1 integer,
    idusuario2 integer,
    datacorrespondencia timestamp without time zone,
    match integer
);
 $   DROP TABLE public.correspondencias;
       public         heap    postgres    false            �            1259    16540    correspondencias_id_seq    SEQUENCE     �   CREATE SEQUENCE public.correspondencias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.correspondencias_id_seq;
       public          postgres    false    221            <           0    0    correspondencias_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.correspondencias_id_seq OWNED BY public.correspondencias.id;
          public          postgres    false    220            �            1259    16527    fotos    TABLE     �   CREATE TABLE public.fotos (
    id integer NOT NULL,
    idusuario integer,
    urldafoto character varying(255),
    legenda text,
    datadeupload timestamp without time zone
);
    DROP TABLE public.fotos;
       public         heap    postgres    false            �            1259    16526    fotos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.fotos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.fotos_id_seq;
       public          postgres    false    219            =           0    0    fotos_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.fotos_id_seq OWNED BY public.fotos.id;
          public          postgres    false    218            �            1259    16558 	   mensagens    TABLE     �   CREATE TABLE public.mensagens (
    id integer NOT NULL,
    idcorrespondencia integer,
    idremetente integer,
    iddestinatario integer,
    conteudomensagem text,
    datahoramensagem timestamp without time zone
);
    DROP TABLE public.mensagens;
       public         heap    postgres    false            �            1259    16557    mensagens_id_seq    SEQUENCE     �   CREATE SEQUENCE public.mensagens_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.mensagens_id_seq;
       public          postgres    false    223            >           0    0    mensagens_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.mensagens_id_seq OWNED BY public.mensagens.id;
          public          postgres    false    222            �            1259    16513    perfis    TABLE     �   CREATE TABLE public.perfis (
    id integer NOT NULL,
    idusuario integer,
    descricaodoperfil text,
    estilodejogo character varying(50),
    jogospreferidos text,
    disponibilidade character varying(255),
    estatisticasatividade integer
);
    DROP TABLE public.perfis;
       public         heap    postgres    false            �            1259    16512    perfis_id_seq    SEQUENCE     �   CREATE SEQUENCE public.perfis_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.perfis_id_seq;
       public          postgres    false    217            ?           0    0    perfis_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.perfis_id_seq OWNED BY public.perfis.id;
          public          postgres    false    216            �            1259    16501    users    TABLE     �  CREATE TABLE public.users (
    id integer NOT NULL,
    nome character varying(255),
    genero character varying(10),
    email character varying(255),
    senha character varying(255),
    fotodeperfil character varying(255),
    biografia character varying(255),
    plataformas character varying(50),
    telefone character(14),
    jogos character varying(255),
    datanasc date
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16500    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    215            @           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    214            �           2604    16585    bloqueios id    DEFAULT     l   ALTER TABLE ONLY public.bloqueios ALTER COLUMN id SET DEFAULT nextval('public.bloqueios_id_seq'::regclass);
 ;   ALTER TABLE public.bloqueios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            �           2604    16544    correspondencias id    DEFAULT     z   ALTER TABLE ONLY public.correspondencias ALTER COLUMN id SET DEFAULT nextval('public.correspondencias_id_seq'::regclass);
 B   ALTER TABLE public.correspondencias ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    16530    fotos id    DEFAULT     d   ALTER TABLE ONLY public.fotos ALTER COLUMN id SET DEFAULT nextval('public.fotos_id_seq'::regclass);
 7   ALTER TABLE public.fotos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    16561    mensagens id    DEFAULT     l   ALTER TABLE ONLY public.mensagens ALTER COLUMN id SET DEFAULT nextval('public.mensagens_id_seq'::regclass);
 ;   ALTER TABLE public.mensagens ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223                       2604    16516 	   perfis id    DEFAULT     f   ALTER TABLE ONLY public.perfis ALTER COLUMN id SET DEFAULT nextval('public.perfis_id_seq'::regclass);
 8   ALTER TABLE public.perfis ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            ~           2604    16504    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            4          0    16582 	   bloqueios 
   TABLE DATA           P   COPY public.bloqueios (id, idusuariobloqueador, idusuariobloqueado) FROM stdin;
    public          postgres    false    225   VB       0          0    16541    correspondencias 
   TABLE DATA           b   COPY public.correspondencias (id, idusuario1, idusuario2, datacorrespondencia, match) FROM stdin;
    public          postgres    false    221   sB       .          0    16527    fotos 
   TABLE DATA           P   COPY public.fotos (id, idusuario, urldafoto, legenda, datadeupload) FROM stdin;
    public          postgres    false    219   !C       2          0    16558 	   mensagens 
   TABLE DATA           {   COPY public.mensagens (id, idcorrespondencia, idremetente, iddestinatario, conteudomensagem, datahoramensagem) FROM stdin;
    public          postgres    false    223   >C       ,          0    16513    perfis 
   TABLE DATA           �   COPY public.perfis (id, idusuario, descricaodoperfil, estilodejogo, jogospreferidos, disponibilidade, estatisticasatividade) FROM stdin;
    public          postgres    false    217   [C       *          0    16501    users 
   TABLE DATA           �   COPY public.users (id, nome, genero, email, senha, fotodeperfil, biografia, plataformas, telefone, jogos, datanasc) FROM stdin;
    public          postgres    false    215   xC       A           0    0    bloqueios_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.bloqueios_id_seq', 1, false);
          public          postgres    false    224            B           0    0    correspondencias_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.correspondencias_id_seq', 103, true);
          public          postgres    false    220            C           0    0    fotos_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.fotos_id_seq', 1, false);
          public          postgres    false    218            D           0    0    mensagens_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.mensagens_id_seq', 1, false);
          public          postgres    false    222            E           0    0    perfis_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.perfis_id_seq', 1, false);
          public          postgres    false    216            F           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 25, true);
          public          postgres    false    214            �           2606    16587    bloqueios bloqueios_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.bloqueios
    ADD CONSTRAINT bloqueios_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.bloqueios DROP CONSTRAINT bloqueios_pkey;
       public            postgres    false    225            �           2606    16546 &   correspondencias correspondencias_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.correspondencias
    ADD CONSTRAINT correspondencias_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.correspondencias DROP CONSTRAINT correspondencias_pkey;
       public            postgres    false    221            �           2606    16534    fotos fotos_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.fotos
    ADD CONSTRAINT fotos_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.fotos DROP CONSTRAINT fotos_pkey;
       public            postgres    false    219            �           2606    16565    mensagens mensagens_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.mensagens
    ADD CONSTRAINT mensagens_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_pkey;
       public            postgres    false    223            �           2606    16520    perfis perfis_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.perfis
    ADD CONSTRAINT perfis_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.perfis DROP CONSTRAINT perfis_pkey;
       public            postgres    false    217            �           2606    16511    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    215            �           2606    16509    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    215            �           2606    16593 +   bloqueios bloqueios_idusuariobloqueado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.bloqueios
    ADD CONSTRAINT bloqueios_idusuariobloqueado_fkey FOREIGN KEY (idusuariobloqueado) REFERENCES public.users(id);
 U   ALTER TABLE ONLY public.bloqueios DROP CONSTRAINT bloqueios_idusuariobloqueado_fkey;
       public          postgres    false    225    215    3207            �           2606    16588 ,   bloqueios bloqueios_idusuariobloqueador_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.bloqueios
    ADD CONSTRAINT bloqueios_idusuariobloqueador_fkey FOREIGN KEY (idusuariobloqueador) REFERENCES public.users(id);
 V   ALTER TABLE ONLY public.bloqueios DROP CONSTRAINT bloqueios_idusuariobloqueador_fkey;
       public          postgres    false    215    3207    225            �           2606    16547 1   correspondencias correspondencias_idusuario1_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.correspondencias
    ADD CONSTRAINT correspondencias_idusuario1_fkey FOREIGN KEY (idusuario1) REFERENCES public.users(id);
 [   ALTER TABLE ONLY public.correspondencias DROP CONSTRAINT correspondencias_idusuario1_fkey;
       public          postgres    false    221    215    3207            �           2606    16552 1   correspondencias correspondencias_idusuario2_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.correspondencias
    ADD CONSTRAINT correspondencias_idusuario2_fkey FOREIGN KEY (idusuario2) REFERENCES public.users(id);
 [   ALTER TABLE ONLY public.correspondencias DROP CONSTRAINT correspondencias_idusuario2_fkey;
       public          postgres    false    3207    215    221            �           2606    16535    fotos fotos_idusuario_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.fotos
    ADD CONSTRAINT fotos_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.fotos DROP CONSTRAINT fotos_idusuario_fkey;
       public          postgres    false    3207    219    215            �           2606    16566 *   mensagens mensagens_idcorrespondencia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.mensagens
    ADD CONSTRAINT mensagens_idcorrespondencia_fkey FOREIGN KEY (idcorrespondencia) REFERENCES public.correspondencias(id);
 T   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_idcorrespondencia_fkey;
       public          postgres    false    3213    223    221            �           2606    16576 '   mensagens mensagens_iddestinatario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.mensagens
    ADD CONSTRAINT mensagens_iddestinatario_fkey FOREIGN KEY (iddestinatario) REFERENCES public.users(id);
 Q   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_iddestinatario_fkey;
       public          postgres    false    3207    223    215            �           2606    16571 $   mensagens mensagens_idremetente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.mensagens
    ADD CONSTRAINT mensagens_idremetente_fkey FOREIGN KEY (idremetente) REFERENCES public.users(id);
 N   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_idremetente_fkey;
       public          postgres    false    3207    223    215            �           2606    16521    perfis perfis_idusuario_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.perfis
    ADD CONSTRAINT perfis_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.users(id);
 F   ALTER TABLE ONLY public.perfis DROP CONSTRAINT perfis_idusuario_fkey;
       public          postgres    false    3207    215    217            4      x������ � �      0   �   x�E���0E�5*&�M��_G³@;���E��$�T����e$v�$^�L�WB���+�)�SJ#�+�Q���=�m;v92�.�}��RI�K���ҿ�W�q�PHmRX��(9^R��p�u�ϣ�zj����+�)���0#_��/��%n�>ϧ���qPD      .      x������ � �      2      x������ � �      ,      x������ � �      *   0  x����n�6���S�bC��ykցw�M���X�^���fK�.)�ݼM�C�=��bRvb�ۃ�.`�"Eg~�y]�~=X�ڴ袛�p�G_�ZPz&M�P�E��4���s)�u����T��>ޞb�f���~3��8&M�F�jCO�a�k/��w6��zF+��Ҩ�a?Ƞ`ܸ1]St4kk��Kz�[�zd?��ΰ���Y�q)C�qY4�Uœy��c,jT��52J�O�d�^D��@6ޛڪ��?cGP�e-D\�P6&���e5O
9�Rx({s� �g��8܂��{�/�^8��@�)mP?s�`�n,�E::��ִ;��h�z�`���Ϫ�k�,�,�'�yg~��t��;Z�=�""]�)O&�����'�~G4�8!��fF��A���V�1�Y-s,*����c5�{���y�/V�%� �^C��	�Y��0�P�w� ���|����u��<����^EKʰ�
5�h��|�����L�q��BV%�B֐I���=zCW���2pm6$���9����|�Dn��Vu�N"L}��{��l}�K
��)O� y O,�@ۣe(!�)x���e���P�L7<����|�j��3 ���;%��k�� �>�ߍ5+-8֣ƭrjk눬������R���%AP�T��Hxu�#�0u�J��{��ݟ[ʋ"�voI�`T�
�PԘ�Ԥ�oT��*�r����Goj�� �6�\�V�P��F��!�U{&��C=��jߘ_p�v�F��'���4���>X�ѳ4w�&ڍqʯ�7��ݣUp����>�*b�T������tIhE�{K�M�$�g!�P�=3b��i���'�<�:�w�g)��4��~&�<"����K�wO���xr�hʔ�Y)�
��D��iC�N��YY����`�>C{�=vk�xɨ-:JBtA39Xg�~j�GG=��`A�zz��՜u�|(���}�(c��'�!��T/Ux
5���w���/�r�K��?	&�;G�T�C�	���㣹�����q}�9��e)��G�S�m>�8�L&2�3]     