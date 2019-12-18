package is.gestione.entity;
import java.util.ArrayList;

public class Appello {
	
	ArrayList<Data> elenco_date;
    boolean isConcluso;
    ArrayList<Studente> studentiPrenotati;
    
    public Appello() {
    	
    	elenco_date = new ArrayList<Data>();
        isConcluso = false;
        studentiPrenotati = new ArrayList<Studente>();
       
    }

public Appello(ArrayList<Data> date, boolean concluso) {
	
	elenco_date = date;
	isConcluso = concluso;
	studentiPrenotati = new ArrayList<Studente>();
	
	}	

public void addStudente(Studente s) {
	studentiPrenotati.add(s);
	}

public ArrayList<Studente> getStudenti(){
	return studentiPrenotati;
	}

public void setDate(ArrayList<Data> _date) {
	elenco_date = _date;
	 }

public ArrayList<Data>getDate(){
	return elenco_date;
}


public boolean getIsConcluso() {
	return isConcluso;
	}

public void setisConcluso(boolean _concluso) {
	isConcluso = _concluso;
	}

public void addData(Data _data) {
	elenco_date.add(_data);
	}

public String toString() {
	
	StringBuffer buff = new StringBuffer();
	if(isConcluso==true) {
		
		buff.append("Stato appello: CHIUSO");

	} else {

		buff.append("Stato appello: APERTO");

	}

	return buff.toString();

}
}

	
