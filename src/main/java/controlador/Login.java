package controlador;

import modelo.Administrador;
import modelo.Propietario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        EntityManager entityManager = new EntityManager();
        Administrador admin = entityManager.getAdmin(user);
        Propietario propietario = entityManager.getPropietario(user);

        if (admin != null){
            if (user.equals(admin.getUserAdm()) && password.equals(admin.getPasswordAdm())){
                request.setAttribute("id_admin",admin.getIdAdm());
                request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
            }
        }else if(propietario != null){
            if (user.equals(propietario.getUserProp()) && password.equals(propietario.getPasswordProp())){
                request.setAttribute("id_prop",propietario.getIdProp());
                request.getRequestDispatcher("homeProp.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        return null;
    }
}
