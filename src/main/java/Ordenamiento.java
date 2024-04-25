/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import Atleta.Atleta;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordenamiento {
    
    private static ArrayList<Atleta> atletas = new ArrayList();
    static Scanner lec= new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Escribir el numero de tiempos a Ingresa :");
        int input=lec.nextInt();
        for(int i=0; i< input;i++){
            System.out.println("Digite el Tiempo del Atleta numero: "+(i+1));
            double tiempoAtleta=lec.nextDouble();
            registrarTiempos(tiempoAtleta);  
        }
        System.out.println("Listado de los Tiempos");
        mostrarTiempos();
        
        int option=0;
        do {
            System.out.println("1. Ordenar por Selección");
            System.out.println("2. Ordenar por Inserción");
            System.out.println("3. Ordenar Burbuja");
            System.out.println("4. Salir");
            System.out.println("Ingrese la opción");
            option=lec.nextInt();
            switch (option) {
                case 1:
                    ordenarPorSeleccion();
                    mostrarTiempos();
                    break;
                case 2:
                    ordenarPorInsercion();
                    mostrarTiempos();
                    break;
                case 3:
                    ordenarPorBurbuja();
                    mostrarTiempos();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción No Valida");
                    break;
            }
            
        } while (option!=4);
        
    }
    
    public static void registrarTiempos(double tiempo){
        Atleta nuevoTiempo = new Atleta(tiempo);
        atletas.add(nuevoTiempo);
    
    }
    
    public static void mostrarTiempos(){
        for(Atleta a: atletas){
            System.out.println(a.getTiempo());
        }
    
    }
    
    public static void ordenarPorInsercion(){
        for(int i=1; i<atletas.size();i++){
            boolean agregado =false;
            for(int j=i;j>0 && !agregado;j--){
                Atleta uno = atletas.get(j);
                Atleta dos = atletas.get(j-1);
                if(uno.getTiempo()< dos.getTiempo()){
                    atletas.set(j, dos);
                    atletas.set(j-1, uno);
                }else {
                    agregado= true;
                
                }
            
            }
        }
    }
    public static void ordenarPorSeleccion() {
        for (int i = 0; i < atletas.size() - 1; i++) {
            Atleta menor = atletas.get(i);
            int posMenor = i;
            for (int j = i + 1; j < atletas.size(); j++) {
                Atleta actual = atletas.get(j);
                if (actual.getTiempo() < menor.getTiempo()) {
                    menor = actual;
                    posMenor = j;
                }
            }
            Atleta temp = atletas.get(i);
            atletas.set(i, menor);
            atletas.set(posMenor, temp);
        }
    }
    
    public static void ordenarPorBurbuja() {
        int n = atletas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Atleta uno = atletas.get(j);
                Atleta dos = atletas.get(j + 1);
                if (uno.getTiempo() > dos.getTiempo()) {
                    atletas.set(j, dos);
                    atletas.set(j + 1, uno);
                }
            }
        }
    
    }
}

