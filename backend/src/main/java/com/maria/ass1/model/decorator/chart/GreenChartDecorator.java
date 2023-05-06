package com.maria.ass1.model.decorator.chart;


import com.maria.ass1.business.factory.Chart;

import static com.maria.ass1.model.decorator.chart.ChartColor.GREEN;

public class GreenChartDecorator extends ChartDecorator {
    private static final Chart decorateChart =null ;

    public GreenChartDecorator(){
        super();

    }
    public GreenChartDecorator(Chart decorateChart){
        super();
    }

    public void setChartColor(ChartColor chartColor) {
        chartColor = GREEN;
    }
    @Override
    public void dumpChart(Chart chart) {
        super.dumpChart(chart);
    }
}
