package com.alejandro.jugador;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.mascotas.Mascota;

public class IA extends Jugador {

	public IA(Jugador _oponente) {
		super(_oponente);
		mascotas = new Mascota[5];
	}

	public void comprarMascotas(int tier) {
		boolean hayEspacios = (totalMascotas < 5);
		while (oro > 3 && hayEspacios) {
			hayEspacios = comprarMascotaAleatoria(tier);
		}
	}

	public boolean comprarMascotaAleatoria(int tier) {
		String nombre = NombresMascotas.obtenerMascotaAleatoria(tier);
		return comprarMascota(nombre);
	}

}
