(function () {
    'use strict';

    angular.module('skillmatcher.competences', ['skillmatcher.core']).config(competencesState);

    function competencesState($stateProvider) {
        $stateProvider.state('main.competences', {
            url: '/competences',
            data: {
                title: 'Compétences',
                breadcrumb: ['main.home']
            },
            views: {
                'content@layout': {
                    templateUrl: 'app/competences/competences.html',
                    controller: 'CompetencesCtrl as competences'
                }
            }
        });
    }
})();