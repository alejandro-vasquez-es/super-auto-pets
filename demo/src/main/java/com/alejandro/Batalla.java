package com.alejandro;

import com.alejandro.helpers.HelperClass;
import com.alejandro.jugador.Jugador;
import com.alejandro.mascotas.Mascota;

public class Batalla {

	// private int numeroRonda = 1;
	private int numeroRonda = 4; // pruebas
	private String campo = "Solitario";
	private Jugador jugador;
	private Jugador oponente;

	public Batalla(Jugador _jugador, Jugador _oponente) {
		jugador = _jugador;
		oponente = _oponente;
	}

	public void actualizarRonda() {
		numeroRonda++;
		if (numeroRonda == 4) {
			jugador.ataque = 2;
			oponente.ataque = 2;
		}
		if (numeroRonda == 7) {
			jugador.ataque = 3;
			oponente.ataque = 3;
		}
	}

	public void verificarTotalMascotas() {
		jugador.totalMascotas = HelperClass.totalMascotas(jugador.mascotas);
		oponente.totalMascotas = HelperClass.totalMascotas(oponente.mascotas);
	}

	public void iniciarBatalla() {
		aplicarHabilidadesInicioBatalla();

		jugador.setMascotaPeleadora();
		oponente.setMascotaPeleadora();

		while (jugador.totalMascotas != 0 && oponente.totalMascotas != 0) {
			batallaIndividual();
			verificarTotalMascotas();
		}

		verificarMascotasMuertas(jugador);
		verificarMascotasMuertas(oponente);

		if (jugador.totalMascotas == 0 && oponente.totalMascotas == 0) {
			HelperClass.imprimirTextoGuiones("Hubo un empate, ambos jugador se quedan sin mascotas");
		} else if (jugador.totalMascotas == 0) {
			ganarBatalla(oponente, "oponente");
		} else if (oponente.totalMascotas == 0) {
			ganarBatalla(jugador, "jugador");
		}

	}

	public void aplicarHabilidadesInicioBatalla() {

		for (int i = 0; i < oponente.totalMascotas; i++) {
			Mascota mascota = oponente.mascotas[i];
			mascota.iniciarBatalla();

		}

		for (int i = 0; i < jugador.totalMascotas; i++) {
			Mascota mascota = jugador.mascotas[i];
			mascota.iniciarBatalla();
		}

		verificarMascotasMuertas(oponente);
		verificarMascotasMuertas(jugador);

	}

	public void verificarMascotasMuertas(Jugador _jugador) {
		for (int i = 0; i < _jugador.totalMascotas; i++) {
			if (intentarMatarMascota(_jugador.mascotas[i], _jugador)) {
				i--;
			}
			;
		}
	}

	public boolean intentarMatarMascota(Mascota _mascota, Jugador _jugador) {
		if (!_mascota.estaVivo()) {
			_mascota.morir();
			_jugador.eliminarMascota(_mascota); // 0 porque la mascota peleadora siempre es la primera
			_jugador.totalMascotas--;
			_jugador.indice--;
			return true;
		}
		return false;

	}

	public void ganarBatalla(Jugador _jugador, String nombre) {
		HelperClass.imprimirTextoGuiones("El " + nombre + " ha ganado la batalla");
		System.out.println("Con un total de " + _jugador.totalMascotas + " mascotas vivas");
		System.out.println("Las mascotas que quedaron vivas son: ");
		_jugador.imprimirEstaidiscticasMascotas();
		_jugador.victorias++;
		_jugador.danarOponente();

	}

	public void setOponente(Jugador _oponente) {
		oponente = _oponente;
	}

	public void batallaIndividual() {
		jugador.mascotaPeleadora.atacar(oponente.mascotaPeleadora);
		oponente.mascotaPeleadora.atacar(jugador.mascotaPeleadora);

		intentarMatarMascota(jugador.mascotaPeleadora, jugador);
		jugador.setMascotaPeleadora();

		intentarMatarMascota(oponente.mascotaPeleadora, oponente);
		oponente.setMascotaPeleadora();
	}

	public void aplicarEfectosCambio() {
		// TODO: No sé por qué agregué esta función
	}

}
