
CREATE TABLE IF NOT EXISTS app_user (
	id bigserial NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	mobile_no VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT app_user_unique UNIQUE(email, mobile_no)
)
;

CREATE TABLE IF NOT EXISTS vm_ram
(
    id bigint NOT NULL,
    ram_size character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_ram_pkey PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS vm_os
(
    id bigint NOT NULL,
    os_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_os_pkey PRIMARY KEY (id)
)
;
CREATE TABLE IF NOT EXISTS vm_hard_disk
(
    id bigint NOT NULL,
    hard_disk_size character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_hard_disk_pkey PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS vm_cpu
(
    id bigint NOT NULL,
    cpu_type character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_cpu_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_vm
(
    id bigserial NOT NULL ,
    app_user_id integer NOT NULL references app_user(id) ON DELETE CASCADE,
    vm_os_id integer NOT NULL references vm_os(id),
    vm_ram_id integer NOT NULL references vm_ram(id),
    vm_hard_disk_id integer NOT NULL references vm_hard_disk(id),
    vm_cpu_id integer NOT NULL references vm_cpu(id),
    CONSTRAINT user_vm_pkey PRIMARY KEY (id)
)
;


