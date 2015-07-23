(function () {
    'use strict';

    angular.module('skillmatcher-error').controller('NotFoundCtrl', NotFoundCtrl);

    function NotFoundCtrl($state) {
        var vm = this;

        vm.goHomepage = goHomepage;

        function goHomepage() {
            $state.go('main.home');
        }
    }
})();
