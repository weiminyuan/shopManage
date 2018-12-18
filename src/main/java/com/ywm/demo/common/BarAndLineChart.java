package com.ywm.demo.common;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

/**
 * @Author: yuanweimin
 * @Date: 2018/12/17 15:45
 */
public class BarAndLineChart {

    public void createBarAndLineChart(double[][] lineData,
                                      String[] lineRowKeys, String[] lineColumnKeys,
                                      double[][] barData, String[] barRowKeys,
                                      String[] barColumnKeys, String path, int width, int height) throws IOException {
        if (lineData == null || lineRowKeys == null || lineColumnKeys == null
                || barData == null || barRowKeys == null || barColumnKeys == null
                || path == null || "".equals(path.trim())) {
            return;
        }
        CategoryDataset dataSetColumn = ChartCommonUtil.createDataset(barData, barRowKeys, barColumnKeys);
        CategoryDataset dataSetLine = ChartCommonUtil.createDataset(lineData, lineRowKeys, lineColumnKeys);
        createChart(dataSetColumn, dataSetLine, path, width, height);
    }

    private void createChart(CategoryDataset dataSetColumn, CategoryDataset dataSetLine, String path,
                             int width, int height) throws IOException {
        ChartCommonUtil.setChartTheme();
        Font font = new Font("宋体", Font.BOLD, 12);

        // 创建图形对象
        JFreeChart jfreeChart = ChartFactory.createBarChart("", // 图表标题
                "", // 目录轴的显示标签
                "",// 数值轴的显示标签
                dataSetColumn, // 数据集
                PlotOrientation.VERTICAL,// 图表方向：水平、垂直
                false, // 是否显示图例(对于简单的柱状图必须是false)
                true,// 是否生成工具
                false);// 是否生成URL链接
        jfreeChart.getTitle().setFont(font);
        // 图表的背景色(默认为白色)
        jfreeChart.setBackgroundPaint(Color.white);
        // 设置图片背景色
        GradientPaint gradientPaint = new GradientPaint(0, 1000, Color.WHITE, 0, 0, Color.WHITE, false);
        jfreeChart.setBackgroundPaint(gradientPaint);

        CategoryPlot categoryPlot = (CategoryPlot) jfreeChart.getPlot();

        // 设置图形的背景色
        categoryPlot.setBackgroundPaint(Color.WHITE);
        // 设置图形上竖线是否显示
        categoryPlot.setDomainGridlinesVisible(false);
        // 设置图形上竖线的颜色
        categoryPlot.setDomainGridlinePaint(Color.GRAY);
        // 设置图形上横线的颜色
        categoryPlot.setRangeGridlinePaint(Color.GRAY);

        // 设置柱状图的Y轴显示样式
        setNumberAxisToColumn(categoryPlot);
        CategoryAxis categoryaxis = categoryPlot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);// 横轴斜45度
        // 设置折线图的Y轴显示样式
        setNumberAxisLine(categoryPlot);

        categoryPlot.setDataset(1, dataSetLine);// 设置数据集索引
        categoryPlot.mapDatasetToRangeAxis(1, 1);// 将该索引映射到axis
        // 第一个参数指数据集的索引,第二个参数为坐标轴的索引
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        // 数据点被填充即不是空心点
        lineAndShapeRenderer.setShapesFilled(true);
        // 数据点间连线可见
        lineAndShapeRenderer.setLinesVisible(true);
        // 设置折线拐点的形状，圆形
        lineAndShapeRenderer.setSeriesShape(0, new Ellipse2D.Double(-2D, -2D, 4D, 4D));

        // 设置某坐标轴索引上数据集的显示样式
        categoryPlot.setRenderer(1, lineAndShapeRenderer);
        // 设置两个图的前后顺序，
        // DatasetRenderingOrder.FORWARD表示后面的图在前者上面，DatasetRenderingOrder.REVERSE后面的图在前者后面
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        File file = new File(path);
        ChartUtilities.saveChartAsJPEG(file, jfreeChart, width, height);
    }

    /**
     * 设置折线图的Y轴显示样式
     *
     * @param categoryplot
     * @return
     */
    private CategoryPlot setNumberAxisLine(CategoryPlot categoryplot) {
        ValueAxis numberaxis = new NumberAxis("");
        numberaxis.setUpperBound(100.00D); // 纵轴上限
        numberaxis.setLowerBound(0.00D); // 纵轴下限
        categoryplot.setRangeAxis(1, numberaxis);
        return categoryplot;
    }

    /**
     * 设置柱状图的Y轴显示样式,NumberAxis为整数格式
     *
     * @param categoryplot
     * @return
     */
    private CategoryPlot setNumberAxisToColumn(CategoryPlot categoryplot) {
        // 获取纵轴
        NumberAxis numberAxis = (NumberAxis) categoryplot.getRangeAxis();
        // 设置纵轴的刻度线
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // 数据轴的数据标签是否自动确定（默认为true）
        numberAxis.setAutoTickUnitSelection(true);
        // 数据轴的数据标签
        numberAxis.setStandardTickUnits(numberAxis.getStandardTickUnits());
        numberAxis.setLowerBound(0); // 数据轴上的显示最小值;
        numberAxis.setAutoRangeMinimumSize(1);// 1为一个间隔单位
        categoryplot.setRangeAxis(numberAxis);
        LayeredBarRenderer layeredBarRenderer = new LayeredBarRenderer();
        // 设置柱子的边框是否显示
        layeredBarRenderer.setDrawBarOutline(false);
        // 设置柱体宽度
        layeredBarRenderer.setMaximumBarWidth(0.08);
        // 设置柱体颜色
        layeredBarRenderer.setSeriesPaint(0, new Color(198, 219, 248));
        categoryplot.setRenderer(layeredBarRenderer);

        return categoryplot;
    }


}
