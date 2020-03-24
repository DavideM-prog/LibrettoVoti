package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	Libretto lib;
	private void run() {
		this. lib=new Libretto();
		Voto v1=new Voto("Tecniche di programmazione",30,LocalDate.of(2020, 06, 15));
		Voto v2=new Voto("Analisi II",28,LocalDate.of(2020, 06, 15));
		lib.add(v1);
		lib.add(v2);
		if(lib.add(new Voto("Economia",24,LocalDate.of(2020, 02, 14)))==false);
			System.out.println("Errore nell'inserimento di Economia\n");
		System.out.println(lib);
		
		System.out.println(lib.stampaVotiUguali(30));
		
		System.out.println(lib.estraiVotiUguali(30));
		
		
		String nomeCorso="Analisi II";
		Voto votoAnalisi=lib.cercaNomeCorso(nomeCorso);
		System.out.println("Il voto di "+nomeCorso+" e' "+votoAnalisi.getVoto());
		
		//verifica voti duplicati e conflitti
		Voto economia2=new Voto("Economia",24,LocalDate.now());
		Voto economia3=new Voto("Economia",21,LocalDate.now());
		System.out.println("Economia con 24 e' duplicato :  "+lib.isDuplicatoVoto(economia2) +"\n"+"Economia con 24 e' conflitto :  "+lib.isConflitto(economia2));  
		System.out.println("Economia con 21 e' duplicato :  "+lib.isDuplicatoVoto(economia3) +"\n"+"Economia con 21 e' conflitto :  "+lib.isConflitto(economia3));
		// punto 6 libretto migliorato
		Libretto migliorato=lib.creaLibrettoMigliorato();
		System.out.println("miglioramento del libretto");
		System.out.println(lib);
		System.out.println(migliorato);
		// punto 7 ordina in ordine alfabetico per corso
		Libretto alfa=new Libretto(lib);
		alfa.ordinaPerCorso();
		System.out.println(alfa);
		//punto 7 (parte 2) ordina per voto
		Libretto num=new Libretto(lib);
		num.ordinaPerVoto();
		System.out.println(num);
		//punto 8, eliminare voti < 24
		lib.add(new Voto("Chimica",19,LocalDate.now()));
		lib.ordinaPerCorso();
		System.out.println(lib);
		lib.cancellaVotiScarsi();
		System.out.println(lib);
		
	}
	public static void main(String[] args) {
		TestLibretto test= new TestLibretto();
		test.run();
	}
}