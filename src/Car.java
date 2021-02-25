import java.util.ArrayList;
import java.util.HashMap;
import java.math.*;

public class Car {
    public int nStreetsToTravel;
    public ArrayList<String> streetsToTravel;
    public int tiempo;
    
    public Car(String[] info) {
        tiempo = 0;
        streetsToTravel = new ArrayList<String>();
        nStreetsToTravel = Integer.parseInt(info[0]);
        for (int i = 1; i < info.length; i++) {
            streetsToTravel.add(info[i]);
        }   
    }
    
    public int tiempoRestante(Street calleActual, HashMap<String,Street> streetsInfo){
        int toret = 0;
        for(int i = streetsToTravel.indexOf(calleActual) + 1; i< streetsToTravel.size();i++){
            toret += streetsInfo.get(streetsToTravel.get(i)).tiempo;
        }
        return toret;
    }
    
    /*
    public int tiempoRestante(Street calleActual, HashMap<String,Street> streetsInfo){
        int toret = 0;
        for(int i = streetsToTravel.indexOf(calleActual) + 1; i< streetsToTravel.size();i++){
            toret += streetsInfo.get(streetsToTravel.get(i)).tiempo;
            toret += Math.max(streetsInfo.get(streetsToTravel.get(i)).cola.size() - streetsInfo.get(streetsToTravel.get(i)).tiempo,0)
        }
        return toret;
    }*/
}
