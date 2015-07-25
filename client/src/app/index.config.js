(function () {
    'use strict';

    angular.module('skillmatcher').config(config);

    function config(RestangularProvider) {
        RestangularProvider.setBaseUrl('/api');
    }
})();