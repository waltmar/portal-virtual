import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.AbstractTableModel;


enum Taxonomia {REINO, FILO;}

class ItemTaxonomico implements Serializable {
	
	protected Taxonomia taxonomia; 
	protected String oid; 
						   
	ItemTaxonomico (String oid) {this.oid = oid;}
	Taxonomia getTaxonomia() {return taxonomia;}
	String getOID() {return oid;}
	
}

class Filo extends ItemTaxonomico {
	private String nome,
				   oid_reino;
	
	public Filo (String oid, String oidr) {
		super(oid);
		taxonomia = Taxonomia.FILO;
		oid_reino = oidr;
	}
	
	public void setNome(String n) {nome = n;}
	public String getNome() {return nome;}
	public String getOidReino() {return oid_reino;}
}



//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

class Iterador { 
	protected  ArrayList<ItemTaxonomico> colecao;
	protected int indice;
	
	public Iterador () {
		colecao = new ArrayList<ItemTaxonomico>();
		indice = 0;
	}
	public Iterador (ArrayList<ItemTaxonomico> arl) {
		colecao = arl;
		indice  = 0 ;
	}
	
	public boolean vazio () { return colecao.isEmpty();}

	public void primeiro() {indice = 0;}

	public void fim() {indice = colecao.size() - 1;}

	public boolean anterior() {
        if (indice > 0) {
           indice--;
           return true;
        }
        return false;
	}

	public boolean proximo() {
		if (indice < (colecao.size()-1)) {
			indice++;
            return true;
        }
        return false;
    }
    
    public int tamanho() {
    	return colecao.size();
    }

	public ItemTaxonomico obter() {return colecao.get(indice);}

}

class IteradorFilo extends Iterador {
	public IteradorFilo (ArrayList<ItemTaxonomico> arl) {super(arl);}
	public IteradorFilo (Iterador it) { colecao = it.colecao;}
	public Filo obter() {return (Filo) super.obter();}
}


//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

class Serializador {
	String arquivo;
	
	public Serializador (String arq){
		arquivo = arq;
	}
	
	public void cadastrar(ArrayList<ItemTaxonomico> arl) {
		try {
			File f = new File(arquivo);
			f.delete();
			f = null;
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
			for (int i=0; i < arl.size() ; i++ ) {
				out.writeObject((ItemTaxonomico) arl.get(i));	
			}
			
			out.close();
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
	}
	
	public void recuperar(ArrayList<ItemTaxonomico> arl) {
		arl.clear();
		try {
			ObjectInputStream in = new ObjectInputStream (new FileInputStream(arquivo));
			ItemTaxonomico it; ;
			for (int i = 0; (it = (ItemTaxonomico) in.readObject()) != null; i++){
				arl.add(it);
			}
			in.close();
		}
		catch (IOException e) {}
		catch (ClassNotFoundException e) {}		
	}
}


abstract class MapaPersistencia {
	protected ArrayList<ItemTaxonomico> colecaoObjetos;
	protected int indice;
	protected Serializador armazenamento;
	
	protected boolean haItemPersistido(String oid) {
		boolean resposta = false;
		int i;
		for (i=0; i<colecaoObjetos.size(); i++ ) {
			if(colecaoObjetos.get(i).getOID().equalsIgnoreCase(oid)) {
				resposta = true;
				indice = i;
			}
		}
		return resposta;
	}
	protected abstract void inserirItemNoArmazenamento(ItemTaxonomico it);
	protected abstract void excluirItemNoArmazenamento();
	
	public MapaPersistencia () {
		colecaoObjetos = new ArrayList<ItemTaxonomico>();
		armazenamento = null;
		indice = -1;
	}
	
	public boolean inserir(ItemTaxonomico it) {
		boolean resposta = false;
		if(!haItemPersistido(it.getOID())){
			inserirItemNoArmazenamento(it);
			resposta = true;
		}
		armazenamento.cadastrar(colecaoObjetos);
		return resposta;
	}
	
