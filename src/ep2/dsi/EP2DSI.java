/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2.dsi;

/**
 *
 * @author bruno
 */
public class EP2DSI {
    
    static String dirDados="";
    
    public static void main(String[] args) {
        dirDados=args[0];
        UI ui = new UI();
        ui.run();
                
    }
    
}
