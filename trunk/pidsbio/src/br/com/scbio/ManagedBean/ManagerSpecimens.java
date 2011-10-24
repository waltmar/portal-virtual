package br.com.scbio.ManagedBean;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.scbio.domain.Collect;
import br.com.scbio.domain.Collector;
import br.com.scbio.domain.Specimen;
import br.com.scbio.exception.ErrorException;
import br.com.scbio.interfaces.IController;

@ManagedBean(name="ManagerSpecimens")
@ViewScoped
public class ManagerSpecimens extends GenericBean<Specimen, Long> {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
		
	public ManagerSpecimens(){
		super();
	}
	
	public String addCollector(){
		Collector c = new Collector();
		c.setNome(name);
		Specimen specimen = objectDomain;
		specimen.getCollect().getColetores().add(c);
		return null;
	}
	
	@Override
	public Specimen getDomain() {
		// TODO Auto-generated method stub
		return new Specimen();
	}

	@Override
	public IController<Specimen, Long> getIController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() throws ErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() throws ErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws ErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Specimen getById(Long id) throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specimen getByFinger(Specimen entity) throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Specimen> getAll() throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}