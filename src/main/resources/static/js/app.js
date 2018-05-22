var app = angular.module('simpleApp', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'partials/home.html',
        controller: 'wordController'
    });
    $routeProvider.when('/error-404', {templateUrl: 'partials/error.html'});
    $routeProvider.otherwise({redirectTo: '/error-404'});
});

app.constant('HOST', '');
app.constant('WORD_ENDPOINT', '/simple-dictionary/v1/word');
app.constant('UTIL_ENDPOINT', '/simple-dictionary/v1/util');

function _(element) {
    return document.getElementById(element);
}