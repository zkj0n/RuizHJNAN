<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="update"/>
    </c:import>
</head>
<body>
<c:import url="/INC/header.jsp"/>
<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center mb-4">actualizar</h1>

    <form action="Update" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-75">
        <div class="row">
            <div class="col-12">
                <h3 class="fw-bold text-center mb-3">profesor</h3>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="profesor" placeholder="profesor" name="nombre" value="${sessionScope.profesor.nombre}" required>
                    <input type="hidden" name="id" value="${sessionScope.profesor.id}">
                    <label for="profesor">nombre del profesor</label>
                </div>
            </div>

            <div class="col-12">
                <h3 class="fw-bold text-center mb-3">módulos existentes</h3>
                <c:set var="i" value="0"/>
                <c:forEach var="modulo" items="${sessionScope.modulos}" varStatus="i" begin="0">
                    <div class="row mb-2">
                        <label class="col-sm-2 col-form-label" for="modulo-${i.index}">módulo ${i.index + 1}:</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" placeholder="ingresa un nuevo módulo" name="modulosInput" value="${modulo.titulo}">
                            <input type="hidden" name="modulosSelect" value="${modulo.id}-${modulo.titulo}">
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="col-12">
                <h3 class="fw-bold text-center mb-3">agregar módulos</h3>
                <c:set var="start" value="${sessionScope.modulos.size() + 1}"/>
                <c:set var="remaining" value="${5 - sessionScope.modulos.size()}"/>
                <c:forEach var="i" begin="${start}" end="${start + remaining - 1}">
                    <div class="row mb-2">
                        <label class="col-sm-2 col-form-label" for="modulo-${i}">módulo ${i}:</label>
                        <div class="col-sm-5">
                            <select class="form-select" name="modulosSelect" id="modulo-${i}">
                                <option selected disabled>selecciona un módulo</option>
                                <c:forEach var="modulo" items="${requestScope.modulosNoTiene}">
                                    <option value="${modulo.id}-${modulo.titulo}">${modulo.titulo}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" placeholder="ingresa un nuevo módulo" name="modulosInput">
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <button class="btn btn-primary w-25 mt-3" type="submit" name="accion" value="update">
            actualizar
        </button>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
