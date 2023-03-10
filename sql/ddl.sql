CREATE TABLE "TEST_CUSTOMER"
(
    "ID"          NUMBER(19, 0) NOT NULL ENABLE,
    "ADDRESS"     VARCHAR2(128 CHAR),
    "CARD_NO"     VARCHAR2(128 CHAR),
    "NAME"        VARCHAR2(32 CHAR),
    "PHONE"       VARCHAR2(128 CHAR),
    "CARD_NO_MAC" VARCHAR2(255 CHAR),
    constraint PK_TEST_CUSTOMER PRIMARY KEY ("ID")
);
CREATE UNIQUE INDEX UNI_CUSTOMER_NAME ON TEST_CUSTOMER(NAME);
CREATE UNIQUE INDEX UNI_CUSTOMER_CARD_NO ON TEST_CUSTOMER(CARD_NO);