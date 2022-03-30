package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Elefante extends Mascota {
	public Elefante(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 5, new String[] {
				NombresTipos.mamifero, NombresTipos.terrestre
		}, NombresMascotas.elefante);
	}

	@Override
	public void atacar(Mascota _oponente) {
		danoColateral();
		super.atacar(_oponente);
	}

	public void danoColateral() {
		int indiceElefante = HelperClass.obtenerIndiceMascota(this, aliados);

		for (int i = 1; i <= nivel; i++) {

			Mascota aliado = aliados[indiceElefante + i];
			if (aliado != null && !aliado.equals(this)) {
				double ataqueIncial = getAtaque();
				setAtaque(1);
				aliado.recibirAtaque(this);
				setAtaque(ataqueIncial);
			}
		}
	}
}
