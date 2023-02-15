package simplechatting2.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import lombok.Data;
import lombok.Getter;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.RequestDto;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class ChattingClient extends JFrame {
	private static ChattingClient instance; 
	
	public static ChattingClient getInstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		
		return instance;
	}
	
	private Socket socket;
	private Gson gson;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList<String> userList;
	private DefaultListModel<String> userListModel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ChattingClient() {
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(370, 10, 131, 33);
		
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipInput.getText(); // 텍스트 필드에서 .getText해서 들고옴
				port = Integer.parseInt(portInput.getText()); // string -> int로 변환 
				
				try { // 클라이언트
					// 서버에 접속하기위해 서버의 주소를 알아야함
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null, 
							socket.getInetAddress() + "서버 접속", 
							"접속성공", 
							JOptionPane.INFORMATION_MESSAGE);
					
					connectButton.setEnabled(false);
					connectButton.removeMouseListener(this);
					
					ClientRecive clientRecive = new ClientRecive(socket);
					clientRecive.start();
					
					username = JOptionPane.showInputDialog(null, "사용자 이름을 입력해 주세요.", "이름입력", JOptionPane.INFORMATION_MESSAGE);
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson); // requestDtoJson만들어서 서버에게 전달
					
							
					
				} catch (ConnectException e1) {

					JOptionPane.showMessageDialog(null, 
							"서버 접속 실패", "접속실패", 
							JOptionPane.ERROR_MESSAGE);
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(558, 10, 66, 33);
		contentPane.add(connectButton);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(504, 10, 52, 33);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 354, 400);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(370, 53, 254, 357);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList<String>(userListModel);
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScoll = new JScrollPane();
		messageScoll.setBounds(12, 420, 525, 33);
		contentPane.add(messageScoll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // 이벤트가 일어난 녀석의 keyCode가 들어있음
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { // return이 int이기에 ==으로 비교
					// 입력된 키 코드와 ENTER의 키 코드가 같은지 비교
					sendMessage();
				}
			}
		});
		messageScoll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMessage();
			}
		});
		sendButton.setBounds(549, 420, 75, 33);
		contentPane.add(sendButton);
	}
	
	private void sendRequest(String resource, String body) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			RequestDto requestDto = new RequestDto(resource, body);
			
			out.println(gson.toJson(requestDto));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private void sendMessage() {
		if(!messageInput.getText().isBlank()) {
			
			String toUser = userList.getSelectedIndex() == 0 ? "all" : userList.getSelectedValue();
				
			MessageReqDto messageReqDto =
					new MessageReqDto(toUser, username, messageInput.getText());
				
			sendRequest("sendMessage", gson.toJson(messageReqDto));
			messageInput.setText("");	
		}
	}
}
