package servletsCadastro;

import itensParaPersistencia.Taxonomia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.Controle;

/**
 * Servlet implementation class AtualizarTaxonomia
 */
@WebServlet("/AtualizarTaxonomia")
public class AtualizarTaxonomia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarTaxonomia() {
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
	    String id_item = request.getParameter("id_item");
	    
	    
	    Taxonomia t = new Taxonomia();
	    t.setId(id_item);
	    t.setNomeTabela(nome_tabela);
	    t.setNome(nome);
	    t.setPai(pai);
		
		Controle ctrl = new Controle();
		 
		try {
			ctrl.atualizarItem(t);
		} catch (Exception e) {}
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<body onload=window.close()>"); 
		out.println("</body>");
		out.println("</html>"); 
		
		
		
	}
}


