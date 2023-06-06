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
    int idProp = (int) request.getAttribute("id_prop");
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("id_prop",idProp);
%>
    <nav class="navbar navbar-expand-lg bg-nav">
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

<div class="w-50 mx-auto">
    <h3 class="mt-4 text-center">Propiedades Horizontales</h3>
    <img class="mt-xl-4" style="width: 100%" src="https://resource.rentcafe.com/image/upload/q_auto,f_auto/s3/3/500300/p0509969wacaba2e.jpg">
    <footer class="mt-4 bg-light text-center text-lg-start"><div class="text-center p-3" style="background-color: #ffdfd0">© 2022 Copyright - UPTC</div></footer>
</div>

</body>
</html>
