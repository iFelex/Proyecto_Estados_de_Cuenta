package controlador;

import modelo.Obligacion;
import modelo.ReciboCobro;
import modelo.Residente;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import persistencia.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GenerarReciboPago implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        String doc_resident = request.getParameter("document");
        String name_ph = request.getParameter("namePH");
        String address_ph = request.getParameter("addressPH");
        String tel_admin = request.getParameter("tel");
        String desc_receipt = request.getParameter("description");
        Double value = Double.valueOf(request.getParameter("value"));
        String date_pay = request.getParameter("fecha");
        String agreement = request.getParameter("acuerdo");
        EntityManager entityManager = new EntityManager();
        boolean exist = entityManager.existeResidente(doc_resident,idAdmin);

        if(exist){
            Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date_pay).getTime());
            Double pending_value = value;
            Residente residente = entityManager.getResidente(doc_resident,idAdmin);
            ReciboCobro recibo = new ReciboCobro(name_ph,address_ph,tel_admin,desc_receipt,value,date,"Pendiente",agreement,pending_value);
            recibo.setRes_rec(residente);
            Obligacion obligacion = new Obligacion(desc_receipt,value);
            List<Obligacion> obligacions = residente.getObligaciones();
            obligacions.add(obligacion);
            residente.setObligaciones(obligacions);
            entityManager.agregarRecibo(recibo);
            entityManager.modificarResidente(residente);
            request.setAttribute("id_admin",idAdmin);
            request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
        }else {
            request.setAttribute("error", -1);
            request.getRequestDispatcher("generarReciboPago.jsp").forward(request, response);
        }

        return null;
    }
}
