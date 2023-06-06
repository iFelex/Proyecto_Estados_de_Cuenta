package controlador;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsultarDisponibilidadReservacion implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        String name = (String) request.getParameter("name");
        String date = (String) request.getParameter("date");
        EntityManager entityManager = new EntityManager();
        String strDate = date.replace("T", " ");
        Date dateFormat = new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(strDate).getTime());
        boolean available = entityManager.reservacionDisponible(idAdmin,dateFormat,name);
        if (available){
            request.setAttribute("error", -2);
            request.getRequestDispatcher("consultarDisponibilidadReservacion.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("consultarDisponibilidadReservacion.jsp").forward(request, response);
        }
        return null;
    }
}
