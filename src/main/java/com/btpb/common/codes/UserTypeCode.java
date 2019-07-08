package com.btpb.common.codes;

import com.btpb.common.Platform;
import com.btpb.common.exceptions.BTPBException;
import com.btpb.common.exceptions.BTPBInvalidIdException;
import com.btpb.common.exceptions.DBReadException;
import com.btpb.common.exceptions.DBWriteException;

import java.sql.*;

public class UserTypeCode extends TypeCode {

    @Override
    public void load(int id) throws BTPBException {
        try (Connection connection = DriverManager.getConnection(
                Platform.getInstance().dbConnectionString);
             CallableStatement s = connection.prepareCall(
                     "{CALL BTPBGetUserType(?, ?)}"))
        {
            s.setInt("nUserTypeID", id);
            s.setNull("strKey", Types.VARCHAR);

            this.loadFromReader(s.executeQuery());
        }
        catch (Exception ex)
        {
            throw new DBReadException(ex, "ID provided: " + id);
        }
    }

    @Override
    public void load(String key) throws BTPBException
    {
        try (Connection connection = DriverManager.getConnection(
                Platform.getInstance().dbConnectionString);
             CallableStatement s = connection.prepareCall(
                     "{CALL BTPBGetUserType(?, ?)}"))
        {
            s.setNull("nUserTypeID", Types.INTEGER);
            s.setString("strKey", key);


            this.loadFromReader(s.executeQuery());
        }
        catch (Exception ex)
        {
            throw new DBReadException(ex, "Key provided: " + key);
        }
    }

    @Override
    public void save() throws BTPBException
    {
        try (Connection connection = DriverManager.getConnection(
                Platform.getInstance().dbConnectionString);
             CallableStatement s = connection.prepareCall(
                     "{CALL BTPBUpdateUserType(?, ?, ?, ?, ?)}"))
        {
            if (this.id > 0)
                s.setInt("nUserTypeID", this.id);
            else
                s.setNull("nUserTypeID", Types.INTEGER);

            s.setString("strTitle", this.title);
            s.setString("strKey", this.key);
            s.setBoolean("bActive", this.active);
            s.setInt("nOrder", this.order);


            this.loadFromReader(s.executeQuery());
        }
        catch (Exception ex)
        {
            throw new DBWriteException(ex);
        }
    }

    @Override
    public void remove() throws BTPBException
    {
        try (Connection connection = DriverManager.getConnection(
                Platform.getInstance().dbConnectionString);
             CallableStatement s = connection.prepareCall(
                     "{CALL BTPBRemoveUserType(?)}"))
        {
            if (this.id <= 0)
                throw new BTPBInvalidIdException("Zero or less-than-zero ID provided: "
                        + this.id);

            s.setInt("nUserTypeID", this.id);
            s.executeUpdate();

            // Reset the ID to zero, in case re-insertion is necessary via save()
            this.id = 0;
        }
        catch (Exception ex)
        {
            throw new DBWriteException(ex);
        }
    }

    private void loadFromReader(ResultSet set) throws DBReadException
    {
        try
        {
            this.id = set.getInt("nUserTypeId");
            this.title = set.getString("strTitle");
            this.key = set.getString("strKey");
            this.active = set.getBoolean("bActive");
            this.order = set.getInt("nOrder");
        }
        catch (SQLException ex)
        {
            throw new DBReadException(ex);
        }

    }
}
