package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Caballo extends Mascota {

	public Caballo() {
		setEstadisticas(2, 1, new String[] {
				NombresTipos.mamifero, NombresTipos.domestico
		}, NombresMascotas.caballo);
		subirNivel(false);
		subirNivel(false);
		subirNivel(false);
		subirNivel(false);
	}

	public void rugidoAliado(Mascota[] _aliados) {
		for (Mascota aliado : _aliados) {
			aliado.setAtaque(nivel);
		}
	}

}
