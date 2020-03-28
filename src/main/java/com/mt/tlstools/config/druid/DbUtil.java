package com.mt.tlstools.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static DruidDataSource druidDataSource = null;
    static {
        Properties prop = new Properties();

        try {
            prop.load(new ClassPathResource("druid.properties").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = prop.getProperty("driver");

//声明DruidDataSource

        druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(driver);


        Resource resource = new ClassPathResource("db/mtload.mt3");
        URL url = null;
        try {
            url = resource.getURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
        druidDataSource.setUrl("jdbc:sqlite:"+url.toString().substring(url.toString().indexOf("/")+1));


    }


    public static Connection getCon() throws SQLException {
        DruidPooledConnection connection = druidDataSource.getConnection();
        return connection;
    }

    public static void closeConn(Connection connection) throws SQLException {
        if(connection instanceof DruidPooledConnection ){
            ((DruidPooledConnection)connection).close();
        }
    }
}
