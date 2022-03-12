package edu.eci.cvds.servlet;
import edu.eci.cvds.servlet.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@WebServlet(
        urlPatterns = "/todoServlet"
)

public class ToDoServlet extends HttpServlet{

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            int n = optId.isPresent() && !optId.get().isEmpty() ? Integer.parseInt(optId.get()) : 0;
            Todo t = Service.getTodo(n);
            resp.setStatus(HttpServletResponse.SC_OK);
            ArrayList<Todo> todos = new ArrayList<>();
            todos.add(t);
            responseWriter.write(Service.todosToHTMLTable(todos));
        }catch (FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            int n = optId.isPresent() && !optId.get().isEmpty() ? Integer.parseInt(optId.get()) : 0;
            Todo t = Service.getTodo(n);
            resp.setStatus(HttpServletResponse.SC_OK);
            ArrayList<Todo> todos = new ArrayList<>();
            todos.add(t);
            responseWriter.write(Service.todosToHTMLTable(todos));
        }catch (FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }catch (NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
