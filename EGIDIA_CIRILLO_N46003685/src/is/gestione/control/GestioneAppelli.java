package is.gestione.control;
import java.util.*;
import is.gestione.entity.*;

public class GestioneAppelli {
	
	ArrayList<Corso> listaCorsi = new ArrayList<>();
	ArrayList<Data> listaDate= new ArrayList<>();

	public GestioneAppelli() {
	}
	
	public Corso creaCorso(String _corso, Docente _docente, int _cfu) {
		Corso c = new Corso(_corso, _docente, _cfu);
		return c;
		}
	
	public Appello creaAppello(ArrayList<Data> date, boolean concluso, Corso c) {
		Appello a = new Appello(date, concluso);
		
		if(listaCorsi.contains(c)) {

			c.addAppello(a);

		}else {

			listaCorsi.add(c);

			c.addAppello(a);
			}
		c.addAppello(a);
		return a;
		
		}
	
	public void aggiungiData(Data data) {

		this.listaDate.add(data);
		} 

	public  ArrayList<Data> elencoDate(){

		return this.listaDate;
		}
	
	public void prenotaStudente(Studente s, Appello a) {
		if(a.getIsConcluso()==true) {

			System.out.println("L'appello è stato chiuso, impossibile effettuare la prenotazione");
		}
		else if(a.getDate().isEmpty()) {
			System.out.println("Non ci sono date per questo appello, la prenotazione è fallita");
			
		}
		else if(!a.getStudenti().contains(s)) {

			a.addStudente(s);

		}else {

			System.out.println("Prenotazione già effettuata, impossibile effettuare più volte la prenotazione");

		}

	}
	
	public void stampaStudentiPrenotati(Appello appello) {
		ArrayList<Studente> studenti= appello.getStudenti();
		
		for(int i=0; i<studenti.size(); i++) {
			System.out.println(studenti.get(i));
		}
		}
	
	public void chiudiAppello(Appello a) {
		a.setisConcluso(true);
		
	}
	}

