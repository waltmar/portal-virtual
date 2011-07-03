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
 * Servlet implementation class ExclusaoTaxonomia2
 */
@WebServlet("/ExclusaoTaxonomia2")
public class ExclusaoTaxonomia2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExclusaoTaxonomia2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String id_item = request.getParameter("id_item");	
		String nome_tabela = request.getParameter("nome_tabela");
		System.out.println(id_item+nome_tabela);
		
		Taxonomia t = new Taxonomia();
	    t.setNomeTabela(nome_tabela);
	    t.setId(id_item);   
	    Controle ctrl = new Controle();
		 
		try {
			ctrl.excluirItem(t);
		} catch (Exception e) {}
		/*tentativa de excluir todos os filhos...
	    EnumTaxonomia enume = new EnumTaxonomia();
	    ArrayList tax = new ArrayList();
	    tax= enume.getEnumTaxonomia();
	    int aux;
	    aux = tax.indexOf(nome_tabela); 
	    for (int i= 1; i <tax.size()-1; i++){
	    	t.clear();
    		t.setNomeTabela((String)tax.get(aux+i));
    		t.setPai(id_item);
    		while (ctrl.buscarPorPai(t) != null) {
    			t = ctrl.buscarPorPai(t);
				id_item = t.Id();
				try {
				ctrl.excluirItem(t);
				} catch (Exception e) {}
			}
	    }
		*/
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<body onload=window.close()>"); 
		out.println("</body>");
		out.println("</html>"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
