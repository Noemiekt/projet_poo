package controllers;

public class MainGameControls{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameControlsBegin gamebegin;
		gamebegin = new GameControlsBegin();
		System.out.printf("L'indice de la lettre est : %d%n", gamebegin.lettre1);
		System.out.printf("L'indice de la lettre est : %d%n", gamebegin.lettre2);
		
		GamesControls game;
		game = new GamesControls();
		System.out.print("les indices de lettres bien positionnées sont : ");
		for (int i = 0; i < game.lettresBonPos.length; i++) {
		    System.out.print(game.lettresBonPos[i] + " ");
		}
		System.out.println();
		
		System.out.print("les indices de lettres bonnes mais mal positionnées sont : ");
		for (int i = 0; i < game.lettresMalPos.length; i++) {
		    System.out.print(game.lettresMalPos[i] + " ");
		}
		System.out.println();
	}

}
