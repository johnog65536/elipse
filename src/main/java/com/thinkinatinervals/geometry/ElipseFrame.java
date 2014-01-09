package com.thinkinatinervals.geometry;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class ElipseFrame {

	private static Logger logger = Logger.getLogger(ElipseFrame.class);

	public static void main(String[] args){
		logger.debug("Initialising");
		
		try{
			
			ElipseFrame f = new ElipseFrame();
			f.go();
			
		} catch (Exception e){
			logger.error("Something went wrong!", e);
		}
		
		logger.debug("Done");
	}
    
	final static int canvasWidth=500;
	private int canvasHeight=0;
	private final int PAD=20;
	
	private void go(){     
        JFrame f = new JFrame("Elipse v0.1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ElipsePanel elipsePanel=new ElipsePanel(canvasWidth,PAD);        
        f.add(elipsePanel);
        
        canvasHeight=elipsePanel.getCanvasHeight();
        logger.debug("Canvas Height="+canvasHeight);
        f.setSize(canvasWidth+PAD, canvasHeight+PAD+PAD);
        
        f.setLocation(200, 200);
        f.setVisible(true);
	}
}
