
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author cgmr2
 */
public class Problem {
    private int duration;
    private int nIntersections;
    private int nStreets;
    private int nCars;
    private int carPoints;

    private HashMap<String,Street> streetsInfo;
    private ArrayList<Intersection> intersections;

    // Por cada coche: carPoints + (duration – T) points if T ≤ D
    // Siendo T el tiempo que tarda el coche en llegar a destino

    public Problem(ArrayList<String[]> input) {

        
        // First line
        this.duration = Integer.parseInt(input.get(0)[0]);
        this.nIntersections = Integer.parseInt(input.get(0)[1]);
        this.nStreets = Integer.parseInt(input.get(0)[2]);
        this.nCars = Integer.parseInt(input.get(0)[3]);
        this.carPoints = Integer.parseInt(input.get(0)[4]);
        
        this.streetsInfo = new HashMap<>(this.nStreets);
        this.intersections = new ArrayList<>(this.nIntersections);

        // Intersections
        for (int i = 0; i < this.nIntersections; i++) {
            this.intersections.add(new Intersection(i));
        }

        // Streets
        for (int i = 1; i <= this.nStreets; i++) {
            Street street = new Street(input.get(i));
            streetsInfo.put(street.nombre, street);
            intersections.get(street.destino).callesEntrada.add(street);
        }

        // Cars
        for (int i = this.nStreets + 2; i < input.size(); i++) {
            Car car = new Car(input.get(i));
            streetsInfo.get(car.streetsToTravel.get(0)).cola.add(car);
            //System.out.println(i);
            //System.out.println(streetsInfo.get(car.streetsToTravel.get(0)).cola);
        }    
        


    }

    public String solve() {

        ArrayList<LinkedHashMap<String,Integer>> result = new ArrayList<>();
        ArrayList<Transit> carsInTransit = new ArrayList<Transit>();

        for (int i = 0; i < nIntersections; i++) {
            result.add(new LinkedHashMap<String,Integer>());
        }

        for (int sec = 0; sec < duration; sec++) { 

            for (Transit transit : carsInTransit) {
                transit.contador -= 1;
                if(transit.contador == 0){
                    transit.calle.cola.add(transit.coche);
                }
            }

            for (int inters = 0; inters < intersections.size(); inters++) {
                Street openStreet = intersections.get(inters).streetToOpen(sec, duration, carPoints,streetsInfo);
                String streetToOpen = openStreet.nombre;
                if(openStreet != null){
                //System.out.println(openStreet.cola);
                Car car = openStreet.cola.poll();
                try{
                    //System.out.println(car);
                    String nextStreet = car.streetsToTravel.get(car.streetsToTravel.indexOf(streetToOpen) + 1);
                    carsInTransit.add(new Transit(car,this.streetsInfo.get(nextStreet)));
                }catch(Exception e){
                    //e.printStackTrace();
                }
            }
                Integer greenDur = result.get(inters).get(streetToOpen);

                if(greenDur == null){
                    greenDur = 0;
                }
                result.get(inters).put(streetToOpen, ++greenDur);
            }
        }

        return parseResultToOutput(result);
    }
    
    public String parseResultToOutput(ArrayList<LinkedHashMap<String,Integer>> result) {
        StringBuilder parsed = new StringBuilder();
        int nSchedules = 0;
        
        for (int inters = 0; inters < nIntersections; inters++) {
            LinkedHashMap<String,Integer> map = result.get(inters);
            if(!map.isEmpty()){
                parsed.append(inters).append("\n");
                parsed.append(map.size()).append("\n");

                for (Entry<String,Integer> entry : map.entrySet()) {
                    parsed.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
                }
                nSchedules++;
            }
        }

        StringBuilder toret = new StringBuilder();
        toret.append(nSchedules);
        toret.append("\n");
        toret.append(parsed);

        return toret.toString();
    }
}
