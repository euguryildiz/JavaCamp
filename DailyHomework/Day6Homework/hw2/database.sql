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

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_users_id PRIMARY KEY (id),
    CONSTRAINT uc_users_email UNIQUE (email)
)

TABLESPACE pg_default;

-- Table: public.employers

-- DROP TABLE public.employers;

CREATE TABLE public.employers
(
    id integer NOT NULL,
    company_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    web_address character varying(50) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(12) COLLATE pg_catalog."default" NOT NULL,
    is_activated boolean NOT NULL DEFAULT false,
    CONSTRAINT pk_employers_id PRIMARY KEY (id),
    CONSTRAINT fk_employers_users FOREIGN KEY (id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;


-- Table: public.employees

-- DROP TABLE public.employees;

CREATE TABLE public.employees
(
    id integer NOT NULL,
    first_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    national_identity character varying(11)[] COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT pk_employees_id PRIMARY KEY (id),
    CONSTRAINT fk_employees_users FOREIGN KEY (id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;


-- Table: public.candidates

-- DROP TABLE public.candidates;

CREATE TABLE public.candidates
(
    id integer NOT NULL,
    first_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    identity_number character varying(11) COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT pk_candidate_id PRIMARY KEY (id),
    CONSTRAINT uc_candidates_identity_number UNIQUE (identity_number),
    CONSTRAINT fk_candidates_users FOREIGN KEY (id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;


-- Table: public.activation_codes

-- DROP TABLE public.activation_codes;

CREATE TABLE public.activation_codes
(
    id integer NOT NULL DEFAULT nextval('activation_codes_id_seq'::regclass),
    activation_code character varying(38) COLLATE pg_catalog."default" NOT NULL,
    is_confirmed boolean NOT NULL,
    confirmed_date date NOT NULL,
    CONSTRAINT pk_activation_codes PRIMARY KEY (id),
    CONSTRAINT uc_activation_codes UNIQUE (activation_code),
    CONSTRAINT fk_activation_codes_activation_code_candidates FOREIGN KEY (id)
        REFERENCES public.activation_code_to_candidates (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_activation_codes_activation_code_employers FOREIGN KEY (id)
        REFERENCES public.activation_code_to_employers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;


-- Table: public.activation_code_to_candidates

-- DROP TABLE public.activation_code_to_candidates;

CREATE TABLE public.activation_code_to_candidates
(
    id integer NOT NULL,
    candidate_id integer NOT NULL,
    CONSTRAINT pk_activation_code_candidates PRIMARY KEY (id),
    CONSTRAINT fk_activation_code_candidates_candidates FOREIGN KEY (candidate_id)
        REFERENCES public.candidates (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

-- Table: public.activation_code_to_employers

-- DROP TABLE public.activation_code_to_employers;

CREATE TABLE public.activation_code_to_employers
(
    id integer NOT NULL,
    employer_id integer NOT NULL,
    CONSTRAINT pk_activation_code_employers PRIMARY KEY (id),
    CONSTRAINT fk_activation_code_employers_employers FOREIGN KEY (employer_id)
        REFERENCES public.employers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

-- Table: public.employer_activation_by_employees

-- DROP TABLE public.employer_activation_by_employees;

CREATE TABLE public.employer_activation_by_employees
(
    id integer NOT NULL DEFAULT nextval('employer_activation_by_employees_id_seq'::regclass),
    employer_id integer NOT NULL,
    confirmed_employee_id integer,
    is_confirmed boolean NOT NULL DEFAULT false,
    confirmed_date date,
    CONSTRAINT pk_employeractivationemployees_id PRIMARY KEY (id),
    CONSTRAINT fk_employer_activation_employees_employees FOREIGN KEY (confirmed_employee_id)
        REFERENCES public.employees (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_employer_activation_employees_employers FOREIGN KEY (employer_id)
        REFERENCES public.employers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

-- Table: public.job_titles

-- DROP TABLE public.job_titles;

CREATE TABLE public.job_titles
(
    id integer NOT NULL DEFAULT nextval('job_titles_id_seq'::regclass),
    title character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_job_titles_id PRIMARY KEY (id),
    CONSTRAINT uc_job_titles_title UNIQUE (title)
)

TABLESPACE pg_default;


