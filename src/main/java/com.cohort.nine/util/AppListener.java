package com.cohort.nine.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Connection conn = DbUtil.getInstance().getDataSource().getConnection();

            ServletContext sc = sce.getServletContext();
            sc.setAttribute("sqlcon", conn);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        if (servletContext.getAttribute("sqlcon")!=null){
            Connection connection= (Connection) servletContext.getAttribute("sqlcon");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
