<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet" href="css/style.css"/>
<div class="wrapper container">
    <header></header>
    <jsp:include page="nav_bar.jsp" flush="true"/>
    <div class="row">
        <jsp:include page="map.jsp" flush="true"/>
    </div>
</div>
<footer></footer>