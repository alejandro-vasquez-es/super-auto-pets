package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Hormiga extends Mascota {

	public Hormiga() {
		setEstadisticas(2, 1, new String[] {
				NombresTipos.insecto, NombresTipos.terrestre
		}, NombresMascotas.hormiga);
	}

	public void companerismo() {

	}

}
