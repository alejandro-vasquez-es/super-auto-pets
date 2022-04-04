package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Tortuga extends Mascota {

	public Tortuga(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 2, new String[] {
				NombresTipos.reptil
		}, NombresMascotas.tortuga);
	}

	@Override
	public void morir() {
		super.morir();
		proteccionAliada();
	}

	public void proteccionAliada() {
		int indiceTortuga = HelperClass.obtenerIndiceMascota(this, aliados);
		int indiceAliado = indiceTortuga + 1;

		for (int i = 1; i <= nivel; i++) {

			if (indiceAliado < 4) {
				Mascota aliado = aliados[indiceAliado];
				if (aliado != null && !aliado.equals(this)) {
					aliado.efectoArmaduraMelon();
				}
				indiceAliado++;
			}

		}
	}

}
