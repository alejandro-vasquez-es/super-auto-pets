package com.alejandro;

import java.util.Scanner;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.motores.MotorModoArena;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */

    public Menu menu = new Menu(new String[] {
            "1- Modo arena",
            "2- Modo versus",
            "3- Modo creativo",
    });

    public static void main(String[] args) {

        App app = new App();
        HelperClass.imprimirTextoGuiones("Bienvenido a Super Auto Pets");
        int opcion = app.menu.getOpcion();
        app.ejecutarOpcion(opcion);

    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                MotorModoArena arena = new MotorModoArena();
                arena.imprimirModo();
                arena.iniciarJuego();
                break;
            case 2:
                System.out.println("Ejecutando modo versus...");
                break;
            case 3:
                System.out.println("Ejecutando modo creativo...");
                break;

            default:
                break;
        }
    }
}
