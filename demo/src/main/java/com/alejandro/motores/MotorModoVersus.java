package com.alejandro.motores;

import com.alejandro.Batalla;

public class MotorModoVersus extends MotorJuego {

	public MotorModoVersus() {
		super();
		modo = "Versus";
		// oponente = new IA(jugador);
		jugador.setOponente(null);
		batalla = new Batalla(jugador, oponente);

	}

}