	public boolean excluir(String oid){
		boolean resposta = false;
		if(haItemPersistido(oid)){
			excluirItemNoArmazenamento();
			resposta = true;
		}
		armazenamento.cadastrar(colecaoObjetos);
		return resposta;
	}
	
	public Iterador getTodos(){ return new Iterador(colecaoObjetos);}
	public ItemTaxonomico get(String oid) {
		if( !haItemPersistido(oid)) { return null;}
		return colecaoObjetos.get(indice);
	}
}


class MPFilo extends MapaPersistencia {
	protected void inserirItemNoArmazenamento (ItemTaxonomico it) {
		colecaoObjetos.add(it);
	}

	protected void excluirItemNoArmazenamento () {
		colecaoObjetos.remove(indice);
	}
		
	public MPFilo () {
		super();
		armazenamento = new Serializador("Filo.dat");
		armazenamento.recuperar(colecaoObjetos);
	}
}

class Persistencia {
	private Hashtable<Taxonomia, MapaPersistencia> mapeadores;
	private static Persistencia persistencia;
	
	static { persistencia = null; }
	
	private Persistencia () {
		mapeadores = new Hashtable<Taxonomia, MapaPersistencia>();
		mapeadores.put(Taxonomia.FILO, new MPFilo());
	}

	public static Persistencia obterInstancia() {
		if( persistencia == null ) {
			persistencia = new Persistencia();
		}

		return persistencia;
	}
	
	public boolean inserir(ItemTaxonomico it) {
		return mapeadores.get(it.getTaxonomia()).inserir(it);
	}
	
	public boolean excluir(String oid, Taxonomia taxonomia) {
		return mapeadores.get(taxonomia).excluir(oid);
	}
	
	public Iterador getTodos(Taxonomia taxonomia) {
		return mapeadores.get(taxonomia).getTodos();
	}
	
	public ItemTaxonomico obterItemTaxonomico(String oid, Taxonomia taxonomia) {
		return mapeadores.get(taxonomia).get(oid);
	}
}


//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
//Para criar a tabela de busca no programa

class MinhaTableModel extends AbstractTableModel {
	
	private String[] tituloColunas;
    private Object[][] data;
    private int linhas, colunas;
    
    public MinhaTableModel(String[] tituloColunas, int numLinhas, int numColunas){
    	this.tituloColunas= tituloColunas;
        this.data= new Object[numLinhas][numColunas];
        linhas=numLinhas;
        colunas=numColunas;
    }
        
    public String getColumnName(int col){
    	return tituloColunas[col];    
	}
	
	public int getColumnCount() {
        return colunas;
    }
        
    public int getRowCount() {
        return linhas;
    }
        
    public Object getValueAt(int linha, int coluna) {
        return data[linha][coluna];
    }
        
    public void setValueAt(Object valor, int linha, int coluna) {
        data[linha][coluna]=valor.toString();
        fireTableCellUpdated(linha, coluna);
    }
}

class TabelaFilo {
	
	private static Controle c;
	public MinhaTableModel tabela;
	private IteradorFilo it;
	private Filo filo; 
	boolean aux;
	public JTable t;

	
	TabelaFilo() {
		
		c = Controle.obterInstancia();
		it = c.getListaFilos();
		
		String [] colunas = {"Reino","Filo"};  
	
		tabela = new MinhaTableModel ( colunas ,it.tamanho() , 2);
        t = new JTable(tabela);
        
		//coluna dos filos
		for (int i=0; i < it.tamanho() ; i++ ) {
			filo =it.obter();
			t.setValueAt(filo.getOidReino(), i, 0);
			t.setValueAt(filo.getNome() , i , 1); 
			aux = it.proximo();	
		}	
		
		t.setAutoCreateRowSorter(true);
		t.setPreferredScrollableViewportSize( new Dimension(450,128)); 
		
	}
	
	public JTable getTabela () { return t;}
	
}

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------


class Controle {
	private Persistencia p;
	private static Controle controle;
	private TabelaFilo tabela;
	
	static { controle = null; }
	
