package com.tetris.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.tetris.window.Button;
import com.tetris.window.Tetris;

public class TetrisOpening extends JFrame {
   
   private Image screenImage;
   private Graphics screenGraphic;
   private ImageIcon exitButtonEnteredImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/exitButtonEntered.png"));
   private ImageIcon exitButtonBasicImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/exitButtonBasic.png"));
   private ImageIcon startButtonEnteredImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/startButtonEntered.png"));
   private ImageIcon startButtonBasicImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/startButtonBasic.png"));
   private ImageIcon quitButtonEnteredImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/quitButtonEntered.png"));
   private ImageIcon quitButtonBasicImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/quitBtnBasic.png"));
   
   
   /** 
    *  �߰��� ��ư��
    *  �α��� , ����, �Ͽ����÷���
    */
   private ImageIcon loginButtonImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/loginBtnBasic.png")); // �α��ι�ư
   private ImageIcon settingButtonImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/settingBtnBasic.png")); // ������ư
   private ImageIcon howToPlayButtonImage = new ImageIcon(TetrisMain.class.getResource("../../../Images/howToPlayBtnBasic.png")); // howtoPlay ��ư
   
   
   
   
   
   
   
   
   private Image background = new ImageIcon(TetrisMain.class.getResource("../../../Images/IntroBackground.jpg")).getImage();
   private JLabel menuBar = new JLabel(new ImageIcon(TetrisMain.class.getResource("../../../Images/menuBar.png")));
   
   private JButton exitButton = new JButton(exitButtonBasicImage);
   private JButton startButton = new JButton(startButtonBasicImage);
   private JButton quitButton = new JButton(quitButtonBasicImage);
   
   /**
    *  �α��ι�ư, ������ư, howToPlay��ư
    */
   private JButton loginButton = new JButton(loginButtonImage);
   private JButton settingButton = new JButton(settingButtonImage);
   private JButton howToPlayButton = new JButton(howToPlayButtonImage);
   
   
   private int mouseX, mouseY;
   private boolean isMainScreen = false;

   public TetrisOpening() {
	   
      setUndecorated(true);
      setTitle("Tetris");
      setSize(TetrisMain.SCREEN_WIDTH, TetrisMain.SCREEN_HEIGHT);
      setResizable(false);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setBackground(new Color(0, 0, 0, 0));
      setLayout(null);
      
      
      
      
      // �����ϱ� ��ư�� ���� ����
      exitButton.setBounds(880, 0, 30, 30);
      exitButton.setBounds(890, 0, 30, 30);
      exitButton.setBorderPainted(false);
      exitButton.setContentAreaFilled(false);
      exitButton.setFocusPainted(false);
      exitButton.addMouseListener(new MouseAdapter() {
    	  
         @Override
         public void mouseEntered(MouseEvent e) {
            exitButton.setIcon(exitButtonEnteredImage);
            exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
         }
         @Override
         public void mouseExited(MouseEvent e) {
            exitButton.setIcon(exitButtonBasicImage);
            exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) { // ���콺 ���ý�
        	 
            try { 
               Thread.sleep(1000); // 1�ʰ� ���߰�
            } catch(InterruptedException ex) {
               ex.printStackTrace();
            } 
            System.exit(0); // �ý��� ������
         }
      });
      
      add(exitButton); // ���� ��ư �߰�
      
      
      // �����ϱ� ��ư ����
      startButton.setBounds(260, 200, 400, 50); //��ư ����(ũ��)
      startButton.setBorderPainted(false); // �� �״�� ��ư setBorder
      startButton.setContentAreaFilled(false);
      startButton.setFocusPainted(false); // ��Ŀ���� ����Ʈ ��
      startButton.addMouseListener(new MouseAdapter() { // ���콺 ������
         @Override
         public void mouseEntered(MouseEvent e) { // ����� ��
        	// �ܼ��� ���콺 ������ ����� �� �̹����� �ٲپ� ������ �ϴ� ���� ��
            startButton.setIcon(startButtonEnteredImage);
            startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
         }
         @Override
         public void mouseExited(MouseEvent e) { // ������ ��
            startButton.setIcon(startButtonBasicImage);
            startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         
         @Override
         public void mousePressed(MouseEvent e) { //���콺 ���߾��� ��
            startButton.setVisible(false);
            quitButton.setVisible(false);
            //background ���߱�
            isMainScreen = true;
            
            
            
            

            
            new ModeSelectionWindow(); // ���� ��� ����
            
         }
      });
      
      
      add(startButton); 
      
      
      

      quitButton.setBounds(260, 250, 400, 50);
      quitButton.setBorderPainted(false);
      quitButton.setContentAreaFilled(false);
      quitButton.setFocusPainted(false);
      quitButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            quitButton.setIcon(quitButtonEnteredImage);
            quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
         }
         @Override
         public void mouseExited(MouseEvent e) {
            quitButton.setIcon(quitButtonBasicImage);
            quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            try {
               Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
            System.exit(0);
            
         }
      });
      
