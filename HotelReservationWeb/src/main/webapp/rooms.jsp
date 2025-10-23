<%@ page import="java.util.*, model.Room" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html><body>
<h2>객실 목록</h2>
<table border="1">
<tr><th>ID</th><th>유형</th><th>가격</th></tr>
<%
List<Room> list = (List<Room>) request.getAttribute("rooms");
for (Room r : list) {
%>
<tr>
<td><%=r.getId()%></td>
<td><%=r.getType()%></td>
<td><%=String.format("%,d", r.getPrice())%>원</td>
</tr>
<% } %>
</table>
<a href="index.jsp">메인으로</a>
</body></html>
