package controlador;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcularPrecioReservacion implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = (String) request.getParameter("name");
        String date = (String) request.getParameter("date");
        short number = Short.parseShort(request.getParameter("number"));
        EntityManager entityManager = new EntityManager();
        int value = entityManager.getValueReservation(number);
        request.setAttribute("value", value);
        request.getRequestDispatcher("calcularPrecioReservacion.jsp").forward(request, response);
        return null;
    }
}
