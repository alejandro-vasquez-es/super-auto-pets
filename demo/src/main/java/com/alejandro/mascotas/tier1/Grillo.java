package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Grillo extends Mascota {

	public Grillo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 2, new String[] { NombresTipos.insecto }, NombresMascotas.grillo);
	}

	@Override
	public void morir() {
		super.morir();
		zombificacion();
	}

	public void zombificacion() {
		int indiceGrillo = HelperClass.obtenerIndiceMascota(this, aliados);
		aliados[indiceGrillo] = new GrilloZombie(aliados, enemigos);
		aliados[indiceGrillo].setEstadisticas(nivel, nivel, new String[] {}, "Grillo Zombie");
	}

}
