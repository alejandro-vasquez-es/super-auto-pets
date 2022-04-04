package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Delfin extends Mascota {
	public Delfin(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(4, 6, new String[] { NombresTipos.acuatico }, NombresMascotas.delfin);
	}

	public void salpicon() {
	}
}