/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter_contornos;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;


/**
 *
 * @author alopezcobo
 */
public class Twitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {
        // TODO code application logic here
        
        //Creamos variables de texto que usaremos para completar
        String busqueda,tweet;
        //Creamos objeto de tipo MetodosConexion con el que acceder a los metodos
        MetodosConexion obj1 = new MetodosConexion();
                
        //LLamamos a los metodos con un menu
        int opciones;
        do{
            opciones=Integer.parseInt(JOptionPane.showInputDialog("1- Ver TimeLine y buscar Trending \n2- Tweetear \n3- Enviar Mensaje Directo \n0- Salir"));
                switch(opciones){
                    case 1: //Vemos TimeLine
                        obj1.clave(); //Carga las claves
                        obj1.verTimeLine(); 
                        busqueda  =JOptionPane.showInputDialog("Introduce lo que deseas buscar:");
                        //buscar Trending
                        obj1.clave(); //Carga las claves
                        obj1.buscarTrending(busqueda);
                        break;
                    case 2:
                        obj1.clave(); //Carga las claves
                        tweet = JOptionPane.showInputDialog("Introduce un tweet:");
                        //"Tweeteamos"
                        obj1.tuiteando(tweet);
                        break;
                    case 3:
                        obj1.clave(); //Carga las claves
                        obj1.directMenssage();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Error");
                }
            }while(opciones!=0);
    }
    
}
