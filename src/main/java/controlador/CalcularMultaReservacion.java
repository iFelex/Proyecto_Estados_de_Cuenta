package controlador;

import modelo.Reservacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcularMultaReservacion implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        int idRes = Integer.parseInt(request.getParameter("id_res"));
        EntityManager entityManager = new EntityManager();
        Reservacion reservacion = entityManager.getReservacion(idAdmin,idRes);
        int multa = (entityManager.getMulta(reservacion));
        request.setAttribute("multa", multa);
        request.getRequestDispatcher("calcularMultaReservacion.jsp").forward(request, response);
        return null;
    }
}
