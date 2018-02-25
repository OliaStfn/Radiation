<link rel="stylesheet" href="css/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="elements" class="java.util.ArrayList" scope="session">
    <jsp:setProperty name="elements" property="*"/>
</jsp:useBean>
<jsp:include page="nav_bar.jsp" flush="true"/>
<br><br><br>
<form style="color: ghostwhite" action="CreatePlace" method="post">
    <label>Назва точки: <input name="name"></label><br>
    <label>Опис:<br><textarea rows="5" cols="40" name="description"></textarea></label><br>
    <label>Широта: <input type="number" name="latitude"></label><br>
    <label>Довгота: <input type="number" name="longitude"></label><br>
    <label>Радіаційне випромінювання(мкР/год): <input name="radiation" type="number"></label><br>
    <label for="select">Переважаючий ізотоп хім. ел.</label>
    <select id="select" name="elements">
        <option disabled selected>Not selected</option>
        <c:forEach var="element" items="${elements}">
            <option value="${element.id}">${element.name}(<sup>${element.mass}</sup>${element.radioactiveElement})
            </option>
        </c:forEach>
    </select><br><br>
    <input type="submit" value="Додати точку">
</form>