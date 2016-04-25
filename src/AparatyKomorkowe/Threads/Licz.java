package AparatyKomorkowe.Threads;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import AparatyKomorkowe.DataStorage;
import AparatyKomorkowe.GUI.GuiBuilder;

/**
 * 
 */
public class Licz extends Thread{

	private GuiBuilder dostep;
	
	private int krok;
	
	private BufferedWriter History;
	
	public Licz(GuiBuilder dostep) {
    
		this.dostep = dostep;
		
		
	}

	@Override
	public void run()
	{
		DataStorage.referencja = this;

		
		this.zamien();
		
		/*History = new BufferedWriter(this.initializeHistogram());
		
		try {
			
			History.write(this.toSave() + " Krok nr " + Integer.toString(krok));History.newLine();

			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
*/		
		while(krok < DataStorage.Times){
		try {
			int ile = (int) DataStorage.TimeMS*1000;
			Thread.sleep(ile);
			
		} catch (InterruptedException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dostep.getTextField("timeshow").setText(Integer.toString(krok+1));
		
		for(int i = 0; i < 9; i ++)
			for(int j = 0; j < 9; j++){
		{
		 
			
			dostep.getCells()[i][j].setVar(this.checkVal(i,j));
			
			dostep.getCells()[i][j].changeColor();
			
			
		 }
		}
		for(int i = 0; i < 9; i ++)
			for(int j = 0; j < 9; j++){
		{
			
			DataStorage.Before[i][j] = dostep.getCells()[i][j].getVar();
			
			
		}
			}
		
		krok ++;


/*		try {
			History.write(this.toSave() + " Krok nr " + Integer.toString(krok));	History.newLine(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
	
	}
	
		/*try {
			History.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	private void zamien(){
		
		int do_zamiany = DataStorage.Regula;
		
		int i = 7;
		
		while(i>=0){
			
			if(do_zamiany % 2 == 1)
			{
				DataStorage.Conditions[i] = 1;
		
				//System.out.println(Integer.toString(DataStorage.Conditions[i]));
			}else
			{
				
				DataStorage.Conditions[i] = 0;
			
				//System.out.println(Integer.toString(DataStorage.Conditions[i]));
			}
		
			do_zamiany = do_zamiany/2;	
			
			i--;
			
		}
		
		
	}
	
	
	private int checkVal(int i, int j)
	{
		
		int middle;
		
		int wynik = 0, counter = 0;

		 middle = DataStorage.Before[i][j];
				
			
		for(int w = i-1 ; w <= i+1; w++ ){
		
			if( w < 0 || w > DataStorage.x -1) continue;
			
			for (int k = j-1; k <= j+1; k++  ){
			
				if(k < 0 || k > DataStorage.y+1 || (w == DataStorage.x && k == DataStorage.y) ) continue;
				
			{
				if(DataStorage.Before[w][k] == 1)
				{
					counter ++;
									
				}
			
			}
		}
		
	}
		if(middle == 1){	counter --; 
		
			if(counter == 2 || counter == 3)
			{
				wynik = 1;
			
			}
			if(counter < 2 || counter > 3)
			{
				
				wynik = 0;


			}
			
		}

		else if(middle == 0){           
			
			if(counter == 3){ wynik = 1;  }
			else { wynik = 0; }

		}
	
		
		return wynik;
	}
	
		private FileWriter initializeHistogram()
		{
			
			String nazwa = null;
				
			Calendar Today = Calendar.getInstance();
		
				nazwa = Today.getTime().toString();
				
				nazwa = nazwa.replace(":", "");
			
				nazwa += (" " + Integer.toString(DataStorage.Regula));
				
				nazwa += (" " + Integer.toString(DataStorage.BC));
				
				nazwa += (" " + Integer.toString(DataStorage.Times));
				
				nazwa = "Histogram/"+nazwa+".txt";
				
				System.out.println(nazwa);
				
				try {
						
						FileWriter histogram = new FileWriter(nazwa);
						
						return histogram;
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
						return null;
					}
				
			
			
			
		}

		private String toSave()
		{
			
			String zapis = null;
			
				for(int i =0 ; i < DataStorage.x; i++)
					for(int j=0; j < DataStorage.y; j ++){
				{
				
					zapis+= " " + Integer.toString(DataStorage.Before[i][j]);
				
				}
					}
			
			return zapis;
		}
}
