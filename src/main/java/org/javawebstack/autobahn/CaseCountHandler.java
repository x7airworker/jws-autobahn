package org.javawebstack.autobahn;

import org.javawebstack.httpclient.websocket.WebSocket;
import org.javawebstack.httpclient.websocket.WebSocketHandler;

import java.util.function.Consumer;

public class CaseCountHandler implements WebSocketHandler {
    private Consumer<Integer> then;

    public CaseCountHandler(Consumer<Integer> then) {
        this.then = then;
    }

    public void onOpen(WebSocket socket) {}

    public void onMessage(WebSocket socket, String message) {
        then.accept(Integer.decode(message));
        socket.close(1000, "");
    }

    public void onMessage(WebSocket socket, byte[] message) {}

    public void onClose(WebSocket socket, Integer code, String reason) {}
}
