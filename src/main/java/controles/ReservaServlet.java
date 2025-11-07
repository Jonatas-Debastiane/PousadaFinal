package controles;

import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO.ReservaDAO;
import modelos.Hospedes;
import modelos.Reserva;

/**
 * Servlet responsável por processar o formulário de reserva.
 * Apenas hóspedes logados podem realizar reservas.
 */
@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Verifica se há um usuário logado
        HttpSession session = request.getSession(false);
        Hospedes usuarioLogado = (Hospedes) (session != null ? session.getAttribute("usuarioLogado") : null);

        if (usuarioLogado == null) {
            response.sendRedirect("entrar.jsp?erro=precisaLogin");
            return;
        }

        try {
            // 2️⃣ Pega os dados do formulário
            int idQuarto = Integer.parseInt(request.getParameter("idQuarto"));
            String dataEntradaStr = request.getParameter("dataEntrada");
            String dataSaidaStr = request.getParameter("dataSaida");
            int qtdHospedes = Integer.parseInt(request.getParameter("hospedes"));

            // 3️⃣ Converte para LocalDate
            LocalDate dataEntrada = LocalDate.parse(dataEntradaStr);
            LocalDate dataSaida = LocalDate.parse(dataSaidaStr);

            // 4️⃣ Valida datas
            if (dataSaida.isBefore(dataEntrada)) {
                throw new IllegalArgumentException("A data de saída não pode ser antes da data de entrada.");
            }

            // 5️⃣ Cria e preenche o objeto de reserva
            Reserva reserva = new Reserva();
            reserva.setIdHospede(usuarioLogado.getIdHospede());
            reserva.setIdQuarto(idQuarto);
            reserva.setDataEntrada(dataEntrada);
            reserva.setDataSaida(dataSaida);
            reserva.setQtdHospedes(qtdHospedes);

            // 6️⃣ Salva no banco
            ReservaDAO reservaDAO = new ReservaDAO();
            reservaDAO.salvar(reserva);

            // 7️⃣ Redireciona com sucesso
            response.sendRedirect("quartos.jsp?reserva=sucesso");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("quartos.jsp?reserva=erro");
        }
    }
}
