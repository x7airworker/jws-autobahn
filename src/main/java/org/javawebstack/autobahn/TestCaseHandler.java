package org.javawebstack.autobahn;

import org.javawebstack.httpclient.websocket.WebSocket;
import org.javawebstack.httpclient.websocket.WebSocketHandler;

import java.io.IOException;

public class TestCaseHandler implements WebSocketHandler {
    private int testCase;

    public TestCaseHandler(int testCase) {
        this.testCase = testCase;
    }

    public void onOpen(WebSocket socket) {
        System.out.println("[" + testCase + "] OPEN");
    }

    public void onMessage(WebSocket socket, String message) {
        try {
            socket.send(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onMessage(WebSocket socket, byte[] message) {

        try {
            socket.send(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onClose(WebSocket socket, Integer code, String reason) {
        System.out.println("[" + testCase + "] CLOSE");
    }
}
