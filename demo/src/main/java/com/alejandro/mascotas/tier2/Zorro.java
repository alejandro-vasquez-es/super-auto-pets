package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Zorro extends Mascota {
	private int contador = 0;

	public Zorro(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 2, new String[] {
				NombresTipos.solitario, NombresTipos.terrestre
		}, NombresMascotas.zorro);
	}

	@Override
	public void atacar(Mascota _oponente) {
		super.atacar(_oponente);
		ataqueRapido(_oponente);
	}

	public void ataqueRapido(Mascota _oponente) {
		if (contador == 0) {
			super.atacar(_oponente);
		}
		contador++;
		reinicarContador();
	}

	public void reinicarContador() {
		if ((nivel == 1 && contador == 3) || (nivel == 2 && contador == 2) || nivel == 3) {
			contador = 0;
		}
	}
}
