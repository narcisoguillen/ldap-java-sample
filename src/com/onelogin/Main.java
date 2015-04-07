package com.onelogin;
import us.monoid.web.AbstractContent;
import us.monoid.web.JSONResource;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        Api api = new Api("");

        //System.out.println("OneLogin User List:" + api.getUsers());
        // System.out.println("USER 14564372:" + api.getUser(ID));

        try{
            JSONResource ldap = api.ldap("", "");
            System.out.println(ldap.get("status"));
        }catch( IOException e){
            System.out.println(e.getMessage());
        }


    }

}