<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="Eliminar Módulo"/>
    </c:import>
</head>
<body>
<c:import url="/INC/header.jsp"/>
<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center mb-4">eliminar módulo de
        <span class="text-danger">${requestScope.c.nombre}</span>
    </h1>

    <c:if test="${requestScope.c != null}">
        <form action="DeleteModulo" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75">
            <input type="hidden" name="idCiclo" value="${requestScope.c.idCiclo}"/>

            <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-100 table">
                <thead class="table-secondary">
                <tr>
                    <th>elige</th>
                    <th>denominación del módulo</th>
                </tr>
                </thead>
                <tbody class="table-primary">
                <c:forEach items="${requestScope.c.modulos}" var="modulo" varStatus="i" begin="0">
                    <c:if test="${not empty modulo.denominacion}">
                        <tr>
                            <td>
                                <label>
                                    <input type="radio" name="idModulo" value="${modulo.idModulo}" ${ i.index == 0 ? 'checked' : '' }>
                                </label>
                            </td>
                            <td>${modulo.denominacion}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>

            <button class="btn btn-danger w-100 mt-3" type="submit">
                eliminar módulo
            </button>
        </form>
    </c:if>

    <c:if test="${requestScope.error != null}">
        <div class="alert alert-danger mt-3" role="alert">
                ${requestScope.error}
        </div>
    </c:if>
</main>

<c:import url="/INC/footer.jsp"/>
</body>
</html>