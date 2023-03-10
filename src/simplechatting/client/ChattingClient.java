package simplechatting.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;
	

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList userList;
	private DefaultListModel<String> userListModel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
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
					
					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					
					if(in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, "사용자 이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);
						// 클라이언트에서 서버로 보내야하는데 out이 없기에 생성
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						out.println(username);
//						
//						String welcomeMessage = in.readLine();
//						contentView.append(welcomeMessage);
					}
					
					Thread thread = new Thread(() -> { // 스레드가 계속 돌면서 readLine을 해줌
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));
							
							while(true) {
								String message = reader.readLine();
								if(message.startsWith("@welcome")) { // startsWith 특정 문자로 시작하는지 확인함
									int tokenIndex = message.indexOf("/"); // /의 위치를 찾음
									message = message.substring(tokenIndex + 1); // substring은 해당 문자열 중에서 특정 인덱스부터 문자열을 자름
								}else if(message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
										userListModel.addElement(username); // addElement -> 인덱스가 자동으로 증가됨
									}
									continue;
								}
								contentView.append(message + "\n");
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
					
					thread.start();
					
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
		userList = new JList(userListModel);
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
					if(!messageInput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username + ": " + messageInput.getText());
							messageInput.setText("");
							
//							InputStream inputStream = socket.getInputStream();
//							BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//							
//							String message = in.readLine();
//							contentView.append("\n" + message);
						
						
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		messageScoll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!messageInput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						out.println(username + ": " + messageInput.getText());
						
//						InputStream inputStream = socket.getInputStream();
//						BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//						
//						String message = in.readLine();
//						contentView.append("\n" + message);
					
					
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		sendButton.setBounds(549, 420, 75, 33);
		contentPane.add(sendButton);
	}
}
