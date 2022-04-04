package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Gato extends Mascota {
	public Gato(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(4, 5, new String[] { NombresTipos.mamifero }, NombresMascotas.gato);
	}

	public void maullido() {
	}
}