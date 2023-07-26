------------------------------------------------------------
-- UTILISATEURS
------------------------------------------------------------

INSERT INTO cda.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) VALUES
(101,'admin','admin@admin.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');

INSERT INTO cda.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) VALUES
(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'client','client@client.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');

INSERT INTO cda.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) VALUES
(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'client2','client2@client.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');

INSERT INTO cda.t_utilisateur_utl (utl_id,utl_mot_de_passe,utl_adresse_email,utl_created_at,utl_updated_at) VALUES
(nextval('cda.T_UTILISATEUR_UTL_UTL_ID_SEQ'),'client3','client3@client.com','2021-01-05 12:00:00.000','2021-01-05 12:00:00.000');

------------------------------------------------------------
-- FILMS
------------------------------------------------------------

insert into cda.T_FILM_FLM values(nextval('cda.t_film_flm_flm_id_seq'), 'titre film 1', 'description 1', '1h 30 min', 'src/image','yoda');

insert into cda.T_FILM_FLM values(nextval('cda.t_film_flm_flm_id_seq'), 'Avatar', 'description 1', '120min', 'avatar.jpg','yoda');
insert into cda.T_FILM_FLM values(nextval('cda.t_film_flm_flm_id_seq'), 'La cité de Dieu', 'description 2', '220min', 'la-cite-de-dieu.jpg','yoda');
insert into cda.T_FILM_FLM values(nextval('cda.t_film_flm_flm_id_seq'), 'Avengers: Endgames', 'description 3', '300min', 'avengers.jpg','yoda');
insert into cda.T_FILM_FLM values(nextval('cda.t_film_flm_flm_id_seq'), 'Star wars: Epsiode 2', 'description 4', '145min', 'star-wars.jpg','yoda');
insert into cda.T_FILM_FLM values(nextval('cda.t_film_flm_flm_id_seq'), 'Interstellar', 'description 5', '260min', 'interstellar.jpg','yoda');


------------------------------------------------------------
-- FILMS FAVORIS PAR UTILISATEUR
------------------------------------------------------------

insert into cda.t_utilisateur_film_association values(101,102), (102,101), (101, 101), (101, 100), (101, 101), (102, 103);