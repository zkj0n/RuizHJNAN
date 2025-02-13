<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="read"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4">read</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <c:if test="${requestScope.ciclos.size() > 0}">

        <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75 table">
            <thead class="table-secondary">
            <tr>
                <th>ciclo</th>
                <th>módulos</th>
            </tr>
            </thead>
            <tbody class="table-primary">
            <c:forEach items="${requestScope.ciclos}" var="c">
                <tr>
                    <td class="align-middle">${c.nombre}</td>
                    <td>
                        <c:if test="${c.modulos.size() > 0}">
                            <c:forEach var="modulo" items="${c.modulos}">
                                <div>${modulo.denominacion}</div>
                            </c:forEach>
                        </c:if>
                        <c:if test="${c.modulos.size() == 0}">
                            <div class="text-danger">este ciclo aún no tiene modulos</div>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${requestScope.ciclos.size() == 0}">
        <div class="text-center fs-3 bg-danger text-white p-3 rounded-3 shadow-lg w-75">
            no hay datos en la base de datos
        </div>
    </c:if>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>