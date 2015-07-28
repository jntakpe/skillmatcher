(function () {
    'use strict';

    angular.module('skillmatcher.questions').factory('questionsService', questionsService);

    function questionsService(Restangular, $mdDialog) {
        var baseQuestions = Restangular.all('questions');

        return {
            list: list,
            save: save,
            showDialog: showDialog,
            deleteDialog: deleteDialog,
            displayEditSuccess: displayEditSuccess,
            displayEditError: displayEditError,
            displayDeleteSuccess: displayDeleteSuccess,
            displayDeleteError: displayDeleteError
        };

        function list() {
            return baseQuestions.getList();
        }

        function save(question) {
            return question.id ? question.put() : baseQuestions.post(question);
        }

        function showDialog(question) {
            return $mdDialog.show({
                controller: 'DialogQuestionsCtrl as dialQuestion',
                templateUrl: 'app/questions/dialog-questions.html',
                locals: {
                    question: question && question.clone()
                }
            });
        }

        function deleteDialog(enonce) {
            var confirm = $mdDialog.confirm()
                .title('Confirmation de suppression')
                .content('Confirmez-vous la suppression de la question \'' + enonce + '\' ?')
                .ok('Confirmer')
                .cancel('Annuler');
            return $mdDialog.show(confirm);
        }

        function displayEditSuccess(question) {
            var action = question.id ? 'éditée' : 'ajoutée';
            toastr.success('La question \'' + question.enonce + '\' a été ' + action + ' avec succès');
        }

        function displayEditError(question, errStatus) {
            var action = question.id ? 'l\'édition' : 'l\'ajout';
            console.log(errStatus);
            if (errStatus === 409) {
                toastr.error('Échec lors de ' + action + ' de la question car l\'énoncé \'' + question.enonce +
                    '\' est déjà utilisé');
            } else {
                toastr.error('Erreur lors de ' + action + ' de la question \'' + question.enonce + '\'');
            }

        }

        function displayDeleteSuccess(question) {
            toastr.success('La question \'' + question.enonce + '\' a été supprimée avec succès');
        }

        function displayDeleteError(question) {
            toastr.error('Erreur lors de la suppression de la question \'' + question.enonce + '\'')
        }
    }
})();