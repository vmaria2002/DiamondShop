package com.maria.ass1.model.decorator.chart;

import com.maria.ass1.business.factory.Chart;

import com.maria.ass1.model.user.User;

public class ChartDecorator extends Chart {
    protected Chart decoratedChart;
   

    public ChartDecorator() {
        super();
        this.decoratedChart = decoratedChart;
    }

    @Override
    public User generateChart(String type) {
        return null;
    }

    public Object createchartDecorator(ChartColor chartColor) {
       if(chartColor.equals(ChartColor.RED)){
           return new GreenChartDecorator();
       }else{
           return new RedChartDecorator();
       }
    }

    public void dumpReport(Chart chart) {
        decoratedChart.dumpReport(chart);
    }

    public void dumpChart(Chart chart) {

    }
}
