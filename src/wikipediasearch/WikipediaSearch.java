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
            while( ! philNye ){
                Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + article ).get();
                System.out.println(doc.title());
            
                String body = (doc.body()).toString();
                Scanner line = new Scanner( body );
                //System.out.println( body );
                
                while( line.hasNext() ){ 
                        
                    String code = line.next();
                    if( code.contains("/wiki/" ) ){
                        
                        Scanner ahh = new Scanner( code );
                        
                        while( ahh.hasNext() ){
                            String tag = ahh.next();
//                            if( tag.matches("(<i|<i>)")){
//                                int cnt = 0;
//                                while( ahh.hasNext() ){
//                                    if( ahh.next().equals("</i>")){
//                                        cnt--;
//                                    }
//                                    else if( ahh.next().matches("(<i|<i>") ){
//                                        cnt++;
//                                    }
//                                    else if( cnt == 0 ){
//                                        break;
//                                    }
//                                }
//                            }
//                            if( tag.matches("<table") ){
//                                while( ahh.hasNext() && (! ahh.next().matches("</table>") )){
//                                    //skip
//                                }
//                            }
                            
//                            if( tag.contains( "(") ){
//                                
//                                boolean loquor = false;
//                                
//                                while( !loquor ){
//                                    
//                                    if( ahh.hasNext() ){
//                                        String oof = ahh.next();
//                                        if( oof.equals(")") ){
//                                            loquor = true;
//                                            break;
//                                        }
//                                    }
//                                    else{
//                                        ahh = new Scanner( line.next() );
//                                    }
//                                    
//                                }
//                                
//                            }
                            //i just want o play chess right now frank leave me alone
                            //needs to skip tables.
                            if( tag.matches("href=\"/wiki/\\d*\\D*\\d*\\D*\\d*\\D*\\d*\\D*\\d*\\D*\\d*\\D*\\d*\\D*\\d*\"") && (!( tag.contains("File:") || tag.contains( "wikipedia" ) ) ) ){
                                System.out.println( tag );
                            }
                            
                        }
                        
                    }
                }
            }
            philNye = false;
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
