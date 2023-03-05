package com.wendy.basic.jdbc;

import com.wendy.utils.ConfigUtils;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/3/5 20:28
 * @Version 1.0
 */
@Slf4j
public class DBService {
    private static final String DRIVER = "datasource.driver-class-name";

    private static final String USERNAME = "datasource.username";

    private static final String PASSWORD = "datasource.password";

    private static final String URL = "datasource.url";

    private static final DBService dbService = new DBService();

    private final DataSource dataSource;

    public static DBService getInstance() {
        return dbService;
    }

    public DBService() {
        dataSource = createDateSource();
    }

    private DataSource createDateSource() {
        HikariDataSource dataSource = new HikariDataSource();
        String driver = ConfigUtils.getValue(DRIVER, "com.mysql.cj.jdbc.Driver");
        String username = ConfigUtils.getValue(USERNAME, "root");
        String password = ConfigUtils.getValue(PASSWORD, "");
        String jdbcUrl = ConfigUtils.getValue(URL, "r");

        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);

        dataSource.setConnectionTimeout(30000);
        dataSource.setMinimumIdle(5);
        dataSource.setMaximumPoolSize(100);

        String testSql = "select 1";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(testSql)) {
            statement.execute();
            log.info("Success init datasource");
        } catch (SQLException e) {
            log.error("Create datasource error");
        }
        return dataSource;
    }

    public int insert(String sql, int[] dataTypes, List<Object> params) {
        // TODO
        return 0;
    }

    public int batchInsert(String sql, int[] dataTypes, List<List<Object>> params) {
        // TODO
        return 0;
    }

    public int update(String sql, int[] dataTypes, List<Object> params) {
        // TODO
        return 0;
    }

    public <T> List<Map<String, Object>> select(String sql, int[] dataTypes, List<T> params) {
        ResultSet resultSet = null;
        List<Map<String, Object>> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i), dataTypes[i]);
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnNum = metaData.getColumnCount();

            Map<String, Object> rowData;
            while (resultSet.next()) {
                rowData = new HashMap<>();
                for (int i = 0; i < columnNum; i++) {
                    rowData.put(metaData.getColumnName(i + 1), resultSet.getObject(i + 1));
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            log.error("execute select fail, the sql is {}", sql);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.error("Close resultSet fail, because {}", e.getMessage());
                }
            }
        }
        return list;
    }
}
