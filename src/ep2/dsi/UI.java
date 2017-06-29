/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2.dsi;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class UI implements Runnable {
    Scanner entrada = new Scanner(System.in);
    boolean controle = true;

     //Metodo para execucao da interface com o usuario
    public void run() {
        
        while (controle) {
            try {
                System.out.println("Digite o comando desejado ou \"help\" para visualizar a lista de comandos validos:");
                String[] comando = entrada.nextLine().split(" ");
                switch (comando[0]){
                    case "quit":
                            System.exit(0);
                        break;
                    default: 
                        break;
                }
            } catch (Exception e) {

            }
        }

    }
    
}
