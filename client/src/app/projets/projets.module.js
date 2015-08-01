(function () {
    'use strict';

    angular.module('skillmatcher.projets', ['skillmatcher.core']).config(stateConfig);

    function stateConfig($stateProvider) {
        $stateProvider.state('main.projets', {
            url: '/projets',
            data: {
                title: 'Projets',
                breadcrumb: ['main.home']
            },
            views: {
                'content@layout': {
                    templateUrl: 'app/projets/projets.html',
                    controller: 'ProjetsCtrl as projets'
                }
            }
        });
    }
})();