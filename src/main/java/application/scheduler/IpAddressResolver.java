package application.scheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

class IpAddressResolver {

    static String getIpAddress() throws IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));
        System.out.println("Obtaining IP Address");
        String ip = in.readLine();
        return "http://" + ip + ":8080/";
    }
}
