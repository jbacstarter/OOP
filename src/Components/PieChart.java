
package Components;

import java.awt.Color;
import java.awt.GradientPaint;

import java.text.AttributedString;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.json.JSONArray;

import Classes.BankAccount;
import Classes.Expense;


public class PieChart extends JPanel{

    private static final long serialVersionUID = 1L;
    private PieDataset dataset = null;
    private JFreeChart chart= null;
    private ChartPanel chartPanel = null;
    
    public PieChart(String chartTitle,JSONArray arr) {
    	if(arr != null && arr.length() > 0) {
    		dataset = createDataset( arr);
    		chart = createChart(dataset, chartTitle);
    	}else {
    		dataset= createDataset( null);
    		chart = createChart(dataset, "Default Chart");
    	}
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(420, 200));
        chartPanel.setBackground(Color.WHITE);
        setBackground(Color.WHITE);
        add(chartPanel);
    }
    
    public void updateChart(JSONArray arr) {
        if (arr != null && arr.length() > 0) {
            this.dataset = createDataset(arr);
            this.chart = createChart(dataset, this.chart.getTitle().getText());
            this.chartPanel.setChart(this.chart);
            this.chartPanel.repaint();
        }
    }
    /**
     * Creates a sample dataset 
     */
    private  PieDataset createDataset(JSONArray arr) {
        DefaultPieDataset result = new DefaultPieDataset();
        if(arr != null) {
        	for(int col = 0;col <Expense.length; col++) {
        		double value = BankAccount.getSum(Expense.TYPES[col], arr);
        		result.setValue(Expense.TYPES[col], value);
        	}
        }else if((arr == null|| arr.length()== 0)) {
        	result.setValue("Window", 245);
        	result.setValue("Linux", 89);
        	result.setValue("Samsung", 482);
        }
       
        return result;
        
    }
    
    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            false,                     // include legend
            true,
            false
        );

        chart.setBackgroundPaint(new GradientPaint(0,0,Color.decode("#92acdf"),0,0,Color.decode("#92acdf")));
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setBackgroundPaint(new GradientPaint(0,0,Color.decode("#92acdf"),0,0,Color.decode("#92acdf")));
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);
        plot.setBackgroundAlpha(0.2f);
        plot.setOutlineVisible(false);
        plot.setLabelGenerator(new PieSectionLabelGenerator() {

			@Override
			public String generateSectionLabel(PieDataset dataset, Comparable key) {
					double sum = DatasetUtilities.calculatePieDatasetTotal(dataset);
					double percent = ((double)dataset.getValue(key)/sum)*100;
				return ""+ key + " " + Math.round(percent) + "%";
				
			}
			
			@Override
			public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) {
				
				return null;
			}
		});
        plot.setLegendLabelGenerator(new PieSectionLabelGenerator() {
			
			@Override
			public String generateSectionLabel(PieDataset dataset, Comparable key) {
				double sum = DatasetUtilities.calculatePieDatasetTotal(dataset);
				double percent = ((double)dataset.getValue(key)/sum)*100;
			return ""+ key + " " + Math.round(percent) + "%";
			}
			
			@Override
			public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) {
				// TODO Auto-generated method stub
				return null;
			}
		});
        plot.setSectionOutlinesVisible(true);
        plot.setIgnoreNullValues(true);
        plot.setIgnoreZeroValues(true);
        plot.setLabelBackgroundPaint(new GradientPaint(0, 0, Color.decode("#FFFFFF"), 0, 0, Color.decode("#FFFFFF")));
        return chart;
        
    }

	public PieDataset getDataset() {
		return dataset;
	}

	public void setDataset(PieDataset dataset) {
		this.dataset = dataset;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
