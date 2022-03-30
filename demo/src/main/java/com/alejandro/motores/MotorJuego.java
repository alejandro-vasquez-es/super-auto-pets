package com.alejandro.motores;

import com.alejandro.Batalla;
import com.alejandro.Tienda;
import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.jugador.Jugador;
import com.alejandro.jugador.JugadorReal;

public class MotorJuego {

	public String modo;
	public Jugador jugador;
	public Jugador oponente;
	public Tienda tienda;
	public Batalla batalla;
	public Menu menu = new Menu(new String[] {
			"1- Batallar",
			"2- Acciones entre batallas",
	});

	public MotorJuego() {
		jugador = new JugadorReal(null);
		tienda = new Tienda();
	}

	public void imprimirModo() {
		String texto = getModo();
		HelperClass.imprimirTextoGuiones(texto);
	}

	public String getModo() {
		String texto = "Has empezado el juego en modo " + modo;
		return texto;
	}

}
