package com.mt.tlstools.config.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteTest {
    public static void main(String[] args) throws SQLException {
        Connection con = DbUtil.getCon();
        String sql = "select * from CfgDevDacu";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);

        }
        preparedStatement.close();
        con.close();
    }
}
