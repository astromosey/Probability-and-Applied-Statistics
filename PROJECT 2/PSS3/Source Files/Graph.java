import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import java.util.ArrayList;

public class Graph extends ApplicationFrame {
    
    public Graph(String appTitle, String graphTitle, String xAxisLabel, String yAxisLabel, ArrayList<Double> xValues, ArrayList<Double> yValues) {
        super(appTitle); 
        
        // Create the chart and assign it to a JFreeChart object
        JFreeChart chart = createChart(graphTitle, xAxisLabel, yAxisLabel, xValues, yValues);
                ChartPanel panel = new ChartPanel(chart);
                panel.setPreferredSize(new java.awt.Dimension(500, 500));
        
        // Set the content pane of the application frame to the chart panel
        setContentPane(panel);
    }
    
    // Method to create the chart
    private JFreeChart createChart(String title, String xAxisLabel, String yAxisLabel, ArrayList<Double> xValues, ArrayList<Double> yValues) {
        XYSeries series = new XYSeries(title);
        
        // Populate the series with the given x and y values
        for (int i = 0; i < xValues.size(); i++) {
            series.add(xValues.get(i), yValues.get(i));
        }
        
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        
        // Create and return the chart using ChartFactory
        return ChartFactory.createXYLineChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
    }
}
