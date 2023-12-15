package controllers;

import graphics.MotusGameFrameUtil;


public class Tab  {

	public static void initTabVerification() {
		
		MotusVariable.TabVerification=new int[7][MotusVariable.nbLettre];
		MotusVariable.TabVerificationInit=new int[7][MotusVariable.nbLettre];
		for (int i = 0; i < 7; i++) {
	        for (int j = 0; j < MotusVariable.nbLettre; j++) {
	        	MotusVariable.TabVerification[i][j] = -1;
	        	MotusVariable.TabVerificationInit[i][j] = -1;
	        }
	    }			
		int coord1=GameControlsBegin.setCoord1();
		int coord2=GameControlsBegin.setCoord2();
			
		MotusVariable.TabVerification[0][coord1]=2;
		MotusVariable.TabVerification[0][coord2]=2;
		MotusVariable.TabVerificationInit[0][coord1]=2;
		MotusVariable.TabVerificationInit[0][coord2]=2;

	}
	public static void initTabVerification2ndplayer() {
		
		MotusVariable.TabVerification=new int[7][MotusVariable.nbLettre];

		for (int i = 0; i < 7; i++) {
	        for (int j = 0; j < MotusVariable.nbLettre; j++) {
	        	MotusVariable.TabVerification[i][j] = MotusVariable.TabVerificationInit[i][j];
	        }
	    }			
	}
	
	
	public static void initTabInput() {
		MotusVariable.TabInput=new char[7][MotusVariable.nbLettre];
		MotusVariable.TabInput[0]=(MotusVariable.motAtrouver).toCharArray();
	}
	
	public static void modifTabVerification() {
		int[] position =GamesControls.setPositionInt();
		int tmp=0;
		for (int i = 0; i < MotusVariable.nbLettre; i++) {
			if (position[i]==2) {
				tmp++;
			}
		}
        if (MotusVariable.nbEssai<7 && tmp < MotusVariable.nbLettre)  {
        	for (int i = 0; i < MotusVariable.nbLettre; i++) {
    			if ((MotusVariable.TabVerification[MotusVariable.nbEssai-1][i]==2)||(position[i]==2)) {
    				MotusVariable.TabVerification[MotusVariable.nbEssai][i]=2;
    			}
    		}   	
        }
		MotusVariable.TabVerification[MotusVariable.nbEssai-1]=position;
	}
	
	public static void modifTabInput() {	
		MotusVariable.TabInput[MotusVariable.nbEssai-1]=(MotusVariable.userInput).toCharArray();
		if (MotusVariable.nbEssai<7 && MotusGameFrameUtil.motbon()==1) {
			MotusVariable.TabInput[MotusVariable.nbEssai]=(MotusVariable.motAtrouver).toCharArray();
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	