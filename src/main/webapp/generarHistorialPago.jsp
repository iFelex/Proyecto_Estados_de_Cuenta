<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/styles/bootstrap_styles.css"%></style>
    <style><%@include file="/styles/styles.css"%></style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>Proyecto Final - Propiedades Horizontales</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    int idAdmin = (int) httpSession.getAttribute("id_admin");
    httpSession.setAttribute("id_admin",idAdmin);
%>
<nav class="navbar navbar-expand-lg bg-nav mb-4">
    <a class="navbar-brand" href="#">Admin</a>
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#" >
                        Residentes
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="agregarResidente.jsp">Agregar</a></li>
                        <li><a class="dropdown-item" href="selectModResident.jsp">Modificar</a></li>
                        <li><a class="dropdown-item" href="generarReciboPago.jsp">Generar recibo</a></li>
                        <li><a class="dropdown-item" href="cargarObligacionResidente.jsp">Cargar Obligaciones</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">
                        Propietarios
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="generarHistorialPago.jsp">Generar historial de pago</a></li>
                        <li><a class="dropdown-item" href="generarPaz&Salvo.jsp">Generar paz y salvo</a></li>
                        <li><a class="dropdown-item" href="cambiarEstadoCuenta.jsp">Cambiar estado de cuenta</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">
                        Reservaciones
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="registrarReservacion.jsp">Registrar</a></li>
                        <li><a class="dropdown-item" href="consultarDisponibilidadReservacion.jsp">Consultar disponibilidad</a></li>
                        <li><a class="dropdown-item" href="calcularPrecioReservacion.jsp">Calcular valor</a></li>
                        <li><a class="dropdown-item" href="calcularMultaReservacion.jsp">Calcular multa</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Salir</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<form action="GenerarHistorialPago" method="post" class="w-50 mx-auto">
    <%
        int error = 0;
        try{error = (int) request.getAttribute("error");}catch (Exception e){}
        if (error == -1){out.print("<div class=\"alert alert-danger\" role=\"alert\">Documento invalido</div>\n");}
    %>
    <label>Documento del residente</label>
    <input required type="number" class="form-control mb-4" name="document" placeholder="documento">

    <label>Periodo pagado</label>
    <input required type="text" class="form-control mb-4" name="periodoPago" placeholder="mes/año">

    <label>Valor del pago</label>
    <input required type="number" class="form-control mb-4" name="value" placeholder="valor">

    <label>Descripcion Pago</label>
    <textarea required class="form-control mb-4" name="description" rows="3" placeholder="Descripcion"></textarea>

    <button type="submit" class="cursor-pointer mb-4 btn mx-auto bg-dark text-white">Generar historial</button>
    <%out.print("<input style=\"visibility: hidden;\" value=\""+idAdmin+"\" name=\"id_admin\"</input>");%>
</form>
</body>
</html>
