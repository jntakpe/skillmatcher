-- Compétences
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'JavaEE');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Javascript');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'AngularJS');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Spring');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Hibernate');

-- Questions
INSERT INTO question(id, enonce, difficulte) VALUES (nextval('question_id_seq'), 'Citer trois types primitifs', 'SIMPLE');
INSERT INTO question(id, enonce, difficulte) VALUES (nextval('question_id_seq'), 'Différences entre == et equals', 'SIMPLE');