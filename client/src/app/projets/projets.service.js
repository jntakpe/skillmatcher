(function () {
    'use strict';

    angular.module('skillmatcher.projets').factory('projetsService', projetsService);

    function projetsService(Restangular, $mdDialog) {
        var baseProjets = Restangular.all('projets');

        return {
            list: list,
            mapList: mapList,
            deleteDialog: deleteDialog,
            displayDeleteSuccess: displayDeleteSuccess,
            displayDeleteError: displayDeleteError
        };

        function list() {
            return baseProjets.getList();
        }

        function mapList(projets) {
            var mapped = [];
            projets.forEach(function eachProjet(projet) {
                projet.competences = _.map(projet.projetsCompetences, 'competence.nom');
                projet.candidats = _.map(projet.candidats, 'nom');
                mapped.push(projet);
            });
            return mapped;
        }

        function deleteDialog(nom) {
            var confirm = $mdDialog.confirm()
                .title('Confirmation de suppression')
                .content('Confirmez-vous la suppression du projet \'' + nom + '\' ?')
                .ok('Confirmer')
                .cancel('Annuler');
            return $mdDialog.show(confirm);
        }

        function displayDeleteSuccess(projet) {
            toastr.success('Le projet \'' + projet.nom + '\' a été supprimé avec succès');
        }

        function displayDeleteError(projet) {
            toastr.error('Erreur lors de la suppression du projet \'' + projet.nom + '\'');
        }
    }
})();