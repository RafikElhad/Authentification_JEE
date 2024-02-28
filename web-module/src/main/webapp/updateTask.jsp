<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
-->
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 29/01/2024
  Time: 13:28
  To change this template use File | Settings | File Templates.
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        /*
  ========================================
  Reset
  ========================================
*/
        html, body, div, span, applet, object, iframe,
        h1, h2, h3, h4, h5, h6, p, blockquote, pre,
        a, abbr, acronym, address, big, cite, code,
        del, dfn, em, img, ins, kbd, q, s, samp,
        small, strike, strong, sub, sup, tt, var,
        b, u, i, center,
        dl, dt, dd, ol, ul, li,
        fieldset, form, label, legend,
        table, caption, tbody, tfoot, thead, tr, th, td,
        article, aside, canvas, details, embed,
        figure, figcaption, footer, header, hgroup,
        menu, nav, output, ruby, section, summary,
        time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }
        /* HTML5 display-role reset for older browsers */
        article, aside, details, figcaption, figure,
        footer, header, hgroup, menu, nav, section {
            display: block;
        }
        body {
            line-height: 1;
        }
        ol, ul {
            list-style: none;
        }
        blockquote, q {
            quotes: none;
        }
        blockquote:before, blockquote:after,
        q:before, q:after {
            content: '';
            content: none;
        }
        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        /*
          ========================================
          General styles
          ========================================
        */
        *,
        *:after,
        *:before {
            box-sizing: border-box;
        }
        body {
            font: 16px 'Ubuntu', sans-serif;
            background: #ecf0f1;
            border-top: 5px solid #95a5a6;
        }


        /*
          ========================================
          Header
          ========================================
        */
        header {
            text-align: center;
        }
        header h1 {
            font-size: 64px;
            font-weight: 300;
            margin: 80px 0 25px;
            color: #7f8c8d;
        }
        header h1 span {
            font-weight: 700;
        }
        header h2 {
            color: #bdc3c7;
        }

        /*
          ========================================
          Insert
          ========================================
        */
        .app-insert {
            width: 800px;
            margin: 50px auto 20px;
        }
        .app-insert input {
            width: 100%;
            height: 60px;
            background: #ecf0f1;
            border: 1px solid #bdc3c7;
            border-radius: 10px;
            outline: none;
            font: 300 28px 'Ubuntu', sans-serif;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: inset 5px 5px 10px #d9d9d9, inset -5px -5px 10px #ffffff;
        }


        /*
          ========================================
          List
          ========================================
        */


        .app-table {
            width: 800px;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background: #ecf0f1;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 5px 5px 15px #d9d9d9, -5px -5px 15px #ffffff;
        }

        thead {
            background-color: #bdc3c7;
            color: #333;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #dcdde1;
        }

        th:last-child, td:last-child {
            text-align: center;
        }

        tr:hover {
            background: rgba(0, 0, 0, .04);
        }

        /*.remove-task {*/
        /*    opacity: 0;*/
        /*    text-decoration: none;*/
        /*    color: #7f8c8d;*/
        /*    cursor: pointer;*/
        /*    transition: opacity 0.2s ease;*/
        /*}*/

        /*tr:hover .remove-task {*/
        /*    opacity: 1;*/
        /*}*/

        .remove-task:hover {
            color: #333;
        }



        .app-insert button {
            padding: 10px 20px;
            background-color: #ecf0f1;
            border: 1px solid #bdc3c7;
            border-radius: 10px;
            outline: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s, box-shadow 0.3s;
            box-shadow: 5px 5px 15px #d9d9d9, -5px -5px 15px #ffffff;
        }

        .app-insert button:hover {
            background-color: #dcdde1;
        }


    </style>
    <%--    <link rel="stylesheet" href="css/addTask.css">--%>

</head>
<body>
<header class="main-header">
    <h1>simple<span>todo</span></h1>

</header>
<form method="post" action="updateTaskServlet">
    <section class="app-insert">
        <input type="text" name="description" value="${editedTask.description}" placeholder="">
        <input type="hidden" name="id" value="${editedTask.id}">
        <button type="submit">Update</button>
    </section>
</form>
</body>

</html>
