package com.alan.feeder;

import com.Upwork.api.Config;
import com.Upwork.api.OAuthClient;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by aleh_bahatyrou on 12/9/16.
 */
public class UpworkApplication {

    public static void main(String args[]){
        Properties keys = new Properties();
        keys.setProperty("consumerKey", args[0]);
        keys.setProperty("consumerSecret", args[1]);
        Config config = new Config(keys);
        OAuthClient client = new OAuthClient(config);
        String authzUrl = client.getAuthorizationUrl();

        Scanner scanner = new Scanner(System.in);

        System.out.println(authzUrl);
        System.out.println("1. Copy paste the following url in your browser : ");
        System.out.println(authzUrl);
        System.out.println("2. Grant access ");
        System.out.println("3. Copy paste the oauth_verifier parameter here :");

        String oauth_verifier = scanner.nextLine();
        scanner.close();

        String verifier = null;
        try {
            verifier = URLDecoder.decode(oauth_verifier, "UTF-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, String> token = client.getAccessTokenSet(verifier);
        System.out.println(token);
    }
}
