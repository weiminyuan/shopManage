package com.ywm.demo.common;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 柱状图
 *
 * @Author: yuanweimin
 * @Date: 2018/12/17 9:48
 */
public class BarChart {

    /**
     * 柱状图
     *
     * @param title     标题
     * @param label     底部说明
     * @param leftTitle 左标题
     * @param rowKeys    分组
     * @param columnKeys  每组项目名称
     * @param data      数据
     * @param path      路径地址
     * @param width     图片宽度
     * @param height    图片高度
     * @throws Exception
     */
    public void createBarChart(String title, String label, String leftTitle, double[][] data,
                               String[] rowKeys, String[] columnKeys, String path, int width, int height) throws Exception {

        ChartCommonUtil.setChartTheme();

        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                label,
                leftTitle,
                ChartCommonUtil.createDataset(data, rowKeys, columnKeys),
                PlotOrientation.VERTICAL,
                true, true, false);

        barChart.setBackgroundPaint(ChartColor.WHITE);
        barChart.setBackgroundImageAlpha(0.0f);
        CategoryPlot p = barChart.getCategoryPlot();
        // 设置图的背景颜色
        p.setBackgroundPaint(ChartColor.WHITE);

        //"BarChart.jpeg"
        File file = new File(path);
        ChartUtilities.saveChartAsJPEG(file, barChart, width, height);
    }

}
