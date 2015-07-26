(function () {
    'use strict';

    angular.module('skillmatcher.core').directive('focusOn', focusOnDirective);

    function focusOnDirective() {
        return {
            restrict: 'A',
            link: link
        };

        function link(scope, elem, attrs) {
            scope.$on('focusOn', function (e, name) {
                if (name === attrs.focusOn) {
                    return elem[0].focus();
                }
            });
        }
    }
})();