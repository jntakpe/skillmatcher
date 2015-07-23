(function () {
    'use strict';

    /* global toastr:false, moment:false */

    angular.module('skillmatcher')
        .constant('moment', moment)
        .constant('toastr', toastr);
})();