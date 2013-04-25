package server;
/**
 * 
 * @author Misiek
 * @date 25.04.13
 */
public interface IEngines {

	//Czy moja tura?
	public boolean isMyTurn(int ID);
	
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
