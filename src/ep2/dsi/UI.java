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
        //Variaveis periodo
        String dia="", mes="", ano="", agrupamento="";
        
        while (controle) {
            try {
                System.out.println("Digite o comando desejado ou \"help\" para visualizar a lista de comandos validos:");
                String[] comando = entrada.nextLine().split(" ");
                comando[0].toUpperCase();
                if(comando.length==3){
                    String[] aux;
                    aux=comando[1].split("/");
                    if(aux.length==3){
                        dia=aux[0];
                        mes=aux[1];
                        ano=aux[2];
                    }else{
                        System.out.println("Periodo invalido, favor seguir o formato dd/mm/aaaa");
                    }
                    agrupamento=comando[2];
                }
                    
                switch (comando[0]){
                    //Sair do programa
                    case "QUIT":
                            System.exit(0);
                    break;
                    //Temperatura media (Fahrenheint)
                    case "TEMP":
                        break;
                    //Ponto de orvalho medio (Fahrenheint) 
                    case "DEWP":
                        break;
                    //Nivel medio de pressao no nivel do mar (Milibar)
                    case "SLP":
                        break;
                    //Pressao media na estacao (Milibar)
                    case "STP":
                        break;
                    //Visibilidade media (Milhas)
                    case "VISIB":
                        break;   
                    //Velocidade media do vento (Nós)
                    case "WSPD":
                        break;
                    //Velocidade max do vento (Nós)
                    case "MXSPD":
                        break;
                    //Velocidade max de rajadas de vento (Nós)
                    case "GUST":
                        break;    
                    //Temperatura maxima (Fahrenheint)
                    case "MAX":
                        break;
                    //Temperatura minima (Fahrenheint)
                    case "MIN":
                        break;
                    //Precipitacao total (Polegadas)
                    case "PRCP":
                        break;    
                    //Porfundidade da neve (Polegadas)
                    case "SNDP":
                        break;    
                    //Ajuda    
                    case "HELP":
                        System.out.println("Os comandos serão aceitos no seguinte formato:\n"
                                + "<tipo_de_dado> <dd/mm/aaaa> <agrupamento>\n\n"
                                + "Tipos de agrupamento:\n"
                                + "Dia da semana, Mes ou Ano\n\n"
                                + "Tipos de dado disponíveis:\n"
                                + "TEMP - Temperaura media (Fahrenheint)\n"
                                + "DEWP - Ponto de orvalho medio (Fahrenheint)\n"
                                + "SLP - Nivel medio da pressao atmosferico no nivel do mar (Milibar)\n"
                                + "STP - Nivel medio da pressao atmosferico na estacao (Milibar)\n"
                                + "VISIB - Visibilidade media (Milhas)\n"
                                + "WSPD - Velocidade media do vento (Nós)\n"
                                + "MXSPD - Velocidade maxima do vento\n"
                                + "GUST - Velocidade maxima das rajadas de vento\n"
                                + "MAX - Temperatura maxima (Fahrenheint)\n"
                                + "MIN - Temperatura minima (Fahrenheint)\n"
                                + "PRCP - Nivel de precipitacao total (polegadas)\n"
                                + "SNDP - Nivel de profundidade da neve (polegadas)");
                        break;
                    default: 
                        System.out.println("Comando inválido, digite \"help\" para consultar os comandos  validos");
                        break;
                }
            } catch (Exception e) {

            }
        }

    }
    
}
