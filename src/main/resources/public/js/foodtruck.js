$(function() {
  var options = {
    center: new google.maps.LatLng(37.7577, -122.4376),
    zoom: 12,
    mapTypeId: google.maps.MapTypeId.TERRAIN
  }
  var map = new google.maps.Map($("#map")[0], options);

  $("#search").submit(function(event) {
    event.preventDefault();
    var search = $("#search .query").val();

    // Grab our current location and fetch nearby restaurants
    navigator.geolocation.getCurrentPosition(function(pos) {
      var you = new google.maps.Marker({
        position: new google.maps.LatLng(pos.coords.latitude,
                      pos.coords.longitude),
        map: map,
        animation: google.maps.Animation.DROP,
        title: "You are here!",
      });
      map.setCenter(you.getPosition());
      map.setZoom(16);

      $.ajax({
        url: "https://data.sfgov.org/resource/6a9r-agq8.json",
        type: "GET",
        data: {
          "status" : "APPROVED",
          "$where": "expirationdate > '" + (new Date()).toISOString().replace(/Z/, '') + "'" 
            + " AND within_circle(location, "
            + pos.coords.latitude + ", "
            + pos.coords.longitude + ", 500)",
          "$q": search,
          "$select": "*, distance_in_meters(location, 'POINT(" + pos.coords.longitude + " " + pos.coords.latitude + ")') AS range",
          "$order" : "range",
          "$limit" : 5,
          "$$app_token": "AIzaSyBCBfbZNUQ4LYHsmeI90d72MyCc__9MAMY"
        }
      }).done(function(trucks) {
        $.each(trucks, function(idx, truck) {
          // Fetch the nearest trees to each truck
          $.ajax({
            url: "https://data.sfgov.org/resource/2zah-tuvt.json",
            type: "GET",
            data: {
              "$select": "min(distance_in_meters(location, 'POINT(" + truck.location.coordinates.join(" ") + ")')) as distance",
              "$$app_token": "AIzaSyBCBfbZNUQ4LYHsmeI90d72MyCc__9MAMY"
            },
          }).done(function(closest_tree) {
            // Add a marker for the location of the food truck
            var marker = new google.maps.Marker({
              position: new google.maps.LatLng(truck.location.coordinates[1],
                            truck.location.coordinates[0]),
              map: map,
              animation: google.maps.Animation.DROP,
              icon: "./img/foodtruck.png",
              title: truck.applicant,
              optimized: false
            });

            // Add an InfoWindow with details about the truck
            var info_window = new google.maps.InfoWindow({
              content: '<div class="info-window">'
                + '<h4>' + truck.applicant + '</h4>'
                + '<h5>' + Math.round(parseFloat(truck.range)) + ' meters away.</h5>'
                + '<p>' + truck.fooditems + '</p>'
                + '<p>Nearest tree is within <em>' + Math.round(parseFloat(closest_tree[0].distance)) + ' meters</em>.</p>'
                + '</div>'
            });
            google.maps.event.addListener(marker, 'click', function() {
              info_window.open(map, marker);
            });

            // Add a circle to show how far you'd have to walk for a tree
            var circle = new google.maps.Circle({
              strokeOpacity: 0.0,
              fillColor: "#00FF00",
              fillOpacity: 0.2,
              map: map,
              radius: parseFloat(closest_tree[0].distance),
              center: new google.maps.LatLng(truck.location.coordinates[1],
                  truck.location.coordinates[0])
            });
          });
        });
      });
    })
  });
});
