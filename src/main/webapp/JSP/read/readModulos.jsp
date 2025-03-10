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
<h1 class="fw-bold text-center mb-4">leer modulos</h1>
<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75 table">
        <thead class="table-secondary">
        <tr>
            <th>modulo</th>
            <th>profesores que lo imparten</th>
        </tr>
        </thead>
        <tbody class="table-primary">
        <c:forEach var="m" items="${requestScope.modulos}">
            <tr>
                <td class="align-middle">${m.titulo}</td>
                <td class="d-flex flex-column">
                    <c:if test="${empty m.profesores}">
                        <span>ningún profesor imparte este módulo</span>
                    </c:if>
                    <c:forEach var="profesor" items="${m.profesores}">
                        <span>${profesor.nombre}</span>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>