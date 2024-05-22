CREATE TABLE category
(
    id            BIGINT NOT NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    create_by     VARCHAR(255) NULL,
    modified_by   VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    user_id        BIGINT NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (user_id)
);

CREATE TABLE jt_mentor
(
    user_id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_ta
(
    user_id        BIGINT NOT NULL,
    no_of_sessions INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    user_id  BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (user_id)
);

CREATE TABLE msc_instructor
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    no_of_sessions INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE new_table
(
    id            BIGINT NOT NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    create_by     VARCHAR(255) NULL,
    modified_by   VARCHAR(255) NULL,
    test_column   VARCHAR(255) NULL,
    CONSTRAINT pk_newtable PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT NOT NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    create_by     VARCHAR(255) NULL,
    modified_by   VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    user_id        BIGINT NOT NULL,
    dtype          VARCHAR(31) NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    no_of_sessions INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (user_id)
);

CREATE TABLE tc_instructor
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tc_instructor PRIMARY KEY (id)
);

CREATE TABLE tc_mentor
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tc_mentor PRIMARY KEY (id)
);

CREATE TABLE tc_ta
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    no_of_sessions INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tc_ta PRIMARY KEY (id)
);

CREATE TABLE tc_user
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (user_id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (user_id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (user_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);