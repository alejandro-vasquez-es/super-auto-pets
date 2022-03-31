package com.alejandro.jugador;

import com.alejandro.helpers.HelperClass;
import com.alejandro.mascotas.Mascota;

public class Jugador {

	public int vida = 10;
	public int ataque = 1;
	public int victorias = 0;
	public int oro = 10;
	public Mascota[] mascotas;
	public Mascota mascotaPeleadora;
	public int indice = 0;
	public int totalMascotas = 0;
	public Jugador oponente;

	public Jugador(Jugador _oponente) {
		oponente = _oponente;
	}

	public void setOponente(Jugador _oponente) {
		oponente = _oponente;
	}

	public void danarOponente() {
		oponente.vida -= ataque;
	}

	public void actualizarAtaque(int _ronda) {
		if (_ronda == 4)
			ataque = 2;
		if (_ronda == 7)
			ataque = 3;
	}

	public boolean comprarMascota(String _nombre) {

		if (totalMascotas < 5) {
			mascotas[indice] = HelperClass.instanciarTipoNombre(_nombre, mascotas, oponente.mascotas);
			mascotas[indice].comprarse();
			oro -= 3;
			totalMascotas++;
			indice++;
			return true;
		} else {
			return false;
		}

	}

	public void anadirOro() {
		oro += 10;
	}

	public Mascota buscarMascota(String _nombre) {
		for (int i = 0; i < totalMascotas; i++) {
			if (mascotas[i].nombre == _nombre) {
				return mascotas[i];
			}

		}

		return null;
	}

	public int venderMascota(Mascota _mascota) {
		totalMascotas--;
		indice--;
		int oroGanado = _mascota.nivel;
		_mascota.venderse();

		eliminarMascota(_mascota);

		return oroGanado;

	}

	public void eliminarMascota(Mascota _mascota) {

		// reorganiza a las mascotas para que no haya null en el rango de totalMascotas
		int indiceMascota = 0;
		for (int i = 0; i < totalMascotas; i++) {
			if (_mascota.equals(mascotas[i])) {
				indiceMascota = i;
				break;
			}
		}

		mascotas[indiceMascota] = null;
		for (int i = indiceMascota; i < mascotas.length - 1; i++) {
			Mascota temp = mascotas[i + 1];
			mascotas[i + 1] = mascotas[i];
			mascotas[i] = temp;
		}
	}

	public void setMascotaPeleadora() {
		mascotaPeleadora = mascotas[0];
	}

	public void imprimirEstaidiscticasMascotas() {
		for (int i = 0; i < totalMascotas; i++) {
			System.out.println((i + 1) + ". " + mascotas[i].nombre);
			System.out.println("con un total de " + mascotas[i].getAtaque() + " puntos de ataque");
			System.out.println("con un total de " + mascotas[i].getVida() + " puntos de vida");
		}
	}

}
