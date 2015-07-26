(function () {
    'use strict';
    angular.module('skillmatcher.competences').controller('AddCompetencesCtrl', AddCompetencesCtrl);

    function AddCompetencesCtrl($mdDialog, focus) {
        var vm = this;

        vm.competence = {};
        vm.submit = submit;
        vm.cancel = cancel;

        function submit() {
            if (vm.addForm.$valid) {
                $mdDialog.hide(vm.competence);
            } else {
                vm.addForm.nom.$setTouched();
                focus('add-comp');
            }
        }

        function cancel() {
            $mdDialog.cancel();
        }

    }
})();