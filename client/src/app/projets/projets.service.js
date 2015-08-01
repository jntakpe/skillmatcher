(function () {
    'use strict';

    angular.module('skillmatcher.projets').factory('projetsService', projetsService);

    function projetsService(Restangular) {
        var baseProjets = Restangular.all('projets');

        return {
            list: list
        };

        function list() {
            return baseProjets.getList();
        }
    }
})();