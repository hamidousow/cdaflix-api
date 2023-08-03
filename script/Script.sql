------------------------------------------------------------
-- INIT DB
------------------------------------------------------------
DROP SCHEMA IF EXISTS cdaflix CASCADE;
DROP DATABASE IF EXISTS cdaflix;
CREATE DATABASE IF NOT EXISTS cdaflix;
CREATE SCHEMA IF NOT EXISTS cdaflix;
------------------------------------------------------------
-- ID SEQUENCE
------------------------------------------------------------
-- CREATE SEQUENCE cdaflix.UTL_ID_SEQ_GEN increment 1 start 100;
-- CREATE SEQUENCE cdaflix.FLM_ID_SEQ_GEN increment 1 start 100;
-- CREATE SEQUENCE cdaflix.FAV_ID_SEQ_GEN increment 1 start 100;

------------------------------------------------------------
-- TABLES
------------------------------------------------------------
CREATE TABLE cdaflix.T_UTILISATEUR_UTL(
	   UTL_ID SERIAL PRIMARY KEY ,
	   UTL_MOT_DE_PASSE VARCHAR(50) NOT NULL ,
	   UTL_ADRESSE_EMAIL VARCHAR(50) NOT NULL  ,
	   UTL_CREATED_AT TIMESTAMP  NOT NULL ,
	   UTL_UPDATED_AT TIMESTAMP  NOT NULL ,
		FAV_ID INT NOT NULL
);


CREATE TABLE cdaflix.T_FILM_FLM(
   FLM_ID SERIAL PRIMARY KEY ,
   FLM_TITRE VARCHAR(50) NOT NULL ,
   FLM_DESCRIPTION VARCHAR(50) NOT NULL ,
   FLM_DUREE INTERVAL  NOT NULL ,
   FLM_IMG VARCHAR(150)  NOT NULL   ,
   FLM_ACTORS VARCHAR(250) NOT null
);

CREATE TABLE cdaflix.T_FAVORIS_FAV(
	FAV_ID SERIAL PRIMARY KEY,
	FAV_ICONE VARCHAR(150),
	UTL_ID INT NOT NULL
)

CREATE TABLE cdaflix.T_FILM_FAVORIS_ASSOCIATION_FFA (
	FLM_ID INT NOT NULL,
	FAV_ID INT NOT NULL,
	PRIMARY KEY(FLM_ID, FAV_ID)
)
------------------------------------------------------------
-- ALTER
------------------------------------------------------------
-- ALTER SEQUENCE cdaflix.flm_id_seq_gen OWNED BY cdaflix.t_film_flm.flm_ID;
-- ALTER SEQUENCE cdaflix.UTL_ID_SEQ_GEN OWNED BY cdaflix.T_UTILISATEUR_UTL.UTL_ID;
-- ALTER SEQUENCE cdaflix.FLM_ID_SEQ_GEN OWNED BY cdaflix.T_FILM_FLM.FLM_ID;
ALTER TABLE cdaflix.t_film_favoris_association_ffa
ADD CONSTRAINT fk_flm_id
FOREIGN KEY (FLM_ID)
REFERENCES cdaflix.t_film_flm(flm_id)

ALTER TABLE cdaflix.t_film_favoris_association_ffa
ADD CONSTRAINT fk_fav_id
FOREIGN KEY (FAV_ID)
REFERENCES cdaflix.t_favoris_fav(fav_id)

alter table cdaflix.t_film_flm
drop column FLM_DUREE

alter table cdaflix.t_film_flm
add column FLM_DUREE timestamp not null

SELECT column_name, data_type FROM information_schema.columns
WHERE table_name = 't_film_flm' AND column_name = 'flm_duree';

------------------------------------------------------------
-- INSERT DATA
------------------------------------------------------------
INSERT INTO cdaflix.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) 
VALUES(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'admin','admin@admin.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');
INSERT INTO cdaflix.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) 
VALUES(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'client','client@client.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');
INSERT INTO cdaflix.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) 
VALUES(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'client2','client2@client.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');
INSERT INTO cdaflix.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) 
VALUES(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'client3','client3@client.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');

insert into cdaflix.T_FILM_FLM(flm_id, flm_titre, flm_description, flm_duree, flm_img, flm_acteurs)
values(nextval('cda.t_film_flm_flm_id_seq'), 'titre film 1', 'description 1', '1h 30 min', 'src/image','yoda');

insert into cdaflix.t_utilisateur_film_association values(101,102), (102,101), (101, 101), (101, 100), (101, 101), (102, 103);

