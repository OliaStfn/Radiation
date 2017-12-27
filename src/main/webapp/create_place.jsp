<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="elements" class="java.util.ArrayList" scope="session">
    <jsp:setProperty name="elements" property="*"/>
</jsp:useBean>
<form action="CreatePlace" method="post">
    <label>Name: <input name="name"></label><br>
    <label>Description:<br><textarea rows="10" cols="50" name="description"></textarea></label><br>
    <label>Latitude: <input type="number" name="latitude"></label><br>
    <label>Longitude: <input type="number" name="longitude"></label><br>
    <label>Radiation: <input name="radiation"></label><br>
    <label for="select">Element</label>
    <select id="select" name="elements">
        <option disabled selected>Not selected</option>
        <c:forEach var="element" items="${elements}">
            <option value="${element.id}">${element.name}(<sup>${element.mass}</sup>${element.radioactiveElement})</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="Add">
</form>