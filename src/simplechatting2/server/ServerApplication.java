package simplechatting2.server;

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

import com.google.gson.Gson;

import lombok.Data;
import simplechatting2.client.ChattingClient;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.JoinRespDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.MessageRespDto;
import simplechatting2.dto.RequestDto;
import simplechatting2.dto.ResponseDto;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private Gson gson;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		socketList.add(this); // 생성된 자기 자신을 List에 담음
	}
	
	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
				String request = in.readLine(); // requestDto(JSON)
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);
				
				switch(requestDto.getResource()) {
					case "join":
						JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
						username = joinReqDto.getUsername();
						List<String> connectedUsers = new ArrayList<>();
						
						for(ConnectedSocket connectedSocket : socketList) {
							connectedUsers.add(connectedSocket.getUsername());
						}
						
						JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
						System.out.println(joinReqDto);
						
						sendToAll(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
						break;
					case "sendMessage" :
						MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);
						
						if(messageReqDto.getToUser().equalsIgnoreCase("all")) {
							String message = messageReqDto.getFromUser() + "[전체]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
						}
						
						

						break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void sendToAll(String resource, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		for(ConnectedSocket connectedSocket : socketList) {
			OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			out.println(gson.toJson(responseDto)); // 모든 소켓에 전달
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
