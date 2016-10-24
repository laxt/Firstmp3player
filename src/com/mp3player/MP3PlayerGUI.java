/**
 *VG Assignment 
 *@author Laxmana
 */

package com.mp3player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;


public class MP3PlayerGUI implements ActionListener{
	
	/**
	 * Required items for MP3Player GUI
	 * Or variables
	 */

	public JFrame frmMpplayer;
	private JLabel lblNowPlaying;
	private JLabel lblFileName;
	private JButton btnOpen;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private PlayerMethods playerMethods = new PlayerMethods();
	private File selectedFile; 
	final JFileChooser fileChooser = new JFileChooser();
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public MP3PlayerGUI() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initializing the contents of the frame.
	 */
	private void createGUI() {
		frmMpplayer = new JFrame();
		frmMpplayer.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 15));
		frmMpplayer.setResizable(false);
		frmMpplayer.setTitle("My Music Player");
		frmMpplayer.setBounds(100, 100, 539, 302);
		frmMpplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpplayer.getContentPane().setLayout(null);
		
		lblNowPlaying.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNowPlaying.setBounds(15, 90, 63, 33);
		
		lblFileName = new JLabel("");
		lblFileName.setBounds(76, 90, 418, 33);
		
		btnOpen = new JButton("Open File");
		btnOpen.setBackground(SystemColor.activeCaption);
		btnOpen.setBounds(337, 28, 104, 25);
		
		btnPlay = new JButton("Play");
		btnPlay.setBackground(SystemColor.activeCaption);
		btnPlay.setBounds(106, 166, 77, 25);
		
		btnPause = new JButton("Pause");
		btnPause.setBackground(SystemColor.activeCaption);
		btnPause.setBounds(235, 166, 77, 25);
		
		btnStop = new JButton("Stop");
		btnStop.setBackground(SystemColor.activeCaption);
		btnStop.setBounds(364, 166, 77, 25);
	}
	
	/**
	 * 
	 */
	private void addComponentsToFrame() {
		frmMpplayer.getContentPane().add(lblNowPlaying);
		frmMpplayer.getContentPane().add(lblFileName);
		frmMpplayer.getContentPane().add(btnOpen);
		frmMpplayer.getContentPane().add(btnPlay);
		frmMpplayer.getContentPane().add(btnPause);
		frmMpplayer.getContentPane().add(btnStop);
		
		lblNewLabel = new JLabel("Please click open file button to select the music to play:");
		lblNewLabel.setBounds(15, 0, 499, 20);
		frmMpplayer.getContentPane().add(lblNewLabel);
	}

	/**
	 * 
	 */
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);		
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			int returnVal = fileChooser.showOpenDialog(frmMpplayer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();				
				lblFileName.setText(selectedFile.getName());
			}			
		}
		if (e.getSource() == btnPlay) {
		playerMethods.play(selectedFile);
		}
		if (e.getSource() == btnPause) {
			playerMethods.pause();
		}
		if (e.getSource() == btnStop) {
			playerMethods.stop();
		}
		
	}
}

