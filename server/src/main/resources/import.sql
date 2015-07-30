-- Compétences
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Java/JavaEE');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Javascript/AngularJS');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'SQL/JPA');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'HTML/CSS');

-- Questions
INSERT INTO question(id, enonce, difficulte, competence_id) VALUES (nextval('question_id_seq'), 'Citer trois types primitifs', 'SIMPLE', (SELECT id FROM competence where nom='Java/JavaEE'));
INSERT INTO question(id, enonce, difficulte, competence_id) VALUES (nextval('question_id_seq'), 'Différences entre == et equals', 'SIMPLE', (SELECT id FROM competence where nom='Java/JavaEE'));