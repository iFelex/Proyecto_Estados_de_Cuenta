package controlador;

import modelo.Propietario;
import modelo.Reservacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrarReservacion implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        int doc = Integer.parseInt(request.getParameter("document"));
        String name = (String) request.getParameter("name");
        String date = (String) request.getParameter("date");
        short number = Short.parseShort(request.getParameter("number"));
        EntityManager entityManager = new EntityManager();
        Boolean exist = entityManager.existePropietario(doc);
        if(exist){
            Propietario propietario = entityManager.getPropietario(doc);
            String address = propietario.getAdressProp();
            String strDate = date.replace("T", " ");
            Date dateFormat = new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(strDate).getTime());
            int valueReservation = entityManager.getValueReservation(number);
            Reservacion reservacion = new Reservacion(address,name,dateFormat,number, (double) valueReservation);
            reservacion.setRes_pro(propietario);
            boolean existRes = entityManager.existeReservacion(idAdmin,name,dateFormat);
            if (!existRes) {
                entityManager.agregarReservacion(reservacion);
                request.setAttribute("id_admin",idAdmin);
                request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
            }else {
                request.setAttribute("error", -2);
                request.getRequestDispatcher("registrarReservacion.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("registrarReservacion.jsp").forward(request, response);
        }
        return null;
    }
}
