package is.gestione.control;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import is.gestione.entity.*;

class GestioneAppelliTest {

	@Test
	public void test1UnoStudenteUnAppelloUnCorso() throws Exception {

		GestioneAppelli gestione = new GestioneAppelli();
		ArrayList<Data> dataAppelli = new ArrayList<>();
		
		Docente d = new Docente("Natella");
		Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);
		
		dataAppelli.add(first);
		
		Corso c = gestione.creaCorso("IS", d, 9);
		
		Appello a = gestione.creaAppello(dataAppelli, false, c);
		
		c.addAppello(a);
		
		gestione.prenotaStudente(s1, a);

		gestione.stampaStudentiPrenotati(a);

	}

	
                                      
	@Test

	public void test2DueStudentiUnAppelloUnCorso() throws Exception {

		GestioneAppelli gestione = new GestioneAppelli();

		ArrayList<Data> dataAppelli = new ArrayList<>();
		
		Docente d = new Docente("Natella");
		Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
		Studente s2= new Studente("Luigi", "Bianchi", "N46", 5678);
		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);
		dataAppelli.add(first);
		
		Corso c = gestione.creaCorso("IS", d, 9);
		
		Appello a = gestione.creaAppello(dataAppelli, false, c);
		
		c.addAppello(a);
		
		gestione.prenotaStudente(s1, a);
		gestione.prenotaStudente(s2, a);
		
		gestione.stampaStudentiPrenotati(a);

	}
	
	
	@Test

	public void test3NessunoStudente() throws Exception {

		GestioneAppelli gestione = new GestioneAppelli();

		ArrayList<Data> dataAppelli = new ArrayList<>();

		

		Docente d = new Docente("Natella");
		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);
		
		dataAppelli.add(first);
		
		Corso c = gestione.creaCorso("IS", d, 9);
		
		Appello a = gestione.creaAppello(dataAppelli, true, c);
		
		c.addAppello(a);
		
		gestione.stampaStudentiPrenotati(a);

	}

	@Test

	public void test4StudentePrenotatoDueVolteLoStessoAppello() throws Exception{

		GestioneAppelli gestione = new GestioneAppelli();

		ArrayList<Data> dataAppelli = new ArrayList<>();
		Docente d = new Docente("Natella");
		Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);
		dataAppelli.add(first); 
		
		Corso c = gestione.creaCorso("IS", d, 9);
		
		Appello a = gestione.creaAppello(dataAppelli, false, c);
		
		c.addAppello(a);
		
		gestione.prenotaStudente(s1, a);

		gestione.prenotaStudente(s1, a);
		
		gestione.stampaStudentiPrenotati(a);

	}

	

	@Test

	public void test5StudenteCercaDiPrenotarsiAdUnAppelloChiuso() throws Exception {

		GestioneAppelli gestione = new GestioneAppelli();

		ArrayList<Data> dataAppelli = new ArrayList<>();
		
		Docente d = new Docente("Natella");
		Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);;
		
		dataAppelli.add(first);

		

		Corso c = gestione.creaCorso("IS", d, 9);
		
		Appello a = gestione.creaAppello(dataAppelli, false, c);
		
		c.addAppello(a);

		gestione.chiudiAppello(a);
		
		gestione.prenotaStudente(s1, a);
		
		gestione.stampaStudentiPrenotati(a);

	}


 @Test
 
 public void test6UnoStudentePrenotaPiuAppelliPerPiuCorsi () throws Exception {
	 
	 GestioneAppelli gestione = new GestioneAppelli();

		ArrayList<Data> dataAppelli = new ArrayList<>();
		
		Docente d = new Docente("Natella");
		Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
		Data first = new Data(LocalDate.of(2019, 12, 18), Tipologia.Calcolatore, Sede.Aula);;
		
		dataAppelli.add(first);
		
		Corso c1 = gestione.creaCorso("IS", d, 9);
		Corso c2= gestione.creaCorso("SO", d, 9);
		
		Appello a1 = gestione.creaAppello(dataAppelli, false, c1);
		Appello a2 = gestione.creaAppello(dataAppelli, false, c2);
		c1.addAppello(a1);
		c2.addAppello(a2);
		
		gestione.prenotaStudente(s1,a1);
		gestione.prenotaStudente(s1,a2);
		
		gestione.stampaStudentiPrenotati(a1);
		gestione.stampaStudentiPrenotati(a2);
		

	}
	 

