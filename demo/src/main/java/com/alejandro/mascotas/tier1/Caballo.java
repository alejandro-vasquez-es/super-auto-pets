package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Caballo extends Mascota {

	public Caballo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 1, new String[] {
				NombresTipos.mamifero, NombresTipos.domestico
		}, NombresMascotas.caballo);
	}

	@Override
	public void iniciarBatalla() {
		rugidoAliado();
	}

	public void rugidoAliado() {
		int totalAliados = HelperClass.totalMascotas(aliados);

		for (int i = 0; i < totalAliados; i++) {
			Mascota aliado = aliados[i];
			aliado.setAtaque(aliado.getAtaque() + nivel);
		}
	}

}
