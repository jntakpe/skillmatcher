(function () {
    'use strict';
    angular.module('skillmatcher.competences').controller('AddCompetencesCtrl', AddCompetencesCtrl);

    function AddCompetencesCtrl($mdDialog) {
        var vm = this;

        vm.competence = {};
        vm.submit = submit;
        vm.cancel = cancel;

        function submit() {
            if (vm.addForm.$valid) {
                $mdDialog.hide(vm.competence);
            }
        }

        function cancel() {
            $mdDialog.cancel();
        }

    }
})();