package org.javawebstack.autobahn;

import org.javawebstack.httpclient.HTTPClient;
import org.javawebstack.httpclient.websocket.WebSocket;
import org.javawebstack.httpclient.websocket.WebSocketHandler;

import java.io.IOException;

public class Bootstrap {
    private static final String AGENT = "JavaWebStack";

    public static void main(String[] args) {
        HTTPClient client = new HTTPClient();

        CaseCountHandler caseCountHandler = new CaseCountHandler(caseCount -> {
            System.out.println("Running " + caseCount + " test cases!");

            for (int i = 1; i < caseCount; i++) {
                try {
                    client.webSocket("http://127.0.0.1:9001/runCase?case=" + i + "&agent=" + AGENT, new TestCaseHandler(i));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                client.webSocket("http://127.0.0.1:9001/updateReports?agent=" + AGENT, new TestCaseHandler(Integer.MAX_VALUE));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            client.webSocket("http://127.0.0.1:9001/getCaseCount", caseCountHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }
}
