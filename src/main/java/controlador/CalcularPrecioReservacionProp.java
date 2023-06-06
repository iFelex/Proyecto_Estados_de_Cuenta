package controlador;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcularPrecioReservacionProp implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        short numberHours = Short.parseShort(request.getParameter("number"));
        EntityManager entityManager = new EntityManager();
        int valueReservation = entityManager.getValueReservation(numberHours);
        request.setAttribute("value", valueReservation);
        request.getRequestDispatcher("calcularPrecioReservacionProp.jsp").forward(request, response);
        return null;
    }
}
