------------------------------------------------------------
--        Script Postgre
------------------------------------------------------------
DROP SCHEMA IF EXISTS cdaflix CASCADE;
CREATE SCHEMA IF NOT EXISTS cdaflix;

------------------------------------------------------------
-- Table: T_UTILISATEUR_UTL
------------------------------------------------------------
CREATE SEQUENCE cdaflix.T_UTILISATEUR_UTL_UTL_ID_SEQ;
CREATE TABLE cdaflix.T_UTILISATEUR_UTL(
                                           UTL_ID INT  NOT NULL ,
                                           UTL_MOT_DE_PASSE VARCHAR(50) NOT NULL ,
                                           UTL_ADRESSE_EMAIL VARCHAR(50) NOT NULL  ,
                                           UTL_CREATED_AT TIMESTAMP  NOT NULL ,
                                           UTL_UPDATED_AT TIMESTAMP  NOT NULL ,
                                           CONSTRAINT PK_UTL PRIMARY KEY (UTL_ID)
);
ALTER SEQUENCE cdaflix.T_UTILISATEUR_UTL_UTL_ID_SEQ OWNED BY cdaflix.T_UTILISATEUR_UTL.UTL_ID;

