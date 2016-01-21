;             
CREATE USER IF NOT EXISTS ADMIN SALT 'eeb4636e13c11c5c' HASH '3d05e01c59aa9419af4a990e3f161c7b35b28a25bf7df18ddcb1335721a6dde8' ADMIN;        
CREATE SCHEMA IF NOT EXISTS GAME AUTHORIZATION ADMIN;         
CREATE SEQUENCE GAME.SYSTEM_SEQUENCE_2BDA90BB_FF29_4ECD_B230_B81CF4A6AAEF START WITH 1 BELONGS_TO_TABLE;      
CREATE SEQUENCE GAME.SYSTEM_SEQUENCE_4F54E570_E015_411A_9484_CBEDA64FF545 START WITH 1 BELONGS_TO_TABLE;      
CREATE SEQUENCE GAME.SYSTEM_SEQUENCE_A9F7DDE7_12EA_4678_BC1F_0D6A3F7121A2 START WITH 1 BELONGS_TO_TABLE;      
CREATE MEMORY TABLE GAME.WEAPON_TYPES(
    WEAPON_TYPE_ID INT DEFAULT (NEXT VALUE FOR GAME.SYSTEM_SEQUENCE_A9F7DDE7_12EA_4678_BC1F_0D6A3F7121A2) NOT NULL NULL_TO_DEFAULT SEQUENCE GAME.SYSTEM_SEQUENCE_A9F7DDE7_12EA_4678_BC1F_0D6A3F7121A2,
    WEAPON_TYPE_NAME VARCHAR(45)
);          
ALTER TABLE GAME.WEAPON_TYPES ADD CONSTRAINT GAME.CONSTRAINT_E PRIMARY KEY(WEAPON_TYPE_ID);   
-- 0 +/- SELECT COUNT(*) FROM GAME.WEAPON_TYPES;              
CREATE MEMORY TABLE GAME.WEAPON(
    WEAPON_ID INT DEFAULT (NEXT VALUE FOR GAME.SYSTEM_SEQUENCE_4F54E570_E015_411A_9484_CBEDA64FF545) NOT NULL NULL_TO_DEFAULT SEQUENCE GAME.SYSTEM_SEQUENCE_4F54E570_E015_411A_9484_CBEDA64FF545,
    NAME VARCHAR(45) NOT NULL,
    DAMAGE_MINIMAL INT NOT NULL,
    DAMAGE_MAXIMAL INT NOT NULL,
    STR_B INT,
    AGI_B INT,
    INT_B INT,
    WEAPON_TYPE INT
);              
ALTER TABLE GAME.WEAPON ADD CONSTRAINT GAME.CONSTRAINT_9 PRIMARY KEY(WEAPON_ID);              
-- 0 +/- SELECT COUNT(*) FROM GAME.WEAPON;    
CREATE INDEX GAME.WEAPONTYPEDICT_IDX ON GAME.WEAPON(WEAPON_TYPE);             
CREATE MEMORY TABLE GAME.ARMOR_TYPES(
    ARMOR_TYPE_ID INT NOT NULL,
    ARMOR_TYPE_NAME VARCHAR(45) NOT NULL
);          
ALTER TABLE GAME.ARMOR_TYPES ADD CONSTRAINT GAME.CONSTRAINT_4 PRIMARY KEY(ARMOR_TYPE_ID);     
-- 0 +/- SELECT COUNT(*) FROM GAME.ARMOR_TYPES;               
CREATE MEMORY TABLE GAME.ARMOR(
    ARMOR_ID INT DEFAULT (NEXT VALUE FOR GAME.SYSTEM_SEQUENCE_2BDA90BB_FF29_4ECD_B230_B81CF4A6AAEF) NOT NULL NULL_TO_DEFAULT SEQUENCE GAME.SYSTEM_SEQUENCE_2BDA90BB_FF29_4ECD_B230_B81CF4A6AAEF,
    ARMOR_TYPE INT,
    NAME VARCHAR(45),
    STR_B INT,
    INT_B INT,
    AGI_B INT,
    ARMOR_AMOUNT INT
);       
ALTER TABLE GAME.ARMOR ADD CONSTRAINT GAME.CONSTRAINT_3 PRIMARY KEY(ARMOR_ID);
-- 0 +/- SELECT COUNT(*) FROM GAME.ARMOR;     
CREATE INDEX GAME.ARMOR_IDX ON GAME.ARMOR(ARMOR_TYPE);        
ALTER TABLE GAME.ARMOR ADD CONSTRAINT GAME.ARMOR FOREIGN KEY(ARMOR_TYPE) REFERENCES GAME.ARMOR_TYPES(ARMOR_TYPE_ID) NOCHECK;  
ALTER TABLE GAME.WEAPON ADD CONSTRAINT GAME.WEAPONTYPEDICT FOREIGN KEY(WEAPON_TYPE) REFERENCES GAME.WEAPON_TYPES(WEAPON_TYPE_ID) NOCHECK;     
