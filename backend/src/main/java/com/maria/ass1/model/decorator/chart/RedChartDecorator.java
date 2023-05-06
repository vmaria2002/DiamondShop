package com.maria.ass1.model.decorator.chart;


import com.maria.ass1.business.factory.Chart;
import com.maria.ass1.model.user.User;

public class RedChartDecorator extends  ChartDecorator{
    public static final Chart decorateChart =null ;

    public RedChartDecorator(){
        super();

    }
    public RedChartDecorator(Chart decorateChart){
        super();
    }

    public RedChartDecorator(User myUser) {
        super();
    }

    public void setChartColor(ChartColor chartColor) {
        chartColor = ChartColor.RED;
    }
    @Override
    public void dumpChart(Chart chart) {
        super.dumpChart(chart);
    }


}
