<header class="header d-flex justify-content-between align-items-center shadow bg-white position-sticky top-0" style="min-height: 15vh">

    <form action="FrontController" method="post">
        <button type="submit" name="accion" value="home" class="border-0 bg-white">
            <img src="${pageContext.servletContext.contextPath}/IMG/logo.png" alt="logotipo" height="150px"/>
        </button>
    </form>

    <form action="FrontController" method="post" class="p-4">

            <button type="submit" name="accion" value="home" class="btn btn-outline-success" title="inicio">
                <i class="fas fa-home fs-2"></i>
            </button>

            <button type="button" class="btn btn-outline-info" data-bs-toggle="collapse" data-bs-target="#collapseRead" aria-expanded="false" aria-controls="collapseRead" title="read">
                <i class="fas fa-list fs-2"></i>
            </button>

            <button type="submit" name="accion" value="create" class="btn btn-outline-primary" title="create">
                <i class="fas fa-plus fs-2"></i>
            </button>

            <button type="submit" name="accion" value="update" class="btn btn-outline-warning" title="update">
                <i class="fas fa-file-signature fs-2"></i>
            </button>

            <button type="button" class="btn btn-outline-danger" data-bs-toggle="collapse" data-bs-target="#collapseDelete" aria-expanded="false" aria-controls="collapseDelete" title="delete">
                <i class="fas fa-trash-alt fs-2"></i>
            </button>

            <div class="collapse" id="collapseRead">
                <div class="d-flex flex-column mt-2">
                    <button type="submit" name="accion" value="read profesores" class="btn btn-outline-info mb-2" title="read profesores">
                        leer profesores
                    </button>
                    <button type="submit" name="accion" value="read modulos" class="btn btn-outline-info" title="read modulos">
                        leer m&oacute;dulos
                    </button>
                </div>
            </div>
            <div class="collapse" id="collapseDelete">
                <div class="d-flex flex-column mt-2">
                    <button type="submit" name="accion" value="delete profesor" class="btn btn-outline-danger mb-2" title="delete profesor">
                        eliminar profesor
                    </button>
                    <button type="submit" name="accion" value="delete modulo" class="btn btn-outline-danger" title="delete modulo">
                        eliminar m&oacute;dulo
                    </button>
                </div>
            </div>

    </form>

</header>
