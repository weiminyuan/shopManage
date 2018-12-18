package com.ywm.demo.common;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 折线图
 *
 * @Author: yuanweimin
 * @Date: 2018/12/17 9:49
 */
public class LineChart {
    /**
     * 创建折线图
     *
     * @param title     标题
     * @param label     底部说明
     * @param leftTitle 左标题
     * @param columnKeys    分组
     * @param rowKeys  每组项目名称
     * @param data      项目名称对于的值
     * @param path      路径地址
     * @param width     图片宽度
     * @param height    图片高度
     * @throws Exception
     */
    public void createLineChart(String title, String label, String leftTitle, double[][] data,
                                String[] rowKeys, String[] columnKeys,
                                String path, int width, int height) throws Exception {
        ChartCommonUtil.setChartTheme();

        JFreeChart lineChart = ChartFactory.createLineChart(
                title,
                label,
                leftTitle,
                ChartCommonUtil.createDataset(data, rowKeys, columnKeys),
                PlotOrientation.VERTICAL,
                true, true, false);
        lineChart.setBackgroundPaint(ChartColor.WHITE);

        CategoryPlot plot = lineChart.getCategoryPlot();
        // 设置图的背景颜色
        plot.setBackgroundPaint(ChartColor.WHITE);

        //"LineChart.jpeg"
        File file = new File(path);
        ChartUtilities.saveChartAsJPEG(file, lineChart, width, height);
    }

}
