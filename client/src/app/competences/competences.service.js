(function () {
    'use strict';

    angular.module('skillmatcher.competences').factory('competencesService', competencesService);

    function competencesService(Restangular) {
        var baseCompetences = Restangular.all('competences');

        return {
            list: list
        };

        function list() {
            return baseCompetences.getList();
        }
    }
})();