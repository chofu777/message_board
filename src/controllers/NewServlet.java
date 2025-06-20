package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //    /**
    //     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    //     */
    //    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //            throws ServletException, IOException {
    //        EntityManager em = DBUtil.createEntityManager();
    //        em.getTransaction().begin();
    //
    //        // Messageのインスタンスを生成
    //        Message m = new Message();
    //
    //        //mの各フィールドにデータを代入
    //        String title = "taro";
    //        m.setTitle(title);
    //
    //        String content = "hello";
    //        m.setContent(content);
    //
    //        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
    //        m.setCreated_at(currentTime);
    //        m.setUpdated_at(currentTime);
    //
    //        // データベースに保存
    //        em.persist(m);
    //        em.getTransaction().commit();
    //
    //        // 自動裁判されたIDの値を表示
    //        response.getWriter().append(Integer.valueOf(m.getId()).toString());
    //
    //        em.close();
    //    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // CSRF対策
        request.setAttribute("_token", request.getSession().getId());

        // おまじないとしてのインスタンスを生成
        request.setAttribute("message", new Message());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
        rd.forward(request, response);
    }

}
