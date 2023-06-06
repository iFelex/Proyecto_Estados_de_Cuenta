package controlador;

import modelo.Propietario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CambiarEstadoCuenta implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        int doc = Integer.parseInt(request.getParameter("document"));
        String state = (String) request.getParameter("state");
        EntityManager entityManager = new EntityManager();
        Boolean exist = entityManager.existePropietario(doc);
        if(exist){
            Propietario propietario = entityManager.getPropietario(doc);
            entityManager.changeStateOwner(propietario,state);
            request.setAttribute("id_admin",idAdmin);
            request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("cambiarEstadoCuenta.jsp").forward(request, response);
        }
        return null;
    }
}
