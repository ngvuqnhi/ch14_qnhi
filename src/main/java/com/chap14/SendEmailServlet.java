package com.chap14;

import com.chap14.MailUtil.*;
import jakarta.mail.MessagingException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("email");

        // Nội dung mail mẫu
        String subject = "Chào cô đến với trang web của iem!";
        String body = "<h2>Hello!</h2>"
                + "<p>Thử nghiệm gửi email bằng JavaMail.</p>"
                + "<p>Chúc cô ngày mới vui vẻ!</p>";

        try {
            MailUtil.sendMail(to, subject, body);
            // Truyền nội dung mail lên JSP để hiển thị
            request.setAttribute("email", to);
            request.setAttribute("subject", subject);
            request.setAttribute("body", body);
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (MessagingException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi gửi email: " + e.getMessage());
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
}
