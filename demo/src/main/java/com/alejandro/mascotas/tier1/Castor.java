package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Castor extends Mascota {

	public Castor() {
		setEstadisticas(2, 2, new String[] { NombresTipos.terrestre, NombresTipos.acuatico }, NombresMascotas.castor);
	}

}
