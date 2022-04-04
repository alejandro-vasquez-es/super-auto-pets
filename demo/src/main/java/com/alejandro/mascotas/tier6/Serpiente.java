package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Serpiente extends Mascota {
	public Serpiente(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(6, 6, new String[] { NombresTipos.reptil, NombresTipos.terrestre, NombresTipos.desertico },
				NombresMascotas.serpiente);
	}

	public void ataqueDiscreto() {
	}
}