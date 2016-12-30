<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <base href="<%=basePath%>">

	  <title>MyMusic添加歌手</title>

	  <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
	  <meta http-equiv="expires" content="0">
	  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	  <meta http-equiv="description" content="This is my page">
	  <link href="music/css/header.css" type="text/css" rel="Stylesheet" />
	  <link href="music/css/login.css" type="text/css" rel="Stylesheet" />

	  <style type="text/css">

		  #singers{
			  width:500px;
			  height:30px;
		  }
		  tr td{
			  padding-top:20px;

		  }
		  table{
			  algin:center;
			  margin:auto;
		  }
		  #subsinger{
			  width:100px;
			  height:30px;
			  background:green;

		  }

		  #addsinger{
			  margin-top:50px;
		  }
		  #rd{
			  margin-left:50px;

		  }

	  </style>
  </head>
  
  <body>

  <div id="header">
	  <img src="music/images/logo.jpg" class="logo"/>
	  <ul class="header_ul">
		  <li class="li"><a href="javascript:;">音乐馆</a></li>
		  <li><a href="javascript:;" class="header_a">我的音乐</a></li>

	  </ul>
	  <div class="header_text">
		  <input type="text" class="text" value=""/>
		  <input type="button" class="btn">
	  </div>
	  <div class="login">
		  <ul>
			  <li><span>您好:</span></li>
			  <li><a href="" class="header_a">注销</a></li>
		  </ul>
	  </div>
  </div>
  <form  action="/singerupdate.action" id="formid"  name= "myform" method = 'post' onsubmit = "return checkUser();" enctype="multipart/form-data">
	  <s:hidden name="singerid" value="%{#request.singer1.singerid}"></s:hidden>
	  <table>
		  <tr>

			  <td><s:textfield name="singer.singername" id="singers" label="歌手" value="%{#request.singer1.singername}"/> </td>
		  </tr>
		  <tr>

			  <td>
				  <s:radio list="{'男','女'}" id="rd" name="singer.sex" value="%{#request.singer1.sex}" label="性别"/>

			  </td>

		  </tr>
		  <tr>
			  <%--<td>简介</td>--%>
			  <%--<td><input type="text" id="singers" name="singerinfo"/></td>--%>
			  <td><s:textarea name="singer.singerinfo" id="singers"  value="%{#request.singer1.singerinfo}" label="简介"/></td>
		  </tr>
		  <tr>

			  <td><s:radio list="{'华语','欧美','日韩'}" name="singer.singerregion" value="%{#request.singer1.singerregion}" label="地域"/></td>
		  </tr>
		  <tr>
			  <td><s:textfield name="singer.singerattention" id="singers" value="%{#request.singer1.singerattention}" label="关注度"/> </td>

		  </tr>
		  <tr>
			  <td><s:file name="photo" id="singers" label="图片" /></td>
		  </tr>
		  <tr>
			  <td><s:submit value="保存" id="subsinger"/></td>
		  </tr>

	  </table>

  </form>
  </body>
</html>
