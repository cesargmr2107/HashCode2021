
import java.util.ArrayList;

/**
 *
 * @author cgmr2
 */
public class HashCode2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Read file into input
        ArrayList<String[]> input = Util.readFile(args[0]);

        // Pass input to problem
        Problem problem = new Problem(input);

        // Solve problem and get result
        String result = problem.solve();

        // Write result to file
        Util.writeFile(args[1], result);

    }

}
