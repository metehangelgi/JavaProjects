import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class MyPaint extends GraphicsProgram{
	//instance variables
	private JRadioButton circleBut=new JRadioButton("Circle");
	private JRadioButton rectBut=new JRadioButton("Rectangle");
	private JRadioButton lineBut=new JRadioButton("Line");
	private JRadioButton textBut=new JRadioButton("Text");
	private JRadioButton blackBut=new JRadioButton("Black");
	private JRadioButton blueBut=new JRadioButton("Blue");
	private JRadioButton redBut=new JRadioButton("Red");
	private JCheckBox filled=new JCheckBox("Filled");
	private JSlider sizeSlider=new JSlider(0,60,30);
	private JTextField textBox=new JTextField(10);
	private JComboBox fontPullDown=new JComboBox();
	private JComboBox sizePullDown=new JComboBox();
	
	private double prevX=-1,prevY=-1;
	private Color selectedColor=Color.BLACK;
	private String text="";
	
	public void init(){
		add(new JLabel("Foto-schop 2020"),NORTH);
		add(new JButton("Clear all"),SOUTH);
		add(new JLabel("0"),SOUTH);
		add(sizeSlider,SOUTH);
		add(new JLabel("60"),SOUTH);
		add(circleBut,EAST);
		add(rectBut,EAST);
		add(new JLabel(" "),EAST);
		add(lineBut,EAST);
		add(textBut,EAST);
		add(new JLabel(" "),EAST);
		add(new JLabel(" "),EAST);
		add(filled,EAST);
		initFontChooser();
		add(fontPullDown,EAST);
		add(sizePullDown,EAST);
		add(textBox,SOUTH);
		textBox.addActionListener(this);
		ButtonGroup shapeGrp=new ButtonGroup();
		shapeGrp.add(circleBut);
		shapeGrp.add(rectBut);
		shapeGrp.add(lineBut);
		shapeGrp.add(textBut);

		add(blackBut,WEST);
		add(blueBut,WEST);
		add(redBut,WEST);
		blackBut.setSelected(true);
		ButtonGroup colorGrp=new ButtonGroup();
		colorGrp.add(blackBut);
		colorGrp.add(blueBut);
		colorGrp.add(redBut);
		
		circleBut.setSelected(true);
		
		addActionListeners();
		addMouseListeners();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equalsIgnoreCase("Clear all"))
		{
			removeAll();
		}else if(e.getSource()==textBox){
			text=textBox.getText();
		}
	}
	public void mouseClicked(MouseEvent m){
		double size=sizeSlider.getValue();
		
		selectColor();
		
		if(circleBut.isSelected()){
			GOval circle=new GOval(size,size);
			circle.setColor(selectedColor);
			if(filled.isSelected()){
				circle.setFilled(true);
				circle.setFillColor(selectedColor);
			}
			add(circle,m.getX(),m.getY());
		}else if(rectBut.isSelected()){
			GRect rect=new GRect(size,size);
			rect.setColor(selectedColor);
			if(filled.isSelected()){
				rect.setFilled(true);
				rect.setFillColor(selectedColor);
			}
			add(rect,m.getX(),m.getY());	
		}else if(textBut.isSelected()){
			GLabel label=new GLabel(text);
			label.setColor(selectedColor);
			label.setFont(setLabelFont());
			add(label,m.getX(),m.getY());	
		}
		
	}
	public void mousePressed(MouseEvent m){
		prevX=m.getX();
		prevY=m.getY();
	}
	public void mouseReleased(MouseEvent m){
		selectColor();
		if(lineBut.isSelected()){
			GLine line=new GLine(prevX,prevY,m.getX(),m.getY());
			line.setColor(selectedColor);
			add(line);
		}
	}
	private void selectColor(){
		if(blackBut.isSelected())
			selectedColor=Color.BLACK;
		else if(blueBut.isSelected())
			selectedColor=Color.BLUE;
		else if(redBut.isSelected())
			selectedColor=Color.RED;
	}
	private void initFontChooser(){
		fontPullDown.addItem("Arial");
		fontPullDown.addItem("Serif");
		fontPullDown.addItem("Times");
		fontPullDown.setEditable(false);
		fontPullDown.setSelectedItem("Arial");
		
		sizePullDown.addItem("12");
		sizePullDown.addItem("14");
		sizePullDown.addItem("16");
		sizePullDown.addItem("18");
		sizePullDown.addItem("20");
		sizePullDown.addItem("24");
		sizePullDown.addItem("28");
		sizePullDown.setEditable(false);
		sizePullDown.setSelectedItem("12");
	}
	private String setLabelFont(){
		String fontName=(String) fontPullDown.getSelectedItem();
		fontName=fontName+"-"+sizePullDown.getSelectedItem();
		return fontName;
	}
}
