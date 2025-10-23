<%@ page import="model.HotelDAO, model.Room" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
HotelDAO dao = new HotelDAO();
%>
<html><body>
<h2>호텔 예약하기</h2>
<form action="hotel" method="post">
이름: <input type="text" name="name" required><br>
객실:
<select name="roomId">
<%
for (Room r : dao.getRooms()) {
%>
<option value="<%=r.getId()%>"><%=r.getType()%> (₩<%=r.getPrice()%>)</option>
<% } %>
</select><br>
체크인: <input type="date" name="checkIn" required><br>
체크아웃: <input type="date" name="checkOut" required><br>
<input type="submit" value="예약하기">
</form>
<a href="index.jsp">메인으로</a>
</body></html>
