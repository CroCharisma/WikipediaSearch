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
            while( !article.equals("Philosophy") ){
                Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + article ).get();
                System.out.println(doc.title());
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
                        System.out.println( code.get(i) );
                        cnt++;
                        break;
                        
                    }
                    
                }
            }    
            
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
