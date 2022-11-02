package com.mycompany.ejercicio3ealexey;

import java.util.*;
import javax.swing.JOptionPane;

public class Ejercicio3EAlexey {

    public static void main(String[] args) {

        float manoDeObra;
        float percPrecioDeVenta_M1_M2_P1 = 1.5f;//50%
        float percPrecioDeVenta_T1_T2 = 1.65f;//65%
        String M1;//Mantecados de Limón
        String M2;//Mazapanes
        String P1;//Polvorones  
        String T1;//Turrón de chocolate
        String T2;//Turrón clásico

        boolean confirm = true;
        boolean confirmMenu, confirmMenu2 = true;
        double answer = 0;

        do {
            //Menu Principal
            String ask = JOptionPane.showInputDialog("""
                                                ----------------------------------------
                                                        Elige que quieres hacer
                                                Hacer calculos
                                                Salir
                                                ----------------------------------------
                                                """);
            String resultAsk = ask.toUpperCase();
            boolean confirmMenu1 = resultAsk.equals("HACER CALCULOS") || resultAsk.equals("SALIR");
            confirmMenu = resultAsk.equals("SALIR");

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
                        
                    } while (confirm != true);

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

        } while (confirmMenu == false);
        JOptionPane.showMessageDialog(null, "Saliendo...");
    }
}
