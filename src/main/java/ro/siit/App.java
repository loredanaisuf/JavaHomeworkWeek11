package ro.siit;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(BufferedReader in = new BufferedReader(new FileReader("resources" + File.separator + "inputFile.csv"));
            PrintWriter out = new PrintWriter("resources" + File.separator + "outputFile.csv")) {

            List<BiathlonAthlete> biathlonAthleteList = new ArrayList<>();
            Set<BiathlonAthlete> biathlonAthleteListSorted = new TreeSet<>(new ComparatorAtheteTime());
            BiathlonAthlete biathlonAthlete;
            String[] lines;
            String line;
            String[] places = {"Winner", "Runner-up", "Third Place"};

            while((line = in.readLine()) != null){
                lines = line.split(",");
                biathlonAthlete = new BiathlonAthlete(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6]);
                biathlonAthleteList.add(biathlonAthlete);

            }

            for(BiathlonAthlete biathlonAthlete1: biathlonAthleteList){
                biathlonAthlete1.changeTime(biathlonAthlete1.numbersOfO());
                biathlonAthleteListSorted.add(biathlonAthlete1);
            }


            int i=0;

            for(BiathlonAthlete biathlonAthlete1: biathlonAthleteListSorted){
                line = places[i++] + " - " + biathlonAthlete1.getName() + " " + biathlonAthlete1.getSkiTimeResult() + " (" + biathlonAthlete1.getAnteriorSkiTimeResult() + " + " + biathlonAthlete1.numbersOfO()*10 + ")";
                out.write(line + "\n");
                System.out.println(line);
                if(i==3)
                    break;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
