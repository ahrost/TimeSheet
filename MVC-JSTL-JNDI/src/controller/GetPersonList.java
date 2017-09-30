package controller;

import model.bl.Manager;
import model.bl.ManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetPersonList  extends HttpServlet {
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException,ServletException {
        Manager manager=new ManagerImpl();
        try {
            httpServletRequest.setAttribute("list",manager.getPersonList());
            httpServletRequest.getRequestDispatcher("getPersonList.jsp").forward(httpServletRequest,httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}