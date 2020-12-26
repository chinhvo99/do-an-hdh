/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanhdh;

/**
 *
 * @author ADMIN
 */
public class ProcessEquation extends Thread {

    float[][] values;

    public ProcessEquation(float[][] values) {
        this.values = values;
    }

    public void run() {
        System.out.println("Start");
        for (int i = 0; i < values.length; i++) {
            // do the for in the row according to the column size
            for (int j = 0; j < values[i].length; j++) {
                // multiple the random by 10 and then cast to in
                System.out.print(values[i][j]);
            }
            // add a new line
            System.out.println();
        }
        for (int k = 0; k < values.length; k++) {
            //Check array[k][k] == 0
            if (values[k][k] == 0) {
                for (int i = k + 1; i < values.length; i++) {
                    if (values[i][k] != values[k][k]) {
                        for (int j = 0; j < values[0].length; j++) {
                            float temp = values[k][j];
                            values[k][j] = values[i][j];
                            values[i][j] = temp;
                        }
                        break;
                    }
                }
            }
            //Division of the pivot row
            float pivot = values[k][k];
            for (int j = 0; j < values[0].length; j++) {
                values[k][j] /= pivot;
            }

            //Elimination loop
            for (int i = 0; i < values.length; i++) {
                if (i == k || values[i][k] == 0) {
                    continue;
                }
                float factor = values[i][k];
                for (int j = 0; j < values[0].length; j++) {
                    values[i][j] -= factor * values[k][j];
                }
            }
        }
        System.out.println("After");
        for (int i = 0; i < values.length; i++) {
            // do the for in the row according to the column size
            System.out.println(values[i][values[0].length - 1]);
        }
    }

}
