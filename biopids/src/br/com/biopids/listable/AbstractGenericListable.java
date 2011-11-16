package br.com.biopids.listable;

import java.util.Date;
import java.util.List;

import br.com.biopids.interfaces.IListable;

public abstract class AbstractGenericListable<T extends Object> implements IListable<T>{
	
	private boolean old;
	private long time;
	private List<T> list;
	private static final long MAXTIME = 7000;
	
	
	public boolean isOld(){
		return (list == null) || old || compareTime();
	}
	
	private boolean haveList(){
		return list == null;
	}
	
	private boolean compareTime(){
		long dataCorrent = (new Date()).getTime() ;
		return ((dataCorrent - time)> MAXTIME);
	}
	private void reNew(){
		this.list = getList();
		this.old = false;
		this.time = (new Date()).getTime();
	}
	
	public List<T> getComboList(){
		if (haveList() || isOld())
			reNew();
		return this.list;
	}
	
	protected abstract List<T> getList();
	
}
