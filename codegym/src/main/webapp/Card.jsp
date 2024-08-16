<%@ page import="Model.BookingCardIteam" %>
<%@ page import="Model.BookingCard" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: levancuong
  Date: 16/8/24
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sach</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<body>

<%
    BookingCard bookingCard = (BookingCard) session.getAttribute("cart");
    if(bookingCard==null){
        response.sendRedirect("ProductController");
    }
    List<BookingCardIteam> bookingCardIteamList = bookingCard.getCartItemList();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    String e = request.getAttribute("error")==null?"":(String) request.getAttribute("error");


%>

<div class="container">
    <h3>Giỏ hàng của tôi</h3>
    <a href="StudentList.jsp">Tiếp tục mua hàng</a>
    <p class="text-danger"><%=e%></p>
</div>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên</th>
            <th scope="col">Giá</th>
            <th scope="col">Hình ảnh</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Thành tiền</th>
            <th scope="col">Chức năng</th>
        </tr>
        </thead>
        <tbody>
            <%
            int count = 0;
            for (BookingCardIteam bookingCardIteam : bookingCardIteamList) {
        %>
        <tr>
            <td><%=count++%></td>
            <td><%=bookingCardIteam.getStudent().getLast_name()%></td>
            <td><%=bookingCardIteam.getStudent().getPrice()%></td>
            <td><img src="<%=bookingCardIteam.getStudent().getThumb()%>" alt=""></td>
            <td><%=bookingCardIteam.getQuanlity()%></td>
            <td><%=numberFormat.format(bookingCardIteam.getTotalPrice())%></td>
            <td>
                <form action="BookingCardController" method="get">
                    <input type="number" name="quanlity" value="<%=bookingCardIteam.getQuanlity()%>">
                    <input type="hidden" name="action" value="put">
                    <input type="hidden" name="id" value="<%=bookingCardIteam.getStudent().getStudent_id()%>">
                    <button type="submit" class="btn btn-success btn-sm">Cập nhập</button>
                </form>

                <form action="BookingCardController"  method="get" >
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%=bookingCardIteam.getStudent().getStudent_id()%>">
                    <button type="submit" class="btn btn-danger btn-sm">Xoá</button>
                </form>

            </td>
        </tr>

            <% }%>
        </tbody>
    </table>
    <h3>Tổng giá của giỏ hàng là: <%=bookingCard.getCartItemList()%></h3>
</div>

</body>
</html>
