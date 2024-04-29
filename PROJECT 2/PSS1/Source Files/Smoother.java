import java.io.*;
import java.util.*;

public class Smoother {
    public void smooth(String inputFileName, String outputFileName, int windowValue) {
        ArrayList<Double> xValues = new ArrayList<>(); // Store x-values
        ArrayList<Double> yValues = new ArrayList<>(); // Store y-values
        File input = new File(inputFileName);
        File output = new File(outputFileName);

        try {
            FileReader fileReader = new FileReader(input);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String nextLine;
            // Read and parse the input CSV file
            for (nextLine = bufferedReader.readLine(); nextLine != null; nextLine = bufferedReader.readLine()) {
                String[] lineValues = nextLine.split(",");
                xValues.add(Double.parseDouble(lineValues[0])); // Add x-value to list
                yValues.add(Double.parseDouble(lineValues[1])); // Add y-value to list
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Smooth the y-values using moving average
        ArrayList<Double> smoothedYValues = movingAverage(yValues, windowValue);

        try {
            FileWriter fileWriter = new FileWriter(output);
            // Write x-values and corresponding smoothed y-values to the output CSV file
            for (int i = 0; i < xValues.size(); i++) {
                fileWriter.write(xValues.get(i) + "," + smoothedYValues.get(i));
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to compute moving average
    private ArrayList<Double> movingAverage(ArrayList<Double> yValues, int windowValue) {
        ArrayList<Double> smoothedYValues = new ArrayList<>();
        for (int i = 0; i < yValues.size(); i++) {
            double sum = 0;
            int count = 0;
            for (int j = Math.max(0, i - windowValue / 2); j <= Math.min(yValues.size() - 1, i + windowValue / 2); j++) {
                sum += yValues.get(j);
                count++;
            }
            double average = sum / count;
            smoothedYValues.add(average);
        }
        return smoothedYValues;
    }
}
