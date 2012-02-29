package org.springframework.webflow.issues;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class MainEntityController implements Serializable {

	private static final long serialVersionUID = 1L;

	public StreamedContent createDynamicImage() {
		try {
			StreamedContent chart;
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

//			for (int i = 0; i < list.size(); i++) {
//				dataset.addValue((Integer) list.get(i).get("value"), "serie1", (String) list.get(i).get("description"));
//			}

		    dataset.addValue( 30.0, "", "foo" );
		    dataset.addValue( 80.0, "", "bar" );
		    dataset.addValue( 35.0, "", "baz" );
		    
			SpiderWebPlot plot = new SpiderWebPlot(dataset);

			plot.setStartAngle(90);
			plot.setInteriorGap(0.30);
			plot.setMaxValue(10);
			plot.setOutlineVisible(true);

			plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			JFreeChart jfreechart = new JFreeChart("", TextTitle.DEFAULT_FONT, plot, false);

			ChartUtilities.applyCurrentTheme(jfreechart);

			File chartFile = new File("test.png");
			ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 512, 400);
			chart = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");
			return chart;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
