<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.cattsoft.pub.util.PagView"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="com.cattsoft.tm.struts.Tools"%>
<%@page import="com.cattsoft.tm.vo.DColumnDescSVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.cattsoft.tm.vo.QueryConditionSVO"%>
<%@page import="com.cattsoft.tm.vo.QueryInstanceColumnSVO"%>
<%@page import="com.cattsoft.pub.util.StringUtil"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/pagination.tld" prefix="pag"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���ݲ�ѯ</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../js/public.js"></script>

<style type="text/css">
body {
	background: #FFF;
	margin: 0;padding: 0;
}
html{
margin: 0;padding: 0;
}

.shortselect {
	background: #fafdfe;
	height: 28px;
	width: 150px;
	line-height: 28px;
	border: 1px solid #9bc0dd;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.shottext {
	background: #fafdfe;
	height: 28px;
	width: 150px;
	line-height: 28px;
	border: 1px solid #9bc0dd;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.smalltext {
	background: #fafdfe;
	height: 15px;
	width: 25px;
	line-height: 15px;
	border: 1px solid #9bc0dd;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.btn {
	background-image: url("../images/button_bg.png");
}

.datetext {
	background: #fafdfe;
	height: 28px;
	width: 80px;
	line-height: 28px;
	border: 1px solid #9bc0dd;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}
</style>
</head>

<body>
	<div class="pageTitle"></div>
	<table>
		<tr class="ctr">
			<td class="ctd"><font size="6">��ӭ���뾭Ӫ����֧��ϵͳ��</font></td>
		</tr>
		<tr class="ctr">
			<td class="ctd" style="float:left;height:60px;overflow:hidden;text-align:left">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font
				size="4">
					��ϵͳ���Ը���������Ҫ���ھ��������ú󣬲�ѯ���ݿ������������ݡ����߱��˲�ѯ��ϸ��Ϣ��������Ϣ�����ò�ѯ���ݡ�
					��ѯ�����Ĺ��ܡ�������ԡ���չ�Խ������û��������ɵ���ɶԾ�Ӫ���ݵĲ鿴�ͷ����� </font></td>
		</tr>
	</table>

</body>
</html>
