package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Escorpion extends Mascota {
	public Escorpion(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 1, new String[] { NombresTipos.desertico, NombresTipos.solitario },
				NombresMascotas.escorpion);
	}

	public void aguja() {
	}
}