      add(quitButton); // �����ư �߰�
      
      
      
      
      
      // �α��� ��ư �����ϱ�
      loginButton.setBounds(260, 300, 400, 50);
      loginButton.setBorderPainted(false);
      loginButton.setContentAreaFilled(false);
      loginButton.setFocusPainted(false);
      loginButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
        	 loginButton.setIcon(loginButtonImage);
        	 loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
         }
         @Override
         public void mouseExited(MouseEvent e) {
        	 loginButton.setIcon(loginButtonImage);
        	 loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
//        	 startButton.setVisible(false);
//             quitButton.setVisible(false);
             //background ���߱�
//             isMainScreen = true;
             
        	 
//        	 TetrisLogin frame = new TetrisLogin();
        	 Login login_frame = new Login();
        	 login_frame.setVisible(true);
            
         }
      });
      
   // �α��� ��ư �߰�
      add(loginButton); 
      
      
      
      
     /**
      *  how to play ��ư �� ������ư �߰�
      */
      
      //how to play ��ư
      howToPlayButton.setBounds(260, 350, 400, 50);
      howToPlayButton.setBorderPainted(false);
      howToPlayButton.setContentAreaFilled(false);
      howToPlayButton.setFocusPainted(false);
      howToPlayButton.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) { // ���콺 ������ ��
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) { // �ش� ��ư���� ���콺�� ����� ��
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) { // ���콺 ��ư�� ���� ����� ��
			howToPlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
      add(howToPlayButton);
      
      
      // ������ư
      settingButton.setBounds(260, 400, 400, 50);
      settingButton.setBorderPainted(false);
      settingButton.setContentAreaFilled(false);
      settingButton.setFocusPainted(false);
      settingButton.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) { // ����Ű ��
			Button start = new Button();
			start.FrameShow();			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			settingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
      add(settingButton);
      
      
      
      
      
      
      
   
    
      
      
      
      
      
      menuBar.setBounds(0, 0, 1280, 30); // �޴��� �ٿ����
      menuBar.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) { //���콺 Ŭ���� 
            mouseX = e.getX();
            mouseY = e.getY();
         }
         
      });
      
      menuBar.addMouseMotionListener(new MouseMotionAdapter() { // â�� �ű� �� �ֵ��� ��
         @Override
         public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            setLocation(x - mouseX, y - mouseY); //��ġ �ٲٱ� , �ű��
         }
      });
      add(menuBar);
      
   
   }
   
   public void paint(Graphics g) {
      screenImage = createImage(TetrisMain.SCREEN_WIDTH, TetrisMain.SCREEN_HEIGHT);
      screenGraphic = screenImage.getGraphics();
      screenDraw(screenGraphic);
      g.drawImage(screenImage, 0, 0, null);
   }
   
   public void screenDraw(Graphics g) {
      g.drawImage(background, 0, 0, null);
      if(isMainScreen) {
         this.setVisible(false);
      }
      printComponents(g);
      this.repaint();
   }

}
 