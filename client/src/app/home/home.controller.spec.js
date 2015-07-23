(function () {
    'use strict';

    describe('Controller : HomeCtrl as home => ', function () {

        var scope, ctrl;

        beforeEach(function () {
            module('skillmatcher');

            inject(function ($controller) {
                scope = {};
                ctrl = $controller('HomeCtrl as home', {
                    $scope: scope
                });
            });
        });

        it('should exist', function () {
            expect(!!ctrl).toBe(true);
        });

    });
})();
