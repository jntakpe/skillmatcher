(function () {
    'use strict';

    angular.module('skillmatcher.questions').controller('QuestionsCtrl', QuestionsCtrl);

    function QuestionsCtrl(questionsService, paginationService, competencesService) {
        var vm = this;
        var competences = competencesService.list();

        paginationService.table.order = 'enonce';
        vm.paginationService = paginationService;
        vm.showDialog = showDialog;
        vm.deleteDialog = deleteDialog;
        vm.progress = questionsService.list().then(function (questions) {
            vm.data = questions;
        });

        function showDialog(question) {
            questionsService.showDialog(question, competences).then(function whenEdited(editedQuestion) {
                vm.progress = questionsService.save(editedQuestion).then(function whenSaved(savedQuestion) {
                    questionsService.displayEditSuccess(savedQuestion);
                    return questionsService.list();
                }, function whenSaveError(err) {
                    questionsService.displayEditError(editedQuestion, err.status);
                    return questionsService.list();
                }).then(function refresh(questions) {
                    vm.data = questions;
                });
            });
        }

        function deleteDialog(question) {
            questionsService.deleteDialog(question.enonce).then(function whenConfirmed() {
                vm.progress = question.remove().then(function () {
                    questionsService.displayDeleteSuccess(question);
                    return questionsService.list();
                }, function whenDeleteError() {
                    questionsService.displayDeleteError(question);
                    return questionsService.list();
                }).then(function refresh(questions) {
                    vm.data = questions;
                });
            });
        }

    }
})();