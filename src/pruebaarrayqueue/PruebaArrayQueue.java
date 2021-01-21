/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pruebaarrayqueue;

import edu.oharenas.aleatorio.Aleatorio;
import modelo.ArrayQueue;

/**
 *
 * @author Oscar Arenas
 */
public class PruebaArrayQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayQueue cola = new ArrayQueue();

        int n = Aleatorio.entero(6, 12);

        int[] codigos = Aleatorio.generarVectorEnteroSinRepeticiones(1, 100, n);

        for (int i = 0; i < codigos.length; i++) {
            cola.enqueue(codigos[i]);
        }

        System.out.println("\nCola inicial: " + cola);

        while (!cola.isEmpty()) {
            System.out.println("\nSe atendió el: " + cola.dequeue());
            System.out.println("Cola: " + cola);
        }
    }
}
