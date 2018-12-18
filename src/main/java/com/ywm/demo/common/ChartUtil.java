package com.ywm.demo.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanweimin
 * @Date: 2018/12/17 9:35
 */
public class ChartUtil {
    final static String path = "E:/jpeg/";
    static int width = 640;
    static int height = 480;

    /**
     * 生成柱状图
     *
     * @param title     标题
     * @param list      值
     * @param imageName 路径地址
     * @throws Exception
     */
    public static String createPieChart(String title, List<Map<String, Object>> list, String imageName) throws Exception {
        PieChart pieChart = new PieChart();
        pieChart.createPieChart(title, list, path + imageName, width, height);
        return path + imageName;
    }

    public static String createPieChart(String title, String imageName, List<Map<String, Object>> list, int width, int height) throws Exception {
        PieChart pieChart = new PieChart();
        pieChart.createPieChart(title, list, path + imageName, width, height);
        return path + imageName;
    }

    /**
     * 柱状图
     *
     * @param title      标题
     * @param label      底部说明
     * @param leftTitle  左标题
     * @param rowKeys    分组
     * @param columnKeys 每组项目名称
     * @param data       数据
     * @param imageName  路径地址
     * @throws Exception
     */
    public static String createBarChart(String title, String label, String leftTitle, double[][] data,
                                        String[] rowKeys, String[] columnKeys, String imageName) throws Exception {
        BarChart barChart = new BarChart();
        barChart.createBarChart(title, label, leftTitle, data, rowKeys, columnKeys, path + imageName, width, height);
        return path + imageName;
    }

    public static String createBarChart(String title, String label, String leftTitle, double[][] data,
                                        String[] rowKeys, String[] columnKeys, String imageName, int width, int height) throws Exception {
        BarChart barChart = new BarChart();
        barChart.createBarChart(title, label, leftTitle, data, rowKeys, columnKeys, path + imageName, width, height);
        return path + imageName;
    }

    /**
     * 创建折线图
     *
     * @param title      标题
     * @param label      底部说明
     * @param leftTitle  左标题
     * @param rowKeys    分组
     * @param columnKeys 每组项目名称
     * @param data       数据
     * @param imageName  文件名称
     * @throws Exception
     */
    public static String createLineChart(String title, String label, String leftTitle, double[][] data,
                                         String[] rowKeys, String[] columnKeys, String imageName) throws Exception {
        LineChart lineChart = new LineChart();
        lineChart.createLineChart(title, label, leftTitle, data, rowKeys, columnKeys, path + imageName, width, height);
        return path + imageName;
    }

    public static String createLineChart(String title, String label, String leftTitle, double[][] data,
                                         String[] rowKeys, String[] columnKeys, String imageName, int width, int height) throws Exception {
        LineChart lineChart = new LineChart();
        lineChart.createLineChart(title, label, leftTitle, data, rowKeys, columnKeys, path + imageName, width, height);
        return path + imageName;
    }

    /**
     * 创建折线+柱状 图
     *
     * @param lineData
     * @param lineRowKeys
     * @param lineColumnKeys
     * @param barData
     * @param barRowKeys
     * @param barColumnKeys
     * @param imageName
     * @return
     * @throws IOException
     */
    public static String createBarAndLineChart(double[][] lineData, String[] lineRowKeys, String[] lineColumnKeys,
                                               double[][] barData, String[] barRowKeys, String[] barColumnKeys,
                                               String imageName) throws IOException {
        BarAndLineChart barAndLineChart = new BarAndLineChart();
        barAndLineChart.createBarAndLineChart(lineData, lineRowKeys, lineColumnKeys, barData, barRowKeys, barColumnKeys
                , path + imageName, width, height);
        return path + imageName;
    }

    public static String createBarAndLineChart(double[][] lineData, String[] lineRowKeys, String[] lineColumnKeys,
                                               double[][] barData, String[] barRowKeys, String[] barColumnKeys,
                                               String imageName, int width, int height) throws IOException {
        BarAndLineChart barAndLineChart = new BarAndLineChart();
        barAndLineChart.createBarAndLineChart(lineData, lineRowKeys, lineColumnKeys, barData, barRowKeys, barColumnKeys
                , path + imageName, width, height);
        return path + imageName;
    }
}
