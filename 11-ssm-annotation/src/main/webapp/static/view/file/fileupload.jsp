<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 2023/1/26
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="fileupload" method="post" enctype="multipart/form-data">
    请选择要上传的文件：
    <input name="files" type="file">
    <input type="submit" value="上传文件">
</form>
</body>
</html>
