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
 * 验证码生成
 * @author Harlan
 * @date 2020/7/16 14:41
 */
@WebServlet(name = "/CheckCodeServlet", urlPatterns = ("/checkCode"))
public class CheckCodeServlet extends HttpServlet {


    /**
     * 设置验证码图片宽度
     * 设置验证码图片高度
     * 设置验证码长度
     * 干扰线的数目
     */
    private static final int WIDTH = 100;
    private static final int HEIGHT = 30;
    private static final int LENGTH = 4;
    public static final int LINECOUNT=20;

    /**
     * 验证码的字符库
     */
    private static final String str="0123456789"+
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
            "abcdefghijklmnopqrstuvwxyz";

    /**
     * 通过随机数取字符库中的字符组合成4位验证码
     */
    private static final Random random=new Random();

    public  Color getColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    //获取字体样式
    public Font getFont() {
        return new Font("Fixedsys", Font.BOLD, 20);
    }

    //绘制字符
    public String drawChar(Graphics g){
        String code="";
        g.setFont(getFont());
        for (int i=0;i<LENGTH;i++){
            char c=str.charAt(random.nextInt(str.length()));
            g.setColor(getColor());
            g.drawString(c+"", 20* i + 10, 20);
            code=code+c;
        }
        return code;
    }

    //绘制随机线
    public  void drawLine(Graphics g) {
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.setColor(getColor());
        g.drawLine(x, y, x + xl, y + yl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容格式
        resp.setContentType("image/jpeg");

        //设置不进行缓存
        resp.setHeader("pragma", "no-cache");
        resp.setHeader("cache-control", "no-cache");
        resp.setHeader("expires", "0");

        //获取画笔
        BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g=image.getGraphics();

        //设置背景颜色并绘制矩形背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //验证码的绘制
        String code=drawChar(g);
        System.out.println("验证码:"+code);


        //随机线的绘制
        for (int i=0;i<LINECOUNT;i++){
            drawLine(g);
        }

        //在session中存入当前的code码，便于验证
        req.getSession().setAttribute("code",code);

        //绘制图片
        g.dispose();

        //将图片输出到response中
        ImageIO.write(image, "JPEG", resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
