<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 29/06/2022
  Time: 02:31 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Pokemons</title>
    <jsp:include page="../../templates/head.jsp"/>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
</head>
<body>
    <jsp:include page="../../templates/navbar.jsp"/>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <c:if test="${param['result']}">
                    <p><c:out value="${param['message']}"></c:out></p>
                </c:if>
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">POKEMONS</div>
                        <div class="col-6 text-end">
                            <a href="create-pokemon" class="btn btn-outline-success btn-sm">Registrar pokemon</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-sm table-hover">
                        <thead>
                        <th>#</th>
                        <th>Pokemon</th>
                        <th>Health</th>
                        <th>Power</th>
                        <th>Weight</th>
                        <th>Height</th>
                        <th>Type</th>
                        </thead>
                        <tbody>
                        <c:forEach var="pokemon" items="${pokemons}" varStatus="status">
                            <tr>
                                <td>
                                    <c:out value="${status.count}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.name}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.health}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.power}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.weight}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.height}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.pokemonType}"></c:out>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="../../templates/footer.jsp"/>
</body>
</html>
