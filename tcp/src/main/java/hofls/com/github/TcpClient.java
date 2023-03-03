package hofls.com.github;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

    private String EOL = System.lineSeparator();

    public void sendRequests() throws Exception {
        Socket socket = new Socket("localhost", 63370);
        System.out.println("Client. Connected to server.");

        OutputStream out = socket.getOutputStream();
        sendRequest("First message", out);
        sendRequest("Last message", out);
        System.out.println("Client. Requests sent.");

        socket.close();
        System.out.println("Client. Disconnected from server.");

    }

    private void sendRequest(String text, OutputStream out) throws IOException {
        String message = text + System.lineSeparator();
        out.write(message.getBytes());
    }

}
