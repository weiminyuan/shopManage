<html>
<head>
    <title>pdf模板</title>
    <script type="text/javascript" src="/static/js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="/static/js/echarts.js"></script>
    <script type="text/javascript" src="/static/js/china.js" ></script>
    <script type="text/javascript" src="/static/js/html2canvas.min.js" ></script>
    <style type="text/css">
        .page{
            width: 100%;
            height: 960px;
        }
        .firstPage{
            background-image: url("/static/images/pdf/page.jpg");
            background-repeat: no-repeat;
            background-size:100% 100%;
        }
        .catalog{
            padding: 80px 0px 0px 50px;

        }
        .endPage{
            background-image: url("/static/images/pdf/end.jpg");
            background-repeat: no-repeat;
            background-size:100% 100%;
        }
        .dividerLine{
            width:100%;
            height:3px;
            margin:0px auto;
            padding:0px;
            background-color:#D5D5D5;
        }
        .chart{
            border: 2px solid gray;
        }
        .explain{
            position: center;
            font-size: 30px;
            display:-moz-inline-box;
            display:inline-block;
            width:90%;
            word-wrap: break-word;
        }
        .table{
            border-collapse:collapse;    /*表示将单元格中各小格之间的空隙进行合并*/
            border:2px #00F solid;      /*定义边框样式*/

        }
        .table tr,td{
            border:1px solid #000;
        }
    </style>
</head>
<body style="overflow-x:hidden;">
    <div class="page firstPage"></div>

</div>
<div class="dividerLine" ></div>
<div class="page catalog">
    <h2>一、放款概览</h2>
    <h2>二、地区分布</h2>
    <h2>三、用户分析</h2>
    <h2>四、产品分析</h2>
    <h2>五、还款情况</h2>
</div>
<div class="dividerLine" ></div>

<div class="page catalog">
    <h1>一、放款概览</h1>
    <div class="chart" id="oneChart" style="width:70%;height:400px; margin-left: 10%"></div>
    <div style="height: 60px; "></div>
    <div>
            <span class="explain">
                从2018年11月1日至11月29日，对8,701人进行放款，成功放款8,899笔，放款总金额达42,139,058.22元。
                </br>注：未放款日未显示。
            </span>
    </div>
</div>

<div class="dividerLine" ></div>

<div class="page catalog">
    <h1>二、地区分布</h1>

    <div>
        <div class="chart" id="twoChart" style="width:60%; height: 90%;float: left; border: 0px"></div>
        <div style="width:35%;float: right; ">
            <br><br>
            <span class="explain" style="width:80%;">
                    11月放款金额top5省份分别是江苏省、浙江省、四川省、广东省和湖南省。5分省放款总金额达1416.79万元，
                    放款2900笔，占总放款金额1/3以上。
                </span>
            <br><br><br><br>

            <table class="table">
                <tr>
                    <td>排名</td><td>省份</td><td>总放款金额（万元）</td><td>总放款笔数</td><td>放款金额占比</td>
                </tr>
                <tr>
                    <td>1</td><td>江苏省</td><td>323.25</td><td>643</td><td>7.67%</td>
                </tr>
                <tr>
                    <td>2</td><td>浙江省</td><td>323.25</td><td>643</td><td>7.67%</td>
                </tr>
                <tr>
                    <td>3</td><td>四川省</td><td>323.25</td><td>643</td><td>7.67%</td>
                </tr>
                <tr>
                    <td>4</td><td>广东省</td><td>323.25</td><td>643</td><td>7.67%</td>
                </tr>
                <tr>
                    <td>5</td><td>湖南省</td><td>总放款金额（万元）</td><td>总放款笔数</td><td>放款金额占比</td>
                </tr>
            </table>

        </div>

    </div>

</div>

<div class="dividerLine" ></div>

<div class="page catalog">
    <h1>三、用户分析</h1>
    <div>
        <div class="chart" id="threeChart" style="width:40%;height:400px; float: left"></div>
        <div class="chart" id="fourChart" style="width:55%;height:400px; float: right; margin-right:4%"></div>
    </div>
    <div style="height: 60px; width: 100%;float:left;"></div>
    <div>
            <span class="explain" style="margin-left: 2%">
                从借款用户性别分布中可以看出，借款用户男性比女性占比更高，但人均借款金额女性比男性高。
                从借款年龄分布中可以看出，20-40岁用户为主要借款群体，占总借款人数90%以上，且人均借款金额
                随年龄增加而增长。本月借款次数最多且借款金额最高的是一位江苏用户，共借款3次，借款总金额达4.5万元。
            </span>
    </div>
</div>

<div class="dividerLine" ></div>


