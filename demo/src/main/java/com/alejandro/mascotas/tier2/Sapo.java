package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Sapo extends Mascota {

	public Sapo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 3, new String[] {
				NombresTipos.terrestre, NombresTipos.acuatico
		}, NombresMascotas.sapo);
	}

	@Override
	public void iniciarBatalla() {
		super.iniciarBatalla();
		metamorfosis();
	}

	public void metamorfosis() {
		int totalAliados = HelperClass.totalMascotas(aliados);
		double saludMayor = getVida();

		for (int i = 0; i < totalAliados; i++) {
			Mascota aliado = aliados[i];
			if (!aliado.equals(this) && saludMayor < aliado.getVida()) {
				saludMayor = aliado.getVida();
			}

		}

		if (saludMayor > 0)
			setVida(saludMayor);
	}

}
