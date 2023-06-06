package controlador;

import modelo.Propietario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class GenerarPaz_y_Salvo implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int doc = Integer.parseInt(request.getParameter("document"));
        EntityManager entityManager = new EntityManager();
        Boolean exist = entityManager.existePropietario(doc);
        if(exist){
            Propietario propietario = entityManager.getPropietario(doc);
            if (propietario.valueObligations() == 0.0){
                String date = String.valueOf(LocalDate.now());
                request.setAttribute("name",propietario.getNameProp());
                request.setAttribute("address",propietario.getAdressProp());
                request.setAttribute("date",date);
                request.getRequestDispatcher("mostrarPaz&Salvo.jsp").forward(request, response);
            }else {
                request.setAttribute("error", -2);
                request.getRequestDispatcher("generarPaz&Salvo.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("generarPaz&Salvo.jsp").forward(request, response);
        }
        return null;
    }
}
