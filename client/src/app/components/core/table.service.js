(function () {
    'use strict';

    angular.module('skillmatcher.core').factory('tableService', tableService);

    function tableService() {
        var table = {
            limit: 12,
            page: 1
        };

        return {
            table: table,
            paginate: paginate
        };

        function paginate(item, index) {
            return index >= (limit * (page - 1));
        }
    }
})();