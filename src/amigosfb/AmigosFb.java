/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amigosfb;

/**
 *
 * @author gus_958
 */
public class AmigosFb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        algorithm a = new algorithm();
        
        
        a.generarPersonas(100);
        a.generarAmigos();
        a.amigosComun();
        a.amigosAll();
        
    }
}
