(function() {
  'use strict';

  angular
    .module('skillmatcher')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
