package server;
/**
 * 
 * @author Misiek
 * @date 25.04.13
 */
public interface IEngines {

	//Czy moja tura?
	public boolean isMyTurn(int ID);
	
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
