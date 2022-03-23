package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Pescado extends Mascota {

	public Pescado() {
		setEstadisticas(2, 3, new String[] {
				NombresTipos.acuatico
		}, NombresMascotas.pescado);
	}

}
