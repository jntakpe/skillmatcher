(function () {
    'use strict';

    angular.module('skillmatcher-core').factory('focus', doFocus);

    function doFocus($rootScope, $timeout) {
        return function timeoutBroadcast(name) {
            return $timeout(function broadcast() {
                return $rootScope.$broadcast('focusOn', name);
            });
        };
    }
})();