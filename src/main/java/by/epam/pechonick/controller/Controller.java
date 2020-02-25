package by.epam.pechonick.controller;

//import by.epam.pechonick.command.Command;
//import by.epam.pechonick.command.factory.CommandFactory;
//import by.epam.pechonick.content.RequestContent;
//import by.epam.pechonick.exception.CommandException;
import by.epam.pechonick.command.Command;
import by.epam.pechonick.command.factory.CommandFactory;
import by.epam.pechonick.content.RequestContent;
import by.epam.pechonick.exception.CommandException;
import by.epam.pechonick.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

@WebServlet("/controller")
public class Controller extends HttpServlet {
  private static final Logger LOGGER = LogManager.getLogger();


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    super.doGet(request, response);
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    super.doPost(request, response);
    processRequest(request,response);
  }

  @Override
  public void destroy() {
    super.destroy();
    if (ConnectionPool.isInitialized()) {
      ConnectionPool.getInstance().closeAll();
    }
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
//    RequestContent requestContent = new RequestContent(request);
//    Command command = CommandFactory.defineCommand(requestContent);
//    String page = null;
//    try {
//      page = command.execute(requestContent);
//    } catch (CommandException e) {
//      LOGGER.error("Error while trying to execute command ", e);
//    }
//
//    requestContent.insertValues(request);
//    getServletContext().getRequestDispatcher(page).forward(request, response);
//
    GregorianCalendar gc = new GregorianCalendar();
    String timeJsp = request.getParameter("time");
    float delta = ((float)(gc.getTimeInMillis()- Long.parseLong(timeJsp)))/1_000;
    request.setAttribute("res", delta);
    request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
  }
}
