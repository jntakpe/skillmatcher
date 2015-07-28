(function () {
    'use strict';

    angular.module('skillmatcher.competences').controller('CompetencesCtrl', CompetencesCtrl);

    function CompetencesCtrl(competencesService, paginationService) {
        var vm = this;

        paginationService.table.order = 'nom';
        vm.paginationService = paginationService;
        vm.showDialog = showDialog;
        vm.deleteDialog = deleteDialog;
        vm.progress = competencesService.list().then(function (competences) {
            vm.data = competences;
        });

        function showDialog(competence) {
            competencesService.showDialog(competence).then(function (editedCompetence) {
                vm.progress = competencesService.save(editedCompetence).then(function (savedCompetence) {
                    competencesService.displayEditSuccess(savedCompetence);
                    return competencesService.list();
                }, function (err) {
                    competencesService.displayEditError(editedCompetence, err.status);
                    return competencesService.list();
                }).then(function (competences) {
                    vm.data = competences
                });
            });
        }

        function deleteDialog(competence) {
            competencesService.deleteDialog(competence.nom).then(function () {
                vm.progress = competence.remove().then(function () {
                    competencesService.displayDeleteSuccess(competence);
                    return competencesService.list();
                }, function () {
                    competencesService.displayDeleteError(competence);
                    return competencesService.list();
                }).then(function (competences) {
                    vm.data = competences;
                });
            });
        }

    }
})();