	private Controle() {
		p = Persistencia.obterInstancia();
	}
	
	public static Controle obterInstancia () {
		if (controle == null ) {
			controle = new Controle();
		}
		return controle;
	}
	
	public boolean inserir(ItemTaxonomico it) {
		return p.inserir(it);
	}
	
	public boolean excluir(String oid, Taxonomia taxonomia) {
		return p.excluir(oid, taxonomia);
	}
	
	public IteradorFilo getListaFilos() {
		return new IteradorFilo(p.getTodos(Taxonomia.FILO));
	}
	
	
	public Filo getFilo(String oid) {
		return (Filo) p.obterItemTaxonomico(oid, Taxonomia.FILO);
	}
	
	public TabelaFilo getTabelaFilo(){
		return (new TabelaFilo());
	}
}
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------



class JanelaFilo extends JFrame {
	
	private static Controle controle;	
   	public Label lb_Reino;
	public Label lb_Filo;
	
	public JComboBox cb_Reino;
	public String Reino[] = {"Reino","Animalia","Archea","Bacteria","Chromista",
	"Fungi","Plantae","Protozoa","Vuruses"}; 
	
	public JTextField tf_Filo;
	public JTextField tf_Buscar;
	
	public JButton bt_Cadastrar;
	public JButton bt_Buscar;
	public JButton bt_Excluir;
	public JButton bt_Alterar;
	
	public Panel pn_Oeste;
	public Panel pn_Norte;
	public Panel pn_Centro;
	public Panel pn_Sul;
	
	public JScrollPane tb_Filo;
	public JTable jtab;

	
	public JanelaFilo() {
		
		setSize(682,309);
		setLocationRelativeTo(null); 
		
		controle = controle.obterInstancia();
		
		lb_Reino = new Label("Reino");
		lb_Filo = new Label("Filo");    

		cb_Reino = new JComboBox(Reino);
		cb_Reino.addActionListener(new AcaoAtivarCampo());
    	
    	tf_Filo = new JTextField(18);
    	tf_Filo.setEnabled(false);
    	tf_Filo.addKeyListener(new AcaoAtivarBotao());
    	tf_Buscar = new JTextField (18);
    	
    	AcaoBotaoCadastrar acao = new AcaoBotaoCadastrar();
    	bt_Cadastrar = new JButton("Cadastrar");
    	bt_Cadastrar.setEnabled(false);
    	bt_Cadastrar.addActionListener(acao);
    	
		bt_Buscar = new JButton("Buscar");
		//bt_Buscar.setEnabled(false);
		bt_Excluir = new JButton("Excluir");
		bt_Excluir.addActionListener(new AcaoBotaoExcluir());
		//bt_Excluir.setEnabled(false);
		bt_Alterar = new JButton("Alterar");
		//bt_Alterar.setEnabled(false);
		
		
		jtab = controle.getTabelaFilo().getTabela();
		tb_Filo = new JScrollPane();
		tb_Filo.setViewportView(jtab);
        tb_Filo.setAutoscrolls(true);		

		
		setLayout(new BorderLayout() );
		
		// Norte do painel
		pn_Norte = new Panel();
		
		Panel pn11 = new Panel();
		pn11.add(lb_Reino);
		pn11.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn11);
			
		Panel pn12 = new Panel();
		pn12.add(lb_Filo);
		pn12.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn12);
		
		pn_Norte.add(new Panel());
		
