
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Uwuntu oli lmao
 */
public class Util {

    public static ArrayList<String[]> readFile(String route) {

        ArrayList<String[]> toret = new ArrayList<>();

        try {

            File text = new File(route);
            Scanner scnr = new Scanner(text);
            while (scnr.hasNextLine()) {
                toret.add(scnr.nextLine().split(" "));
            }
            scnr.close();

        } catch (Exception ex) {
            System.err.println("Ha ocurrido un problema al leer el archivo:\n" + ex.getMessage());
        }

        return toret;
    }

    public static void writeFile(String fileName, String fileContent) {
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter out = new PrintWriter(fw);
            out.print(fileContent);
            out.close();
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un problema al escribir el archivo");
        }
    }

}
