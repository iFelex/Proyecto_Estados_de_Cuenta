<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style><%@include file="/styles/bootstrap_styles.css"%></style>
    <style><%@include file="/styles/styles.css"%></style>
    <title>Proyecto Final - Propiedades Horizontales</title>
</head>
<body>

    <div class="login-reg-panel">
        <div class="login-info-box">
            <h2>Have an account?</h2>
            <p>Lorem ipsum dolor sit amet</p>
            <label id="label-register" for="log-reg-show">Login</label>
            <input type="radio" name="active-log-panel" id="log-reg-show"  checked="checked">
        </div>

        <form action="Log_in" method="post">
            <div class="white-panel">
                <div class="login-show show-log-panel">
                    <h2 class="text-center">Administrador de Propiedades Horizontales</h2>
                    <input type="text" placeholder="User" name="user">
                    <input type="password" placeholder="Password" name="password">
                    <input class="mb-3" type="submit" value="Log In">
                </div>
                <%
                    int error = 0;
                    try{error = (int) request.getAttribute("error");}catch (Exception e){}
                    if (error == -1){out.print("<div class=\"alert alert-danger\" role=\"alert\">Login invalido - Datos ingresados incorrectos</div>\n");}
                %>
            </div>
        </form>
    </div>
</body>
</html>
