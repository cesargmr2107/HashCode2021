
import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {
    public int id;
    public ArrayList<Street> callesEntrada;

    public Intersection(int id){
        this.id = id;
        callesEntrada = new ArrayList<Street>();
    }

    public Street streetToOpen(int seg, int tiempoTotal, int carPoints, HashMap<String,Street> streetsInfo){
        Street toret = null;
        int coste = -1;
        int aux;

        if (callesEntrada.size() == 1) {
            toret = callesEntrada.get(0);
            
        } else {
            for (Street st : callesEntrada) {
                aux = st.coste(seg, tiempoTotal, carPoints, streetsInfo);
                if(coste < aux){
                    toret = st;
                    coste = aux;
                }
            }
        }
        return toret;
    }

}
