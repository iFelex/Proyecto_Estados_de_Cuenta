package controlador;

import modelo.Pago;
import modelo.Propietario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerarHistorialPago implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        int doc = Integer.parseInt(request.getParameter("document"));
        String periodPaid = request.getParameter("periodoPago");
        Double valuePayment = Double.valueOf(request.getParameter("value"));
        String descPayment = request.getParameter("description");
        EntityManager entityManager = new EntityManager();
        Boolean exist = entityManager.existePropietario(doc);
        if(exist){
            Propietario propietario = entityManager.getPropietario(doc);
            String address = propietario.getAdressProp();
            Double valueDue = valuePayment;
            Pago payment = new Pago(address,periodPaid,descPayment,valuePayment,valueDue,propietario);
            entityManager.agregarHistorialPago(payment);
            request.setAttribute("id_admin",idAdmin);
            request.setAttribute("historialPago",payment);
            request.getRequestDispatcher("mostrarHistorialPago.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("generarHistorialPago.jsp").forward(request, response);
        }

        return null;
    }
}
