package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Rata extends Mascota {

	public Rata(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(4, 5, new String[] {
				NombresTipos.terrestre, NombresTipos.solitario
		}, NombresMascotas.rata);
	}

	@Override
	public void morir() {
		ayudaHipocrita();
	}

	public void ayudaHipocrita() {

		for (int i = 0; i < nivel; i++) {
			int totalEnemigos = HelperClass.totalMascotas(enemigos);
			Mascota dirtyRat = new DirtyRat(aliados, enemigos);
			if (totalEnemigos != 5) {
				enemigos[totalEnemigos] = dirtyRat;
			}
		}
	}

}
