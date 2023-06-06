package controlador;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoHome implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idAdmin = Integer.parseInt(request.getParameter("id_admin"));
        request.setAttribute("id_admin",idAdmin);
        request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
        return null;
    }
}
