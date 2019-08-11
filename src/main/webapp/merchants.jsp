<%--
  Created by IntelliJ IDEA.
  User: tirthpatel
  Date: 2019-08-10
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Merchants</title>

    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
    </head>

</head>
<body>

<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="dad"><img src="/logo.png" /></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div></div>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/merchants">Merchants</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Orders</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Hii <%=session.getAttribute("name")%></a>
                </li>


            </ul>

            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            &nbsp &nbsp
            <form class="form-inline my-2 my-lg-0" action="/login" method="get">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
    </nav>
</div>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Merchant Name</th>

            <th scope="col">Email</th>
            <th scope="col">Password</th>
        </tr>
        </thead>

        <c:forEach items="${requestScope.merchants}" var="merchant">
            <tr>

                <td scope="col"><c:out value="${merchant.name}" /><td>
                <td scope="col"><c:out value="${merchant.email}" /><td>
                <td scope="col"><c:out value="${merchant.pass}" /><td>
<%--                <td scope="col"><a href="<c:url value="/addToCart?id=${product.productID}"/>" /><button type="button" class="btn btn-success">Buy</button></a></td>--%>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
