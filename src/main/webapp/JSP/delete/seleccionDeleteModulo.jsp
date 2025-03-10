<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="eliminar modulo"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>

<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center">eliminar módulo</h1>

    <form action="Delete" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50">
        <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-100 table">
            <thead class="table-secondary">
            <tr>
                <th>elige</th>
                <th>nombre del módulo</th>
            </tr>
            </thead>
            <tbody class="table-primary">
            <c:forEach items="${requestScope.modulos}" var="m" varStatus="i">
                <tr>
                    <td>
                        <label>
                            <input type="radio" name="idModulo" value="${m.id}" ${ i.index == 0 ? 'checked' : '' }>
                        </label>
                    </td>
                    <td>${m.titulo}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <button class="btn btn-outline-primary w-100" type="submit" value="eliminar modulo" name="accion">
            eliminar
        </button>

    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>