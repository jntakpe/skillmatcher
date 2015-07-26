(function () {
    'use strict';

    angular.module('skillmatcher.core').controller('TablePaginationCtrl', TablePaginationCtrl);

    function TablePaginationCtrl(paginationService) {
        var vm = this;

        paginationService.table.page = vm.page || 1;
        paginationService.table.limit = vm.limit || 8;

        vm.paginationService = paginationService;
        vm.label = {
            of: 'sur',
            text: 'Nombre de lignes par page :'
        };
        vm.rowSelect = [5, 8, 10, 12, 15];
    }
})();