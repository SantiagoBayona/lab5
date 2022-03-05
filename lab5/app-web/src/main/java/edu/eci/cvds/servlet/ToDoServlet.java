package edu.eci.cvds.servlet;
import edu.eci.cvds.servlet.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(
        urlPatterns = "/todoServlet"
)

public class ToDoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
        int n = optId.isPresent() && !optId.get().isEmpty() ? Integer.parseInt(optId.get()) : 0 ;
        Todo t = Service.getTodo(n);

    }

}
