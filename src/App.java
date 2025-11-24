import java.util.Random;
import java.util.Scanner;

import abstrac.HostilMob;
import character.MainCharacter;
import mobs.Zombie;
import mobs.Enderman;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== Enemy Simulator ===");
        System.out.println("Bienvenido jugador.");

        System.out.println("\nElige tu arma:");
        System.out.println("1. Ninguna");
        System.out.println("2. Espada de madera");
        System.out.println("3. Espada de hierro");
        System.out.println("4. Espada de diamante");
        int arma = leerEntero(sc, 1, 4);

        int fuerza = switch (arma) {
            case 2 -> 2;
            case 3 -> 3;
            case 4 -> 5;
            default -> 1;
        };

        System.out.println("\nElige tu armadura:");
        System.out.println("1. Ninguna");
        System.out.println("2. Cuero");
        System.out.println("3. Hierro");
        System.out.println("4. Diamante");
        int armor = leerEntero(sc, 1, 4);

        int defensa = switch (armor) {
            case 2 -> 1;
            case 3 -> 2;
            case 4 -> 3;
            default -> 0;
        };

        MainCharacter personaje = new MainCharacter(fuerza, defensa);

        HostilMob enemigo = rand.nextBoolean() ? new Zombie() : new Enderman();
        System.out.println("\nHa aparecido un enemigo: " + enemigo.getClass().getSimpleName());

        int turnos = 0;

        while (personaje.isAlive() && enemigo.isAlive()) {
            turnos++;

            System.out.println("\n--- Turno " + turnos + " ---");

            int dañoPJ = personaje.attack();
            System.out.println("El personaje ataca con " + dañoPJ);
            enemigo.receiveAttack(dañoPJ);

            if (!enemigo.isAlive()) break;

            if (rand.nextBoolean()) {
                int dañoMob = enemigo.attack();
                System.out.println("El enemigo ataca con " + dañoMob);
                personaje.receiveAttack(dañoMob);
            } else {
                enemigo.move();
            }
        }

        System.out.println("\n FIN DEL COMBATE");
        System.out.println("Turnos totales: " + turnos);

        if (personaje.isAlive())
            System.out.println("El personaje principal ha ganado");
        else
            System.out.println("El enemigo ha vencido");

        sc.close();
    }

    private static int leerEntero(Scanner sc, int min, int max) {
        int valor;
        while (true) {
            System.out.print("> ");
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Introduce un valor entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println("Entrada inválida.");
                sc.next();
            }
        }
    }
}

