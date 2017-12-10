<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="elements" class="java.util.ArrayList" scope="session">
    <jsp:setProperty name="elements" property="*"/>
</jsp:useBean>
<form action="CreatePlace" method="post">
    <label>Name: <input name="name"></label>
    <label>Description:<textarea rows="10" cols="50" name="description"></textarea></label>
    <label>Latitude: <input type="number" name="latitude"></label>
    <label>Longitude: <input type="number" name="longitude"></label>
    <label>Radiation: <input name="radiation"></label>
    <select name="elements">
        <option disabled selected>Not selected</option>
        <c:forEach var="element" items="elements">
            <option value="${element.id}">${element.name}(<sup>${element.mass}</sup>${element.radioactiveElement})</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="Add">
</form>