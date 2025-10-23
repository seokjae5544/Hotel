<%@ page import="java.util.*, model.Reservation, model.Room, model.HotelDAO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
HotelDAO dao = new HotelDAO();
List<Reservation> list = (List<Reservation>) request.getAttribute("reservations");
%>
<html><body>
<h2>예약 목록</h2>
<table border="1">
<tr><th>ID</th><th>이름</th><th>객실</th><th>체크인</th><th>체크아웃</th><th>삭제</th></tr>
<%
for (Reservation r : list) {
    Room room = dao.getRoomById(r.getRoomId());
%>
<tr>
<td><%=r.getId()%></td>
<td><%=r.getName()%></td>
<td><%=room.getType()%> (<%=room.getId()%>)</td>
<td><%=r.getCheckIn()%></td>
<td><%=r.getCheckOut()%></td>
<td><a href="hotel?action=delete&id=<%=r.getId()%>">삭제</a></td>
</tr>
<% } %>
</table>
<a href="index.jsp">메인으로</a>
</body></html>
