public class CSVTester {
    public static void main(String[] args) {
        // Create a new Plotter object
        Plotter plotter = new Plotter();

        // Plot the data using the Plotter class
        plotter.plot("PlottedValues", -10, 10, 0.1);

        // Create a new Salter object
        Salter salter = new Salter();

        // Salt the data using the Salter class
        salter.salt("PlottedValues.csv", 0, 250);

        // Create a new Smoother object
        Smoother smoother = new Smoother();

        // First run: Read from "SaltedValues.csv" and output to "SmoothedValues1.csv"
        smoother.smooth("SaltedValues.csv", "SmoothedValues1.csv", 8);

        // Second run: Read from "SmoothedValues1.csv" and output to "SmoothedValues2.csv"
        smoother.smooth("SmoothedValues1.csv", "SmoothedValues2.csv", 8);

        // Third run: Read from "SmoothedValues2.csv" and output to "SmoothedValues3.csv"
        smoother.smooth("SmoothedValues2.csv", "SmoothedValues3.csv", 8);
    }
}
