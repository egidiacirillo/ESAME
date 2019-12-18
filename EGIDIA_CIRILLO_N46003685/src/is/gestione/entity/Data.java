package is.gestione.entity;
import java.time.LocalDate;

public class Data {

	protected LocalDate data;
	protected Tipologia tipo;
	protected Sede luogo;

public Data(LocalDate _data, Tipologia _tipo, Sede _luogo) {

		this.data= _data;
		luogo=_luogo;
		tipo=_tipo;

	}

public LocalDate getData() {
	return data;

	}

public Tipologia getTipo() {
	return tipo;

	}

	

	public Sede getLuogo() {
		return luogo;
}

}