package br.com.scbio.domain;

public class Specimen extends EntityPersist{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collect collect;
	
	public Specimen() {
		this.collect = new Collect();
	}
	
	

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}
}
