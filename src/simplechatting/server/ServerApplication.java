package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this); // 생성된 자기 자신을 List에 담음
	}
	
	@Override
	public void run() {
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true); // PrintWriter 활성화 
			out.println("join");
			
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			username = in.readLine();
			System.out.println(username + "님이 접속하였습니다."); // 서버의 console창에 띄움
			
//			SocketOption<String> usernameOption = new SocketOption<String>() {
//				
//				@Override
//				public Class<String> type() {
//					return String.class;
//				}
//				
//				@Override
//				public String name() {
//					return username;
//				}
//			};
//			
//			socket.setOption(usernameOption, username);
			
			String userListStr = "";
			
			for(int i = 0; i < socketList.size(); i++) {
				userListStr += socketList.get(i).getUsername();
				if(i < socketList.size() - 1) { // 마지막 인덱스가 i가 아닐때 까지, 찍음
					userListStr += ",";
				}
			}
			
			for(ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream(); // 소켓의 outputStream을 가져옴
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다."); // 클라이언트에게 다시 돌려줌
				out.println("@userList/" + userListStr);
			}
			
			while(true) {
				String message =  in.readLine(); // 서버가 종료되지 않도록 클라이언트가 들어올 때까지 계속 기다림
				for(ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();// 소켓의 outputStream을 가져옴
					out = new PrintWriter(outputStream, true);
					out.println(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

public class ServerApplication {
	
	public static void main(String[] args) {
		// 서버랑 클라이언트 1:1로 주고받기
		ServerSocket serverSocket = null; // try안에 지역변수로 있으면 finally에서 못쓰니까 밖으로 뺌
		
		try {
			serverSocket = new ServerSocket(9090); // 이 port를 다른사람이 쓰고있으면 못열기 때문에 예외가 일어남
			System.out.println("=====<<< 서버 실행 >>>=====");
			// 127.0.0.1을 넣는 이유는 
			// 서버는 자기 자신이고 클라이언트도 127.0.0.1에 들어있음 (같은 PC이기 때문에)
			// 클라이언트는 서버에 접속해야하기 때문에 127.0.0.1 입력
			
//			List<Socket> socketList = new ArrayList<>();
			
			while(true) {
				Socket socket = serverSocket.accept();	// 클라이언트의 접속을 기다리는 역할
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocket.start();
				
				// 소켓 하나가 하나의 클라이언트
//				socketList.add(socket);
				
				// Runnalble을 받을 수 있음(람다로 사용 가능)
//				Thread thread = new Thread(() -> {
					
				
//				thread.start();
				
//				});
				
				
//			System.out.println(socket.getInetAddress() + "클라이언트가 연결되었습니다.");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} finally {
					if(serverSocket != null) {
						try {
							serverSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					System.out.println("=====<<< 서버 종료 >>>=====");
				}
			
		
	}

}
