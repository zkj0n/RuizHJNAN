<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="actualizar"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>

<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center">eliminar</h1>

    <form action="Delete" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50">
        <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-100 table">
            <c:if test="${requestScope.ciclos.size() > 0}">
                <thead class="table-secondary">
                <tr>
                    <th>elige</th>
                    <th>nombre del ciclo</th>
                </tr>
                </thead>
                <tbody class="table-primary">
                <c:forEach items="${requestScope.ciclos}" var="c" varStatus="i">
                    <tr>
                        <td>
                            <label>
                                <input type="radio" name="codigo" value="${c.idCiclo}" ${ i.index == 0 ? 'checked' : '' }>
                            </label>
                        </td>
                        <td>${c.nombre}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
            <c:if test="${requestScope.ciclos.size() == 0}">
                <tbody class="table-danger">
                <tr>
                    <td colspan="2" class="text-center fs-3">no hay ciclos</td>
                </tr>
                </tbody>
            </c:if>
        </table>
        <c:if test="${requestScope.ciclos.size() > 0}">
            <div class="d-flex justify-content-between mt-3">
                <button class="btn btn-danger w-25 " name="accion" type="submit" value="ciclo">
                    eliminar ciclo
                </button>
                <button class="btn btn-warning w-25" name="accion" type="submit" value="modulo">
                    eliminar modulo
                </button>
            </div>
        </c:if>
        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger mt-3" role="alert">
                    ${requestScope.error}
            </div>
        </c:if>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
