<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>龙果支付</title>
</head>
<body>
    <!-- 获取后台传来的表单数据,并自动提交 -->
<%--      ${payMessage}--%>
    <form id="rppaysubmit" name="rppaysubmit" action="http://demo.pay.roncoo.com:8092/roncoo-pay-web-gateway/scanPay/initPay" method="get">
        <input type="hidden" name="orderNo" value="1589087432565"/>
        <input type="hidden" name="sign" value="6AF5E8C1CD046BF3226EBDD809FA8A8B"/>
        <input type="hidden" name="numberOfStages" value=""/>
        <input type="hidden" name="remark" value=""/>
        <input type="hidden" name="productName" value=""/>
        <input type="hidden" name="orderPeriod" value="5"/>
        <input type="hidden" name="payType" value=""/>
        <input type="hidden" name="orderTime" value="20200510131042"/>
        <input type="hidden" name="orderIp" value="192.168.1.13"/>
        <input type="hidden" name="notifyUrl" value="http://www.roncoo.com"/>
        <input type="hidden" name="orderPrice" value="0.01"/>
        <input type="hidden" name="payKey" value="64efebf7eb5b439d8fa213de9028392e"/>
        <input type="hidden" name="returnUrl" value="http://www.roncoo.com"/>
        <input type="hidden" name="orderDate" value="20200510"/>
        <input type="submit" value="确定"></form>
<%--    <script>document.forms['rppaysubmit'].submit();</script>--%>
</body>
</html>
