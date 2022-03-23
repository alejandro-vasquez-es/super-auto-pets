package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Mosquito extends Mascota {

	public Mosquito() {
		setEstadisticas(2, 2, new String[] { NombresTipos.volador }, NombresMascotas.mosquito);
	}

}
