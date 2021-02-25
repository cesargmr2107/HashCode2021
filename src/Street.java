import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Street {
    public String nombre;
    public int origen;
    public int destino;
    public int tiempo;
    public Queue<Car> cola;


    public Street(String[] input){
        this.origen = Integer.parseInt(input[0]);
        this.destino = Integer.parseInt(input[1]);
        this.nombre = input[2];
        this.tiempo = Integer.parseInt(input[3]);
        this.cola = new LinkedBlockingQueue<Car>();
    }

    //indica el coste que tiene una calle por NO abrirse
    public int coste(int seg, int tiempoTotal, int carPoints, HashMap<String,Street> streetsInfo){
        int i = 0;
        int toret = 0;
        for (Car car : cola) {
            if((car.tiempoRestante(this,streetsInfo) + i++ )== tiempoTotal){
                toret += carPoints;
            }
            else {
                toret += 1;
            }
        }
        return toret;
    }    
}
