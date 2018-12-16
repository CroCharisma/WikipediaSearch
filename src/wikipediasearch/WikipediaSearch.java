package wikipediasearch;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.*;
import java.io.*;


public class WikipediaSearch {

    public static void main(String[] args) {
        
        try
        {
            
            String article = "Special:Random";
            List<String> Ahh = new ArrayList();
            boolean philNye = false;
            int cnt = 0;
            String title = "";
            while( !article.matches("(Philosophy|Philosophical)") && cnt < 250 ){
                Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + article ).get();
                //System.out.println(doc.title());
                if( cnt == 0){
                    title = doc.title();
                }
                if( cnt == 50 ){
                    System.out.println("This might take a bit...");
                }
                if( cnt == 100 ){
                    System.out.println("Maybe more than a bit...");
                }
                if( cnt == 150 ){
                    System.out.println("Its probably a loop just wait...");
                }
                String body = (doc.body()).toString();
                Scanner line = new Scanner( body );
                //System.out.println( body );
                String frank = "";
                
                while( line.hasNext() ){
                    
                    String ahh = line.nextLine();
                    if( ahh.contains("<p>" ) && ahh.length() > 20 && ahh.contains("href") ){
                        frank = ahh;
                        break;
                    }
                    
                }
                ArrayList<String> code = new ArrayList( Arrays.asList( frank.split(" ")));
                for( int i = 0; i < code.size(); i++ ){
                    
                    if( code.get(i).contains( "(" ) ){
                        if( !code.get(i).contains( ")") ){
                            while( !code.get(i).contains(")") ){
                                i++;
                            }
                        }
                    }
                    
                    if( code.get(i).equals("id=\"coodrinates\">" ) ){
                        while( !code.get(i).equals("</span>")){
                            i++;
                        }
                    }
                        
                    
                    if( code.get(i).contains( "href=") && !code.get(i).contains(":") && !code.get(i).contains("cite") && !code.get(i).contains(".") && !article.contains( code.get(i) )){
                        //article = code.get(i);
                        article = ( code.get(i).substring( code.get(i).lastIndexOf("/")+1 ,  code.get(i).lastIndexOf("\"") ));
                        cnt++;
                        break;
                        
                    }
                    
                }
            }
            System.out.println( title );
//            if( cnt == 0 ){
//                System.out.println("Never gets there, Sorry!");
//            }
            if( cnt > 249 ){
                System.out.println("\"ITS A LOOP\" - Admiral Akbar" );
            }
            else System.out.println( cnt + " jumps to Philosophy" );
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    
    }
//\\
//\\
//\\    
}
//i want it to be 100 lines frank thats why its there :dab: