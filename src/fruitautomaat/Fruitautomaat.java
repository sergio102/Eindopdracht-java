package fruitautomaat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;



@SuppressWarnings("serial")
public class Fruitautomaat extends Applet {

Button speelbutton;
Button kredietbutton;
int	krediet;
int punten;
Image[] fotos = new Image[20];
int een = (int)(Math.random() * 20);
int	twee = (int)(Math.random() * 20);
int drie = (int)(Math.random() * 20);

public void init() {
	setSize(320, 300);
	
	//welke fotos
	for(int i = 0; i < 20; i++) {
		fotos[i] = getImage(getCodeBase(), "fruit_" + (i+1) + ".jpg");
	}
	//speelknop
	speelbutton = new Button("Speel");
	SpeelKnopLuisteraar skl = new SpeelKnopLuisteraar();
	speelbutton.addActionListener(skl);
	add(speelbutton);
    //krediet knop
    kredietbutton = new Button("Koop 10 kredietpunten");
    add(kredietbutton);
    KredietKnopLuisteraar kkl = new KredietKnopLuisteraar();
	kredietbutton.addActionListener(kkl);
    krediet= 10;
    kredietbutton.setEnabled(false);	
	
}
	
public void paint(Graphics g) {	
	
	//krediet text
	g.drawString("Krediet: " + krediet, 50, 230 );	
	if(een == twee && twee == drie) {
		g.drawString("20 punten gewonnen", 160, 300);
		}
		if(een == twee || twee == drie || drie == een) {
		g.drawString("4 punten gewonnen", 10, 300);
		}
	// random fotos krijgen
	g.drawImage(fotos[een], 50, 40, this);
	g.drawImage(fotos[twee], 122, 40, this);
	g.drawImage(fotos[drie], 193, 40, this);	
}
	//speel knop luisteraar
	class SpeelKnopLuisteraar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			een = (int)(Math.random() * 20);
			twee = (int)(Math.random() * 20);
			drie = (int)(Math.random() * 20);
			if(krediet == 1) {
				kredietbutton.setEnabled(true);	
				speelbutton.setEnabled(false);	
				krediet--;
			}
			else {krediet--;}
			if(een == twee && twee == drie) {
				krediet += 20; 
				}
				if(een == twee || twee == drie || drie == een) {
				krediet += 4;
				}
			repaint();
		}
	}
	
	
	
	// kredietknop luisteraar
	class KredietKnopLuisteraar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(krediet == 0) {
				kredietbutton.setEnabled(false);	
				speelbutton.setEnabled(true);
			}
			krediet = 10;
		    repaint();
		}
	}

	

}






	
	
	
	
	
	
	
	
	
	
	
	
	
	

