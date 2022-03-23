package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Grillo extends Mascota {

	public Grillo() {
		setEstadisticas(1, 2, new String[] { NombresTipos.insecto }, NombresMascotas.grillo);
	}

}
