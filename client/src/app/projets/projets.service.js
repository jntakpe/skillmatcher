(function () {
    'use strict';

    angular.module('skillmatcher.projets').factory('projetsService', projetsService);

    function projetsService(Restangular) {
        var baseProjets = Restangular.all('projets');

        return {
            list: list,
            mapList: mapList
        };

        function list() {
            return baseProjets.getList();
        }

        function mapList(projets) {
            var mapped = [];
            projets.forEach(function eachProjet(projet) {
                var edited = {
                    id: projet.id,
                    nom: projet.nom
                };
                edited.competences = _.map(projet.projetsCompetences, 'competence.nom');
                edited.candidat = _.map(projet.candidats, 'nom');
                mapped.push(edited);
            });
            return mapped;
        }
    }
})();