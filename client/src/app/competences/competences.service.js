(function () {
    'use strict';

    angular.module('skillmatcher.competences').factory('competencesService', competencesService);

    function competencesService(Restangular, $mdDialog, toastr) {
        var baseCompetences = Restangular.all('competences');

        return {
            list: list,
            save: save,
            showDialog: showDialog,
            deleteDialog: deleteDialog,
            displayEditSuccess: displayEditSuccess,
            displayEditError: displayEditError,
            displayDeleteSuccess: displayDeleteSuccess,
            displayDeleteError: displayDeleteError
        };

        function list() {
            return baseCompetences.getList();
        }

        function save(competence) {
            return competence.id ? competence.put() : baseCompetences.post(competence);
        }

        function showDialog(competence) {
            return $mdDialog.show({
                controller: 'DialogCompetencesCtrl as dialComp',
                templateUrl: 'app/competences/dialog-competences.html',
                locals: {
                    competence: competence && competence.clone()
                }
            });
        }

        function checkDeletable(withRelations) {
            var msg = 'Impossible de supprimer la compétence ' + withRelations.nom + ' car elle est liée à des ';
            if (withRelations.projets.length) {
                msg += 'projets';
            } else if (withRelations.questions.length) {
                msg += 'questions';
            } else {
                return true;
            }
            toastr.warning(msg);
            return false;
        }

        function deleteDialog(competenceWithRelations) {
            if (checkDeletable(competenceWithRelations)) {
                var confirm = $mdDialog.confirm()
                    .title('Confirmation de suppression')
                    .content('Confirmez-vous la suppression de la compétence ' + competenceWithRelations.nom + ' ?')
                    .ok('Confirmer')
                    .cancel('Annuler');
                return $mdDialog.show(confirm);
            }
        }

        function displayEditSuccess(competence) {
            var action = competence.id ? 'éditée' : 'ajoutée';
            toastr.success('La compétence ' + competence.nom + ' a été ' + action + ' avec succès');
        }

        function displayEditError(competence, errStatus) {
            var action = competence.id ? 'l\'édition' : 'l\'ajout';
            if (errStatus === 409) {
                toastr.error('Échec lors de ' + action + ' car le nom de la compétence ' + competence.nom +
                    ' est déjà utilisé');
            } else {
                toastr.error('Erreur lors de ' + action + ' de la compétence ' + competence.nom);
            }
        }

        function displayDeleteSuccess(competence) {
            toastr.success('La compétence ' + competence.nom + ' a été supprimée avec succès');
        }

        function displayDeleteError(competence) {
            toastr.error('Erreur lors de la suppression de la compétence ' + competence.nom);
        }
    }
})();