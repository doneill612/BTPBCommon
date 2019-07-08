package com.btpb.common;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.btpb.common.exceptions.DBReadException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Platform} contains a singleton accessor
 * to the AWS RDS context. Methods are exposed to
 * transact against the database.
 */
public class Platform {

    private static Platform platform;

    /**
     * Retrieve the platform singleton.
     * @return the platform database context
     * @throws Exception if the database context cannot be established.
     * If an Exception is thrown, this indicates that the database
     * connection string could not be properly retrieved from Secrets Manager.
     */
    public static Platform getInstance() throws DBReadException
    {
        if (platform == null)
        {
            try
            {
                platform = new Platform();
            }
            catch (Exception ex)
            {
                throw new DBReadException(ex);
            }
        }
        return platform;
    }

    public final String dbConnectionString;

    private Platform() throws Exception
    {
        dbConnectionString = retrieveDBConnectionString();
    }

    private String retrieveDBConnectionString() throws Exception
    {
        try
        {
            final String secretName = "BTPB_DBConnectionInfo";

            AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().build();
            GetSecretValueRequest request = new GetSecretValueRequest()
                    .withSecretId(secretName);

            GetSecretValueResult result = client.getSecretValue(request);

            final ObjectMapper mapper = new ObjectMapper();

            @SuppressWarnings("unchecked")
            Map<String, String> secrets = mapper.readValue(result.getSecretString(), HashMap.class);

            return String.format("Data Source=%1$s; " +
                            "initial catalog = %2$s; persist security info=False; " +
                            "user id=%3$s; password=%4$s;",
                    secrets.get("DataSource"), secrets.get("InitialCatalog"),
                    secrets.get("User"), secrets.get("Password"));
        }
        catch (ResourceNotFoundException | InvalidRequestException | InvalidParameterException | IOException ex)
        {
            throw ex;
        }

    }

}
