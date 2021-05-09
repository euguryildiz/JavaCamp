-- Database: Hrms

-- DROP DATABASE "Hrms";

CREATE DATABASE "Hrms"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Turkish_Turkey.1254'
    LC_CTYPE = 'Turkish_Turkey.1254'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

    

    -- Table: public.candidates

-- DROP TABLE public.candidates;

CREATE TABLE public.candidates
(
    user_id integer NOT NULL,
    first_name character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    national_identity character varying(11)[] COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.candidates
    OWNER to postgres;

GRANT ALL ON TABLE public.candidates TO postgres;


-- Table: public.companies

-- DROP TABLE public.companies;

CREATE TABLE public.companies
(
    user_id integer NOT NULL,
    company_name character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    company_web character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(11)[] COLLATE pg_catalog."default" NOT NULL,
    activation_code character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    is_active boolean NOT NULL,
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.companies
    OWNER to postgres;

GRANT ALL ON TABLE public.companies TO postgres;


-- Table: public.employees

-- DROP TABLE public.employees;

CREATE TABLE public.employees
(
    user_id integer NOT NULL,
    first_name character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    national_identity character varying(11)[] COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.employees
    OWNER to postgres;

GRANT ALL ON TABLE public.employees TO postgres;


-- Table: public.job_positions

-- DROP TABLE public.job_positions;

CREATE TABLE public.job_positions
(
    id integer NOT NULL,
    job_name character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT job_positions_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.job_positions
    OWNER to postgres;

GRANT ALL ON TABLE public.job_positions TO postgres;


-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id integer NOT NULL,
    email character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    password character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

GRANT ALL ON TABLE public.users TO postgres;