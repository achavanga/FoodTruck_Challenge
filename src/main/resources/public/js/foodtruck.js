//Abel Chavanga
$(function () {
    var options = {
        center: new google.maps.LatLng(37.7577, -122.4376),
        zoom: 11,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }//37.7924°N 122.4102°W
    var map = new google.maps.Map($("#map")[0], options);

    $("#search").submit(function (event) {
        event.preventDefault();
        var search = $("#search .query").val();
        var str = "";

        var markers;
        //Initilize screen
        document.getElementById('result-list').innerHTML = '<ul id="result-list" class="list-group">' + str + '</ul>';
        map = new google.maps.Map($("#map")[0], options);
        // Grab our Fairmot Hotel location and fetch nearby restaurants
        navigator.geolocation.getCurrentPosition(function (pos) {
//            var you = new google.maps.Marker({
//                position: new google.maps.LatLng(37.7924,
//                        -122.4102),
//                map: map,
//                animation: google.maps.Animation.DROP,
//                title: "You are here!",
//            });
//            map.setCenter(you.getPosition());
//            map.setZoom(16);

            $.ajax({
                url: "https://data.sfgov.org/resource/6a9r-agq8.json",
                type: "GET",
                data: {
                    "status": "APPROVED",
                    "$where": "expirationdate > '" + (new Date()).toISOString().replace(/Z/, '') + "'",
                    "$q": search,
                    "$limit": 20,
                    "$$app_token": "5i36j9wyiU0itZ0gcdSCmLjNb"
                }
            }).done(function (trucks) {
                markers = [];
                $.each(trucks, function (idx, truck) {

                    // Add a marker for the location of the food truck
                    var marker = new google.maps.Marker({
                        position: new google.maps.LatLng(truck.location.coordinates[1],
                                truck.location.coordinates[0]),
                        map: map,
                        animation: google.maps.Animation.DROP,
                        icon: "./truck.png",
                        title: truck.applicant,
                        optimized: false

                    });

                    // Add an InfoWindow with details about the truck
                    var info_window = new google.maps.InfoWindow({
                        content: '<div class="info-window">'
                                + '<h4>' + truck.applicant + '</h4>'
                                + '<p>Location: ' + truck.locationdescription + '</p>'
                                + '<p>Address: ' + truck.address + '</p>'
                                + '<h5>' + Math.round(parseFloat(truck.range)) + ' meters away.</h5>'
                                + '<p>Foods: ' + truck.fooditems + '</p>'
                                + '</div>'
                    });


                    str += '<li class="list-group-item">' +
                            '<div class="result-wrap">' +
                            '<h3><a id="applicant-' + idx + '" href="#">' + truck.applicant + '</a></h3>' +
                            '<p>Location: ' + truck.locationdescription + '</p>' +
                            '<p>Address: ' + truck.address + '</p>' +
                            '<p>Hours: ' + truck.dayshours + '</p>' +
                            '<p>Foods: ' + truck.fooditems + '</p>' +
                            '</div>';

                    str += '</li>';


                    //collection listeners
                    google.maps.event.addListener(marker, 'click', function () {
                        info_window.open(map, marker);

                    });
                    document.getElementById('result-list').innerHTML = '<ul id="result-list" class="list-group">' + str + '</ul>';


                });

            });
        })
    });
});
