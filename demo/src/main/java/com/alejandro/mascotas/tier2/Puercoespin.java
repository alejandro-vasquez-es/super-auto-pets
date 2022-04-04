package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Puercoespin extends Mascota {
	public Puercoespin(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 2, new String[] {
				NombresTipos.solitario, NombresTipos.terrestre
		}, NombresMascotas.puercoespin);
	}

	@Override
	public void morir() {
		super.morir();
		espinasSalvajes(aliados);
		espinasSalvajes(enemigos);
	}

	public void espinasSalvajes(Mascota[] _mascotas) {

		int totalMascotas = HelperClass.totalMascotas(_mascotas);

		double ataqueIncial = getAtaque();
		setAtaque(nivel * 2);

		for (int i = 0; i < totalMascotas; i++) {
			if (!this.equals(_mascotas[i])) {
				atacar(_mascotas[i]);
			}
		}

		setAtaque(ataqueIncial);
	}
}
