package com.alejandro.helpers;

import java.util.Arrays;

import com.alejandro.jugador.Jugador;
import com.alejandro.mascotas.Mascota;

public class Comidas {

	final public static String manzana = "manzana";
	final public static String naranja = "naranja";
	final public static String miel = "miel";
	final public static String pastelito = "pastelito";
	final public static String huesoDeCarne = "huesoDeCarne";
	final public static String pastillaParaDormir = "pastillaParaDormir";
	final public static String ajo = "ajo";
	final public static String ensalada = "ensalada";
	final public static String comidaEnlatada = "comidaEnlatada";
	final public static String pera = "pera";
	final public static String chile = "chile";
	final public static String chocolate = "chocolate";
	final public static String sushi = "sushi";
	final public static String melon = "melon";
	final public static String hongo = "hongo";
	final public static String pizza = "pizza";
	final public static String carne = "carne";
	final public static String gelatina = "gelatina";

	// TIERS
	public static String[] tier1 = new String[] {
			manzana, naranja, miel
	};
	public static String[] tier2 = new String[] {
			manzana, naranja,
			miel, pastelito, huesoDeCarne, pastillaParaDormir
	};
	public static String[] tier3 = new String[] {
			manzana, naranja,
			miel, pastelito, huesoDeCarne,
			pastillaParaDormir, ajo, ensalada, comidaEnlatada, pera
	};
	public static String[] tier4 = new String[] {
			manzana, naranja,
			miel, pastelito, huesoDeCarne,
			pastillaParaDormir, ajo, ensalada, comidaEnlatada, pera, chile, chocolate, sushi
	};
	public static String[] tier5 = new String[] {
			manzana, naranja,
			miel, pastelito, huesoDeCarne,
			pastillaParaDormir, ajo, ensalada, comidaEnlatada, pera, chile, chocolate,
			sushi, melon, hongo
	};
	public static String[] tier6 = new String[] {
			manzana, naranja,
			miel, pastelito, huesoDeCarne,
			pastillaParaDormir, ajo, ensalada, comidaEnlatada, pera, chile, chocolate,
			sushi, melon,
			hongo, pizza, carne
	};
	public static String[] tier7 = new String[] {
			manzana, naranja,
			miel, pastelito, huesoDeCarne,
			pastillaParaDormir, ajo, ensalada, comidaEnlatada, pera, chile, chocolate,
			sushi, melon,
			hongo, pizza,
			carne, gelatina
	};

	public static boolean tieneComida(String[] comidas, String _comida) {
		return Arrays.stream(comidas).anyMatch(comida -> comida == _comida);
	}

	public static void ejecutarComida(String _comida, Mascota _mascota) {
		_mascota.comidas[_mascota.indiceComidas] = _comida;
		_mascota.indiceComidas++;
		switch (_comida) {
			case manzana:
				ejecutarManzana(_mascota);
				break;
			case pastelito:
				ejecutarPastelito(_mascota);
				break;
			case ensalada:
				ejecutarEnsalada(_mascota.aliados);
				break;
			case pera:
				ejecutarPera(_mascota);
				break;

			default:
				System.out.println("La comida " + _comida + " fue dada a la mascota " + _mascota.nombre);
				break;
		}
	}

	public static void ejecutarManzana(Mascota _mascota) {

		System.out.println("Tu mascota " + _mascota.nombre + " pasó de tener " + _mascota.getAtaque()
				+ " de ataque y " + _mascota.getVida() + " de vida");
		_mascota.setAtaque(_mascota.getAtaque() + 1);
		_mascota.setVida(_mascota.getVida() + 1);
		System.out.println("a tener " + _mascota.getAtaque() + " de ataque y " + _mascota.getVida() + " de vida");

	}

	public static void ejecutarPera(Mascota _mascota) {
		if (!_mascota.pastelitoQuitado) {
			System.out.println("Tu mascota " + _mascota.nombre + " pasó de tener " + _mascota.getAtaque()
					+ " de ataque y " + _mascota.getVida() + " de vida");
			_mascota.setAtaque(_mascota.getAtaque() + 2);
			_mascota.setVida(_mascota.getVida() + 2);
			System.out.println("a tener " + _mascota.getAtaque() + " de ataque y " + _mascota.getVida() + " de vida");
		}

	}

	public static void ejecutarPastelito(Mascota _mascota) {

		System.out.println("Tu mascota " + _mascota.nombre + " pasó de tener " + _mascota.getAtaque()
				+ " de ataque y " + _mascota.getVida() + " de vida");
		_mascota.setAtaque(_mascota.getAtaque() + 3);
		_mascota.setVida(_mascota.getVida() + 3);
		System.out.println("a tener " + _mascota.getAtaque() + " de ataque y " + _mascota.getVida() + " de vida");

	}

	public static void ejecutarEnsalada(Mascota[] mascotas) {
		Mascota mascotaAlimentada = null;
		for (int i = 0; i < 2; i++) {
			Mascota mascotaAleatoria = HelperClass.obtenerMascotaAleatoria(mascotas,
					HelperClass.totalMascotas(mascotas));
			while (mascotaAleatoria.equals(mascotaAlimentada) && HelperClass.totalMascotas(mascotas) != 1) {
				mascotaAleatoria = HelperClass.obtenerMascotaAleatoria(mascotas, HelperClass.totalMascotas(mascotas));
			}
			mascotaAlimentada = mascotaAleatoria;
			mascotaAleatoria.setAtaque(mascotaAleatoria.getAtaque() + 1);
			mascotaAleatoria.setVida(mascotaAleatoria.getVida() + 1);
			System.out.println("A tu mascota " + mascotaAleatoria.nombre + " le ha subida la vida y el ataque en 1 ");
		}
	}

}
