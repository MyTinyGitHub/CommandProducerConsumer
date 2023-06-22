package main.database;

import main.dao.User;
import main.dao.UserConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UsersTable implements ITable {

    public UsersTable() {
    }

    public void deleteTable() {
        Connection connection = Database.getInstance().getConnection();

        try(Statement st = connection.createStatement()) {
            st.execute("drop table USERS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        Connection connection = Database.getInstance().getConnection();

        try(Statement st = connection.createStatement()) {
            deleteTable();

            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE USERS");
            sb.append("( ");
            sb.append(UserConstants.USER_ID + " " + UserConstants.USER_ID_TYPE);
            sb.append(", " + UserConstants.USER_GUID + " " + UserConstants.USER_GUID_TYPE);
            sb.append(", " + UserConstants.USER_NAME + " " + UserConstants.USER_NAME_TYPE);
            sb.append(");");

            st.execute(sb.toString());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> getAll() {
        Connection connection = Database.getInstance().getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(UserConstants.USER_ID);
        sb.append(", " + UserConstants.USER_GUID);
        sb.append(", " + UserConstants.USER_NAME);
        sb.append(" FROM USERS");

        List<Object> users = new LinkedList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sb.toString());

            while(rs.next()) {
                int id = rs.getInt(UserConstants.USER_ID);
                String guid = rs.getString(UserConstants.USER_GUID);
                String name = rs.getString(UserConstants.USER_NAME);

                users.add(new User(id, guid, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void insert(Object object) {
        Connection connection = Database.getInstance().getConnection();

        if(!(object instanceof User)) {
            return;
        }

        User user = ((User) object);

        try(Statement st = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO USERS ");
            sb.append("( ");
            sb.append(UserConstants.USER_ID);
            sb.append(" ," + UserConstants.USER_GUID);
            sb.append(" ," + UserConstants.USER_NAME);
            sb.append(") ");
            sb.append("VALUES ");
            sb.append("( ");
            sb.append(user.getId());
            sb.append(",'" + user.getGuid() + "'");
            sb.append(",'" + user.getName() + "'");
            sb.append(");");

            st.execute(sb.toString());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        Connection connection = Database.getInstance().getConnection();
        try(Statement st = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE USERS");
             st.execute(sb.toString());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
