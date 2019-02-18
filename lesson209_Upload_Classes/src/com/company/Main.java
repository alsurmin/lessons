package com.company;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Policy;

public class Main extends Policy {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, LoginException {
        System.setProperty("java.security.policy", "src/MyApp.policy");
        System.setProperty("java.security.auth.login.config", "src/jaas.config");
        System.setSecurityManager(new SecurityManager());
        //System.out.println(System.getProperty("os.name"));

        LoginContext context = new LoginContext("Login1");
        context.login();
        Subject subject = context.getSubject();
        System.out.println("user is auth");

        //Subject.doAsPrivileged(subject, action, null);
        context.logout();


    }
}
