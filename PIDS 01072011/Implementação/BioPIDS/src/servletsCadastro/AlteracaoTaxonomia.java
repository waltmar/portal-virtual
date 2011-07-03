package servletsCadastro;

import itensParaPersistencia.Taxonomia;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import controle.Controle;

/**
 * Servlet implementation class AlteracaoTaxonomia
 */
@WebServlet("/AlteracaoTaxonomia")
public class AlteracaoTaxonomia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteracaoTaxonomia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType( "text/html" );
	    String nome_tabela = request.getParameter("nome_tabela");
	    String nome= request.getParameter("nome");
	    String pai = request.getParameter("pai");
	    
	    
	    Taxonomia t = new Taxonomia();
	    t.setNomeTabela(nome_tabela);
	    t.setNome(nome);
	    t.setPai(pai);

		Controle ctrl = new Controle();
		 
		try {
			ctrl.inserirItem(t);
		} catch (Exception e) {}
		 
		RequestDispatcher view = request.getRequestDispatcher ("DominioFilo.jsp");
		view.forward(request, response);
		
	}
	

}
	

