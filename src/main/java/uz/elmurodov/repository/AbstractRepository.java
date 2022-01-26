package uz.elmurodov.repository;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.settings.Types;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public abstract class AbstractRepository {

    protected Connection connection = UNIContainer.getBean(Connection.class);
    private Object[] args;
    protected DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);
    protected Gson gson = UNIContainer.getBean(Gson.class);


    protected Long sessionUserId() {
        return SecurityHolder.authUserSession.getId();
    }

    protected Serializable callProcedure(String query, int outType) {
        try {
            CallableStatement statement = connection.prepareCall(query);
            prepareToExecute(statement);
            ResultSet resultSet = statement.executeQuery();
            return prepareResultSet(resultSet, outType);
        } catch (SQLException ex) {
            throw new CustomSQLException(ex.getMessage(), ex.getCause());
        }
    }

    protected <T> T callProcedure(String query, Class<T> clazz) {
        if (clazz.getSimpleName().equalsIgnoreCase("String"))
            return (T) callProcedure(query, Types.VARCHAR);
        if (clazz.getSimpleName().equalsIgnoreCase("Long"))
            return (T) callProcedure(query, Types.BIGINT);
        if (clazz.getSimpleName().equalsIgnoreCase("Boolean"))
            return (T) callProcedure(query, Types.BOOLEAN);
        if (clazz.getSimpleName().equalsIgnoreCase("Void"))
            return (T) callProcedure(query, Types.VOID);
        return null;
    }

    @SneakyThrows
    private Serializable prepareResultSet(ResultSet resultSet, int outType) {
        if (Objects.nonNull(resultSet) && resultSet.next()) {
            return switch (outType) {
                case Types.VARCHAR -> resultSet.getString(1);
                case Types.BIGINT -> resultSet.getLong(1);
                case Types.BOOLEAN -> resultSet.getBoolean(1);
                case Types.VOID -> -1;
                default -> throw new IllegalStateException("Unexpected value: " + outType);
            };
        }
        return null;
    }

    @SneakyThrows
    private void prepareToExecute(CallableStatement statement) {
        for (int i = 0; i < this.args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    protected void prepareArguments(Object... args) {
        this.args = args;
    }
}
