<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="crear"/>
    </c:import>
</head>
<body>
<c:import url="/INC/header.jsp"/>
<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center mb-4">crear</h1>

    <form action="Create" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75">
        <div class="row">
            <div class="col-md-6">
                <h2 class="fw-bold text-center mb-3">ciclo</h2>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="nombreCiclo" placeholder="nombreCiclo" name="nombre" required>
                    <label for="nombreCiclo">nombre del ciclo</label>
                </div>
            </div>

            <div class="col-md-6">
                <h2 class="fw-bold text-center mb-3">módulos</h2>

                <div id="modulosContainer">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="denominacionModulo1" placeholder="denominacionModulo1" name="denominacion">
                        <label for="denominacionModulo1">denominación del módulo</label>

                    </div>
                </div>

                <button type="button" class="btn btn-outline-secondary w-100 mt-3" onclick="addModuloField()">agregar módulo</button>
            </div>
        </div>

        <button class="btn btn-outline-primary w-100 mt-3" type="submit">
            crear
        </button>

        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger mt-3" role="alert">
                    ${requestScope.error}
            </div>
        </c:if>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

<script src="${applicationScope.contexto}/JS/fields.js"></script>
</body>
</html>