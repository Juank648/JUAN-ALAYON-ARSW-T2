var app = ( function(){
    let mapList = [];
    let mapListCountry = [];
    


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
    var mapCaseCountry = function (data){
        console.log("map");
        console.log(data);
        mapListCountry = data.map(function (caseCorona){
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

        mapList.map(function (caseCorona) {
            html += "<tr>";
            html += "<td onclick='app.getCaseByCountry(\""+caseCorona.country+"\");'>" + caseCorona.country +  "</td>"; //Servicio coronavirusAPI caído
            html += "<td>" + caseCorona.numDeaths + "</td>"; //numDeaths se reemplaza con el nombre correcto del JSON
            html += "<td>" + caseCorona.numInfected + "</td>"; //numInfected se reemplaza con el nombre correcto del JSON
            html += "<td>" + caseCorona.numCured + "</td>"; //numCured se reemplaza con el nombre correcto del JSON
            html += "</tr>"

        });

        $("#Table_Content").html(html);
    }
    var drawTableCountry = function () {
        let html = "";
        let countryName = "";

        mapListCountry.map(function (caseCorona) {
            countryName = caseCorona.country;
            html += "<tr>";
            html += "<td> numDeaths </td>";
            html += "<td>" + caseCorona.numDeaths+ "</td>";
            html += "</tr>"

        });

        $("#country_name").html(countryName);
        $("#Table_Content_Country").html(html);
    }

    var getAllCases = function () {

        apiclient.getAllCases(function (error, data){
            mapCases(data);
            drawTable();

        })

    };

    var getCaseByCountry = function (country){
        apiclient.getCasesByCountry(country, function (error, data){
            mapCaseCountry(data);
            drawTableCountry();
        })
    }

    


    return {
        getAllCases, getCaseByCountry

    }
})();