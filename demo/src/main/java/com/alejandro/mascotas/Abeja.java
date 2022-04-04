package com.alejandro.mascotas;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;

public class Abeja extends Mascota {

	public Abeja(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 1, new String[] {
				NombresTipos.insecto
		}, NombresMascotas.abeja);
	}

}
