(function () {
    'use strict';
    angular.module('skillmatcher.competences').controller('DialogCompetencesCtrl', DialogCompetencesCtrl);

    function DialogCompetencesCtrl($mdDialog, competence) {
        var vm = this;

        vm.competence = competence || {};
        vm.submit = submit;
        vm.cancel = cancel;


        function submit() {
            $mdDialog.hide(vm.competence);
        }

        function cancel() {
            $mdDialog.cancel();
        }

    }
})();