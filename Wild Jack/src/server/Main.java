package server;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Misiek
 * @date 25.04.13
 */
public class Main {

	public static void main(String[] args) {
		LinkedList<LogicCard> list = new LinkedList<LogicCard>();
		/*
		 * list.add(new LogicCard(VALUE._02, COLOR.Clubs)); list.add(new
		 * LogicCard(VALUE._03, COLOR.Clubs)); list.add(new LogicCard(VALUE._04,
		 * COLOR.Clubs)); list.add(new LogicCard(VALUE._05, COLOR.Clubs));
		 * list.add(new LogicCard(VALUE._06, COLOR.Clubs)); list.add(new
		 * LogicCard(VALUE._07, COLOR.Clubs)); list.add(new LogicCard(VALUE._08,
		 * COLOR.Clubs)); list.add(new LogicCard(VALUE._09, COLOR.Clubs));
		 * list.add(new LogicCard(VALUE._10, COLOR.Clubs)); list.add(new
		 * LogicCard(VALUE.Jack, COLOR.Clubs)); list.add(new
		 * LogicCard(VALUE.Queen, COLOR.Clubs)); list.add(new
		 * LogicCard(VALUE.King, COLOR.Clubs)); list.add(new
		 * LogicCard(VALUE.Ace, COLOR.Clubs));
		 * 
		 * list.add(new LogicCard(VALUE._02, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._03, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._04, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._05, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._06, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._07, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._08, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._09, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE._10, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE.Jack, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE.Queen, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE.King, COLOR.Diamonds)); list.add(new
		 * LogicCard(VALUE.Ace, COLOR.Diamonds));
		 * 
		 * list.add(new LogicCard(VALUE._02, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._03, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._04, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._05, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._06, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._07, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._08, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._09, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE._10, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE.Jack, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE.Queen, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE.King, COLOR.Hearths)); list.add(new
		 * LogicCard(VALUE.Ace, COLOR.Hearths));
		 * 
		 * list.add(new LogicCard(VALUE._10, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._03, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._04, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._05, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._06, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._07, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._08, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._09, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE._02, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE.Jack, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE.Queen, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE.King, COLOR.Spades)); list.add(new
		 * LogicCard(VALUE.Ace, COLOR.Spades));
		 */

		for (LogicCard i : list) {
			System.err.println(i.toString());
		}

		System.err.println("\nSortowanie");
		Collections.sort(list);

		System.out.println();
		for (LogicCard i : list) {
			System.out.println(i.toString());
		}
	}
}
