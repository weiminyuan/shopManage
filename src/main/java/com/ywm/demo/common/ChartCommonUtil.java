package com.ywm.demo.common;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.*;

/**
 * @Author: yuanweimin
 * @Date: 2018/12/17 16:10
 */
public class ChartCommonUtil {
    public static void setChartTheme() {
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
    }

    /**
     * 创建图表数据集
     *
     * @param data
     * @param rowKeys
     * @param columnKeys
     * @return
     */
    public static CategoryDataset createDataset(double[][] data, String[] rowKeys, String[] columnKeys) {
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
        return dataset;
    }
}
