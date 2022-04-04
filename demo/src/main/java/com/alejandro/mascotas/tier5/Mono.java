package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Mono extends Mascota {
	public Mono(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 2, new String[] { NombresTipos.mamifero }, NombresMascotas.mono);
	}

	public void amistad() {
	}
}