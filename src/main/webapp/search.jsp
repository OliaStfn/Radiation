<link rel="stylesheet" href="css/search.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/search-menu.js"></script>
<jsp:include page="nav_bar.jsp"/>
<form action="Places" method="post">
    <h1>What search by?</h1>
    <span>Position</span>
    <span>Name</span>
    <hr>
    <div id="Position">
        <label>Latitude (as "degree.minutes.seconds") <input name="latitude" value="0.0.0"></label>
        <select name="latitude-string">
            <option disabled selected>Not selected</option>
            <option value="N">North</option>
            <option value="S">South</option>
        </select><br>
        <label>Longitude (as "degree.minutes.seconds") <input name="longitude" value="0.0.0"></label>
        <select name="longitude-string">
            <option disabled selected>Not selected</option>
            <option value="W">West</option>
            <option value="E">East</option>
        </select><br>
    </div>
    <div id="Name">
        <label>Place name: <input name="name"></label>
    </div><br>
    <input type="submit" value="Search">
</form>