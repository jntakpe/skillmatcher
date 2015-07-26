(function () {
    'use strict';

    angular.module('skillmatcher.competences').controller('CompetencesCtrl', CompetencesCtrl);

    function CompetencesCtrl(competencesService, paginationService, toastr) {
        var vm = this;

        vm.paginationService = paginationService;
        vm.addDialog = addDialog;
        vm.deleteDialog = deleteDialog;
        vm.progress = list();

        function list() {
            return competencesService.list().then(function (competences) {
                vm.data = competences;
            });
        }

        function addDialog() {
            competencesService.showDialog().then(function (competence) {
                vm.progress = competencesService.add(competence).then(function (competences) {
                    toastr.success('La compétence ' + competence.nom + ' a été ajouté avec succès');
                    vm.data = competences;
                }, function () {
                    toastr.error('Erreur lors de l\'ajout de la compétence ' + competence.nom);
                    vm.progress = list();
                });
                console.log(vm.progress);
            });
        }

        function deleteDialog(competence) {
            competencesService.deleteDialog(competence.nom).then(function () {
                vm.progress = competence.remove().then(function (competences) {
                    toastr.success('La compétence ' + competence.nom + ' a été supprimée avec succès');
                    vm.data = competences;
                }, function () {
                    toastr.error('Erreur lors de la suppression de la compétence ' + competence.nom);
                    vm.progress = list();
                });
            });
        }

    }
})();