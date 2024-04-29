import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;

public class Smoother {
    public void smooth(String fileName, int windowValue) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        ArrayList<String> plottedvalues = new ArrayList<>();
        ArrayList<Double> yvalues = new ArrayList<>();
        ArrayList<Double> xValues = new ArrayList<>();
        File smoothedCSV = new File("smoothedCSV.csv");
        
        try (BufferedReader bReader = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = bReader.readLine()) != null) {
                String[] lineValues = nextLine.split(",");
                plottedvalues.addAll(Arrays.asList(lineValues));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        stats.setWindowSize(windowValue);
        
        for (int i = 0; i < plottedvalues.size(); i++) {
            if (i % 2 == 0)
                xValues.add(Double.parseDouble(plottedvalues.get(i)));
            if (i % 2 == 1) {
                stats.addValue(Double.parseDouble(plottedvalues.get(i)));
                Double average = stats.getMean();
                yvalues.add(average);
                plottedvalues.set(i, average.toString());
            }
        }
        
        try (FileWriter fWriter = new FileWriter(smoothedCSV)) {
            for (int i = 0; i < plottedvalues.size(); i++) {
                fWriter.write(plottedvalues.get(i) + ",");
                if (i % 2 != 0)
                    fWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
  
    }
}
