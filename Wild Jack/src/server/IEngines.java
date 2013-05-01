package server;
/**
 * Interfejs silnika gry, dziêki niemu gra bêdzie kompatybilna<br> 
 * z implementacj¹ jakiejkolwiek gry karcianej opartej na systemie<br>
 * dwóch stosów: stosu g³ownego(odkryte karty na stole) oraz<br> 
 * stosu podrzêdnego(stos kart nieodkrytych).<br>
 * ID oznacza identyfikator danego gracza.<br>
 * 
 * @author Misiek
 * @date 25.04.13
 */
public interface IEngines {

	//Czy moja tura?
	public boolean isMyTurn(int ID);
	
	public GAME getGameState();
	
	//Jakie s¹ moje karty?
	public LogicCard[] getMyCards(int ID);
	
	//Ile kart maj¹ przeciwnicy?
	public int[] getEnemyCards(int ID);
	
	//Przekazujê do serwera moje karty
	public boolean setMyCards(int ID, LogicCard[] cards);
	
	//Biorê kartê z g³ównego stosu
	public boolean getMainStack(int ID);
	
	public boolean getSecondStack(int ID);
}
