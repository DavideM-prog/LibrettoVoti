package it.polito.tdp.libretto.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Libretto {
	private List <Voto> voti=new ArrayList<>();
	
	
	public Libretto() {
		
	}
	
	
	
	public Libretto(Libretto lib) {	
		this.voti.addAll(lib.voti);
	}
	
	
	
	
	
	public boolean add(Voto v) {
		if(this.isDuplicatoVoto(v)||(this.isConflitto(v))) 
			return false;
		else {
			this.voti.add(v);
			return true;
		}
	}
	
	
	public Libretto creaLibrettoMigliorato() {
		Libretto lTemp=new Libretto();
		for(Voto v : this.voti) {
			Voto v1=v.clone();
			if(v1.getVoto()>=24) {
				v1.setVoto(v1.getVoto()+2);
				if(v1.getVoto()>=30)
					v1.setVoto(30);
			}
			else if(v1.getVoto()>=18) {
				v1.setVoto(v1.getVoto()+1);
			}
			lTemp.add(v1);
		}
		return lTemp;
	}
	
	public String stampaVotiUguali(int voto) {
		String s="";
		for(Voto v:this.voti) {
			if(v.getVoto()==voto)
				s+=v.toString()+"\n";
		}
		return s;
	}
	
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo=new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto()==voto)
				nuovo.add(v);
		}
		return nuovo;
	}
	
	
	
	public String toString() {
		String s="";
		for(Voto v:this.voti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
	public Voto cercaNomeCorso(String nomeCorso) {
		/*for(Voto v : this.voti) {
			if(v.getCorso().compareTo(nomeCorso)==0)
				return v;
		}
		return null;
	}*/
		int pos=this.voti.indexOf(new Voto(nomeCorso,0,null));
		if(pos!=-1)
			return this.voti.get(pos);
		else
			return null;
	}
	
	public boolean isDuplicatoVoto(Voto v) {
		Voto esiste=this.cercaNomeCorso(v.getCorso());
		if(esiste==null)
			return false;
		return (esiste.getVoto()==v.getVoto());
		
	}
	
	public boolean isConflitto(Voto v) {
		Voto esiste=this.cercaNomeCorso(v.getCorso());
		if(esiste==null)
			return false;
		return (esiste.getVoto()!=v.getVoto());
	}
	
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	public void ordinaPerVoto() {
		Collections.sort(this.voti,new ConfrontaVotiPerValutazione());
	}
	
	
	//elimina tutti i voti < 24
	public void cancellaVotiScarsi() {
		List <Voto> daRimuovere=new ArrayList<>();
		for(Voto v : this.voti) {
			if(v.getVoto()<24)
				daRimuovere.add(v);
		}
		this.voti.removeAll(daRimuovere);
	}
}