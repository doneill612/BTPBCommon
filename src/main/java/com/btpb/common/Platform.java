package com.btpb.common;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Platform {

    private static Platform platform;

    public static Platform getInstance() throws Exception
    {
        if (platform == null)
        {
            try
            {
                platform = new Platform();
            }
            catch (Exception ex)
            {
                throw ex;
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
