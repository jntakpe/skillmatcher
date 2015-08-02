(function () {
    'use strict';

    angular.module('skillmatcher.projets').controller('ProjetsCtrl', ProjetsCtrl);

    function ProjetsCtrl(projetsService) {
        var vm = this;

        projetsService.list().then(function (projets) {
            vm.data = projetsService.mapList(projets);
            console.log(vm.data);
        });
    }
})();