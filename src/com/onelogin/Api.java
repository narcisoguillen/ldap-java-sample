package com.onelogin;

import us.monoid.web.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by narcisoguillen on 4/2/15.
 */

public class Api {
    static String api_key;
    static Resty  resty;

    public static final String host          = "https://app.onelogin.com";
    public static final String USER_ENDPOINT = "/api/v2/users";  // URL : https://onelogin.zendesk.com/hc/en-us/articles/201175524-Users-API

    Api(String key){
        api_key   = key;
        resty     = new Resty();
    }

    // Get a User by ID
    public static XMLResource getUser(int id) throws IOException{
        boolean custom_attrs = true;
        String  endpoint     = String.format("%s%s/%d.xml?api_key=%s&include_custom_attributes=%b", host, USER_ENDPOINT, id, api_key, custom_attrs);

        return resty.xml(endpoint);
    }

    // GET list of all Users
    public static XMLResource getUsers() throws IOException {
        int     form_id      = 0;
        boolean custom_attrs = true;
        String  endpoint     = String.format("%s%s.xml?api_key=%s&from_id=%d&include_custom_attributes=%b", host, USER_ENDPOINT, api_key, form_id, custom_attrs);

        return resty.xml(endpoint);
    }

    public static JSONResource ldap(String dn, String password) throws IOException{
        String d_name = URLEncoder.encode(dn, java.nio.charset.StandardCharsets.UTF_8.toString());
        String endpoint = String.format("http://localhost:3000/api/v3/users/dn_auth?dn=%s&api_key=%s&password=%s", d_name, api_key, password);
        return resty.json(endpoint);
    }
}
