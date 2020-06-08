package ders1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;




public class IlkDers extends JFrame {

	public static void main(String[] args) {
		new IlkDers();
	}

	
	
	
	public IlkDers() {
		this.setSize(400,400);
		Toolkit tk= Toolkit.getDefaultToolkit();
		Dimension dim= tk.getScreenSize();
		int xPoz=(dim.width/2)-(this.getWidth()/2);
		int yPoz=(dim.height/2)-(this.getHeight()/2);
		
		this.setLocation(xPoz, yPoz);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ilk denemem");
		
		
		
		JPanel panelim =new JPanel();
		JLabel labelim=new JLabel("bir şey söyleee");
		
		labelim.setText("beni bul yiğidim");
		labelim.setToolTipText("bu bir label");
		panelim.add(labelim);
		JButton button1=new JButton("bebişşş");
		button1.setToolTipText("benim adım doktoycuk");
		button1.setBorderPainted(true);
		panelim.add(button1);
		JTextField textF= new JTextField("bana yaz",15);
		textF.setColumns(10);
		textF.setText("text değişti");
		textF.setToolTipText("buna yazılır");
		panelim.add(textF);
		JTextArea txtA=new JTextArea("burası alandır ",15,20);
		txtA.setText("beni değiştirdidgldisfaldsiflişadlfşisdlfişaslfaişslfisşafldsşiaslişlf \n");
		txtA.setLineWrap(true);
		JScrollPane scrollBar=new JScrollPane(txtA,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		txtA.setWrapStyleWord(true);
		panelim.add(scrollBar);
		int satırS=txtA.getLineCount();
		txtA.append("Satır Sayısı:" + satırS);
		
		this.add(panelim);
		this.setVisible(true);
		txtA.requestFocus();
	}
}
