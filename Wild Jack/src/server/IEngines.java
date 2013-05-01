package server;
/**
 * Interfejs silnika gry, dzi�ki niemu gra b�dzie kompatybilna<br> 
 * z implementacj� jakiejkolwiek gry karcianej opartej na systemie<br>
 * dw�ch stos�w: stosu g�ownego(odkryte karty na stole) oraz<br> 
 * stosu podrz�dnego(stos kart nieodkrytych).<br>
 * ID oznacza identyfikator danego gracza.<br>
 * 
 * @author Misiek
 * @date 25.04.13
 */
public interface IEngines {

	//Czy moja tura?
	public boolean isMyTurn(int ID);
	
	public GAME getGameState();
	
	//Jakie s� moje karty?
	public LogicCard[] getMyCards(int ID);
	
	//Ile kart maj� przeciwnicy?
	public int[] getEnemyCards(int ID);
	
	//Przekazuj� do serwera moje karty
	public boolean setMyCards(int ID, LogicCard[] cards);
	
	//Bior� kart� z g��wnego stosu
	public boolean getMainStack(int ID);
	
	public boolean getSecondStack(int ID);
}