@Test

public void test7StudentePrenotaUnAppelloSenzaDate() throws Exception{

	GestioneAppelli gestione = new GestioneAppelli();

	ArrayList<Data> dataAppelli = new ArrayList<>();
	
	Docente d = new Docente("Natella");
	Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
	
	Corso c1 = gestione.creaCorso("IS", d, 9);
	
	Appello a1 = gestione.creaAppello(dataAppelli, false, c1);
	
	c1.addAppello(a1);
	gestione.prenotaStudente(s1,a1);
	
	gestione.stampaStudentiPrenotati(a1);
	}

@Test
public void test8UnoStudentePrenotaAppelloApertoUnoStudentePrenotaAppelloChiuso() throws Exception{
	GestioneAppelli gestione = new GestioneAppelli();

	ArrayList<Data> dataAppelli = new ArrayList<>();
	
	Docente d = new Docente("Natella");
	Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
	Studente s2= new Studente("Luigi", "Bianchi", "N46", 5678);
	Data first = new Data(LocalDate.of(2018, 12, 18), Tipologia.Calcolatore, Sede.Aula);
	dataAppelli.add(first);
	
	Corso c = gestione.creaCorso("IS", d, 9);
	
	Appello a = gestione.creaAppello(dataAppelli, false, c);
	
	c.addAppello(a);
	
	gestione.prenotaStudente(s1, a);
	gestione.chiudiAppello(a);
	gestione.prenotaStudente(s2, a);
	
	gestione.stampaStudentiPrenotati(a);

}

@Test
public void test9StudentePrenotaAppelloConPiudate() throws Exception{
	GestioneAppelli gestione = new GestioneAppelli();

	ArrayList<Data> dataAppelli = new ArrayList<>();
	
	Docente d = new Docente("Natella");
	Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
	Data first = new Data(LocalDate.of(2018, 12, 18), Tipologia.Calcolatore, Sede.Aula);
	Data second = new Data(LocalDate.of(2018, 12, 19), Tipologia.Calcolatore, Sede.Aula);
	dataAppelli.add(first);
	dataAppelli.add(second);
	
	Corso c1 = gestione.creaCorso("IS", d, 9);
	
	Appello a1 = gestione.creaAppello(dataAppelli, false, c1);
	
	c1.addAppello(a1);
	gestione.prenotaStudente(s1,a1);
	
	gestione.stampaStudentiPrenotati(a1);
	}
	
	
@Test
public void test10StudentePrenotaDueAppelliApertiEUnoChiuso() throws Exception{
	GestioneAppelli gestione = new GestioneAppelli();

	ArrayList<Data> dataAppelli = new ArrayList<>();
	
	Docente d = new Docente("Natella");
	Studente s1 = new Studente("Egidia", "Cirillo", "N46", 1234);
	Data first = new Data(LocalDate.of(2018, 12, 18), Tipologia.Calcolatore, Sede.Aula);
	dataAppelli.add(first);
	Corso c1 = gestione.creaCorso("IS", d, 9);
	Corso c2 = gestione.creaCorso("SO", d, 9);
	Corso c3 = gestione.creaCorso("EG", d, 9);
	
	Appello a1 = gestione.creaAppello(dataAppelli, false, c1);
	Appello a2 = gestione.creaAppello(dataAppelli, false, c2);
	Appello a3 = gestione.creaAppello(dataAppelli, false, c3);
	
	
	c1.addAppello(a1);
	c2.addAppello(a2);
	c3.addAppello(a3);
	 gestione.chiudiAppello(a3);
	
	gestione.prenotaStudente(s1,a1);
	gestione.prenotaStudente(s1,a2);
	gestione.prenotaStudente(s1,a3);
	
	gestione.stampaStudentiPrenotati(a1);
	gestione.stampaStudentiPrenotati(a2);
	gestione.stampaStudentiPrenotati(a3);
	
	}
	
}