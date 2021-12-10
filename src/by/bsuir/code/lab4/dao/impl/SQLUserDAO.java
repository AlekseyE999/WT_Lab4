package by.bsuir.code.lab4.dao.impl;

import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.dao.UsersRepositoryDAO;
import by.bsuir.code.lab4.dao.impl.controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UsersRepositoryDAO {

    private final DatabaseController databaseController;

    public SQLUserDAO(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public User getAccountByLogin(String login) {
        User user = null;

        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "SELECT * FROM USERS WHERE login=?"
            );
            ps.setString(1, login);
            ResultSet result = ps.executeQuery();

            user = getNextUser(result);

        } catch (SQLException ignore) {

        }

        return user;
    }

    @Override
    public void add(User user) {
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "INSERT INTO USERS (name, login, pass_hash, role) VALUES (?, ?, ?, ?);"
            );
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassHash());
            ps.setString(4, user.getRole());
            ps.executeUpdate();

        } catch (Exception ignore) {

        }
    }

    private User getNextUser(ResultSet resultSet) throws SQLException {
        User user = null;
        if (resultSet.next()) {
            user = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return user;
    }
}
