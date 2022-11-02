package com.mycompany.ejercicio3ealexey;

import java.util.*;
import javax.swing.JOptionPane;

public class Ej3EMetodos {


    public static void main(String[] args) {
        String resultAsk;
        double ask=0;
        boolean confirmMenu;
        boolean confirm = true;
        int filter;
        // filter=0 --- Error
        // filter=1 --- OK
        // filter=2 --- SALIR

        
        float manoDeObra;
        float percPrecioDeVenta_M1_M2_P1 = 1.5f;//50%
        float percPrecioDeVenta_T1_T2 = 1.65f;//65%
        String M1;//Mantecados de Limón
        String M2;//Mazapanes
        String P1;//Polvorones  
        String T1;//Turrón de chocolate
        String T2;//Turrón clásico

        boolean confirmMenu2 = true;

        programm:
        do {
            resultAsk = mostrarMenuPrincipal();
            boolean confirmMenu1 = resultAsk.equals("HACER CALCULOS") || resultAsk.equals("SALIR");
            confirmMenu = resultAsk.equals("SALIR");

            if (confirmMenu1 == false) {
                confirmMenu = false;
            } else if (confirmMenu == true) {
                break;
            } else {

                do {
                    resultAsk = leerCodigos();
                    filter= filtrarCodigos();
                } while (filter == 0);
                
                if(filter==1){
                    do{
                        ask=leerMateriaPrima();   
                        filter= filtrarMateriaPrima();
                    } while(filter==0);
                    
                }else{
                    break programm;
                }

                /*int codigo = (int) answer;
                
                do {
                    answer= filtrarCodigos();
                    if (answer > 1 || answer < 0.1) {
                                confirm = false;
                                JOptionPane.showInternalMessageDialog(null, "Escribe precio en rango entre 0.1 hasta 1");
                            } else {
                                break;
                            }
                } while(confirm==false);*/
                
            }
        } while (confirmMenu == false);
        System.out.println("Saliendo...");
    }

    public static String mostrarMenuPrincipal() {
        String ask = JOptionPane.showInputDialog("""
                                                ----------------------------------------
                                                        Elige que quieres hacer
                                                Hacer calculos
                                                Salir
                                                ----------------------------------------
                                                """);
        String resultAsk = ask.toUpperCase();
        return resultAsk;
    }

    public static String leerCodigos() {

        String ask = JOptionPane.showInputDialog("""
                                                --------------------------------------------
                                                        Solicita codigo de producto
                                                1- Mantecados de Limón
                                                2- Mazapanes
                                                3- Polvorones
                                                4- Turrón de chocolate
                                                5- Turrón clásico
                                                Salir
                                                --------------------------------------------
                                                """);

        String leercodigos = ask.toUpperCase();
        return leercodigos;
    }

    public static int filtrarCodigos() {
        double answer;
        int filter=0;
        String resultAsk= leerCodigos();
        if (!resultAsk.equals("SALIR")) {

                        answer = Double.parseDouble(resultAsk);
                        if ((answer > 5.0 || answer < 1.0)) {
                            filter = 0;
                            JOptionPane.showInternalMessageDialog(null, "No Hay este codigo");
                        } else {
                            filter = 1;
                        }
                    } else if (resultAsk.equals("SALIR")) {
                        filter=2;
                    }
        return filter;
    }

    public static double leerMateriaPrima() {
    String ask = JOptionPane.showInputDialog("""
                                                --------------------------------------------
                                                     
                                                        Escribe Precio de materia prima
                                               
                                                --------------------------------------------
                                                """);
        Double resultAsk = Double.parseDouble(ask);
        return resultAsk;
        
    }

    public static int filtrarMateriaPrima() {
        int filter=0;
        double answer=leerMateriaPrima();
        if (answer > 1 || answer < 0.1) {
                                filter=0;
                                JOptionPane.showInternalMessageDialog(null, "Escribe precio en rango entre 0.1 hasta 1");
                            } else {
                                filter=1;
                            }
        return filter;
    }

