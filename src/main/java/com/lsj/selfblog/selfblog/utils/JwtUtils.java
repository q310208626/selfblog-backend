package com.lsj.selfblog.selfblog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.lsj.selfblog.selfblog.bean.BlogUser;
import com.lsj.selfblog.selfblog.bean.role.BlogRole;

public class JwtUtils {

    public static String FLG_USER_TOKEN = "usertoken";

    private static String JWT_CONFIG_FILE = "classpath:jwtconfig.properties";

    private static String CONFIG_JWT_KEYSTORE_PATH = "jwt.keystore.path";

    private static String CONFIG_JWT_KEYSTORE_PASSWORD = "jwt.keystore.password";

    private static String CONFIG_JWT_ALIAS = "jwt.keystore.alias";

    private static String CONFIG_JWT_ALIAS_DEFAULT = "jwt";

    private static String keystorePath;

    private static String keystorePassword;

    private static KeyStore keyStore;

    private static String jwtAlias;

    static {

        File jwtConfigFile;
        try {
            jwtConfigFile = ResourceUtils.getFile(JWT_CONFIG_FILE);

            try (FileInputStream fileInputStream = new FileInputStream(jwtConfigFile)) {
                Properties jwtProperties = new Properties();
                jwtProperties.load(fileInputStream);
                keystorePath = jwtProperties.getProperty(CONFIG_JWT_KEYSTORE_PATH);
                keystorePassword = jwtProperties.getProperty(CONFIG_JWT_KEYSTORE_PASSWORD);
                jwtAlias = jwtProperties.getProperty(CONFIG_JWT_ALIAS, CONFIG_JWT_ALIAS_DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileInputStream storeInputStream = new FileInputStream(ResourceUtils.getFile(keystorePath))) {
                keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(storeInputStream, keystorePassword == null ? null : keystorePassword.toCharArray());
                System.out.println(keyStore);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String createToken(BlogUser blogUser) {
        if (null == blogUser) {
            return null;
        }

        if (keyStore == null) {
            return null;
        }

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, 30);

        String jwtToken = null;
        try {
            jwtToken = JWT.create().withClaim("username", blogUser.getUsername())
                    .withArrayClaim("role",
                            blogUser.getRoles().stream().map(role -> role.getRole().getValue())
                                    .collect(Collectors.toList()).toArray(new String[0]))
                    .withExpiresAt(calendar.getTime())
                    .sign(Algorithm.HMAC256(keyStore.getKey(jwtAlias, keystorePassword.toCharArray()).getEncoded()));
        } catch (UnrecoverableKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JWTCreationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (KeyStoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jwtToken;
    }

}
