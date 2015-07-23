(function () {
    'use strict';

    angular.module('skillmatcher').config(routeConfig);

    function routeConfig($urlRouterProvider) {
        $urlRouterProvider.otherwise('/404');
    }

})();