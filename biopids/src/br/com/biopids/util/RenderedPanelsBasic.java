package br.com.biopids.util;

import java.util.ArrayList;
import java.util.List;

public class RenderedPanelsBasic {
	
	private List<Boolean> listPanels;
	int size;
	
	public RenderedPanelsBasic(int size){
		this.size = size;
		listPanels = new ArrayList<Boolean>();
	}
	
	private List<Boolean> setListPanels(int n){
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		for (int i = 0; i < size; i++) {
			list.add(false);
		}
		list.add(n, true);
		return list;
	}
	
	public boolean actionPanel(String n){
		int i = Integer.parseInt(n);
		setListPanels(i);
		return listPanels.get(i);
	}

	public List<Boolean> getListPanels() {
		return listPanels;
	}

	public void setListPanels(List<Boolean> listPanels) {
		this.listPanels = listPanels;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
