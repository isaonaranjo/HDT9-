/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 * Obtenido de: https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
 */

import hojadetrabajo9.Association;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProcesosRBT {
    public RedBlackBST<String,String> rbt;

    public void setRBT(RedBlackBST<String,String> arbolito){
        this.rbt=arbolito;
    }

    public void hacerDiccionarioRBT() {

        File archivo = null;
        FileReader fr = null;
        FileReader frr = null;
        BufferedReader br = null;
        BufferedReader brr = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
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
                this.rbt.put(Key.toUpperCase(), Value.toUpperCase());
            }

        } catch(IOException e){

        } finally {

            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (IOException e2){
            }
        }

    }

    public void traducirArchivoRBT(){

        File archivo = null;
        FileReader fr = null;
        FileReader frr = null;
        BufferedReader br = null;
        BufferedReader brr = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader("freedict-eng-spa.txt");
            br = new BufferedReader(fr);

            //Iniciamos con la segunda lectura del archivo a traducir
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

            System.out.println("\nHa seleccionado Red Black Tree!\n");
            System.out.println("El achivo a traducir es:");

            for(String p: WordList){

                palabra = p.toUpperCase();
                System.out.print(palabra + " ");

                String traducida = rbt.get(palabra);

                if (traducida==null) {
                    traducida = "*" + palabra + "*";
                }

                resultado += traducida+" ";

            }

            System.out.println("\n\nTraduccion:");

            System.out.println(resultado);

        } catch(IOException e){

        } finally {

            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (IOException e2){
            }
        }

    }

    public void diccionarioRBT(){

        hacerDiccionarioRBT();
        traducirArchivoRBT();

    }

}