package simplechatting.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
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

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;
	

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	
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
						
						out.println(username + "님이 접속하였습니다.");
						
						String welcomeMessage = in.readLine();
						contentView.append(welcomeMessage);

					}
					
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
		
		JList userList = new JList();
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScoll = new JScrollPane();
		messageScoll.setBounds(12, 420, 525, 33);
		contentPane.add(messageScoll);
		
		JTextArea messageInput = new JTextArea();
		messageScoll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.setBounds(549, 420, 75, 33);
		contentPane.add(sendButton);
	}
}
