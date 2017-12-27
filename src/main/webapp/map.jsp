<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
        #map {
            height: 100%;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div align="center">
    <a href="/Places">Places</a>
    <a href="/Places?name=Київ">Place</a>
    <a href="/CreatePlace">Create place</a>
    <a href="/map.jsp">Map</a>
    <a href="/search.jsp">Search</a>
</div>
<c:set var="lat" value="50.45987"/>
<c:set var="lng" value="30.562989"/>
<div id="map"></div>
<script>
    var map;
    function initMap() {
        var myLatLng = {lat: ${lat}, lng: ${lng}};

        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: ${lat}, lng: ${lng}},
            zoom: 8
        });
        var marker = new google.maps.Marker({
            position: myLatLng,
            map: map,
            title: 'Київ'
        });
    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBROHDp1a2maS6wCzusGPLjgT0iOCClwyk&callback=initMap"
        async defer></script>
</body>
</html>