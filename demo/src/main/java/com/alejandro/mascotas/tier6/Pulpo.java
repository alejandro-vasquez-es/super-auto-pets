package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Pulpo extends Mascota {
	public Pulpo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(8, 8, new String[] { NombresTipos.acuatico, NombresTipos.solitario }, NombresMascotas.pulpo);
	}

}