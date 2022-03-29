package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Pescado extends Mascota {

	public Pescado(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 3, new String[] {
				NombresTipos.acuatico
		}, NombresMascotas.pescado);
	}

	public void subirNivel() {
		super.subirNivel();
		powerUp();
	}

	public void powerUp() {
		int totalMascotas = HelperClass.totalMascotas(aliados);

		for (int i = 0; i < totalMascotas; i++) {
			Mascota aliado = aliados[i];
			if (!aliado.equals(this)) {
				aliado.setAtaque(aliado.getAtaque() + nivel - 1);
				aliado.setVida(aliado.getVida() + nivel - 1);
			}
		}
	}

}
