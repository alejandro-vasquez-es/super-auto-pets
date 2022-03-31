package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Buho extends Mascota {

	public Buho(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 3, new String[] {
				NombresTipos.volador, NombresTipos.solitario
		}, NombresMascotas.buho);
	}

	@Override
	public void venderse() {
		suerteAmigos();
	}

	public void suerteAmigos() {
		Mascota aliadoAlAzar = HelperClass.obtenerMascotaAleatoria(aliados, HelperClass.totalMascotas(aliados));
		while (HelperClass.totalMascotas(aliados) > 1 && this.equals(aliadoAlAzar)) {
			aliadoAlAzar = HelperClass.obtenerMascotaAleatoria(aliados, HelperClass.totalMascotas(aliados));
		}
		aliadoAlAzar.aumentarEstadisticas(nivel * 2, nivel * 2);

	}

}
