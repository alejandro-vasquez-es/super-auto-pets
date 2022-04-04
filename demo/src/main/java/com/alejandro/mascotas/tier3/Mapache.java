package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Mapache extends Mascota {
	public Mapache(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 4, new String[] {
				NombresTipos.solitario
		}, NombresMascotas.mapache);
	}

	@Override
	public void morir() {
		super.morir();
		repartirPoder();
	}

	public void repartirPoder() {
		int indiceMapache = HelperClass.obtenerIndiceMascota(this, aliados);
		if (indiceMapache < 4 && aliados[indiceMapache + 1] != null) {
			aliados[indiceMapache + 1].setAtaque(aliados[indiceMapache + 1].getAtaque() * nivel);
		}
	}
}
