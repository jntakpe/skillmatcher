(function() {
    'use strict';

    angular.module('skillmatcher.core').directive('tablePagination', tablePagination);

    function tablePagination() {
        return {
            scope: {},
            bindToController: {
                page: '=',
                limit: '=',
                total: '@',
                rowSelect: '='
            },
            templateUrl: 'app/components/core/tables/pagination.tpl.html',
            controller: 'TablePaginationCtrl as pagin',
            transclude: true
        };
    }
})();