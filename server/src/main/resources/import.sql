-- Compétences
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Java/JavaEE');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'Javascript/AngularJS');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'SQL/JPA');
INSERT INTO competence(id, nom) VALUES (nextval('competence_id_seq'), 'HTML/CSS');

-- Questions
INSERT INTO question(id, enonce, difficulte, competence_id) VALUES (nextval('question_id_seq'), 'Citer trois types primitifs en Java', 'SIMPLE', (SELECT id FROM competence where nom='Java/JavaEE'));
INSERT INTO question(id, enonce, difficulte, competence_id) VALUES (nextval('question_id_seq'), 'Différences entre == et equals', 'SIMPLE', (SELECT id FROM competence where nom='Java/JavaEE'));
INSERT INTO question(id, enonce, difficulte, competence_id) VALUES (nextval('question_id_seq'), 'Expliquer en quoi JavaScript diffère de Java', 'SIMPLE', (SELECT id FROM competence where nom='Javascript/AngularJS'));
INSERT INTO question(id, enonce, difficulte, competence_id) VALUES (nextval('question_id_seq'), 'Citer trois types primitifs en JavaScript', 'SIMPLE', (SELECT id FROM competence where nom='Javascript/AngularJS'));

-- Projets
INSERT INTO projet (id, nom) VALUES (nextval('projet_id_seq'), 'Qualité');
INSERT INTO projet (id, nom) VALUES (nextval('projet_id_seq'), 'Pilotage');
INSERT INTO projet (id, nom) VALUES (nextval('projet_id_seq'), 'Parc');
INSERT INTO projet (id, nom) VALUES (nextval('projet_id_seq'), 'Poste de travail');

-- Projets <-> Compétences
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Pilotage'), (SELECT id FROM competence WHERE competence.nom = 'Java/JavaEE'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Parc'), (SELECT id FROM competence WHERE competence.nom = 'Java/JavaEE'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Poste de travail'), (SELECT id FROM competence WHERE competence.nom = 'Java/JavaEE'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Qualité'), (SELECT id FROM competence WHERE competence.nom = 'Java/JavaEE'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Pilotage'), (SELECT id FROM competence WHERE competence.nom = 'Javascript/AngularJS'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Parc'), (SELECT id FROM competence WHERE competence.nom = 'Javascript/AngularJS'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Poste de travail'), (SELECT id FROM competence WHERE competence.nom = 'Javascript/AngularJS'));
INSERT INTO projet_competence(coefficient, projet_id, competence_id) VALUES (5, (SELECT id FROM projet WHERE projet.nom='Qualité'), (SELECT id FROM competence WHERE competence.nom = 'Javascript/AngularJS'));

-- Candidats
INSERT INTO candidat (id, annees_xp, date_dispo, interne, nom, score, tarif, projet_id) VALUES (nextval('candidat_id_seq'), 1, null, false, 'Njeneza Francois', null, null, null);
INSERT INTO candidat (id, annees_xp, date_dispo, interne, nom, score, tarif, projet_id) VALUES (nextval('candidat_id_seq'), 3, null, false, 'Patience', null, null, null);
