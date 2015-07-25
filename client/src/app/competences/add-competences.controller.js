(function () {
    'use strict';
    angular.module('skillmatcher.competences').controller('AddCompetencesCtrl', AddCompetencesCtrl);

    function AddCompetencesCtrl($mdDialog) {
        var vm = this;

        vm.competence = {};
        vm.hide = hide;
        vm.cancel = cancel;

        function hide() {
            $mdDialog.hide(vm.competence);
        }

        function cancel() {
            $mdDialog.cancel();
        }

    }
})();