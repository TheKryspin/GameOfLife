package AparatyKomorkowe.GUI;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * 
 */
public class Frame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1187440399722486581L;

	public Frame() {
    
    	this.setTitle("APARATY BY KRYSTIAN STEMPLEWSKI");
    	
    	this.setSize(400, 550);
    
    		BorderLayout layout = new BorderLayout();
    	
    		layout.setHgap(0); layout.setVgap(0);
    		
    		this.setLayout(layout);
    	
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    	this.setResizable(false);

    
    }



}