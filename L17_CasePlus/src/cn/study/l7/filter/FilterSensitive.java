package cn.study.l7.filter; /**
 * @author Harlan
 * @date 2020/7/19 20:17
 */


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "FilterSensitive", urlPatterns = "/*")
public class FilterSensitive implements Filter {

    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig config) throws ServletException {

        try {
            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            //2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            //3.将文件的每一行添加到list
            String line = null;
            while ((line = br.readLine()) != null){
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象,增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equals(method.getName())){
                    //增强返回值
                    String str = (String) method.invoke(req, args);
                    if (str != null){
                        for (String s : list) {
                            if (str.contains(s)){
                                str = str.replaceAll(str, "***");
                            }
                        }
                        return str;
                    }
                }else {
                    return method.invoke(req, args);
                }
                return null;
            }
        });

        //2.放行
        chain.doFilter(proxy_req, resp);
    }

    @Override
    public void destroy() {

    }
}
