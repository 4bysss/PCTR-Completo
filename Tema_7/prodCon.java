/**
 * @(#)prodCon.java
 * @author A.T.
 * @version 1.00 2011/11/17
 * ESPECIFICACION: productor-consumidor sin control de sincronizacion
 * y sin acceso al buffer en exclusion mutua.
 */

import java.util.*;
import java.util.concurrent.Semaphore;

import javax.swing.table.TableModel;
public class prodCon
 {
    private static int tamBuffer;
    private static double [] buffer;
    private static int InPtr=0;
    private static int OutPtr=0;
    private int tipoHilo;
    private static int espacios;
    private static int eltos;
    private static  Object sem;


      public prodCon(int tipo,int tam,Object algo) {
        tamBuffer = tam;
        tipoHilo = tipo;
        espacios = tamBuffer;
        eltos = 0;
        buffer = new double[tamBuffer];
        //sem = new Semaphore(1);
        sem = algo;
      }
      public  void metodo()
      {
      	switch(tipoHilo){
      		case 0:{


      			for(;;)
      			{
              synchronized(sem){ 
                while(espacios==0){try{sem.wait();}catch(Exception e){}}


                buffer[InPtr]=Math.random();
                System.out.println("Hilo productor insertando "+buffer[InPtr]+" en buffer");
                InPtr=(InPtr+1)%tamBuffer;
                ++eltos;
                --espacios;
              
                sem.notifyAll();
               } 
      			}
      		}
      		case 1:{


      			for(;;){
              synchronized(sem){
                while(eltos==0){try{sem.wait();}catch(Exception e){}}

                  System.out.println("Hilo consumidor extrayendo "+buffer[OutPtr]+" de buffer"); OutPtr=(OutPtr+1)%tamBuffer;
                  ++espacios;
                  --eltos;
                
                  sem.notifyAll();
                }
              }
      		}
      	}
      }
    }
