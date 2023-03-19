<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
<main>
    <input id="student" name="student" type="text" placeholder="输入要查询的学生的姓名">
    <input id="teacher" name="teacher" type="text" placeholder="输入要查询的教师的姓名">
    <input id="send" type="button" value="发送异步查询请求" @click="sendRequest">

<%--    <a href="shcool/student/汤米谢尔比">查询学生</a>--%>
<%--    <a href="shcool/teacher/默凡语">查询老师</a>--%>
</main>
</body>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script>
    import { ref } from 'vue'
    export default {
        setup() {
            const count = ref(0)

            //要编写的被暴露的方法

            // 返回值会暴露给模板和其他的选项式 API 钩子
            return {
                count
            }
        },

        mounted() {
            console.log(this.count) // 0
        }
    }
</script>
</html>
