<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>

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
                    <a class="nav-link" href="/admin">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/merchants">Merchants</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/products">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/orders">Orders</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link disabled" href="/merchants">Hii <%=session.getAttribute("name")%></a>
                </li>


            </ul>

            <form class="form-inline my-2 my-lg-0" action="/admin/search" method="get">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
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
            <th scope="col">Customer Name</th>
            <th scope="col">Customer ID</th>
            <th scope="col">Product Name</th>
            <th scope="col">Product ID</th>
            <th scope="col">Order Count</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.orderList}" var="order">
            <tr>
                <td scope="col"><c:out value="${order.customer.name}" /></td>
                <td scope="col"><c:out value="${order.customer.id}" /></td>
                <td scope="col"><c:out value="${order.product.name}" /></td>
                <td scope="col"><c:out value="${order.merchant.id}" /></td>
                <td scope="col"><c:out value="${order.count}" /></td>
                    <%--                <td scope="col"><a href="<c:url value="/deleteProduct=${product.productID}"/> ><button type="button" class="btn btn-danger">Delete</button><td>--%>
            </tr>
        </c:forEach>
    </table>
</div></body>
</html>
