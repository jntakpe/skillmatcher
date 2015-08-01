(function () {
    'use strict';

    angular.module('skillmatcher.projets').controller('ProjetsCtrl', ProjetsCtrl);

    function ProjetsCtrl(projetsService) {
        var vm = this;

        projetsService.list().then(function (data) {
            console.log(data);
        });
    }
})();