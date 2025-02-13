<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="actualizar ciclo"/>
    </c:import>
</head>
<body>
<c:import url="/INC/header.jsp"/>
<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center mb-4">change</h1>

    <c:if test="${requestScope.c != null}">
        <form action="Change" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75">

            <input type="hidden" name="id" value="${requestScope.c.idCiclo}"/>

            <div class="row">
                <div class="col-md-6">
                    <h2 class="fw-bold text-center mb-3">Ciclo</h2>

                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="nombreCiclo" placeholder="nombreCiclo" name="nombre" value="${requestScope.c.nombre}" required>
                        <label for="nombreCiclo">Nombre del Ciclo</label>
                    </div>
                </div>

                <div class="col-md-6">
                    <h2 class="fw-bold text-center mb-3">Módulos</h2>

                    <div id="modulosContainer">
                        <c:forEach var="modulo" items="${requestScope.c.modulos}" varStatus="i">
                            <div class="form-floating mb-3">
                                <input type="hidden" name="idModulo" value="${modulo.idModulo}">
                                <input type="text" class="form-control" id="denominacionModulo${i.index}" placeholder="denominacionModulo${i.index}" name="denominacion" value="${modulo.denominacion}" required>
                                <label for="denominacionModulo${i.index}">denominación del módulo</label>
                            </div>
                        </c:forEach>
                    </div>

                    <button type="button" class="btn btn-outline-secondary w-100 mt-3" onclick="addModuloField(${requestScope.c.modulos.size()})">Agregar Módulo</button>
                </div>
            </div>

            <button class="btn btn-outline-primary w-100 mt-3" type="submit">
                actualizar
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

<script src="${applicationScope.contexto}/JS/fields.js"></script>
</body>
</html>