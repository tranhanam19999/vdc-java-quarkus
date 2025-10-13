--------------------------------------------------------
--  File created - Friday-October-10-2025   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REF_SWI_SAVINGS_UPDATE_HISTORY
--------------------------------------------------------

  CREATE TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" 
   (	"SWI_CONTRACT_ID" NUMBER, 
	"SWI_CUSTOMER_INTEREST" NUMBER, 
	"SWI_BANK_INTEREST" NUMBER, 
	"SWI_MPESA_INTEREST" NUMBER, 
	"SWI_EVENT_TYPE" VARCHAR2(20), 
	"SWI_DATE" DATE
   ) ;
--------------------------------------------------------
--  Constraints for Table REF_SWI_SAVINGS_UPDATE_HISTORY
--------------------------------------------------------

  ALTER TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" MODIFY ("SWI_CONTRACT_ID" NOT NULL ENABLE);
  ALTER TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" MODIFY ("SWI_CUSTOMER_INTEREST" NOT NULL ENABLE);
  ALTER TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" MODIFY ("SWI_BANK_INTEREST" NOT NULL ENABLE);
  ALTER TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" MODIFY ("SWI_MPESA_INTEREST" NOT NULL ENABLE);
  ALTER TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" MODIFY ("SWI_DATE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table REF_SWI_SAVINGS_UPDATE_HISTORY
--------------------------------------------------------

  ALTER TABLE "ODS"."REF_SWI_SAVINGS_UPDATE_HISTORY" ADD CONSTRAINT "REF_SWI_DAYLY_UPDATE_HISTORY_FK1" FOREIGN KEY ("SWI_CONTRACT_ID")
	  REFERENCES "ODS"."REF_SWI_SAVINGS_CONTRACT" ("SWI_ID") ON DELETE CASCADE ENABLE;
