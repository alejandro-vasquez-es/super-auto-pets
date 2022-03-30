package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Dodo extends Mascota {

	public Dodo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 3, new String[] {
				NombresTipos.volador
		}, NombresMascotas.dodo);
	}

	@Override
	public void iniciarBatalla() {
		divisionDePoder();
	}

	public void divisionDePoder() {
		int indice = HelperClass.obtenerIndiceMascota(this, aliados);
		double porcentaje = (nivel == 1) ? 0.5 : (nivel == 2) ? 1 : 1.5;

		if (indice > 0) {
			Mascota aliado = aliados[indice - 1];
			aliado.setAtaque(aliado.getAtaque() + aliado.getAtaque() * porcentaje);
		}
	}

}
