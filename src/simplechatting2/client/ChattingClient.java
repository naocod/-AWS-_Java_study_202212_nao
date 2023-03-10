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
		
		JButton connectButton = new JButton("??????");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipInput.getText(); // ????????? ???????????? .getText?????? ?????????
				port = Integer.parseInt(portInput.getText()); // string -> int??? ?????? 
				
				try { // ???????????????
					// ????????? ?????????????????? ????????? ????????? ????????????
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null, 
							socket.getInetAddress() + "?????? ??????", 
							"????????????", 
							JOptionPane.INFORMATION_MESSAGE);
					
					connectButton.setEnabled(false);
					connectButton.removeMouseListener(this);
					
					ClientRecive clientRecive = new ClientRecive(socket);
					clientRecive.start();
					
					username = JOptionPane.showInputDialog(null, "????????? ????????? ????????? ?????????.", "????????????", JOptionPane.INFORMATION_MESSAGE);
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson); // requestDtoJson???????????? ???????????? ??????
					
							
					
				} catch (ConnectException e1) {

					JOptionPane.showMessageDialog(null, 
							"?????? ?????? ??????", "????????????", 
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
			public void keyPressed(KeyEvent e) { // ???????????? ????????? ????????? keyCode??? ????????????
				if(e.getKeyCode() == KeyEvent.VK_ENTER) { // return??? int????????? ==?????? ??????
					// ????????? ??? ????????? ENTER??? ??? ????????? ????????? ??????
					sendMessage();
				}
			}
		});
		messageScoll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("??????");
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
