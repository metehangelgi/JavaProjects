package ders2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;




public class IkinciDers extends JFrame {
	
	JButton button1;
	JTextField textF;
	JTextArea txtA;
	int banatıklandı;
	public static void main(String[] args) {
		new IkinciDers();
	}

	
	
	
	public IkinciDers() {
		this.setSize(400,400);
		Toolkit tk= Toolkit.getDefaultToolkit();
		Dimension dim= tk.getScreenSize();
		int xPoz=(dim.width/2)-(this.getWidth()/2);
		int yPoz=(dim.height/2)-(this.getHeight()/2);
		this.setLocation(xPoz, yPoz);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ikinci denemem");
		
		
		
		JPanel panelim =new JPanel();
		JLabel labelim=new JLabel("bir şey söyleee");
		
		labelim.setText("beni bul yiğidim");
		labelim.setToolTipText("bu bir label");
		panelim.add(labelim);
		button1=new JButton("bebişşş");
		button1.setToolTipText("benim adım doktoycuk");
		button1.setBorderPainted(true);
		ListenForButton listenButton=new ListenForButton();
		button1.addActionListener(listenButton);
		panelim.add(button1);
		textF= new JTextField("bana yaz",15);
		textF.setColumns(10);
		textF.setText("text değişti");
		textF.setToolTipText("buna yazılır");
		
		ListenForKeys KeyListen=new ListenForKeys();
		textF.addKeyListener(KeyListen);
		
		panelim.add(textF);
		txtA=new JTextArea("burası alandır ",15,20);
		txtA.setText("beni değiştirdidgldisfaldsiflişadlfşisdlfişaslfaişslfisşafldsşiaslişlf \n");
		txtA.setLineWrap(true);
		JScrollPane scrollBar=new JScrollPane(txtA,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		txtA.setWrapStyleWord(true);
		panelim.add(scrollBar);
		int satırS=txtA.getLineCount();
		txtA.append("Satır Sayısı:" + satırS);
		
		this.add(panelim);
		
		ListenForWindow windowListen =new ListenForWindow();
		this.addWindowListener(windowListen);
		this.setVisible(true);
		ListenForMouse mouseListen=new ListenForMouse();
		this.addMouseListener(mouseListen);
		txtA.requestFocus();
	}
	
	private class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==button1) {
				banatıklandı++;
				txtA.append("\n butona tıklandı: "+ banatıklandı+" defa \n");
			}
		}
	}
	
	private class ListenForKeys implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			txtA.append("harf girildi: "+ e.getKeyChar()+ "\n");
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			txtA.append("harf girildi: "+ e.getKeyChar()+ "\n");
			
		}
		
	}
	
	private class ListenForWindow implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			txtA.append("ekran oluşturldu \n");

			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			txtA.append("ekran küçültüldü \n");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			txtA.append("ekran normal durumda \n");

			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			txtA.append("ekran aktif \n");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			txtA.append("ekran aktif değil \n");

			
		}
		
	}
	private class ListenForMouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			txtA.append("mouse panele clickledi to this location: "+ e.getX()+" " +e.getY()+ "\n");
			txtA.append("mouse ekrandaki yeri: "+e.getXOnScreen()+" "+ e.getYOnScreen()+"\n");
			txtA.append("mouse buton konum: "+e.getButton()+ "\n");
			txtA.append("mouse tıklama: "+ e.getClickCount()+"\n");


			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
