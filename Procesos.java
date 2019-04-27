/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 */

import hojadetrabajo9.Association;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Procesos {     
 public SplayTree st;
 
 public void setSplayTree(SplayTree arbol){
     this.st=arbol;
 }
 
 
    public void hacerDiccionarioST(){
        
        File archivo = null;
        FileReader fr = null;
        FileReader frr = null;
        BufferedReader br = null;
        BufferedReader brr = null;
      
          
        try {
            // Lectura del archivo
            fr = new FileReader("freedict-eng-spa.txt");
            br = new BufferedReader(fr);

            // Lectura del fichero        
            String linea;
            String Key;
            String Value;
            int posicion;

            while((linea=br.readLine())!=null){                                    

                if (linea.contains(";")) { 
                    linea = linea.substring(0,linea.indexOf(";"));                

                }

                if (linea.contains(",")){
                    linea = linea.substring(0,linea.indexOf(","));
                }                        

                linea = linea.replace("\t", "-");
                linea = linea.replace(" ", "-");                        

                posicion = linea.indexOf("-");           
                Key = linea.substring(0, posicion);            
                Value=linea.substring(posicion+1, linea.length());  

                Asociacion nuevoNodo = new Asociacion(Key.toUpperCase(), Value.toUpperCase()); //se crea el "nodo" que se pondrá en el tree
                st.insert(nuevoNodo);

            }                
        } catch(IOException e){
            
      } finally {
            // Se cierra el fichero
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (IOException e2){ 
         }         
      }     
        
    }
    public void traducirArchivoST() {
        
        File archivo = null;
        FileReader fr = null;
        FileReader frr = null;
        BufferedReader br = null;
        BufferedReader brr = null;
      
          
        try {

            // Segunda lectura del archivo
            frr = new FileReader("texto.txt");
            brr = new BufferedReader(frr);
            Scanner scr = new Scanner(brr);  

            String linea2="";   
            String string="";

              while (scr.hasNextLine()) {
                linea2 += scr.nextLine();                        
            }                    

            string = linea2.replaceAll("\n", " ");        

            String WordList[] = string.split(" ");

            String resultado = "";
            String palabra;

                System.out.println("\nSplay Tree!\n");
                System.out.println("El archivo a traducir es:");

            for(String p: WordList){

                palabra = p.toUpperCase();                
                System.out.print(palabra + " ");                            
                resultado += st.translate(palabra);     

            }                 

            System.out.println("\n\nTraduccion:");        
            System.out.println(resultado);                     
        
        } catch(IOException e){
            
      } finally {
            // Se cierra el fichero

         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (IOException e2){ 
         }         
      } 
    }
    
    public void diccionarioST(){
        hacerDiccionarioST();
        traducirArchivoST();
    }
    
}
