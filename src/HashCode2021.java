
import java.util.ArrayList;

/**
 *
 * @author cgmr2
 */
public class HashCode2021 {

    /**
     * @param args archivo input
     */
    public static void main(String[] args) {

        if (args.length != 2) {

            System.out.println("Uso: java HashCode2021 entrada.txt salida.txt");

        } else {

            System.out.println("Reading file... " + args[0]);

            // Read file into input
            ArrayList<String[]> input = Util.readFile(args[0]);

            // Pass input to problem
            Problem problem = new Problem(input);

            // Solve problem and get result
            String result = problem.solve();

            // Write result to file
            System.out.println("Writing file... " + args[1]);
            Util.writeFile(args[1], result);
            
        }
    }

}
