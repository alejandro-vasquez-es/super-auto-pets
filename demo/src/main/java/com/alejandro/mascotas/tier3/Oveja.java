package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Oveja extends Mascota {

	public Oveja(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 2, new String[] {
				NombresTipos.domestico, NombresTipos.terrestre
		}, NombresMascotas.oveja);
	}

	@Override
	public void morir() {
		super.morir();
		revolucion();
	}

	public void revolucion() {
		for (int i = 0; i < 2; i++) {
			int totalAliados = HelperClass.totalMascotas(aliados);
			Mascota carnero = new Carnero(aliados, enemigos);
			carnero.setVida(nivel * 2);
			carnero.setAtaque(nivel * 2);
			if (totalAliados != 5) {
				aliados[totalAliados] = carnero;
			}
		}

	}

}
