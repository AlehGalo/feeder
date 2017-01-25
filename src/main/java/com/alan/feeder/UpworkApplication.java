package com.alan.feeder;

import com.Upwork.api.Config;
import com.Upwork.api.OAuthClient;
import org.apache.commons.lang3.ArrayUtils;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by aleh on 12/9/16.
 */
public final class UpworkApplication {

    public static void main(String args[]) {
        if (ArrayUtils.getLength(args) >= 2) {
            Properties keys = new Properties();
            keys.setProperty("consumerKey", args[0]);
            keys.setProperty("consumerSecret", args[1]);
            Config config = new Config(keys);
            OAuthClient client = new OAuthClient(config);
            String authzUrl = client.getAuthorizationUrl();

            Scanner scanner = new Scanner(System.in);

            println(authzUrl);
            println("1. Copy paste the following url in your browser : ");
            println(authzUrl);
            println("2. Grant access ");
            println("3. Copy paste the oauth_verifier parameter here :");

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
            println("Token: " + token);
            println("consumerKey: " + args[0]);
            println("consumerSecret " + args[1]);
            println("oauth_verifier " + oauth_verifier);
        }
        else {
            println(">> Set input parameters [consumerKey], [consumerSecret]");
        }
    }

    private static void println(String text) {
        System.out.println(text);
    }
}
