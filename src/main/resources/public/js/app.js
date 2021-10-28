var app = ( function(){
    let privateAuthor = "";
    let mapList = [];
    


    var mapCases = function (data){
        console.log("map");
        console.log(data);
        mapList = data.map(function (caseCorona){
            let country = caseCorona.country;
            let numDeaths = caseCorona.numDeaths;
            let numInfected = caseCorona.numInfected;
            let numCured = caseCorona.numCured;
            return {
                country,
                numDeaths,
                numInfected,
                numCured
            };
        });
    }

    
    var drawTable = function () {
        let html = "";

        console.log(privateAuthor);
        mapList.map(function (caseCorona) {
            html += "<tr>";
            html += "<td>" + caseCorona.country +  "</td>"; //Servicio coronavirusAPI caído
            html += "<td>" + caseCorona.numDeaths + "</td>"; //numDeaths se reemplaza con el nombre correcto del JSON
            html += "<td>" + caseCorona.numInfected + "</td>"; //numInfected se reemplaza con el nombre correcto del JSON
            html += "<td>" + caseCorona.numCured + "</td>"; //numCured se reemplaza con el nombre correcto del JSON
            html += "</tr>"

        });

        $("#Table_Content").html(html);
    }

    var getAllCases = function (author) {
        privateAuthor = author;
        apiclient.getAllCases(function (error, data){
            mapCases(data);
            drawTable();

        })

    };

    


    return {
        getAllCases

    }
})();