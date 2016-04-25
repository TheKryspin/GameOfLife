package AparatyKomorkowe.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import AparatyKomorkowe.DataStorage;
import AparatyKomorkowe.listeners.LiczenieListener;
import AparatyKomorkowe.listeners.OneBCListener;
import AparatyKomorkowe.listeners.PauzaListener;
import AparatyKomorkowe.listeners.ZeroBCListener;


public class GuiBuilder {

    private Frame MainFrame;

    private Button ZeroBC;
    private Button OneBC;
    private Button PauzaButton;
    private Button CountButton;
    
    
    private Panel TopPanel;
    private Panel MiddlePanel;
    private Panel BottomPanel;
	
    private TextField Regula;
    private TextField TimeStep;
    private TextField TimeShow;
    private TextField TimeAnim;
    
    private Podpis RegulaLabel;
    private Podpis TimeStepLabel;
    private Podpis TimeShowLabel;
    private Podpis TimeAnimLabel;
    
    private Cell[][] Cells ;
    
	public GuiBuilder() {
    
		MainFrame = new Frame();
	
			TopPanel = new Panel("TopPanel");
		
			MiddlePanel = new Panel("MiddlePanel");
			
			BottomPanel = new Panel("BottomPanel");	
		
				Regula = new TextField();
				
				TimeStep = new TextField();
				
				TimeShow = new TextField();

				TimeAnim = new TextField();
	
					TimeAnim.setBackground(new Color(141,50,85));
				
				TimeShow.setEditable(false);
					
					ZeroBC = new Button("0");
					
					ZeroBC.addMouseListener(new ZeroBCListener());
					
					OneBC = new Button("1");
	
					OneBC.addMouseListener(new OneBCListener());
					
					CountButton = new Button("Count");
					
						CountButton.setPreferredSize(new Dimension(120,60));
						
						LiczenieListener CountListener = new LiczenieListener(this);
						
						CountButton.addMouseListener(CountListener);
				
					PauzaButton = new Button("Pauza");
						
						PauzaButton.setPreferredSize(new Dimension(120,60));
					
						PauzaButton.addMouseListener(new PauzaListener());
				
							Cells = new Cell[DataStorage.x][DataStorage.y];
								
								RegulaLabel = new Podpis("Wpisz Regule");
								
								TimeStepLabel = new Podpis("Ile krokow");
										
								TimeShowLabel = new Podpis("Krok nr");		
	
								TimeAnimLabel = new Podpis("Czas animacji");
	}		


	public void buildGui()
	{
		
		for(int i = 0; i < DataStorage.x; i ++){
			for(int j = 0; j < DataStorage.y ; j ++){
			
			Cells[i][j] = new Cell(i,j);
			
			TopPanel.add(Cells[i][j]);
		
			}
			
		}
		
		//MiddlePanel.add(TimeShowLabel); MiddlePanel.add(TimeShow);
		
		//MiddlePanel.add(RegulaLabel);MiddlePanel.add(Regula);
		
	//	MiddlePanel.add(TimeStepLabel);MiddlePanel.add(TimeStep);
		
	//	MiddlePanel.add(ZeroBC);
		
		//MiddlePanel.add(OneBC);
		
		BottomPanel.add(TimeAnimLabel);
		
		BottomPanel.add(TimeAnim);
		
		//BottomPanel.add(PauzaButton);
		
		BottomPanel.add(CountButton);
		
			MainFrame.add(TopPanel, BorderLayout.CENTER);
		
			//MainFrame.add(MiddlePanel);
		
			MainFrame.add(BottomPanel, BorderLayout.SOUTH);
		
		MainFrame.setVisible(true);
		
	}

public Cell[][] getCells(){ return Cells;}

public Button getButton(String which){
	if(which == "one"){
		
		return OneBC;
	}else if(which == "zero")
	{
		
		return ZeroBC;
	}else
	{
		return null;
		
	}
		
}

public TextField getTextField(String which)
{
	if(which == "timestep")
	{
	
		return TimeStep;
		
	}else if(which == "regula")
	{
		
		return Regula;
		
	}else if( which == "timeshow")
	{
		
		return TimeShow;
		
	}else if(which == "timeanim"){
		
		return TimeAnim;
		
	}else { return null;}

}


}