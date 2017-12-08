<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="places" class="java.util.ArrayList" scope="session">
    <jsp:setProperty name="places" property="*"/>
</jsp:useBean>
<table align="center" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>Radiation</th>
        <th>Element</th>
        <th>Last update</th>
    </tr>
    <c:forEach items="${places}" var="place">
        <tr>
            <td>${place.id}</td>
            <td>${place.name}</td>
            <td>${place.description}</td>
            <td>${place.latitude}</td>
            <td>${place.longitude}</td>
            <td>${place.influence.radiation}</td>
            <td><sup>${place.influence.element.mass}</sup>
                <sub>${place.influence.element.number}</sub>
                    ${place.influence.element.radioactiveElement}</td>
        </tr>
    </c:forEach>
</table>