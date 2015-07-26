(function () {
    'use strict';

    angular.module('skillmatcher.questions', ['skillmatcher.core']).config(questionsState);

    function questionsState($stateProvider) {
        $stateProvider.state('main.questions', {
            url: '/questions',
            data: {
                title: 'Questions',
                breadcrumb: ['main.home']
            },
            views: {
                'content@layout': {
                    templateUrl: 'app/questions/questions.html',
                    controller: 'QuestionsCtrl as questions'
                }
            }
        })
    }
})();