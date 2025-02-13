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

            <button type="submit" name="accion" value="read" class="btn btn-outline-info" title="read">
                <i class="fas fa-list fs-2"></i>
            </button>

            <button type="submit" name="accion" value="create" class="btn btn-outline-primary" title="create">
                <i class="fas fa-plus fs-2"></i>
            </button>

            <button type="submit" name="accion" value="update" class="btn btn-outline-warning" title="update">
                <i class="fas fa-file-signature fs-2"></i>
            </button>

            <button type="submit" name="accion" value="delete" class="btn btn-outline-danger" title="delete">
                <i class="fas fa-trash-alt fs-2"></i>
            </button>

    </form>

</header>
