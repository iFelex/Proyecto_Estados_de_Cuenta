package controlador;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectModResident implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String doc = request.getParameter("document");
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        EntityManager entityManager = new EntityManager();
        Boolean exist = entityManager.existeResidente(doc,idAdmin);
        if(exist){
            request.setAttribute("id_resident", doc);
            request.getRequestDispatcher("modificarResidente.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("selectModResident.jsp").forward(request, response);
        }
        return null;
    }
}
