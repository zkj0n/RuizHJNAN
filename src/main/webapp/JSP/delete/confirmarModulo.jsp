<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="confirmar modulo"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>
<h1 class="fw-bold text-center mb-4">confirmar modulos</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <form method="post" action="Delete">

        <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75 table">
            <thead class="table-secondary">
            <tr>
                <th>id</th>
                <th>modulo</th>
                <th>profesores que lo imparten</th>
            </tr>
            </thead>
            <tbody class="table-primary">
            <tr>
                <td class="align-middle fw-bold">${sessionScope.modulo.id}</td>
                <td class="align-middle">${sessionScope.modulo.titulo}</td>
                <td class="d-flex flex-column">
                    <c:if test="${empty sessionScope.modulo.profesores}">
                        <span>ningún profesor imparte este módulo</span>
                    </c:if>
                    <c:forEach var="profesor" items="${sessionScope.modulo.profesores}">
                        <span>${profesor.nombre}</span>
                    </c:forEach>
                </td>
            </tr>
            </tbody>
        </table>
        <button class="btn btn-outline-primary w-100 mt-3" type="submit" value="eliminar modulo confirmado" name="accion">
            eliminar definitivamente
        </button>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>