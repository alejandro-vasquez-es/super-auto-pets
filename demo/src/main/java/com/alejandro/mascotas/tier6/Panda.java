package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Panda extends Mascota {
	public Panda(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 5, new String[] { NombresTipos.mamifero, NombresTipos.solitario }, NombresMascotas.panda);
	}

	public void fortaleza() {
	}
}