		Panel pn21 = new Panel();
		pn21.add(cb_Reino);
		pn21.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn21);
		
		Panel pn22 = new Panel();
		pn22.add(tf_Filo);
		pn22.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn22);
		
		Panel pn23 = new Panel();
		pn23.add(bt_Cadastrar);
		pn23.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn23);
		
		Panel pn31 = new Panel();
		pn31.add(tf_Buscar);
		pn31.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn31);
		
		Panel pn32 = new Panel();
		pn32.add(bt_Buscar);
		pn32.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn_Norte.add(pn32);
		
		pn_Norte.add(new Panel());
		
		pn_Norte.setLayout (new GridLayout (3,3) );
		add("North", pn_Norte);
		
		//Centro do painel
		pn_Centro = new Panel();
		
		Panel pl11 = new Panel();
		pl11.add(bt_Excluir);
		pl11.setLayout(new FlowLayout());
		pn_Centro.add(pl11);
		
		Panel pl21 = new Panel();
		pl21.add(bt_Alterar);
		pl21.setLayout(new FlowLayout());
		pn_Centro.add(pl21);
		
		pn_Centro.add(new Panel());
		
		pn_Centro.setLayout (new GridLayout (3,1) );
		add("Center", pn_Centro);
		
		//Oeste do painel
		pn_Oeste = new Panel();
		pn_Oeste.add(tb_Filo);
		add("West", pn_Oeste);
		
	
	}
	
	public void CarregarTabela () {
		tb_Filo.setViewportView(controle.getTabelaFilo().getTabela());
        tb_Filo.setAutoscrolls(true); 
	}
	
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------

	public class AcaoBotaoCadastrar implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
			
				if(b.getText().equalsIgnoreCase("Cadastrar")) {
					if ( tf_Filo.getText().isEmpty()   ||
						((String)(cb_Reino.getSelectedItem())).equalsIgnoreCase("Reino") ) { 
					
							JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
							return;	
					}
					Filo f = new Filo(tf_Filo.getText(), (String) cb_Reino.getSelectedItem()); 
					f.setNome(tf_Filo.getText());
					if (! Controle.obterInstancia().inserir(f) ) {
						JOptionPane.showMessageDialog(null, "Filo já cadastrado.");
						tf_Filo.setText(null);
						return;
					}
					tf_Filo.setText(null);
					CarregarTabela();
					bt_Cadastrar.setEnabled(false);
					cb_Reino.requestFocus();
					//cb_Reino.setEnabled(true);
				}	
		}
	}
	
	public class AcaoBotaoExcluir implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			if (b.getText().equalsIgnoreCase("Excluir")) {
				int linhaSelecionada = jtab.getSelectedRow();
				String coluna2 = jtab.getModel().getValueAt(linhaSelecionada,1).toString();
				//tf_Filo.setText(coluna2); 
				if(! Controle.obterInstancia().excluir(coluna2, Taxonomia.FILO) ) {
					JOptionPane.showMessageDialog(null, "Erro.");
					return;
				}
				CarregarTabela();
			}		
		}
	}
	
	/*public class AcaoBotaoBuscar implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			if (b.getText().equalsIgnoreCase("Buscar")) {
				int linhaSelecionada = jtab.getSelectedRow();
				String coluna2 = jtab.getModel().getValueAt(linhaSelecionada,1).toString();
				tf_Filo.setText(coluna2); 
				if(! Controle.obterInstancia().excluir(coluna2, Taxonomia.FILO) ) {
					JOptionPane.showMessageDialog(null, "Erro.");
					return;
				}
				CarregarTabela();
			}		
		}
	}*/
	
	public class AcaoAtivarBotao implements KeyListener {
	
		public void keyTyped(KeyEvent e) {}	
			
		public void keyPressed(KeyEvent e) {
			JTextField b = (JTextField) e.getSource();
			
				if ( !b.getText().isEmpty()  &&
					!((String)(cb_Reino.getSelectedItem())).equalsIgnoreCase("Reino")  )
						bt_Cadastrar.setEnabled(true);				
		}

		public void keyReleased(KeyEvent e) {}
	}
	
	public class AcaoAtivarCampo implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JComboBox c = (JComboBox) e.getSource();
			
			if (!((String)(cb_Reino.getSelectedItem())).equalsIgnoreCase("Reino") ) {
				tf_Filo.setEnabled(true);
				tf_Filo.requestFocus();
			} else tf_Filo.setEnabled(false);		

		}			
	}

	
}



class Teste
{
   public static void main(String args[])
   {
      JanelaFilo janela = new JanelaFilo();
      janela.show();
   }
}