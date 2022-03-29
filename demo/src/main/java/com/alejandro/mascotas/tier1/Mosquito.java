package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Mosquito extends Mascota {

	public Mosquito(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 2, new String[] { NombresTipos.volador }, NombresMascotas.mosquito);
	}

	@Override
	public void iniciarBatalla() {
		piequeteInicial();
	}

	public void piequeteInicial() {
		int totalEnemigos = HelperClass.totalMascotas(enemigos);

		for (int i = 0; i < totalEnemigos; i++) {
			Mascota enemigo = enemigos[i];
			double ataqueInicial = getAtaque();
			setAtaque(nivel);
			atacar(enemigo);
			setAtaque(ataqueInicial);
		}
	}

}
