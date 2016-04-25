package AparatyKomorkowe.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

import AparatyKomorkowe.DataStorage;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5172173795699678646L;
	String nazwa;

	public Panel(String nazwa) {
		
			this.nazwa = nazwa;
			
			if(nazwa == "TopPanel"){
			
			GridLayout layout = new GridLayout();
			
				this.setSize(400, 400 );
		
				layout.setColumns(DataStorage.y);
				
				layout.setRows(DataStorage.x);
		
					layout.setHgap(1);
					
					layout.setVgap(1);
			this.setLayout(layout);

			
			}else{

				FlowLayout layout = new FlowLayout();
							
				layout.setVgap(30);
				
				layout.setHgap(20);

				this.setLayout(layout);


				this.setSize(400, 150 );
			
			}
		
			
	
		this.setBackground(Color.LIGHT_GRAY);
		
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(this.nazwa == "TopPanel"){
			
			g.setColor(new Color(255, 82, 57));
			
			g.fillRect(0, 0, 400, 200);
			
			g.setColor(new Color(243, 75, 49));
			
			g.fillRect(0, 200, 400, 400);
		}
		else if(this.nazwa == "MiddlePanel"){
			
			Image bck = new ImageIcon("GUI/MiddlePanel.jpg").getImage();
			
			g.drawImage(bck, 0, 0, this);
			
		}else if(this.nazwa == "BottomPanel"){
			
			Image bck = new ImageIcon("GUI/BottomPanel.jpg").getImage();
			
			g.drawImage(bck, 0, 0, this);
			
		}
		
	}

}