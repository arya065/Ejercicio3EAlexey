package com.mycompany.ejercicio3ealexey;

import java.util.*;
import javax.swing.JOptionPane;

public class Ej3EMetodos {

    public static void main(String[] args) {
        String resultAsk;
        float ask = 0;
        boolean confirmMenu;
        int filter, codigo;
        // filter=0 --- Error
        // filter=1 --- OK
        // filter=2 --- SALIR
        float costeDeProducion, precioDeVenta;
        int numeroDeUnidades;
        float manoDeObra;
        float precioMateriaPrima;

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
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------hello there
                do {
                    resultAsk = leerCodigos();
                    filter = filtrarCodigos(resultAsk);
                } while (filter == 0);

                if (filter == 1) {
                    codigo = Integer.parseInt(resultAsk);
                    do {
                        ask = (float) leerMateriaPrima();
                        filter = filtrarMateriaPrima(ask);
                    } while (filter == 0);
                    precioMateriaPrima = ask;
                    do {
                        ask = (float) leeManoObra();
                        filter = filtrarManoObra(ask);
                    } while (filter == 0);
                    manoDeObra = ask;
                    //расчёт стоимости
                    costeDeProducion = (float) calcularCosteProducion(codigo, manoDeObra, precioMateriaPrima);
                    precioDeVenta = calcularPrecioVentaUnidad(codigo, costeDeProducion);
                    numeroDeUnidades = calcularUnidades(precioDeVenta);
                    String result = String.format("""
                                      Coste de produccion unitario es %f€
                                      Precio de venta unitario es %.3f€
                                      El número de unidades a producir es %d
                                      """, costeDeProducion, precioDeVenta, numeroDeUnidades);
                    JOptionPane.showMessageDialog(null, result);
                } else if (filter == 2) {
                    break programm;
                }

            }
        } while (!confirmMenu);
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

        String resultAsk = ask.toUpperCase();
        return resultAsk;
    }

    public static int filtrarCodigos(String resultAsk) {
        double answer;
        int filter = 0;
        if (!resultAsk.equals("SALIR")) {

            answer = Double.parseDouble(resultAsk);////////////////////////////////////////////////////////////////////try-catch-finally
            if ((answer > 5.0 || answer < 1.0)) {
                filter = 0;
                JOptionPane.showInternalMessageDialog(null, "No Hay este codigo");
            } else {
                filter = 1;
            }
        } else if (resultAsk.equals("SALIR")) {
            filter = 2;
        }
        return filter;
    }

    public static double leerMateriaPrima() {
        String ask = JOptionPane.showInputDialog("""
                                ------------------------------------------------
                                                     
                                Escribe Precio de materia prima
                                               
                                ------------------------------------------------
                                                """);
        Double resultAsk = Double.parseDouble(ask);//////////////////////////////////////////////////////////try-catch-finally
        return resultAsk;

    }

    public static int filtrarMateriaPrima(double answer) {
        int filter = 0;
        if (answer > 1 || answer < 0.1) {
            filter = 0;
            JOptionPane.showInternalMessageDialog(null, "Escribe precio en rango entre 0.1 hasta 1");
        } else {
            filter = 1;
        }
        return filter;
    }

    public static double leeManoObra() {
        String ask = JOptionPane.showInputDialog("""
                                ------------------------------------------------
                                                     
                                Escribe precio de mano de obra      
                                               
                                ------------------------------------------------
                                                """);
        Double resultAsk = Double.parseDouble(ask);////////////////////////////////////////////////////try-catch-finally
        return resultAsk;
    }

    public static int filtrarManoObra(double answer) {
        int filter; 
        if (answer > 0.9 || answer < 0.5) {
            filter = 0;
            JOptionPane.showInternalMessageDialog(null, """
                                                            -------------------------------------------------
                                                               Escribe precio en rango entre 0.5 hasta 0.9
                                                            -------------------------------------------------
                                                            """);
        } else {
            filter = 1;
        }
        return filter;
    }

    public static double calcularCosteProducion(int codigo, float manoDeObra, float precioMateriPrima) {
        float costeDeProducion;// coste de producion
        if (codigo == 1 && codigo == 4) {
            costeDeProducion = manoDeObra * (float) precioMateriPrima;
        } else {
            costeDeProducion = manoDeObra * (float) precioMateriPrima;
        }
        return costeDeProducion;
    }

    public static float calcularPrecioVentaUnidad(int codigo, double costeDeProducion) {
        float precioDeVenta;
        float percPrecioDeVenta_M1_M2_P1 = 1.5f;//50%
        float percPrecioDeVenta_T1_T2 = 1.65f;//65%

        if (codigo == 4 && codigo == 5) {
            precioDeVenta = (float) (costeDeProducion * percPrecioDeVenta_T1_T2);
        } else {
            precioDeVenta = (float) (costeDeProducion * percPrecioDeVenta_M1_M2_P1);
        }
        return precioDeVenta;
    }

    public static int calcularUnidades(float precioDeVenta) {
        int numeroDeUnidades = (int) Math.ceil(2500 / precioDeVenta);
        return numeroDeUnidades;
    }
}
