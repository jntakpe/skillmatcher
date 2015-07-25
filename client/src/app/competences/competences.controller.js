(function () {
    'use strict';

    angular.module('skillmatcher.competences').controller('CompetencesCtrl', CompetencesCtrl);

    function CompetencesCtrl(competencesService) {
        var vm = this;

        competencesService.list().then(function (response) {
            vm.data = response;
        });
    }
})();