package TranslateServer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TCPframe extends JFrame
{
private static final long serialVersionUID = 1L;
	
	// Private components
	private JLabel lblServerStatus;
	private JTextArea txtRequestStatus;
	
	// Private dimension
	private int width = 1000;
	private int height = 500;
	
	public TCPframe()
	{
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Translation Server");
		this.setSize(new Dimension(width, height));  
				
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// Center the frame on the screen
		this.setLocationRelativeTo(null);
		 
		// Initialize component
		this.lblServerStatus = new JLabel ("Waiting for Connection...");
		
		// Row, Column
		this.txtRequestStatus  = new JTextArea(20, 70);
				
		// Load more component
		loadComponent();
	}
	
	// server status
	private JPanel getServerStatusPanel(Font font) {
		
		// Components to display server's status
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblServer = new JLabel ("Server status: ");
		
		// Style the components
		lblServer.setFont(font);
		lblServerStatus.setFont(font);
		lblServer.setOpaque(true);
		lblServerStatus.setOpaque(true);


		// Organize component into the panel
		panel.add(lblServer);
		panel.add(lblServerStatus);
		
		return panel;
		
	}
	
	// request text space
	private JPanel getRequestStatusPanel () 
	{
		// Component to display request's status
		JPanel panel = new JPanel();

		// Set default message
		txtRequestStatus.setText("\n > Server is running");
		txtRequestStatus.setEditable(false);
		
		// Styling the request text
		txtRequestStatus.setFont(new Font("Courier", Font.PLAIN, 15));

		// Add component to panel
		panel.add(txtRequestStatus);
		
		return panel;
		
	}
	
	
	//interface arrangement
	public void loadComponent() {
		
		// Get the server status panel and add to frame
		Font font = this.getFontStyle();
		JPanel topPanel = this.getServerStatusPanel(font);
		this.add(topPanel, BorderLayout.NORTH);
		
		
		// Component to display request's status
		JPanel centrePanel = this.getRequestStatusPanel();		
		this.add(centrePanel, BorderLayout.CENTER);
		
		
	}
	
	//update server status
	public void updateServerStatus(boolean flag) {
		
		String status = "Waiting for connection.";
		
		if (flag)
			status = "Received connection.";
		
		this.lblServerStatus.setText(status);
		
	}
	
	// update request
	public void updateRequestStatus (String status) {
		
		// Get current status displayed on the window
		String currentText = this.txtRequestStatus.getText();
		txtRequestStatus.setEditable(true);
		
		// Display the latest status on top
		status += "\n > " + currentText;
		this.txtRequestStatus.setText(status);
		txtRequestStatus.setEditable(false);
	}
	
	//general used font style
	private Font getFontStyle() {
		
		Font font = new Font (Font.SANS_SERIF, Font.PLAIN, 30);
		
		return font;
		
	}
}
