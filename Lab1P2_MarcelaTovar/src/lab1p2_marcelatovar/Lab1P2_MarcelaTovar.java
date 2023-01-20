
package lab1p2_marcelatovar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lab1P2_MarcelaTovar {

  
    public static void main(String[] args) throws ParseException {
        menu();
    }
    
    public static void menu() throws ParseException{
        Scanner ObiWan = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Hola Andres! Bienvenido a mi primer lab de progra");
        System.out.println("Estoy nerviosa jaja :)");
        System.out.println("Mi nombre es Marcela y me gustaria saber como te llamas");
        System.out.print("Favor ingresa tu nombre: ");
        String nombre = ObiWan.nextLine();
        System.out.println("Hola "+nombre +" es un gusto conocerte!");
        System.out.println("Empecemos con el menu");
        do{
            System.out.println("---MENU---");
            System.out.println("1. Torres de Hanoi");
            System.out.println("2. Fechas");
            System.out.println("3. pi");
            System.out.println("4. Salida");
            System.out.println("Ingrese la opcion que quiere realizar: ");
            opcion = ObiWan.nextInt();
            while(opcion != 1 || opcion != 2 || opcion != 3 || opcion != 4 ){
                break;
            }
            switch(opcion){
                case 1 ->{
                    torresDeHanoi();
                }
                case 2 ->{
                    Fechas();
                }
                case 3 ->{
                    Pi();
                }
            }
        }while(opcion == 1 || opcion == 2 || opcion == 3 || opcion != 4 );
        System.out.println("Nos Vemos "+nombre +"!");
        
    }
    
    public static void torresDeHanoi(){
        Scanner ObiWan = new Scanner(System.in);
        System.out.println("Bienvenido a torres de Hanoi");
        System.out.println("Ingrese la cantidad de discos: ");
        int discos = ObiWan.nextInt();
        int origen = 1;
        int auxiliar = 2;
        int destino = 3;
        hanoi(discos,origen,auxiliar,destino);
    }
    
    public static void Fechas() throws ParseException{
        Scanner ObiWan = new Scanner(System.in);
        System.out.println("Bienvenido a fechas");
        System.out.println("Porfavor ingrese la string");
        String fecha = ObiWan.nextLine();
        String [] array = Dividir(fecha);
        ArrayList <String> dividirFecha = extraccionFecha(array);
        transformar(dividirFecha);
        
    }
    
    public static void Pi(){
        Scanner ObiWan = new Scanner(System.in);
        System.out.println("Bienvenidos a pi");
        System.out.println("Ingresa el numero");
        int Suma = ObiWan.nextInt();
        System.out.println(4* suma(Suma,0));
        
        
    }
    
    public static void hanoi(int discos, int origen, int auxiliar, int destino ){
        if (discos == 1) {
            System.out.println("Mover disco "+discos+" de "+origen+" a "+ destino);
        }else{
            hanoi(discos-1,origen,destino,auxiliar);
            System.out.println("Mover disco "+discos+" de "+origen+" a "+ destino);
            hanoi(discos-1,auxiliar,origen,destino);
        }
    }
   
    public static String[] Dividir(String fecha){
        String[] t = fecha.split(",");
        return t;  
    }
    
    public static ArrayList <String> extraccionFecha(String[] array){
        ArrayList <String> fechasX = new ArrayList <String>();
        for (int i = 0; i < array.length; i++) {
            String aux = array[i];
            int help = aux.length()-1;
            if (aux.contains("/") && (int)aux.charAt(i) > 47 || (int)aux.charAt(help) < 58 && (int)aux.charAt(i) < 58 && (int)aux.charAt(help) > 48) {
                fechasX.add(array[i]);
            }
        }
        return fechasX;
    }
    
    
    
    public static void transformar(ArrayList <String> array) throws ParseException{
        DateFormat osd = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < array.size(); i++) {
            Date d = osd.parse(array.get(i));
            System.out.println(d);
        }
    }
    
    public static double suma(double n, double respuestaFinal ){
        double sd;
        if (n == respuestaFinal) {
            sd = (Math.pow(-1, respuestaFinal))/(2*respuestaFinal+1);
            return (sd);
        }else{
            sd = suma(n,respuestaFinal+1) + (Math.pow(-1, respuestaFinal))/(2*respuestaFinal+1);
            return sd;
        }

    }
    
    
    
}
