package graphics;

import controllers.GameControlsBegin;
import controllers.GamesControls;


public class Tab  {
	
	

	public static void initTabVerification() {
		
		MotusVariable.TabVerification=new int[7][MotusVariable.nbLettre];

		
		for (int i = 0; i < 7; i++) {
	        for (int j = 0; j < MotusVariable.nbLettre; j++) {
	        	MotusVariable.TabVerification[i][j] = -1;
	        }
	    }
		
				
		MotusVariable.TabVerification[0][GameControlsBegin.setCoord1()]=2;
		MotusVariable.TabVerification[0][GameControlsBegin.setCoord2()]=2;
		
		MotusGameLeftPanel.afficherTableau(MotusVariable.TabVerification);
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	