<div class="page endPage"></div>
</body>
<script type="text/javascript">
    console.log("path路径值：<%=path %>");
    console.log("basePath路径值：<%=basePath %>");
    function randomData() {
        return Math.round(Math.random()*500);
    }

    // 第一页柱状图-初始化图表标签
    var oneChart = echarts.init(document.getElementById('oneChart'));
    var options={
        //定义一个标题
        title:{
            text:'AI学习热度',
            left:"center"
        },
        legend:{
            data:['AI']
        },
        //X轴设置
        xAxis:{
            data:['ML','DL','TL','RL','DL-GAN']
        },
        yAxis:{
        },
        //name=legend.data的时候才能显示图例
        series:[{
            name:'销量',
            type:'bar',
            data:['12','32','45','78','60']
        }]

    };
    oneChart.setOption(options);

    // 第二页地图--初始化图表标签
    var mydata = [
        {name: '北京',value: '100' },{name: '天津',value: randomData() },
        {name: '上海',value: randomData() },{name: '重庆',value: randomData() },
        {name: '河北',value: randomData() },{name: '河南',value: randomData() },
        {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
        {name: '黑龙江',value: randomData() },{name: '湖南',value: randomData() },
        {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
        {name: '新疆',value: randomData() },{name: '江苏',value: randomData() },
        {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
        {name: '湖北',value: randomData() },{name: '广西',value: randomData() },
        {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
        {name: '内蒙古',value: randomData() },{name: '陕西',value: randomData() },
        {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
        {name: '贵州',value: randomData() },{name: '广东',value: randomData() },
        {name: '青海',value: randomData() },{name: '西藏',value: randomData() },
        {name: '四川',value: randomData() },{name: '宁夏',value: randomData() },
        {name: '海南',value: randomData() },{name: '台湾',value: randomData() },
        {name: '香港',value: randomData() },{name: '澳门',value: randomData() }
    ];
    var options = {
        backgroundColor: '#FFFFFF',
        title: {
            text: '',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item'
        },

        //左侧小导航图标
        visualMap: {
            show : true,
            x: 'left',
            y: 'center',
            splitList: [
                {start: 500, end:600},{start: 400, end: 500},
                {start: 300, end: 400},{start: 200, end: 300},
                {start: 100, end: 200},{start: 0, end: 100},
            ],
            color: ['#5475f5', '#9feaa5', '#85daef','#74e2ca', '#e6ac53', '#9fb5ea']
        },

        //配置属性
        series: [{
            name: '数据',
            type: 'map',
            mapType: 'china',
            roam: true,
            label: {
                normal: {
                    show: true  //省份名称
                },
                emphasis: {
                    show: false
                }
            },
            data:mydata  //数据
        }]
    };
    //初始化echarts实例
    var twoChart = echarts.init(document.getElementById('twoChart'));
    //使用制定的配置项和数据显示图表
    twoChart.setOption(options);

    //第三页饼状图+柱状图
    var json = [
        {value:30,name:'高圆圆'},
        {value:26,name:'赵丽颖'},
        {value:24,name:'江莱'}
    ];
    var threeChart = echarts.init(document.getElementById('threeChart'));
    var option = {
        title : {
            text: '女神年龄分布',
            subtext: '独家报道',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} 岁"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['高圆圆','赵丽颖','江莱']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                // dataView : {show: true, readOnly: false},    //修改数据
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                // restore : {show: true},  //刷新
                // saveAsImage : {show: true}   //保存图片
            }
        },
        calculable : true,
        series : [
            {
                name:'女神',
                type:'pie',
                radius : '55%',//饼图的半径大小
                center: ['50%', '60%'],//饼图的位置
                data:json
            }
        ]
    };
    threeChart.setOption(option);


    var fourChart = echarts.init(document.getElementById('fourChart'));
    var options={
        //定义一个标题
        title:{
            text:'AI学习热度',
            left:"center"
        },
        legend:{
            data:['AI']
        },
        //X轴设置
        xAxis:{
            data:['ML','DL','TL','RL','DL-GAN']
        },
        yAxis:{
        },
        //name=legend.data的时候才能显示图例
        series:[{
            name:'销量',
            type:'bar',
            data:['12','32','45','78','60']
        }]

    };
    fourChart.setOption(options);

    //获取echarts图的base64编码，为png格式。
    var picBase64Info_twoChart = twoChart.getDataURL();
    alert(picBase64Info_twoChart);
    if(picBase64Info_twoChart){
        $.ajax({
            type: "post",
            url: "/echarts/save",
            data: {picBase64Info_twoChart:picBase64Info_twoChart},
            dataType: "json",
            success: function(data){
              if("success" == data){
                  alert("保存成功!");
              }else {
                  alert("保存失败!");
              }
            }
        });
    }
</script>
</html>
