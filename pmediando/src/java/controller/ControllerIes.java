package controller;

import dao.CadastroIesDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CadastroIes;

@WebServlet(name = "medController", urlPatterns = {"/ControllerIes"})
public class ControllerIes extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "user.jsp";
    private static String LIST_USER = "ListAll.jsp";
    private CadastroIesDao dao;

    public ControllerIes() {
        super();
        dao = new CadastroIesDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int userId = Integer.parseInt(request.getParameter("userid"));
            dao.deleteIes(userId);
            forward = LIST_USER;
            request.setAttribute("Ies", dao.getAllIes());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userid"));
            CadastroIes cad = dao.getIesById(userId);
            request.setAttribute("ies", cad);
        } else if (action.equalsIgnoreCase("ListAll")) {
            forward = LIST_USER;
            request.setAttribute("Ies", dao.getAllIes());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CadastroIes cad = new CadastroIes();
        cad.setCod_ies(Integer.parseInt(request.getParameter("cod_ies")));
        cad.setRazao_social(request.getParameter("razao_social"));
        cad.setCnpj(request.getParameter("cnpj"));
        cad.setEndereco(request.getParameter("endereco"));
        cad.setEmail(request.getParameter("email"));
        cad.setSenha(request.getParameter("senha"));
        String userid = request.getParameter("userid");
        if (userid == null || userid.isEmpty()) {
            dao.addIes(cad);
        } else {
            cad.setUserid(Integer.parseInt(userid));
            dao.updateIes(cad);
        }
        //RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        //request.setAttribute("Ies", dao.getAllIes());
        //view.forward(request, response);
        response.sendRedirect(request.getContextPath()+"/index.html");
    }
}
