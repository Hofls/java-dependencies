package hofls.com.github;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TcpClientTest {

    private int serversCount = 1;
    private CountDownLatch startCountdown = new CountDownLatch(serversCount);
    private CountDownLatch endCountdown = new CountDownLatch(serversCount);
    private List<String> actualMessages = new ArrayList<>();

    @Test
    void sendRequests() throws Exception {
        new Thread(() -> startServer(63370)).start();
        startCountdown.await(); // run client after server starts

        new TcpClient().sendRequests();
        endCountdown.await(); // execute asserts after server processes all requests

        assertEquals("First message", actualMessages.get(0));
        assertEquals("Last message", actualMessages.get(1));
    }

    private void startServer(int port) throws RuntimeException {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            startCountdown.countDown();
            System.out.println("Server. Listening on port " + port);

            Socket clientSocket = serverSocket.accept();
            clientSocket.setSoTimeout(2000);
            System.out.println("Server. Received connection from " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                try {
                    String line = in.readLine();
                    if (line == null) break;
                    actualMessages.add(line);
                    System.out.println("Server. Received request: " + line);
                } catch (SocketTimeoutException e) {
                    break;
                }
            }

            clientSocket.close();
            endCountdown.countDown();
            System.out.println("Server. Client disconnected.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
