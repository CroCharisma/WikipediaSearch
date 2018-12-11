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
//            
            boolean philNye = false;
            while( ! philNye ){
                Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + article ).get();
                System.out.println(doc.title());
            
                String body = (doc.body()).toString();
                Scanner line = new Scanner( body );
                //System.out.println( body );
                
                while( line.hasNext() ){
                
                    String key = line.next();
                    if( key.equals( "id=\"bodyContent\"" ) ){
                    int cnt = 0;
                        while( line.hasNext() ){
                            
                            String code = line.next();
                            
                            if( code.equals( "<table class") ){
                                while( line.hasNext() &&( ! line.next().contains("</table>")  ) ){
                                    //skip
                                }
                            }
                            if( code.contains( "img") || code.contains( "/wiki/File:" ) && code.contains( "<a href" ) ){
                                //skip
                            }
                            if( code.contains( "(" ) && (! code.contains( ")" ) ) ){
                                while( line.hasNextLine() ){
                                    if( code.contains( ")") && (! code.contains("") ) ){
                                        break;
                                    }
                                }
                                //skips the ((((( links )))))
                            }
                            else if( code.contains( "<a href" ) && ( ! code.contains("#")) && ( !code.contains( "_language") ) && code.contains( "/wiki/") ){
                                System.out.println( code );
                                break;
                            }
                            if( code.contains( "<p>" )){
                                System.out.println(cnt++);
                            }
                            
                        }
                    
                    }
                    else if( key.equals( "id=\"mw-navigation\">" ) ){
                        break;
                    }
                }
                philNye = true;
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
