--------------------------------------------------------
--  File created - Wednesday-November-30-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ACCOUNT
--------------------------------------------------------

  CREATE TABLE "VKU"."ACCOUNT" 
   (	"ACC_ID" NUMBER, 
	"BALANCE" FLOAT(126), 
	"CUST_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table AUCTION
--------------------------------------------------------

  CREATE TABLE "VKU"."AUCTION" 
   (	"ITEM_ID" NUMBER(*,0), 
	"OFFER" NUMBER, 
	"OFFERED_BY" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "VKU"."CUSTOMER" 
   (	"CUST_ID" NUMBER, 
	"CUST_NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table INVENTORY
--------------------------------------------------------

  CREATE TABLE "VKU"."INVENTORY" 
   (	"ITEM_ID" NUMBER(*,0), 
	"MAKE" VARCHAR2(15 BYTE), 
	"MODEL" VARCHAR2(15 BYTE), 
	"TRIM" VARCHAR2(15 BYTE), 
	"YEAR" NUMBER(4,0), 
	"COLOR" VARCHAR2(15 BYTE), 
	"COST" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into VKU.ACCOUNT
SET DEFINE OFF;
Insert into VKU.ACCOUNT (ACC_ID,BALANCE,CUST_ID) values (1,132.4,3);
Insert into VKU.ACCOUNT (ACC_ID,BALANCE,CUST_ID) values (2,234.5,1);
Insert into VKU.ACCOUNT (ACC_ID,BALANCE,CUST_ID) values (3,356.47,2);
Insert into VKU.ACCOUNT (ACC_ID,BALANCE,CUST_ID) values (4,459.87,1);
REM INSERTING into VKU.AUCTION
SET DEFINE OFF;
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (1,26000,'Tom');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (1,23000,'MAX');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (2,48000,'Bob');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (2,44000,'Tom');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (2,40000,'Liz');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (3,19000,'Ryan');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (7,26000,'Ryan');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (7,29000,'Max');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (7,33000,'Liz');
Insert into VKU.AUCTION (ITEM_ID,OFFER,OFFERED_BY) values (7,36000,'Tom');
REM INSERTING into VKU.CUSTOMER
SET DEFINE OFF;
Insert into VKU.CUSTOMER (CUST_ID,CUST_NAME) values (1,'Vaibhaw');
Insert into VKU.CUSTOMER (CUST_ID,CUST_NAME) values (2,'Rahul');
Insert into VKU.CUSTOMER (CUST_ID,CUST_NAME) values (3,'Shreya');
REM INSERTING into VKU.INVENTORY
SET DEFINE OFF;
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (1,'HONDA','ACCORD','EXL',2012,'BLACK',25000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (2,'BMW','X5','3.0',2011,'SILVER',45000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (3,'HONDA','ACCORD','LX',2012,'WHITE',20000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (4,'HONDA','CRV','LX',2010,'BLACK',19000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (5,'TOYOTA','CAMRY','EX',2011,'WHITE',22000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (6,'HONDA','ACCORD','EXL',2011,'SILVER',24000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (7,'BMW','X3','3.0',2012,'SILVER',35000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (8,'HONDA','ACCORD','LX',2011,'BLACK',19000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (9,'BMW','X3','3.0',2011,'SILVER',34000);
Insert into VKU.INVENTORY (ITEM_ID,MAKE,MODEL,TRIM,YEAR,COLOR,COST) values (10,'HONDA','CRV','LX',2011,'WHITE',20000);
--------------------------------------------------------
--  DDL for Index CUSTOMER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VKU"."CUSTOMER_PK" ON "VKU"."CUSTOMER" ("CUST_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ACCOUNT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VKU"."ACCOUNT_PK" ON "VKU"."ACCOUNT" ("ACC_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "VKU"."CUSTOMER" ADD CONSTRAINT "CUSTOMER_PK" PRIMARY KEY ("CUST_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VKU"."CUSTOMER" MODIFY ("CUST_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AUCTION
--------------------------------------------------------

  ALTER TABLE "VKU"."AUCTION" MODIFY ("ITEM_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table INVENTORY
--------------------------------------------------------

  ALTER TABLE "VKU"."INVENTORY" ADD PRIMARY KEY ("ITEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ACCOUNT
--------------------------------------------------------

  ALTER TABLE "VKU"."ACCOUNT" ADD CONSTRAINT "ACCOUNT_PK" PRIMARY KEY ("ACC_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VKU"."ACCOUNT" MODIFY ("CUST_ID" NOT NULL ENABLE);
  ALTER TABLE "VKU"."ACCOUNT" MODIFY ("BALANCE" NOT NULL ENABLE);
  ALTER TABLE "VKU"."ACCOUNT" MODIFY ("ACC_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table AUCTION
--------------------------------------------------------

  ALTER TABLE "VKU"."AUCTION" ADD CONSTRAINT "AUCTION_FK1" FOREIGN KEY ("ITEM_ID")
	  REFERENCES "VKU"."INVENTORY" ("ITEM_ID") ON DELETE CASCADE ENABLE;
