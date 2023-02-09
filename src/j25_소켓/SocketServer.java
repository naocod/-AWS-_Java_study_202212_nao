package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
	
	public static final int PORT = 9090;
	
	public static void main(String[] args) {
		List<Socket> clients = new ArrayList<>();
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("클라이언트의 접속을 기다리는 중입니다.");
				Socket socket = serverSocket.accept();
				clients.add(socket);
				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter out = new PrintWriter(outputStream, true);
				out.println("___서버에 접속한 것을 환영합니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}








