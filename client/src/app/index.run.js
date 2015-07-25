(function() {
    'use strict';

    angular.module('skillmatcher').run(run);

    function run(toastr) {
        toastr.options = {
            progressBar: true,
            closeButton: true
        };
    }
})();