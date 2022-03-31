package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Caracol extends Mascota {
	public Caracol(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 2, new String[] {
				NombresTipos.insecto, NombresTipos.solitario
		}, NombresMascotas.caracol);
	}

	@Override
	public void comprarse() {
		resurgir();
	}

	public void resurgir() {
		int totalAliados = HelperClass.totalMascotas(aliados);

		for (int i = 0; i < totalAliados; i++) {
			Mascota aliado = aliados[i];
			aliado.setVida(aliado.getVida() + nivel);
			aliado.setAtaque(aliado.getAtaque() + nivel);

		}
	}

}
