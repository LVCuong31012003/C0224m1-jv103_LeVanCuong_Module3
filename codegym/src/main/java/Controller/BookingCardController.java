package Controller;

import Model.BookingCard;
import Model.BookingCardIteam;
import Model.Student;
import Services.IStudentService;
import Services.StudentService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookingCardController", value = "/BookingCardController")
public class BookingCardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingCard bookingcard;
        HttpSession session = request.getSession();
        bookingcard = (BookingCard) session.getAttribute("card");
        if(bookingcard==null){
            bookingcard = new BookingCard();
        }
        session.setAttribute("card",bookingcard);

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BookingCard bookingCard = (BookingCard) session.getAttribute("card");
        String action =  request.getParameter("action");
        switch (action){
            case "get":
                request.getRequestDispatcher("/Card.jsp").forward(request,response);
                break;
            case "delete":
                doDelete(request,response);
                break;
            case "put":
                doPut(request,response);
                break;
            case "post":
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = StudentService.findById(id);
                BookingCardIteam bookingCarditeam = new BookingCardIteam(student,1);
                bookingCard.Add(bookingCarditeam);
                session.setAttribute("card",bookingCard);
                response.sendRedirect("ProductController");
                break;
            default:
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        BookingCard bookingCard = (BookingCard) session.getAttribute("cart");
        int id = Integer.parseInt(req.getParameter("id"));
        int quanlity  =  Integer.parseInt(req.getParameter("quanlity"));
        String e ="";
        if(quanlity>0){
            bookingCard.update(id,quanlity);
        }
        else{
            e="So luong phai lon hon 0";
        }
        req.setAttribute("error",e);
        session.setAttribute("card",bookingCard);
        req.getRequestDispatcher("ShopingCartCL?action=get").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}