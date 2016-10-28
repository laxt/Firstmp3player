/**
 *VG Assignment 01
 *@author Laxmana Thapa
 */

package com.mp3player.otherclasses;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


public class MP3PlayerGUI implements ActionListener{
	
	/**
	 * Required items for MP3Player GUI
	 * Or variables
	 */

	public JFrame frmMpplayer;
	private JLabel lblFileName;
	private JButton btnOpen;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private PlayerMethods playerMethods = new PlayerMethods();
	private File selectedFile; 
	final JFileChooser fileChooser = new JFileChooser();
	private JLabel lblMessage;
	private JLabel lblPlaying ;
	

	/**
	 * Methods call for the GUI and action performed
	 */
	public MP3PlayerGUI() {
		initializeGUI();
		addComponentsToFrame();
		addActionListeners();
	}
	
	/**
	 * Get MP3player frame
	 * @return frmMpplayer Main frame for MP3player application
	 */
	public JFrame getFrmMpplayer(){
		return frmMpplayer;
	}


	/**
	 * Initializing the contents of the frame.
	 */
	private void initializeGUI() {
		frmMpplayer = new JFrame();
		frmMpplayer.setForeground(Color.WHITE);
		frmMpplayer.getContentPane().setEnabled(false);
		frmMpplayer.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 11));
		frmMpplayer.setResizable(false);
		frmMpplayer.setTitle("My Music Player");
		frmMpplayer.setBounds(100, 100, 428, 194);
		frmMpplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpplayer.getContentPane().setLayout(null);
		
		
		lblFileName = new JLabel("");
		lblFileName.setBounds(104, 62, 355, 33);
		
		btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon(MP3PlayerGUI.class.getResource("/Images/openp.jpg")));
		btnOpen.setBackground(Color.WHITE);
		btnOpen.setBounds(338, 32, 69, 25);
		
		btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon(MP3PlayerGUI.class.getResource("/Images/playp.jpg")));
		btnPlay.setBackground(Color.WHITE);

		btnPlay.setBounds(91, 111, 57, 25);
		
		btnPause = new JButton("");
		btnPause.setIcon(new ImageIcon(MP3PlayerGUI.class.getResource("/Images/pausep.jpg")));
		btnPause.setBackground(Color.WHITE);
		btnPause.setBounds(190, 111, 57, 25);
		
		btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon(MP3PlayerGUI.class.getResource("/Images/stopp.jpg")));
		btnStop.setBackground(Color.WHITE);
		btnStop.setBounds(300, 111, 57, 25);
		
		lblMessage = new JLabel("Please click open file button to select the music to play:");
		lblMessage.setBounds(15, 0, 499, 33);
		
		lblPlaying = new JLabel("Playing:");
		
		lblPlaying.setEnabled(false);
		lblPlaying.setBounds(25, 62, 69, 33);

	}
	
	/**
	 * Adding components that are needed for the Music player
	 */
	private void addComponentsToFrame() {
		frmMpplayer.getContentPane().add(lblPlaying);
		frmMpplayer.getContentPane().add(lblFileName);
		frmMpplayer.getContentPane().add(btnOpen);
		frmMpplayer.getContentPane().add(btnPlay);
		frmMpplayer.getContentPane().add(btnPause);
		frmMpplayer.getContentPane().add(btnStop);
		frmMpplayer.getContentPane().add(lblMessage);

	}

	/**
	 * On click action listeners for all the buttons available in interface
	 */
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);		
	}
	
	/**
	 * Adding action methods for the available buttons
	 * Empty file check for play button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			try {
				int returnVal = fileChooser.showOpenDialog(frmMpplayer);
			
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					if (selectedFile.isFile()){
						playerMethods.open(selectedFile);
						lblFileName.setText(selectedFile.getName());
						lblPlaying.setEnabled(true);
					}
				}			
			} catch (Exception ex){
				ex.getMessage();
			}
		}
		if (e.getSource() == btnPlay &&!lblPlaying.isEnabled()){
			JOptionPane.showMessageDialog(null, "Open file to play by clicking open button!");
			}
				
	else 
		//(e.getSource() == btnPlay)
		{		
		playerMethods.play();
				}
		
		
		if (e.getSource() == btnPause) {	
			playerMethods.pause();
		}
		
		
		if (e.getSource() == btnStop) {
			playerMethods.stop();
		}
		
	}
}

