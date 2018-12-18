package com.ywm.demo;

import com.ywm.demo.common.ChartUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanweimin
 * @Date: 2018/12/17 9:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JfreechartTest {

    @Test
    public void testPie() throws Exception {
        String title = "饼状图案例1";
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "苹果");
        map.put("value", 1);
        list.add(map);
        map = new HashMap<>();
        map.put("name", "梨");
        map.put("value", 2);
        list.add(map);
        map = new HashMap<>();
        map.put("name", "香蕉");
        map.put("value", 3);
        list.add(map);
        map = new HashMap<>();
        map.put("name", "橘子");
        map.put("value", 4);
        list.add(map);
        map = new HashMap<>();
        map.put("name", "西瓜");
        map.put("value", 5);
        list.add(map);
        String jpegName = "pie1.jpeg";
        ChartUtil.createPieChart(title, list, jpegName);
    }

    @Test
    public void testBar() throws Exception {
        String title = "统计水果销售情况";
        String label = "图示2";
        String leftTitle = "数量";
        double[][] data = {{20, 30, 40, 50, 60, 70}, {20, 30, 40, 50, 60, 70}, {20, 30, 40, 50, 60, 70}
                , {20, 30, 40, 50, 60, 70}, {70, 60, 50, 40, 30, 20}};

        String[] columnKeys = {"1月", "2月", "3月", "4月", "5月", "6月"};
        String[] rowKeys = {"苹果", "梨", "香蕉", "橘子", "西瓜"};
        String jpgName = "bar1.jpeg";
        ChartUtil.createBarChart(title, label, leftTitle, data, rowKeys, columnKeys, jpgName);
    }

    @Test
    public void testLine() throws Exception {
        String title = "统计水果销售情况";
        String label = "图示2";
        String leftTitle = "数量";
        double[][] data = {{20, 20, 20, 20, 20, 20}, {30, 30, 30, 30, 30, 30}, {20, 30, 40, 50, 60, 70}
                , {50, 50, 50, 50, 60, 50}, {70, 60, 50, 40, 30, 20}};

        String[] columnKeys = {"1月", "2月", "3月", "4月", "5月", "6月"};
        String[] rowKeys = {"苹果", "梨", "香蕉", "橘子", "西瓜"};
        String jpgName = "line1.jpeg";
        ChartUtil.createLineChart(title, label, leftTitle, data, rowKeys, columnKeys, jpgName);
    }

    @Test
    public void testBarAndLine() throws Exception {
        double[][] lineData = {{20, 30, 40, 70, 90}};
        String[] lineRowKeys = {"苹果"};
        String[] lineColumnKeys = {"1月", "2月", "3月", "4月", "5月"};
        double[][] barData = {{1, 2, 3, 4, 5}};
        String[] barRowKeys = {"苹果"};
        String[] barColumnKeys = {"1月", "2月", "3月", "4月", "5月"};
        String jpgName = "barLine.jpg";

        ChartUtil.createBarAndLineChart(lineData, lineRowKeys, lineColumnKeys, barData, barRowKeys, barColumnKeys, jpgName);
    }

}
