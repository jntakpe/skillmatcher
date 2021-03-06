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
            competencesService.showDialog(competence).then(function whenEdited(editedCompetence) {
                vm.progress = competencesService.save(editedCompetence).then(function whenSaved(savedCompetence) {
                    competencesService.displayEditSuccess(savedCompetence);
                    return competencesService.list();
                }, function whenSaveError(err) {
                    competencesService.displayEditError(editedCompetence, err.status);
                    return competencesService.list();
                }).then(function refresh(competences) {
                    vm.data = competences;
                });
            });
        }

        function deleteDialog(competence) {
            competence.get().then(function (competenceWithRelations) {
                competencesService.deleteDialog(competenceWithRelations).then(function whenConfirmed() {
                    vm.progress = competence.remove().then(function whenDeleted() {
                        competencesService.displayDeleteSuccess(competence);
                        return competencesService.list();
                    }, function whenDeleteError() {
                        competencesService.displayDeleteError(competence);
                        return competencesService.list();
                    }).then(function refresh(competences) {
                        vm.data = competences;
                    });
                });
            });
        }

    }
})();