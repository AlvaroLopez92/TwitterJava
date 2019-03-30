/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter_contornos;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author alopezcobo
 */
public class MetodosConexion {
    private ConfigurationBuilder cb;
    private Twitter twitter;
    

    public void clave(){
            cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("LvDvh15874uDWrShwe7kBUXPfG")
                    .setOAuthConsumerSecret("r0xXh4j3juSi11v0OAUCIJVjaunEUTfIsTw0HVAxgUyFyHDzoc")
                    .setOAuthAccessToken("84733903434762240-vEg6mva8GnITk37oiJlA008xKFUA0M5")
                    .setOAuthAccessTokenSecret("LnrfJbq0TkvGK2wMUVzDgjssF4q49XhT78dLtS7IaQ9jF");
            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter = tf.getInstance();
    }
    public void verTimeLine(){
        List<String> statuses=null;
        String mensaje="Éste es el Timeline \n";
        Status aux=null;
        try {
            statuses = twitter.getHomeTimeline();
            System.out.println("Actualizar");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" +
                        status.getText());
            }   } catch (TwitterException ex) {
            Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String>miIterator=statuses.iterator();
            while(miIterator.hasNext()){
                mensaje+=aux.getUser().getName()+','+aux.getText()+"\n -- \n";
            }
    }

    public void tuiteando(String latestStatus){
        List<Status> statuses=null;
        try {
            Status status = twitter.updateStatus(latestStatus);
            System.out.println("Actualizó correctamente el estado a [" + status.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void directMenssage(){
        try {
            DirectMessage message;
            message = twitter.sendDirectMessage("Mblanc01","Buenas, un saludo");
            System.out.println("Enviado: "+ message.getText() + " para @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarTrending(String busqueda){
        try {
            Query query = new Query(busqueda);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }   } catch (TwitterException ex) {
            Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}