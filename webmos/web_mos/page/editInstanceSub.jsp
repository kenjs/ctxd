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
<%@page import="com.cattsoft.pub.util.StringUtil" %>
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
	background: #FFF
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

.smallselect {
	background: #fafdfe;
	height: 25px;
	width: 100px;
	line-height: 25px;
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
	height: 25px;
	width: 35px;
	line-height: 25px;
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

<script type="text/javascript">
	(function($) {//���.html()������ȡ�����޸�valueֵ�������
		var oldHTML = $.fn.html;
		$.fn.formhtml = function() {
			if (arguments.length)
				return oldHTML.apply(this, arguments);
			$("input,textarea,button", this).each(function() {
				this.setAttribute('value', this.value);
			});
			$(":radio,:checkbox", this).each(function() {
				if (this.checked)
					this.setAttribute('checked', 'checked');
				else this.removeAttribute('checked');
			});
			$("option", this).each(function() {
				if (this.selected)
					this.setAttribute('selected', 'selected');
				else this.removeAttribute('selected');
			});
			return oldHTML.apply(this);
		};
	})(jQuery);
	
	
$(function(){
 
		$('#btnQuery').click(function() {
			showCover();
			$("#queryForm").submit();
		});
})

function doChange(obj){
	var trn=$(obj).parent().parent().prevAll().length;
	var n=parseInt(trn)-1;
	if($(obj).val()!=''){
		//$("#chkIsCondition"+n).attr("checked", true);
		document.getElementById("chkIsCondition"+n).checked=true;
	}else{
		//$("#chkIsCondition"+n).attr("checked", false);
		document.getElementById("chkIsCondition"+n).checked=false;
	}
}
</script>

<%
	List columnList=(List)request.getAttribute("columnList");
	List bgColorList=(List)request.getAttribute("bgColorList");
 %>
</head>

<body>
	<form id="queryForm" action="../tm/ctxdAction.do?method=queryResult"
		method="post">
		<span style="display:none">
			<input type="hidden" name="instanceId" value='<%=request.getAttribute("instanceId")%>'/>
		</span>
		<div id="contentWrap">
			<div class="pageColumn">
				<div class="qryCondition">
				</div>
				<div id="datadiv" style="width:100%;overflow: auto;height:90%">
				<table id="datatable">
					<thead>
						<th>����</th>
						<th>
							�Ƿ���ʾ
							<input type="checkbox" name="chkselectAll" id="chkselectAll" onclick="selectAll();"/>	
						</th>
						<th>����ɫ</th>
						<th>���</th>
						<th>��ѯ����</th>
						<th>��������</th>
						<th>���</th>
						<th>�Ƿ�����</th>
					</thead>
					<tbody>
						<%
							out.println("<input type='hidden' name='columnCount' value='"+((List)request.getAttribute("columnList")).size()+"' />");
							for(int i=0;i<columnList.size();i++){
								out.println("<tr>");
								com.cattsoft.tm.vo.QueryInstanceColumnSVO  column=(com.cattsoft.tm.vo.QueryInstanceColumnSVO)columnList.get(i);
								String isShow=column.getIsShow();
								String isCondition=column.getIsCondition();
								String conditiontype=column.getConditionType();
								String isShowChecked="Y".equals(isShow)?"checked":"";
								String isConditionChecked="Y".equals(isCondition)?"checked":"";
								String seq=column.getSeq()==null?"":column.getSeq();
								String bgColor=column.getBgColor()==null?"":column.getBgColor();;
								String width=column.getWidth()==null?"":column.getWidth();
								String isSort=column.getIsSort();
								String isSortCheck="Y".equals(isSort)?"checked":"";
								out.println("<td class='ctd'>"+column.getColumnDesc()+"</td>");
								out.println("<td class='ctd'><input type='checkbox' "+ isShowChecked+ " class='ck' id='chkIsShow"+i +"' name='chkIsShow"+i+"' value='Y' /></td>");
						%>
							<!-- ����ɫ -->
							<td class='ctd'>
								<select id="sltbgColor<%=i%>" name="sltbgColor<%=i%>" class="smallselect">
								<option value="">��ѡ��</option>
								<%
									for(int j=0;j<bgColorList.size();j++){
										Map m=(Map)bgColorList.get(j);
										String label=(String)m.get("label");
										String value=(String)m.get("value");
										String selected=bgColor.equals(label)?"selected":"";
										out.println("<option "+ selected+ " style='background-color:"+label+"'  value='"+label+"'>"+label+"</option>");
									}
									%>
								 </select>
							</td>
						<!-- ��� -->
						<td class="ctd">
							<input type="text" id="width<%=i%>" name="width<%=i%>"  class="smalltext" value="<%=width %>" />
						</td>
						<%
							out.println("<td class='ctd'><input type='checkbox' "+isConditionChecked+" id='chkIsCondition"+i +"' name='chkIsCondition"+i+"'  value='Y' onclick='checkCondition(this);'/></td>");
						%>
						<td class='ctd'>
								<input type="hidden" id="columnName<%=i%>" name="columnName<%=i%>" value="<%=column.getColumnName() %>" />
								<select id="sltConditionType<%=i%>" name="sltConditionType<%=i%>" class="smallselect" onchange="doChange(this);">
									<option value="" >��ѡ��</option>
									<option value="E" <%if("E".equals(conditiontype))out.print("selected"); %>>����</option>
									<option value="B" <%if("B".equals(conditiontype))out.print("selected"); %>>����</option>
									<option value="C" <%if("C".equals(conditiontype))out.print("selected"); %>>����</option>
									<option value="S" <%if("S".equals(conditiontype))out.print("selected"); %>>����</option>
								</select>
							</td>
							<td class="ctd">
								<input type="text" id="seq<%=i%>" name="seq<%=i%>"  class="smalltext" value="<%=seq%>" />
							</td>
							<td class="ctd">
								<input type="checkbox" id="isSort<%=i%>" name="isSort<%=i%>"  class="smalltext" value="Y" <%=isSortCheck %> />
							</td>
						<%		
								out.println("</tr>");
							}
						 %>
					</tbody>
				</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
