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
    int idProp = (int) httpSession.getAttribute("id_prop");
    httpSession.setAttribute("id_prop",idProp);
%>
<nav class="navbar navbar-expand-lg bg-nav mb-4">
    <a class="navbar-brand" href="#">Propietario</a>
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">
                        Reservaciones
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="registrarReservacionProp.jsp">Registrar</a></li>
                        <li><a class="dropdown-item" href="consultarDisponibilidadReservacionProp.jsp">Consultar disponibilidad</a></li>
                        <li><a class="dropdown-item" href="calcularPrecioReservacionProp.jsp">Calcular valor</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Salir</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<form action="ConsultarDisponibilidadReservacionProp" method="post" class="w-50 mx-auto">
    <label>Espacio</label>
    <select name="name" class="w-100 browser-default custom-select">
        <option value="Salon">Salon</option>
        <option value="Cancha deportiva">Cancha deportiva</option>
        <option value="Salon de baile">Salon de baile</option>
    </select>

    <label>Fecha</label>
    <input required type="datetime-local" class="form-control mb-4" name="date">

    <label>Numero Horas</label>
    <input required type="number" class="form-control mb-4" name="number" placeholder="horas">

    <button type="submit" class="cursor-pointer mb-4 btn mx-auto bg-dark text-white">Consultar</button>
    <%out.print("<input style=\"visibility: hidden;\" value=\""+idProp+"\" name=\"id_prop\"</input>");%>
    <%
        int error = 0;
        try{error = (int) request.getAttribute("error");}catch (Exception e){}
        if (error == -1){out.print("<div class=\"alert alert-danger\" role=\"alert\">Espacio no disponible</div>\n");}
        if (error == -2){out.print("<div class=\"alert alert-primary\" role=\"alert\">Espacio disponible</div>\n");}
    %>
</form>

</body>
</html>
