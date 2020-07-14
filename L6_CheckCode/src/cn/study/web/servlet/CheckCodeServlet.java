package cn.study.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Harlan
 * @date 2020/7/14 18:08
 */
@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("image/jpg;charset=utf-8");

        //1.创建一个对象，在内存中的图片(验证码对象)
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0, width, height);

        //2.2化边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0, width-1, height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            //2.3写验证码
            g.drawString(ch+"",width/5*i, height/2);
        }
        //2.4干扰线
        g.setColor(Color.CYAN);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width-1);
            int x2 = random.nextInt(width-1);
            int y1 = random.nextInt(width-1);
            int y2 = random.nextInt(width-1);
            g.drawLine(x1, y1, x2, y2);
        }

        //3.将图片输出到页面
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
