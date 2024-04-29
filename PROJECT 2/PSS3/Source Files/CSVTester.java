public class CSVTester {
    public static void main(String[] args) {
        // Create instances of Plotter, Salter, and Smoother classes
        Plotter plotter = new Plotter();
        Salter salter = new Salter();
        Smoother smoother = new Smoother();
        
        plotter.plot("xyValues", -100, 100, 0.2);
        salter.salt("xyValues.csv", 0, 1000);
        smoother.smooth("saltedxyValues.csv", 20);
    }
}
