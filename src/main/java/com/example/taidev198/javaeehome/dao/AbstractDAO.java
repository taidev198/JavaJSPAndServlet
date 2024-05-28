package com.example.taidev198.javaeehome.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

        public Connection getConnection() {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/taidev198";
                        String username = "root";
                        String password = "root";
                        return DriverManager.getConnection(url, username, password);

                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
        }

        @Override
        public <T1> List<T1> query(String sql, RowMapper<T1> rowMapper, Object... parameters) {
                List<T1> results = new ArrayList<>();
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
                        connection = getConnection();
                        preparedStatement = connection.prepareStatement(sql);
                        setParameter(preparedStatement, parameters);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                                results.add(rowMapper.mapRow(resultSet, resultSet.getRow()));
                        }
                        return results;
                } catch (SQLException e) {
                    return null;
                }
                finally {
                        try {
                                if (connection != null) {
                                        connection.close();
                                }
                                if (preparedStatement != null) {
                                        preparedStatement.close();
                                }
                        } catch (SQLException e) {
                            return null;
                        }
                }

        }

        private void setParameter(PreparedStatement preparedStatement, Object[] parameters) {
                try {
                        for (int i = 0; i < parameters.length; i++) {
                                Object parameter = parameters[i];
                                int index = i + 1;
                                if (parameter instanceof Long) {
                                        preparedStatement.setLong(index, (Long)parameter);
                                }
                               else if (parameter instanceof String) {
                                        preparedStatement.setString(index, (String)parameter);
                                }
                               else if (parameter instanceof Integer) {
                                       preparedStatement.setInt(index, (Integer)parameter);
                                }
                               else if (parameter instanceof Timestamp) {
                                       preparedStatement.setTimestamp(index, (Timestamp)parameter);
                                }
                                else if (parameter instanceof Integer) {
                                        preparedStatement.setInt(index, (Integer)parameter);
                                }
                        }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


        }

        @Override
        public void update(String sql, Object... parameters) {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                try {
                        connection = getConnection();//init connection
                        connection.setAutoCommit(false);
                        preparedStatement = connection.prepareStatement(sql);//preparing to execute statement
                        setParameter(preparedStatement, parameters);//set parameters to statement
                        preparedStatement.executeUpdate();//execute update method
                        connection.commit();//close execute statement update

                } catch (SQLException e) {
                        if (connection != null) {
                                try {
                                        connection.rollback();//call back again
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                        }

                }
                finally {
                        try {
                                if (connection != null) {
                                        connection.close();//close connection
                                }
                                if (preparedStatement != null) {
                                        preparedStatement.close();
                                }
                        } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                        }
                }


        }

        @Override
        public Long insert(String sql, Object... parameters) {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
                        Long id = null;
                        connection = getConnection();//init connection
                        connection.setAutoCommit(false);
                        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//preparing to execute statement
                        setParameter(preparedStatement, parameters);//set parameters to statement
                        preparedStatement.executeUpdate();//execute update method
                        resultSet = preparedStatement.getGeneratedKeys();
                        if (resultSet.next()) {
                                id = resultSet.getLong(1);
                        }
                         connection.commit();//close execute statement update
                        return id;
                } catch (SQLException e) {
                        return null;

                }
                finally {
                        try {
                                if (connection != null) {
                                        connection.close();//close connection
                                }
                                if (preparedStatement != null) {
                                        preparedStatement.close();
                                }
                        } catch (SQLException ex) {
                                return null;
                        }
                }
        }

        @Override
        public void delete(String sql, Object... parameters) {

        }

        @Override
        public int count(String sql, Object... parameters) {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
                        int count = 0;
                        connection = getConnection();
                        preparedStatement = connection.prepareStatement(sql);
                        setParameter(preparedStatement, parameters);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                                count = resultSet.getInt(1);//first cell because the statement count (*) from database
                        }
                        return count;
                } catch (SQLException e) {
                        return 0;
                }
                finally {
                        try {
                                if (connection != null) {
                                        connection.close();
                                }
                                if (preparedStatement != null) {
                                        preparedStatement.close();
                                }
                        } catch (SQLException e) {
                                return 0;
                        }
                }

        }
}
