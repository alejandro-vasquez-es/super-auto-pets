package com.alejandro;

import com.alejandro.helpers.HelperClass;
import com.alejandro.jugador.Jugador;
import com.alejandro.mascotas.Mascota;

public class Batalla {

	private int numeroRonda = 1;
	private String campo = "Solitario";
	private Jugador jugador;
	private Jugador oponente;

	public Batalla(Jugador _jugador, Jugador _oponente) {
		jugador = _jugador;
		oponente = _oponente;
	}

	public boolean iniciarBatalla() {
		if (jugador.totalMascotas == 0) {
			System.out.println("No puedes batallar sin mascotas, ve a la tienda a comprar");
			return true;
		}

		aplicarHabilidadesInicioBatalla();

		jugador.setMascotaPeleadora();
		oponente.setMascotaPeleadora();

		while (jugador.totalMascotas != 0 && oponente.totalMascotas != 0) {
			batallaIndividual();
		}

		if (jugador.totalMascotas == 0 && oponente.totalMascotas == 0) {
			HelperClass.imprimirTextoGuiones("Hubo un empate, ambos jugador se quedan sin mascotas");
		} else if (jugador.totalMascotas == 0) {
			ganarBatalla(oponente, "oponente");
		} else if (oponente.totalMascotas == 0) {
			ganarBatalla(jugador, "jugador");
		}

		return true;

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

		verificarMuerteInicio(oponente);
		verificarMuerteInicio(jugador);

	}

	public void verificarMuerteInicio(Jugador _jugador) {
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
