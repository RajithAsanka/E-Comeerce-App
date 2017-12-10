package com.imperia.core;

import com.imperia.CategoryResourceClient;
import com.imperia.UserResourceClient;
import com.imperia.impl.CategoryResourceClientImpl;
import com.imperia.impl.UserResourceClientImpl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author Kithmal
 */
public class ResourceClientProxyPool {

    private static ResourceClientProxyPool instance = null;

    protected String targetBaseServiceURL = null;

    private UserResourceClient userResourceClient;

    private CategoryResourceClient categoryResourceClient;

    protected ResourceClientProxyPool(final String targetBaseServiceURL) {
        this.targetBaseServiceURL = targetBaseServiceURL;
    }

    public static String getWSPath() throws IOException {
        Properties prop = new Properties();
        URL url = ResourceClientProxyPool.class.getResource("/client-service-properties");
        InputStream strm;
        strm = url.openStream();
        prop.load(strm);
        String coreWsPath = prop.getProperty("core.app.deploy.service");
        return coreWsPath;
    }

    public static ResourceClientProxyPool getInstance() {

        if (instance == null) {
            try {

                String coreWsPath = getWSPath();
                instance = new ResourceClientProxyPool(coreWsPath);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return instance;
    }

    public UserResourceClient getUserResourceClient() {
        if (userResourceClient == null) {
            userResourceClient = new UserResourceClientImpl(this.targetBaseServiceURL + "/user-mgt");
        }
        return userResourceClient;
    }

    public CategoryResourceClient getCategoryResourceClient() {
        if (categoryResourceClient == null) {
            categoryResourceClient = new CategoryResourceClientImpl(this.targetBaseServiceURL + "/user-mgt");
        }
        return categoryResourceClient;
    }
}
