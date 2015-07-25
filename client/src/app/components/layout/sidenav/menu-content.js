(function () {
    'use strict';

    angular.module('skillmatcher.layout').constant('menuContent', menuContent());

    function menuContent() {
        var content = [],
            navtest = {
                name: 'HeadingTest',
                type: 'heading',
                children: [{
                    name: 'ToggleTest',
                    type: 'toggle',
                    pages: [{
                        name: 'Accueil',
                        state: 'main.home',
                        type: 'link'
                    }, {
                        name: 'Candidats',
                        state: 'main.candidats',
                        type: 'link'
                    }]
                }]
            },
            home = {
                name: 'Accueil',
                state: 'main.home',
                type: 'link'
            },
            candidats = {
                name: 'Candidats',
                state: 'main.candidats',
                type: 'link'
            },
            competences = {
                name: 'Gestion des compétences',
                state: 'main.competences',
                type: 'link'
            };
        content.push(navtest);
        content.push(home);
        content.push(candidats);
        content.push(competences);
        return content;
    }
})();