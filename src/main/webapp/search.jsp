<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/search-menu.js"></script>
<form action="Places" method="post">
    <h1>What search by?</h1>
    <label><input type="radio" name="radio" value="position">Position</label>
    <label><input type="radio" name="radio" value="name">Place name</label>
    <hr>
    <div id="position">
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
    <div id="name">
        <label>Place name: <input name="name"></label>
    </div><br>
    <input type="submit" value="Search">
</form>