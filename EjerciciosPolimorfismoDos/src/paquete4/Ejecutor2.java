/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.Scanner;
import java.util.ArrayList;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int contador = 0;
        int local;
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        int opc;
        System.out.println("Ingrese el numero de veces que quiere ingresar");
        opc = entrada.nextInt();
        while (contador < opc) {
            System.out.println("Ingrese 1 si quiere ingresar arriendo local comida");
            System.out.println("Ingrese 2 si quiere ingresar arriendo local comercial");
            System.out.println("Ingrese 3 si quiere ingrear arriendo local sesiones");
            System.out.println("Ingrese 4 si quiere ingresa centro comercial");
            local = entrada.nextInt();
            if (local == 1) {
                String nombre;
                double iva;
                double couatoB;
                double agua;
                double valorLuz;
                System.out.println("Ingrese un nombre");
                nombre = entrada.nextLine();
                entrada.nextLine();
                System.out.println("Ingrese la cuota ");
                couatoB = entrada.nextDouble();
                System.out.println("Ingrese el iva");
                iva = entrada.nextDouble();
                System.out.println("Ingrese el valor de agua");
                agua = entrada.nextDouble();
                System.out.println("Ingrese el valor de la luz");
                valorLuz = entrada.nextDouble();
                ArriendoLocalComida arriendoComida = new ArriendoLocalComida(nombre,
                        couatoB, iva, agua, valorLuz);
                listaArriendos.add(arriendoComida);
            } else {
                if (local == 2) {
                    String nombre;
                    double couatoB;
                    double valorAdicional;
                    System.out.println("Ingrese un nombre");
                    nombre = entrada.nextLine();
                    entrada.nextLine();
                    System.out.println("Ingrese la cuota ");
                    couatoB = entrada.nextDouble();
                    System.out.println("Ingrese el valor adicional");
                    valorAdicional = entrada.nextDouble();

                    ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(nombre, couatoB);
                    arriendoComercial.establecerValorAdicionalFijo(valorAdicional);
                    listaArriendos.add(arriendoComercial);
                } else {
                    if (local == 3) {
                        String nombre;
                        double couatoB;
                        double valorSillas;
                        double valorAmplificacion;
                        System.out.println("Ingrese un nombre");
                        nombre = entrada.nextLine();
                        entrada.nextLine();
                        System.out.println("Ingrese la cuota ");
                        couatoB = entrada.nextDouble();
                        System.out.println("Ingrese el valor de la silla");
                        valorSillas = entrada.nextDouble();
                        System.out.println("ingrese el valor de la amplificacion");
                        valorAmplificacion = entrada.nextDouble();
                        ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                                nombre, couatoB);
                        arriendoSesiones.establecerValorSillas(valorSillas); // en $
                        arriendoSesiones.establecerValorAmplificacion(valorAmplificacion); // en $
                        listaArriendos.add(arriendoSesiones);
                    } else {
                        if (local == 4) {
                            String nombre;

                            System.out.println("Ingrese un nombre");
                            nombre = entrada.nextLine();

                            CentroComercial centro = new CentroComercial(nombre,
                                    listaArriendos);
                            centro.establecerTotalArriendosBaseMensual();
                            centro.establecerTotalArriendosFinalMensual();
                            System.out.println(centro);
                        }
                    }
                }
            }

            contador = contador + 1;

        }
        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
             System.out.printf("Datos Locales\n"
                        + "%s\n",                        
                   listaArriendos.get(i));
        }

    }
}
