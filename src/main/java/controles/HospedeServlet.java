package controles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.HospedeDAO;
import modelos.Hospedes;


@WebServlet("/HospedeServlet")
public class HospedeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
  List<Hospedes> hospedes = new ArrayList<>();
	
	public HospedeServlet(){
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        /*if(acao != null) {
          	 
          	 String idHospede = request.getParameter("id_hospede");
          	 Hospedes ct = getById(Integer.parseInt(idHospede));
          	 if(acao.equals("editar")) {
          	 request.setAttribute("contato", ct);
          	 RequestDispatcher rd = request.getRequestDispatcher("edicao.jsp");
          	 rd.forward(request,response);
          	 } else {
          		 hospedes.remove(ct);
          		 response.sendRedirect("ContatoServlet");
          	 }
           } else {*/
        	hospedes = new HospedeDAO().getAll();
		request.setAttribute("hospedes", hospedes);
		RequestDispatcher rd = request.getRequestDispatcher("entrar.jsp");
		rd.forward(request,response);
   }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String acao = request.getParameter("acao");
		 /*if(acao != null) {
			  try {
				  HospedeDAO cdao = new HospedeDAO();
				  Hospedes hospedes = cdao.getById(Integer.parseInt(request.getParameter("id")));
				  hospedes.setNome(request.getParameter("nome"));
				  hospedes.setEmail(request.getParameter("email"));
				  hospedes.setSenha(request.getParameter("senha"));
			      cdao.alterar(hospedes);
			  }catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
		 } else {*/
			 try {
		Hospedes hospede = new Hospedes();
		hospede.setNome(request.getParameter("nome"));
		hospede.setTelefone(request.getParameter("telefone"));
		hospede.setEmail(request.getParameter("email"));
		hospede.setSenha(request.getParameter("senha"));
		hospedes.add(hospede);
		
		new HospedeDAO().salvar(hospede);
			 }catch (RuntimeException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			 
	    response.sendRedirect("HospedeServlet");
		 }
	
	
	

	private Hospedes getById(int id) {
		for (Hospedes ct : hospedes) {
			if(ct.getIdHospede() == id) {
				return ct;
			}
		}
		return null;
	}
}