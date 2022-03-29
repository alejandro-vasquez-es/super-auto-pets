package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Castor extends Mascota {

	public Castor(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 2, new String[] { NombresTipos.terrestre, NombresTipos.acuatico }, NombresMascotas.castor);
	}

	@Override
	public void venderse() {
		represa();
	}

	public void represa() {
		int totalMascotas = HelperClass.totalMascotas(aliados);

		for (int i = 0; i < 2; i++) {
			Mascota aliado = HelperClass.obtenerMascotaAleatoria(aliados, totalMascotas);
			if (totalMascotas != 1) {
				while (aliado.equals(this)) {
					aliado = HelperClass.obtenerMascotaAleatoria(aliados, totalMascotas);
				}
				aliado.setVida(aliado.getVida() + nivel);
			}
		}
	}

}