    /*public static String leeManoObra() {
        return;
    }

    public static String filtraManoObra() {
        return;
    }

    public static String calcularCosteProducion() {
        return;
    }

    public static String calcularPrecioVentaUnidad() {
        return;
    }

    public static String calcularUnidades() {
        return;
    }

}

////////////////////////////////////////////////////////////
do {
            //Menu Principal
            String ask = JOptionPane.showInputDialog("""
                                             asking   ----------------------------------------
                                                        Elige que quieres hacer
                                                Hacer calculos
                                                Salir
                                                ----------------------------------------
                                                """);
            String resultAsk = ask.toUpperCase();
            boolean confirmMenu1 = resultAsk.equals("HACER CALCULOS") || resultAsk.equals("SALIR");
            confirmMenu = resultAsk.equals("SALIR");
//////////
            if (confirmMenu1 == true) {

                if (confirmMenu == false) {

                    do {
                        confirm = true;
                        ask = JOptionPane.showInputDialog("""
                                                --------------------------------------------
                                                        Solicita codigo de producto
                                                1- Mantecados de Limón
                                                2- Mazapanes
                                                3- Polvorones
                                                4- Turrón de chocolate
                                                5- Turrón clásico
                                                Salir
                                                --------------------------------------------
                                                """);

                        resultAsk = ask.toUpperCase();
////////////
                        if (!resultAsk.equals("SALIR")) {
                            answer = Double.parseDouble(ask);
                            if ((answer > 5.0 || answer < 1.0)) {
                                confirm = false;
                                JOptionPane.showInternalMessageDialog(null, "No Hay este codigo");
                            } else {
                                confirm = true;
                            }
                        } else if (resultAsk.equals("SALIR")) {
                            confirmMenu2 = false;
                            confirm = true;
                        }
                    } while (confirm == false);
////////////
                    if (confirmMenu2 == true) {

                        int codigo = (int) answer;//codigo de producto

                        do {
                            confirm = true;
                            ask = JOptionPane.showInputDialog("""
                                                --------------------------------------------
                                                     
                                                        Escribe Precio de materia prima
                                               
                                                --------------------------------------------
                                                """);
                            answer = Double.parseDouble(ask);
                            if (answer > 1 || answer < 0.1) {
                                confirm = false;
                                JOptionPane.showInternalMessageDialog(null, "Escribe precio en rango entre 0.1 hasta 1");
                            } else {
                                confirm = true;
                            }
                        } while (confirm != true);
                        double precioMateriPrima = answer;//precio materia prima

                        do {
                            ask = JOptionPane.showInputDialog("""
                                                --------------------------------------------
                                                     
                                                        Escribe precio de mano de obra      
                                               
                                                --------------------------------------------
                                                """);
                            answer = Double.parseDouble(ask);
                            if (answer > 0.9 || answer < 0.5) {
                                confirm = false;
                                JOptionPane.showInternalMessageDialog(null, """
                                                            -------------------------------------------------
                                                               Escribe precio en rango entre 0.5 hasta 0.9
                                                            -------------------------------------------------
                                                            """);
                            } else {
                                confirm = true;
                            }
                        } while (confirm != true);
                        manoDeObra = (float) answer;

                        float costeDeProducion;// coste de producion
                        if (codigo == 1 && codigo == 4) {
                            costeDeProducion = manoDeObra * (float) precioMateriPrima;
                        } else {
                            costeDeProducion = manoDeObra * (float) precioMateriPrima;
                        }

                        float precioDeVenta;//precio de venta
                        if (codigo == 4 && codigo == 5) {
                            precioDeVenta = costeDeProducion * percPrecioDeVenta_T1_T2;
                        } else {
                            precioDeVenta = costeDeProducion * percPrecioDeVenta_M1_M2_P1;
                        }

                        int numeroDeUnidades = (int) Math.ceil(2500 / precioDeVenta);
                        String result = String.format("""
                                      Coste de produccion unitario es %f€
                                      Precio de venta unitario es %.3f€
                                      El número de unidades a producir es %d
                                      """, costeDeProducion, precioDeVenta, numeroDeUnidades);
                        JOptionPane.showMessageDialog(null, result);

                    } else{
                        confirmMenu = true;
                    }
                }
                
            }

        } while (confirmMenu != true);
        JOptionPane.showMessageDialog(null, "Saliendo...");
     */
}
