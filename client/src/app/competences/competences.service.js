(function () {
    'use strict';

    angular.module('skillmatcher.competences').factory('competencesService', competencesService);

    function competencesService(Restangular, $mdDialog) {
        var baseCompetences = Restangular.all('competences');

        return {
            list: list,
            add: add,
            showDialog: showDialog,
            deleteDialog: deleteDialog
        };

        function list() {
            return baseCompetences.getList();
        }

        function add(competence) {
            return baseCompetences.post(competence);
        }

        function showDialog() {
            return $mdDialog.show({
                controller: 'AddCompetencesCtrl as addComp',
                templateUrl: 'app/competences/add-competences.html'
            });
        }

        function deleteDialog(nom) {
            var confirm = $mdDialog.confirm()
                .title('Confirmation de suppression')
                .content('Confirmez-vous la suppression de la compétence ' + nom + '?')
                .ok('Confirmer')
                .cancel('Annuler');
            return $mdDialog.show(confirm);
        }

    }
})();