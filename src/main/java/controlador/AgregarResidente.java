package controlador;

import modelo.Administrador;
import modelo.Residente;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgregarResidente implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        String document = request.getParameter("document");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        EntityManager entityManager = new EntityManager();
        boolean exist = entityManager.existeResidente(document,idAdmin);
        if (!exist){
            Administrador admin = entityManager.getAdmin(idAdmin);
            Residente resident = new Residente(document,name,tel,address,admin);
            entityManager.agregarResidente(resident);
            request.setAttribute("id_admin",admin.getIdAdm());
            request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("agregarResidente.jsp").forward(request, response);
        }
        return null;
    }
}
