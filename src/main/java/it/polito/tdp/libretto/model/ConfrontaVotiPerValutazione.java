package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ConfrontaVotiPerValutazione implements Comparator <Voto>{

	
	public int compare(Voto o1, Voto o2) {
		return o2.getVoto()-o1.getVoto();
	}

}
