package com.yanfuchang.jacoco.helloworld;


import com.alibaba.fastjson.JSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试jacoco
 */
@WebServlet("/helloworld")
public class HelloWorld extends HttpServlet {

    private String message;

    @Override
    public void init() {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置相应内容类型
        resp.setContentType("text/json;charset=utf-8");
        // 实例化输出流对象
        PrintWriter out = resp.getWriter();
        Map<String, Object> resultMap = new HashMap<>();

        String data = req.getParameter("data");
        if ("daling".equals(data)) {
            resultMap.put("data", "daling");
        }else if ("dalingjia".equals(data)){
            resultMap.put("data", "dalingjia");
        }else {
            resultMap.put("data", "helloworld");
        }
        out.println(JSON.toJSONString(resultMap));
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
