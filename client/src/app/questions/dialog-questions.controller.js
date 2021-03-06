(function () {
    'use strict';
    angular.module('skillmatcher.questions').controller('DialogQuestionsCtrl', DialogQuestionsCtrl);

    function DialogQuestionsCtrl($mdDialog, question, competences) {
        var vm = this;

        vm.difficultes = ['SIMPLE', 'MOYENNE', 'DIFFICILE'];
        vm.question = question || {};
        vm.competences = competences;
        vm.submit = submit;
        vm.cancel = cancel;

        function submit() {
            $mdDialog.hide(vm.question);
        }

        function cancel() {
            $mdDialog.cancel();
        }

    }
})();