(function () {
    'use strict';

    angular.module('skillmatcher.core').factory('paginationService', paginationService);

    function paginationService() {

        var table = {};

        return {
            table: table,
            paginate: paginate
        };

        function paginate(item, index) {
            return index >= (table.limit * (table.page - 1));
        }

    }
})();