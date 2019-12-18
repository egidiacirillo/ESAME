package is.gestione.control;
import java.util.ArrayList;
import is.gestione.entity.*;

public class GestioneAppelli {
	
	ArrayList<Corso> listaCorsi = new ArrayList<>();

	public GestioneAppelli() {
	}
	
	public Corso creaCorso(String _corso, Docente _docente, int _cfu) {
		Corso c = new Corso(_corso, _docente, _cfu);
		return c;
		}
	
	public Appello creaAppello(ArrayList<Data> date, boolean concluso, Corso corso) {
		Appello a = new Appello(date, concluso);
		
		if(listaCorsi.contains(corso)) {

			corso.addAppello(a);

		}else {

			listaCorsi.add(corso);

			corso.addAppello(a);

		}
		
		corso.addAppello(a);
		return a;
		
		}
	
	public void prenotaStudente(Studente s, Appello appello) {
		if(appello.getIsConcluso()==true) {

			System.out.println("Appello è stato chiuso, impossibile effettuare la prenotazione");
		}
		else if(appello.getDate().isEmpty()) {
			System.out.println("Non ci sono date per questo appello prenotazione fallita");
			
		}
		else if(!appello.getStudenti().contains(s)) {

			appello.addStudente(s);

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

