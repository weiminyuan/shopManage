package com.ywm.demo.common;

import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

/**
 * 饼状图
 *
 * @Author: yuanweimin
 * @Date: 2018/12/17 9:48
 */
public class PieChart {

    /**
     * 生成柱状图
     *
     * @param title  标题
     * @param list   值
     * @param path  路径地址
     * @param width  图片宽度
     * @param height 图片高度
     * @throws Exception
     */
    public void createPieChart(String title, List<Map<String, Object>> list, String path, int width, int height) throws Exception {

        /**
         * 生成一个饼图的图表
         *
         * 分别是:显示图表的标题、需要提供对应图表的DateSet对象、是否显示图例、是否生成贴士以及是否生成URL链接
         */
        JFreeChart chart = ChartFactory.createPieChart(
                title, // chart title
                createDataset(list), // data
                true, // include legend
                true,
                false);
        chart.getTitle().setFont(new Font("黑体",Font.BOLD,20));//设置标题字体

        PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
        piePlot.setLabelFont(new Font("黑体",Font.BOLD,10));
        //饼图的透明度
        piePlot.setForegroundAlpha(0.7f);
        // 饼图的背景全透明
        piePlot.setBackgroundAlpha(0.0f);
        // 去除背景边框线
        piePlot.setOutlinePaint(null);
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
        chart.setBackgroundPaint(ChartColor.WHITE);

        DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题,表示小数点后保留两位。
        NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
        // 设置标签生成器(默认{0})
        // {0}:key {1}:value {2}:百分比 {3}:sum
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1}占{2})",nf, df));


        //"PieChart.jpeg"
        File pieChart = new File(path);
        ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
    }

    private DefaultPieDataset createDataset(List<Map<String, Object>> list) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        list.forEach(item -> {
            dataset.setValue(item.get("name").toString(), Double.valueOf(item.get("value").toString()));
        });
        return dataset;
    }

}
