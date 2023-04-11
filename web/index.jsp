<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的育碧游戏</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/indexcss.css" type="text/css" />
</head>

<body>

<div id="zy">
    <nav>
        <img src="img/logo.png"/>

        <a href="#dbyx">游戏</a>
        <form class="bs-example bs-example-form" role="form">
            <div class="input-group input-group-lg">

                <input type="text" class="form-control" placeholder="搜索资讯 商品或游戏">
                <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="background-color: #D4D4D4;">搜索</button>
                </span>
            </div>
        </form>

        <div class="dropdown">
            <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
                欢迎你，<%=request.getSession().getAttribute("username")%>
                <span class="caret"></span>
            </button>

            <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu1">

                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/zwy/updateuser.jsp">修改信息</a>
                </li>

                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/logout">退出登录</a>
                </li>

            </ul>
            <!-- 登录按钮（Modal） -->

        </div>
    </nav>

    <div id="bgphoto">
        <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">

            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="img/cp1.png" alt="First slide">
                    <div class="carousel-caption">刺客信条奥德赛</div>
                </div>

                <div class="item">
                    <img src="img/cp3.png" alt="Second slide">
                    <div class="carousel-caption">星链</div>
                </div>

                <div class="item">
                    <img src="img/cp2.png" alt="Third slide">
                    <div class="carousel-caption">荣耀战魂</div>
                </div>
            </div>

            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>

            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div id="gsdt">
            <p id="gsdt-bt">资讯</p>
            <ol>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/1989" target="_blank">1.主设计师访谈--游戏背后的故事</a>
                </li>
                <li><a class="gsdt-1"
                       href="https://baike.baidu.com/reference/950025/35ff-ml2_ptHnJKKD0g8jAsvvrtqeqOgtfJjf2AorgUDEZC8W_cmBdLWULiZtkFlXSxaXWF9512GItlVxps8ZSZ5D3A1ag"
                       target="_blank">2.育碧公布最新财报 营业收入和利润创新高</a></li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2084"
                       target="_blank">3.《荣耀战魂》5月计划表</a></li>

                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2046" target="_blank">4.《全境封锁2》4月18日
                    维护更新详情</a></li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2080" target="_blank">5.《刺客信条》——2019 年
                    5 月更新</a></li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2064" target="_blank">6.《全境封锁2》制作团队访谈——聊聊新版本</a>
                </li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2020" target="_blank">7.来《饥饿龙》参加复活节狩猎，赢取复活节彩蛋</a>
                </li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2076" target="_blank">8.展开复仇！《看门狗》简体中文更新现已上线</a>
                </li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2021" target="_blank">9.《全境封锁冲破黎明》官方小说即将登陆！</a>
                </li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2083" target="_blank">10.《刺客信条：奥德赛》创造未知的世界</a>
                </li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2067" target="_blank">11.游戏小技巧，特工们你们GET到了么</a> 
                </li>
                <li><a class="gsdt-1" href="https://www.ubisoft.com.cn/news2/show/2057"
                       target="_blank">12《英灵乱战》每周活动开启 </a>
                </li>
                <br/>
                <li><a class="gsdt-1"
                       href="https://baike.baidu.com/reference/950025/c8f14rezJqlUPNJRqd4P2D6UITJj7LGYujcQUJG2s4EXXysdkypqvYpxvEwxiFuiwLr3-5AetcmDeo4xlpv0CBkSf6_OM8LNEmldVw"
                       target="_blank">育碧公布了新的Logo 官方解释Logo背后含义</a>
                </li>
            </ol>
        </div>
        <div id="Prizewinning">
            <div id="spmc">
                育碧2018TGA获奖和2018E3展视频
            </div>
            <iframe src="zwy/iframe-void.html"></iframe>
        </div>
        <div id="ub">
            <img src="img/timg.gif"/>
            <div id="ubzl">
                &emsp; &emsp;育碧成立于1986年，是一家总部设于法国雷恩（Rennes）的电动游戏开发商和发行商。它在全世界拥有23间游戏开发工作室。2008年它是欧洲第三大独立游戏开发商、北美第四独立出版商
                <br/>&emsp; &emsp;" 育碧娱乐软件公司(Ubisoft
                Entertainment)是一家跨国的游戏制作、发行和代销商。作为多媒体工业的佼佼者，其广泛的业务稳步扩展，在和各老牌游戏公司合作的基础上，也在不断推出独特的产品，加强自己在国际市场上的影响力。
                <br/> &emsp; &emsp;其中优秀的作品有《雷曼》(Rayman)、《刺客信条》系列(Assassin's Creed)、《波斯王子》(Prince of Persia)、《细胞分裂》（Tom
                Clancy's Splinter Cell）、《彩虹六号》系列（Tom Clancy's Rainbow Six）、《看门狗》系列、《全境封锁》系列（Tom clancy's The
                Division)、《幽灵行动》系列（Tom Clancy's Ghost Recon）等。
            </div>
        </div>

        <div id="zb">
            <div id="first">
                <a href="zwy/ckxtxx.html" target="_blank"> <img src="img/ckxtxxx.png"/>
                <a href="zwy/ckxtqy.html" target="_blank"><img src="img/ylxdhy.png"/>
                <a href="zwy/ckxtqy.html" target="_blank"><img src="img/ckxtqy.png"/>

                <a href="zwy/ckxtbns.html" target="_blank"><img src="img/ckxtbns.png">
                <a href="zwy/ckxtpb.html" target="_blank"><img src="img/cckxtpb.png"/>
            </div>

            <div id="scand">
                <a href="zwy/ckxtxdh.html" target="_blank"><img src="img/chyh.png"/>
                <a href="zwy/ckxthq.html" target="_blank"><img src="img/gdjh.png"/>
                <a href="zwy/ckxtdgm.html" target="_blank"><img src="img/dgm.png"/>
                <a href="zwy/ckxt1.html" target="_blank"><img src="img/xkzs.png"/>
                <a href="zwy/ckxt2.html" target="_blank"><img src="img/ylxdhy.png"/>
            </div>
        </div>

        <div id="gryx">
            <a name="dbyx"></a>
            <a href="#top" id="hddb">回到顶部</a>
            <div id="bq"> (c) Copyright 2023 李成俊，All Rights Reserved.
                资料来源：育碧官网
            </div>
        </div>
    </div>
</body>
</html>
