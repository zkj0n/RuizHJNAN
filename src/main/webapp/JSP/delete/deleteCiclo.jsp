<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="readone"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>

<main class="d-flex justify-content-center flex-column align-items-center mt-5 p-3">
    <h1 class="fw-bold text-center">confirmación de los datos a eliminar</h1>
    <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75 table">
        <thead class="table-secondary">
        <tr>
            <th>ciclo</th>
            <th>módulos</th>
        </tr>
        </thead>
        <tbody class="table-primary">
        <tr>
            <td>${requestScope.c.nombre}</td>
            <td>
                <c:forEach var="modulo" items="${requestScope.c.modulos}">
                    <div>${modulo.denominacion}</div>
                </c:forEach>
            </td>
        </tr>
        </tbody>
    </table>
    <form action="DeleteCiclo" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50">
        <input type="hidden" name="id" value="${requestScope.c.idCiclo}"/>
        <button class="btn btn-danger w-100 mt-3" type="submit">
            eliminar definitivamente
        </button>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>