package cn.study.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Harlan
 * @date 2020/7/15 8:33
 */
@WebServlet("/download")
public class ServletDownload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String filename = req.getParameter("filename");
        resp.setHeader("content-type", this.getServletContext().getMimeType(filename));
        resp.setHeader("content-disposition","attachment;filename="+filename);

        File file = new File(this.getServletContext().getRealPath("/img/"+filename));
        ServletOutputStream sos = resp.getOutputStream();
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[1024 * 1];
        int len = -1;
        while ((len = fis.read(data)) != -1){
            sos.write(data, 0, len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
