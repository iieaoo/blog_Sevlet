package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * ClassName: model.Blog
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/3 0:03
 * Version 1.0
 */
public class Blog {
    private int blogId;
    private String title;
    private  String content;
    private Timestamp  postTime;
    private int userId;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTimestamp() {
        return postTime;
    }

    public String getPostTime() {
        // 把时间戳转成 格式化 时间。
        // 这个方法不用背，搜索一下
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(postTime);
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
