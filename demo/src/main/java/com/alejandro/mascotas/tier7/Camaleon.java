package com.alejandro.mascotas.tier7;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Camaleon extends Mascota {
	public Camaleon(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(8, 8, new String[] { NombresTipos.reptil, NombresTipos.solitario }, NombresMascotas.camaleon);
	}

}