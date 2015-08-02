(function () {
    'use strict';

    angular.module('skillmatcher.projets').controller('ProjetsCtrl', ProjetsCtrl);

    function ProjetsCtrl(projetsService, paginationService) {
        var vm = this;

        paginationService.table.order = 'nom';
        vm.paginationService = paginationService;
        vm.deleteDialog = deleteDialog;

        vm.progress = projetsService.list().then(function (projets) {
            vm.data = projetsService.mapList(projets);
        });

        function deleteDialog(projet) {
            projetsService.deleteDialog(projet.nom).then(function whenConfirmed() {
                vm.progress = projet.remove().then(function whenDeleted() {
                    projetsService.displayDeleteSuccess(projet);
                    return projetsService.list();
                }, function whenDeleteError() {
                    projetsService.displayDeleteError(projet);
                    return projetsService.list();
                }).then(function refresh(projets) {
                    vm.data = projetsService.mapList(projets);
                });
            });
        }
    }
})();