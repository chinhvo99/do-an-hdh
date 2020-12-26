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
public class CreateNumberMethod extends Thread {

    private float[][] values;

    public CreateNumberMethod(float[][] values) {
        this.values = values;
    }

    public void run() {
        for (int i = 0; i < values.length; i++) {
            // do the for in the row according to the column size
            for (int j = 0; j < values[i].length; j++) {
                // multiple the random by 10 and then cast to in
                values[i][j] = ((int) (Math.random() * 10));
                System.out.print(values[i][j]+" ");
            }
            // add a new line
            System.out.println();
        }
        System.out.println("Done");
    }
}
