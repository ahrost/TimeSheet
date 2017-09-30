package controller;


import model.bl.Manager;
import model.bl.ManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPerson extends HttpServlet {
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException,ServletException {
        if (httpServletRequest.getParameter("name")!=null && !httpServletRequest.getParameter("name").equals("") )
        {
          Manager manager=new ManagerImpl();
            try {
               long id= manager.registerPerson(httpServletRequest.getParameter("name"));
                httpServletRequest.getSession().setAttribute("id",id);
                httpServletResponse.sendRedirect("registerPersonResponse.jsp");
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        else
        {
            httpServletResponse.sendRedirect("registerPersonError.jsp");
        }
    }
}
