package controles;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.QuartoDAO;
import modelos.Quartos;

@WebServlet("/QuartoServlet")
public class QuartoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private QuartoDAO quartoDAO = new QuartoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        if ("listar".equals(acao) || acao == null) {
            // Lista todos os quartos para a área administrativa
            request.setAttribute("quartos", quartoDAO.listarTodos());
            RequestDispatcher rd = request.getRequestDispatcher("admin/listar_quartos.jsp");
            rd.forward(request, response);
        } else if ("editar".equals(acao)) {
            // Busca um quarto para edição
            int id = Integer.parseInt(request.getParameter("id"));
            Quartos quarto = quartoDAO.buscarporId(id);
            request.setAttribute("quarto", quarto);
            RequestDispatcher rd = request.getRequestDispatcher("admin/editar_quarto.jsp");
            rd.forward(request, response);
        } else if ("deletar".equals(acao)) {
            // Deleta um quarto
            int id = Integer.parseInt(request.getParameter("id"));
            quartoDAO.deletar(id);
            response.sendRedirect("QuartoServlet?acao=listar&msg=deletado");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        try {
            Quartos q = new Quartos();
            q.setNumero(Integer.parseInt(request.getParameter("numero")));
            q.setTipo(request.getParameter("tipo"));
            q.setDescricao(request.getParameter("descricao"));
            q.setPrecoDiaria(Double.parseDouble(request.getParameter("precoDiaria")));
            q.setStatus(Boolean.parseBoolean(request.getParameter("status")));

            if ("salvar".equals(acao)) {
                // Insere novo quarto
                quartoDAO.inserir(q);
                response.sendRedirect("QuartoServlet?acao=listar&msg=inserido");
            } else if ("atualizar".equals(acao)) {
                // Atualiza quarto existente
                q.setIdQuarto(Integer.parseInt(request.getParameter("idQuarto")));
                quartoDAO.atualizar(q);
                response.sendRedirect("QuartoServlet?acao=listar&msg=atualizado");
            } else {
                 response.sendRedirect("QuartoServlet?acao=listar&msg=acao_invalida");
            }
        } catch (Exception e) {
            System.err.println("Erro no QuartoServlet: " + e.getMessage());
            response.sendRedirect("QuartoServlet?acao=listar&erro=" + e.getMessage());
        }
    }
}
