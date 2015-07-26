(function () {
    'use strict';

    angular.module('skillmatcher.competences').factory('competencesService', competencesService);

    function competencesService(Restangular, $mdDialog) {
        var baseCompetences = Restangular.all('competences');

        return {
            list: list,
            add: add,
            showDialog: showDialog
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

    }
})();