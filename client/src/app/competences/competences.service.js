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

        function deleteDialog(nom) {
            var confirm = $mdDialog.confirm()
                .title('Confirmation de suppression')
                .content('Confirmez-vous la suppression de la compétence ' + nom + ' ?')
                .ok('Confirmer')
                .cancel('Annuler');
            return $mdDialog.show(confirm);
        }

        function displayEditSuccess(competence) {
            var action = competence.id ? 'éditée' : 'ajoutée';
            toastr.success('La compétence ' + competence.nom + ' a été ' + action + ' avec succès');
        }

        function displayEditError(competence) {
            var action = competence.id ? 'l\'édition' : 'l\'ajout';
            toastr.error('Erreur lors de ' + action + ' de la compétence ' + competence.nom);
        }

        function displayDeleteSuccess(competence) {
            toastr.success('La compétence ' + competence.nom + ' a été supprimée avec succès');
        }

        function displayDeleteError(competence) {
            toastr.error('Erreur lors de la suppression de la compétence ' + competence.nom)
        }
    }
})();