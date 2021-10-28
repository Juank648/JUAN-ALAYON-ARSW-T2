var apiclient = (function () {
    return {
        getAllCases: function (callback) {
            $.get(
                {
                    url: "/corona" ,
                    contentType: "application/json",
                }

                , function (data){
                    console.log(data);
                    callback(null, data);
                }).fail(function (error) {
                    alert("No se pudieron obtener los datos")
                }
            );

        },

        getCasesByCountry: function(name, country, callback) {
            $.get({
                    url: "/corona/" + country,
                    contentType: "application/json",
                },

                function (data){
                    callback(null, data)
                }).fail(function (){
                alert("error");
            });
        },
    }
})();