package controlador;

import modelo.Administrador;
import modelo.Residente;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarResidente implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        String document = request.getParameter("doc");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        EntityManager entityManager = new EntityManager();
        Administrador administrador = entityManager.getAdmin(idAdmin);
        Residente residente = new Residente(document,name,tel,address,administrador);
        Residente existResident = entityManager.existResident(document,idAdmin);

        if (existResident != null){
            residente.setIdResident(existResident.getIdResident());
            entityManager.modificarResidente(residente);
            request.setAttribute("id_admin",idAdmin);
            request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.setAttribute("id_resident", document);
            request.getRequestDispatcher("modificarResidente.jsp").forward(request, response);
        }
        return null;
    }
}
