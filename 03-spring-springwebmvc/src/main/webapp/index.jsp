<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<a href="firstController">基于Controller接口实现类点这里</a>
<br>
<hr>
<a href="secondController">基于注解的Controller点这里</a>
<br>
<hr>
<a href="request1">request1</a>
<br>
<a href="request2">request2</a>
<br>
<%--会访问失败，拒绝访问--%>
<a href="request3">request3:Web-INF(该目录下不允许Post请求访问)</a>
<br>
<a href="request4">request4</a>
<br>
<a href="request5">request5:Forward(SpringMVC)</a>
<br>
<a href="request6">request6:Redirect(SpringMVC：禁止请求重定向到WEB-INF下)</a>
<br>
<a href="request7">request7:Forward(Servlet)</a>
<br>
<a href="request8">request8:Redirect(Servlet：禁止请求重定向到WEB-INF下)</a>
<br>
<a href="request9">request9</a>
<br>
<a href="request10">request10</a>
<br>
<a href="request11">request11</a>
<br>
<a href="request12">request12</a>
<br>
<a href="request13">request13</a>
<br>
</body>
</html>
