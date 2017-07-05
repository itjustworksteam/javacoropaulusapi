package it.itjustworks.coropaulus;

import java.util.ArrayList;
import java.util.List;

public class ListaCanti {

	private List<Canto> canti;
	
	public ListaCanti(List<Canto> canti) {
		this.canti = canti;
	}

	public List<Canto> canti() {
		return this.canti;
	}

	public int dimensione() {
		return this.canti.size();
	}

	public List<Canto> cerca(String ricerca) {
		List<Canto> ricercati = new ArrayList<Canto>();
		for(int index = 0; index < this.canti.size(); index++){
			Canto c = this.canti.get(index);
			if(c.nome().contains(ricerca)){
				ricercati.add(c);
			}
		}
		return ricercati;
	}

}
