package is.gestione.main;
import java.time.LocalDate;
import java.util.ArrayList;
import is.gestione.control.*;
import is.gestione.entity.*;

public class main {

	public void main(String[] args) {
		
		GestioneAppelli gestione = new GestioneAppelli();
		ArrayList<Data> dataAppelli = new ArrayList<>();
		
		Docente d = new Docente("Natella");
		Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
		Studente s2= new Studente("Luigi", "Bianchi", "N46", 5678);

		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);
		dataAppelli.add(first);
		
		Corso c = gestione.creaCorso("IS", d, 9);
		Appello a = gestione.creaAppello(dataAppelli, true, c);
		System.out.println(a);
		
		c.addAppello(a);
		
		gestione.prenotaStudente(s1, a);

		gestione.prenotaStudente(s2, a);
		
		gestione.stampaStudentiPrenotati(a);

	}



} 

