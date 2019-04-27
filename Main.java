/**
 * @author: Maria Isabel Ortiz 18176
 * @author: Diego Estrada 18540
 * Main
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {

    public static void main(String [] arg) {
        
        int decision,implementacion=1; 
        String paciente="";
        boolean power = true, inicio = true;
        Scanner teclado = new Scanner(System.in);
        Procesos procesos = new Procesos(); 
        ProcesosRBT procesosrbt= new ProcesosRBT();
         Factory fac = new Factory();
        
      
        RedBlackBST<String,String> RBTree = null;
        
        System.out.println("Ingrese la implementacion que desea utilizar:");
        System.out.println("1. SplayTree");
        System.out.println("2. Red Black Tree");
        System.out.println("3. Salir del programa\n");
        System.out.print("Opcion: ");
        
        while (inicio) {
        
            while (!teclado.hasNextInt())   
                
                {
                    System.out.print("Por favor ingrese una opcion valida: ");
                    teclado.next();            
                }

            decision = teclado.nextInt();
            
            if (decision==1) {
                procesos.setSplayTree((SplayTree) fac.getImp("1"));
                procesos.diccionarioST();
                power = false;
                
            } else if (decision==2) {
                procesosrbt.setRBT((RedBlackBST<String, String>) fac.getImp("2"));
                procesosrbt.diccionarioRBT();
                power=false;
                
            } else if (decision==3){
                
                System.out.println("\nNo utilizo ninguna implementacion:(");
                power=false;
                                               
            } else {
                System.err.println("Ingrese la opcion");
            }            
        }
    }
}
