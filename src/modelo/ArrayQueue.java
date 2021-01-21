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
package modelo;

import edu.oharenas.util.EmptyQueueException;

/**
 *
 * @author Oscar Arenas
 */
public class ArrayQueue {

    private double[] data;
    private int front;
    private int n;

    public ArrayQueue() {
        data = new double[1];
        front = 0;
        n = 0;
    }

    public void enqueue(double item) {
        if (data.length == n) {
            resize(2 * n);
        }
        data[(front + n) % data.length] = item;
        n++;
    }

    public double dequeue() throws EmptyQueueException {
        if (n > 0) {
            double item = data[front];
            n--;
            front = (front + 1) % data.length;

            if (data.length / 4 == n) {
                resize(data.length / 2);
            }
            return item;
        }
        throw new EmptyQueueException();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int nc) {
        if (nc > 0 && nc >= n) {
            double[] newArray = new double[nc];

            for (int i = 0; i < n; i++) {
                newArray[i] = data[(front + i) % data.length];
            }
            data = newArray;
            front = 0;
        }
    }

    @Override
    public String toString() {
        String text = "";

        if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                text += data[(front + i) % data.length] + ", ";
            }
            text += data[(front + n - 1) % data.length];
        }
        return "[" + text + "]";
    }
}
