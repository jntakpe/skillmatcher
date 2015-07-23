(function () {
    'use strict';

    angular.module('skillmatcher-error').config(notFoundState);

    function notFoundState($stateProvider) {
        $stateProvider.state('notfound', {
            url: '/404',
            templateUrl: 'app/errors/404/notfound.html',
            controller: 'NotFoundCtrl as notFound'
        });
    }
})();