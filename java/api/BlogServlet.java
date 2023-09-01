package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: api.BlogServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/3 16:43
 * Version 1.0
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 尝试获取一下 queryString 中的 blogId 字段
        BlogDao blogDao = new BlogDao();
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            List<Blog> blogs = blogDao.selectAll();
            // 需要把 blogs 转成符合要求的 json 格式字符串
            String respJson = objectMapper.writeValueAsString(blogs);
            resp.setContentType("application/json; charset=utf8");
            resp.getWriter().write(respJson);
        } else {
            // queryString 存在，说， 本次请求获取的是指定 id 的博客
            Blog blog = blogDao.selectById(Integer.parseInt(blogId));
            if (blog == null) {
                System.out.println("当前 blogId = " + blogId + "对应的博客不存在！");
            }
            String respJson = objectMapper.writeValueAsString(blog);
            resp.setContentType("application/json; charset=utf8");
            resp.getWriter().write(respJson);
        }
    }
}
