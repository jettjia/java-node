<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>
<#--我只是一个注释，我不会有任何输出  -->
${name},你好。${message}

<h2>assign指令</h2>
<#assign info={"mobile": "15012345678", "address":"上海"} />
电话:${info.mobile} 地址:${info.address}

<h1>FTL指令</h1>
<h2>include指令</h2>
<#include "head.ftl">

<h2>if指令</h2>
<#if success=true>
通过
<#else>
未通过
</#if>

<h2>list指令</h2>
<#list goodsList as goods>
${goods_index+1} 商品名称：${goods.name} 价格：${goods.price}<br/>
</#list>

<h1>内建函数</h1>
<h2>内建函数-size</h2>
共 ${goodsList?size}条记录

<h2>内建函数-eval</h2>
<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />
<#assign data=text?eval />
开户行：${data.bank}  账号：${data.account}

<h2>内建函数-日期</h2>
当前日期：${today?date} <br>
当前时间：${today?time} <br>   
当前日期+时间：${today?datetime} <br>        
日期格式化：  ${today?string("yyyy年MM月")}

<h2>内建函数-数字转</h2>
累计积分：${point} <br/>
累计积分：${point?c}

<h1>空值处理运算符</h1>
<#if aaa??>
    aaa存在
<#else>
    aaa不存在
</#if>
<br/>
如果是null，则输出-
${aaa!'-'}

<h1>运算符</h1>
+-*/
&& || ! 

== = != >= ...


</body>
</html>