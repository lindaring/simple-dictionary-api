app.factory('utilService', function ($http, HOST, UTIL_ENDPOINT) {

    return {
        getCurrentYear: function () {
            var promise = $http({
                method: 'GET',
                url: HOST + UTIL_ENDPOINT + '/year'
            });
            return promise;
        }
    };

});