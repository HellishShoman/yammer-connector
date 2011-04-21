/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */
package org.mule.yammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class YammerTestCase extends Assert {
    @Test
    public void testGetMessages() throws Exception {
        YammerConnector connector = new YammerConnector();
        connector.setConsumerKey("itUVrWHnCdv0QMntF9ovw");
        connector.setConsumerSecret("JgPo2npkc6uPXhHWY0JVtPsEs5NEyLssqRt0jLtULM");
        
        connector.setToken("gAvX8IjnpPzJvVM3hcWA");
        connector.setSecret("zNhgCAU1gkgLTwzWmRczfkFEbf1HwCD54bfJ2hgc");
        
        connector.setDebug(true);
        connector.initialize();

        // If you don't have a token/secret, uncomment out these lines. The connector
        // will print out a URL where you can go to and then set the verifier code here
        // String url = connector.requestAuthorization();
        // System.out.println("Please go to " + url + " to get an access code.");
        // String oauthVerifier = getOauthVerifierFromSystemIn();
        // connector.setOauthVerifier(oauthVerifier);

        List<Message> messages = connector.getMessages();
        assertTrue(messages.size() > 0);
        
        messages = connector.getSentMessages();
        assertTrue(messages.size() > 0);
        
        messages = connector.getPrivateMessages();
//        assertTrue(messages.size() > 0);
        
        messages = connector.getFollowingMessages();
        assertTrue(messages.size() > 0);
        System.out.println(messages);
    }

    protected String getOauthVerifierFromSystemIn() {
        System.out.print("Enter your oauth access token: ");

        // open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String oauthVerifier = null;

        try {
            oauthVerifier = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        return oauthVerifier;
    }
}
