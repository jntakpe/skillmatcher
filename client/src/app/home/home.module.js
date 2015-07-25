(function () {
    'use strict';

    angular.module('skillmatcher.home', ['skillmatcher.core']).config(homeState);

    function homeState($stateProvider) {
        $stateProvider.state('main.home', {
            url: '/',
            data: {
                title: 'Accueil'
            },
            views: {
                'content@layout': {
                    templateUrl: 'app/home/home.html',
                    controller: 'HomeCtrl as home'
                }
            }
        });
    }
})();