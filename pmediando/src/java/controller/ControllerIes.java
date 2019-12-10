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
    private static String INSERT_OR_EDIT = "ies.jsp";
    private static String LIST_All = "ListAll.jsp";
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
            int iesId = Integer.parseInt(request.getParameter("iesId"));
            dao.deleteIes(iesId);
            forward = LIST_All;
            request.setAttribute("Ies", dao.getAllIes());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int iesId = Integer.parseInt(request.getParameter("iesId"));
            CadastroIes cad = dao.getIesById(iesId);
            request.setAttribute("ies", cad);
        } else if (action.equalsIgnoreCase("ListAll")) {
            forward = LIST_All;
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
        String iesId = request.getParameter("iesId");
        if (iesId == null || iesId.isEmpty()) {
            dao.addIes(cad);
        } else {
            cad.setIesId(Integer.parseInt(iesId));
            dao.updateIes(cad);
        }
        response.sendRedirect(request.getContextPath()+"/index.html");
    }
}
