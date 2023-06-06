package controlador;

import modelo.Obligacion;
import modelo.Residente;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CargarObligacionResidente implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String doc = request.getParameter("document");
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        String desc_receipt = request.getParameter("description");
        Double value = Double.valueOf(request.getParameter("value"));
        EntityManager entityManager = new EntityManager();
        Boolean exist = entityManager.existeResidente(doc,idAdmin);
        if(exist){
            Residente residente = entityManager.getResidente(doc,idAdmin);
            Obligacion obligacion = new Obligacion(desc_receipt,value);
            obligacion.setObl_res(residente);
            entityManager.agregarObligacion(obligacion);
            request.setAttribute("id_admin", idAdmin);
            request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("cargarObligacionResidente.jsp").forward(request, response);
        }
        return null;
    }
}
