package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Jirafa extends Mascota {

	public Jirafa(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 5, new String[] {
				NombresTipos.mamifero, NombresTipos.terrestre
		}, NombresMascotas.jirafa);
	}

	@Override
	public void iniciarBatalla() {
		fortalezaAliada();
	}

	public void fortalezaAliada() {

		int indiceJirafa = HelperClass.obtenerIndiceMascota(this, aliados);
		int indiceAliado = indiceJirafa + 1;

		for (int i = 1; i <= nivel; i++) {

			if (indiceAliado < 4) {
				Mascota aliado = aliados[indiceAliado];
				if (aliado != null && !aliado.equals(this)) {
					aliado.setAtaque(aliado.getAtaque() + 1);
					aliado.setVida(aliado.getVida() + 1);
				}
				indiceAliado++;
			}

		}

	}

}
