<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="lat" value="50.45987"/>
<c:set var="lng" value="30.562989"/>
<link href="css/map.css" rel="stylesheet"/>
<input type="text">
<div align="center"><div id="map"></div></div>
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