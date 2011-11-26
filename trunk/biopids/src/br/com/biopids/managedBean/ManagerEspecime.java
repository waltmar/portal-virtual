package br.com.biopids.managedBean;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.biopids.domain.Aplicacao;
import br.com.biopids.domain.Autor;
import br.com.biopids.domain.Bibliografia;
import br.com.biopids.domain.Classe;
import br.com.biopids.domain.Datum;
import br.com.biopids.domain.EntityPersist;
import br.com.biopids.domain.EpEspecifico;
import br.com.biopids.domain.Especime;
import br.com.biopids.domain.Estado;
import br.com.biopids.domain.EstagioDesenvolvimento;
import br.com.biopids.domain.Familia;
import br.com.biopids.domain.Fenologia;
import br.com.biopids.domain.Filo;
import br.com.biopids.domain.Fenologia;
import br.com.biopids.domain.Genero;
import br.com.biopids.domain.Imagem;
import br.com.biopids.domain.MassaDagua;
import br.com.biopids.domain.Metodo;
import br.com.biopids.domain.Municipio;
import br.com.biopids.domain.Ordem;
import br.com.biopids.domain.Pais;
import br.com.biopids.domain.Reino;
import br.com.biopids.domain.Sexo;
import br.com.biopids.domain.SubClasse;
import br.com.biopids.domain.SubFamilia;
import br.com.biopids.domain.SubGenero;
import br.com.biopids.domain.SubOrdem;
import br.com.biopids.domain.TipoMontagem;
import br.com.biopids.model.Video;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.interfaces.IController;
import br.com.biopids.listable.ControlerList;
import br.com.biopids.managedListable.ListableAutor;
import br.com.biopids.managedListable.ListableClasse;
import br.com.biopids.managedListable.ListableDatum;
import br.com.biopids.managedListable.ListableEstado;
import br.com.biopids.managedListable.ListableEstagioDesenvolvimento;
import br.com.biopids.managedListable.ListableFamilia;
import br.com.biopids.managedListable.ListableFenologia;
import br.com.biopids.managedListable.ListableFilo;
import br.com.biopids.managedListable.ListableGenero;
import br.com.biopids.managedListable.ListableMassaDagua;
import br.com.biopids.managedListable.ListableMetodo;
import br.com.biopids.managedListable.ListableMunicipio;
import br.com.biopids.managedListable.ListableOrdem;
import br.com.biopids.managedListable.ListablePais;
import br.com.biopids.managedListable.ListableReino;
import br.com.biopids.managedListable.ListableSexo;
import br.com.biopids.managedListable.ListableSubClasse;
import br.com.biopids.managedListable.ListableSubFamilia;
import br.com.biopids.managedListable.ListableSubOrdem;
import br.com.biopids.managedListable.ListableTipoMontagem;
import br.com.biopids.model.Coletor;
import br.com.biopids.model.ComboEspecime;
import br.com.biopids.model.EspecimeModel;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@ManagedBean(name = "ManagerEspecime")
@SessionScoped
public class ManagerEspecime extends GenericBean<Especime, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboEspecime combos;
	private Coletor collector;
	private Bibliografia bibliografia;
	private Aplicacao aplicacao;

	private StreamedContent imagemEnviada = new DefaultStreamedContent();
	private String imagemTemporaria;
	private CroppedImage croppedImage;
	private boolean exibeBotao = false;
	private List<Imagem> imagens;
	private List<Video> videos;
	private boolean renderedVideo = false;
	private Video video;
	private String videoCurrent;
	private List<String> listaImagens;
	private Imagem foto;
	private StreamedContent contentImagem = new DefaultStreamedContent();

	/** 
	 * 
	 */

	public ManagerEspecime() {
		super();
		this.collector = new Coletor();
		this.bibliografia = new Bibliografia();
		this.aplicacao = new Aplicacao();
		this.video = new Video();
		this.imagens = new ArrayList<Imagem>();
		this.videos = new ArrayList<Video>();
		this.listaImagens = new ArrayList<String>();
		this.videoCurrent = "";
		this.renderedVideo = false;

	}

	protected void afterSave() {
		// TODO Auto-generated method stub
		loadProperties();
		objectModel = getModel();

		// setMethodDialogSave();
		setMessage(FacesMessage.SEVERITY_INFO, FactoreProperties.loadPtbr()
				.getValor("SalvoSucesso"), "");
		exit();
	}
	
	protected void afterMapping() {
		
	}

	public String exit2() {
		objectModel = getModel();
		return "";
	}

	public String exit() {
		return "/formularios/Specimen/index.xhtml?move=1";
	}

	public String removeImage(Imagem imagem) {

		boolean result = imagens.remove(imagem);

		System.out.println(result);
		listaImagens.remove(imagem.getNome() + ".jpg");
		return "";
	}

	public void criaArquivo(byte[] bytes, String arquivo) {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(arquivo);
			fos.write(bytes);
			fos.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ManagerEspecime.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ManagerEspecime.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public String getRandomString() {
		return Integer.toString(1000 + (int) (Math.random() * 1000)).toString();
	}

	public void enviarImagem(FileUploadEvent event) {

		try {
			contentImagem = new DefaultStreamedContent(event.getFile()
					.getInputstream());
			foto = new Imagem();
			foto.setImagem(event.getFile().getContents());
			foto.setNome("imagem" + getRandomString());
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ServletContext scontext = (ServletContext) facesContext
					.getExternalContext().getContext();
			String nomeArquivo = foto.getNome() + ".jpg";
			listaImagens.add(foto.getNome() + ".jpg");
			String arquivo = scontext.getRealPath("/temp/" + nomeArquivo);
			criaArquivo(foto.getImagem(), arquivo);
			imagens.add(foto);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String newCollector() {
		collector = new Coletor();
		return null;
	}

	public String newBibliografia() {
		bibliografia = new Bibliografia();
		return null;
	}

	public String newAplicacao() {
		aplicacao = new Aplicacao();
		return null;
	}

	public String newVideo() {
		video = new Video();
		return null;
	}

	public String removeCollector(Coletor object) {
		EspecimeModel specimen = (EspecimeModel) objectModel;
		specimen.getColeta().getColetores().remove(object);
		return null;
	}

	public String removeBibliografia(Bibliografia object) {
		EspecimeModel specimen = (EspecimeModel) objectModel;
		specimen.getOutros().getBibliografias().remove(object);
		return null;
	}

	public String removeAplicacao(Aplicacao object) {
		EspecimeModel specimen = (EspecimeModel) objectModel;
		specimen.getOutros().getAplicacoes().remove(object);
		return null;
	}

	public String removeVideo(Video object) {
		EspecimeModel specimen = (EspecimeModel) objectModel;

		specimen.getMedia().getVideos().remove(object);

		if (specimen.getMedia().getVideos().size() == 0)
			this.renderedVideo = false;
		if (videoCurrent.equalsIgnoreCase(object.getUrl()))
			videoCurrent = "algo";
		return null;
	}

	public String playVideo(Video object) {
		videoCurrent = object.getUrl();
		return null;
	}

	public String addVideo() {
		this.renderedVideo = true;
		if (video.getUrl() != null) {
			videoCurrent = video.getUrl();
			video.setNome("video" + getRandomString());
			EspecimeModel specimen = (EspecimeModel) objectModel;
			specimen.getMedia().getVideos().add(video);
			video = new Video();
		}
		return null;
	}

	public String addCollector() {
		if (collector.getNome() != null) {
			EspecimeModel specimen = (EspecimeModel) objectModel;
			specimen.getColeta().getColetores().add(collector);
			collector = new Coletor();
		}
		return null;
	}

	public String returnToInit() {
		return "/formularios/Specimen/index.xhtml?move=1";
	}

	public ControlerList getControllerList() {
		return (ControlerList) AppContext.getApplicationContext().getBean(
				"ControlerList");
	}

	@Override
	public IController<Especime, Long> getIController() {
		return (IController<Especime, Long>) AppContext.getApplicationContext()
				.getBean("ControllerEspecime");
	}

	public void next(ActionEvent actionEvent) {
	}

	@Override
	public Object getModel() {
		return new EspecimeModel();
	}

	@Override
	public Especime getDomain() {
		return new Especime();
	}


	public Object loadCombos() {
		combos = new ComboEspecime();

		List<Pais> list = (List<Pais>) getControllerList().getList(
				ListablePais.class);
		combos.setPaises(list);
		List<Estado> list1 = (List<Estado>) getControllerList().getList(
				ListableEstado.class);
		combos.setEstados(list1);
		List<Municipio> list2 = (List<Municipio>) getControllerList().getList(
				ListableMunicipio.class);
		combos.setMunicipios(list2);
		List<MassaDagua> list3 = (List<MassaDagua>) getControllerList()
				.getList(ListableMassaDagua.class);
		combos.setMassasDagua(list3);
		List<Datum> list4 = (List<Datum>) getControllerList().getList(
				ListableDatum.class);
		combos.setDatuns(list4);

		List<Reino> list5 = (List<Reino>) getControllerList().getList(
				ListableReino.class);
		combos.setReinos(list5);
		List<Filo> list6 = (List<Filo>) getControllerList().getList(
				ListableFilo.class);
		combos.setFilos(list6);
		List<Classe> list7 = (List<Classe>) getControllerList().getList(
				ListableClasse.class);
		combos.setClasses(list7);
		List<SubClasse> list8 = (List<SubClasse>) getControllerList().getList(
				ListableSubClasse.class);
		combos.setSubClasses(list8);
		List<Ordem> list9 = (List<Ordem>) getControllerList().getList(
				ListableOrdem.class);
		combos.setOrdens(list9);
		List<SubOrdem> list10 = (List<SubOrdem>) getControllerList().getList(
				ListableSubOrdem.class);
		combos.setSubOrdens(list10);
		List<Familia> list11 = (List<Familia>) getControllerList().getList(
				ListableFamilia.class);
		combos.setFamilias(list11);
		List<SubFamilia> list12 = (List<SubFamilia>) getControllerList()
				.getList(ListableSubFamilia.class);
		combos.setSubFamilias(list12);
		List<Genero> list13 = (List<Genero>) getControllerList().getList(
				ListableGenero.class);
		combos.setGeneros(list13);

		List<Autor> list19 = (List<Autor>) getControllerList().getList(
				ListableAutor.class);
		combos.setAutores(list19);

		List<EstagioDesenvolvimento> list14 = (List<EstagioDesenvolvimento>) getControllerList()
				.getList(ListableEstagioDesenvolvimento.class);
		combos.setEstagiosDesenvolvimento(list14);
		List<Fenologia> list15 = (List<Fenologia>) getControllerList().getList(
				ListableFenologia.class);
		combos.setFenologias(list15);
		List<Metodo> list16 = (List<Metodo>) getControllerList().getList(
				ListableMetodo.class);
		combos.setMetodos(list16);
		List<Sexo> list17 = (List<Sexo>) getControllerList().getList(
				ListableSexo.class);
		combos.setSexos(list17);
		List<TipoMontagem> list18 = (List<TipoMontagem>) getControllerList()
				.getList(ListableTipoMontagem.class);
		combos.setTiposMontagem(list18);

		return combos;
	}

	public Boolean getDefaultButton() {
		return false;
	}

	public ComboEspecime getCombos() {
		return combos;
	}

	public void setCombos(ComboEspecime combos) {
		this.combos = combos;
	}
	public String GenerateCodigo(){
		((EspecimeModel) getObjectModel()).getColeta().setCodigoCatalogo("lab" +getRandomString());
		
		return null;
	}

	public String[] getCollunsTableSearch() {
		return new String[] { "especime.coleta", "especime.coleta",
				"especime.geografia", "especime.taxonomia"};
	}

	public String[] getOrdersTableSearch() {
		return new String[] { "especime.coleta.codigoColeta" };
	}

	private void loadSpecimen(String codigoCatalogo) {
		IController<Especime, Long> controler = getIController();
		Especime Specimen = new Especime();
		// Specimen.getColeta().setCodigoCatalogo(codigoCatalogo);
		List<Especime> list = null;
		try {
			list = (List<Especime>) controler.getByFinder(Specimen,
					"especime.codigo", "especime.nome");
		} catch (ErrorException e) {
			treatException(e);
		}
		if ((list != null) && (list.size() != 0)) {
			loadObjectTable(list.get(0));
		}
	}

	public Coletor getCollector() {
		return collector;
	}

	public void setCollector(Coletor collector) {
		this.collector = collector;
	}

	public StreamedContent getImagemEnviada() {
		return imagemEnviada;
	}

	public void setImagemEnviada(StreamedContent imagemEnviada) {
		this.imagemEnviada = imagemEnviada;
	}

	public String getImagemTemporaria() {
		return imagemTemporaria;
	}

	public void setImagemTemporaria(String imagemTemporaria) {
		this.imagemTemporaria = imagemTemporaria;
	}

	public CroppedImage getCroppedImage() {
		return croppedImage;
	}

	public void setCroppedImage(CroppedImage croppedImage) {
		this.croppedImage = croppedImage;
	}

	public boolean isExibeBotao() {
		return exibeBotao;
	}

	public void setExibeBotao(boolean exibeBotao) {
		this.exibeBotao = exibeBotao;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Imagem getFoto() {
		return foto;
	}

	public void setFoto(Imagem foto) {
		this.foto = foto;
	}

	public StreamedContent getContentImagem() {
		return contentImagem;
	}

	public void setContentImagem(StreamedContent contentImagem) {
		this.contentImagem = contentImagem;
	}

	public List<String> getListaImagens() {
		return listaImagens;
	}

	public void setListaImagens(List<String> listaImagens) {
		this.listaImagens = listaImagens;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public String getVideoCurrent() {
		return videoCurrent;
	}

	public void setVideoCurrent(String videoCurrent) {
		this.videoCurrent = videoCurrent;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Bibliografia getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(Bibliografia bibliografia) {
		this.bibliografia = bibliografia;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public boolean isRenderedVideo() {
		return renderedVideo;
	}

	public void setRenderedVideo(boolean renderedVideo) {
		this.renderedVideo = renderedVideo;
	}

}
