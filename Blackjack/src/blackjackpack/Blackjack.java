package blackjackpack;

import java.awt.*;
import java.awt.event.*; //Import event libraries
import javax.swing.*;

class blackjackWindo extends JFrame implements ActionListener {
	// Window components used by other method must be declared
	// as class variables

	int drawcounter;
	int counter;
	static String Stringcard = Drawcard();
	JLabel textLabel = new JLabel("Your Total =");
	JLabel textLabel3 = new JLabel("Your cards are:");
	JLabel textLabel2 = new JLabel("Dealer's Total =");
	JLabel textLabel4 = new JLabel("Dealer cards are: ");
	JLabel textLabel5 = new JLabel(" ");
	JLabel textLabel6 = new JLabel(" ");
	JLabel drawcount = new JLabel("Total draws =" + drawcounter);
	JLabel player = new JLabel("0");
	JLabel player1 = new JLabel("");
	JLabel player2 = new JLabel("");
	JLabel player3 = new JLabel("");
	JLabel player4 = new JLabel("");
	JLabel player5 = new JLabel("");
	JLabel player6 = new JLabel("");
	JLabel player7 = new JLabel("");
	JLabel player8 = new JLabel("");
	JLabel player9 = new JLabel("");
	JLabel player10 = new JLabel("");
	JLabel dealer = new JLabel("0");
	JButton drawButton = new JButton("Draw");
	JButton standButton = new JButton("Stand");
	JButton newButton = new JButton("New Game");
	JPanel bank = new JPanel(new GridLayout(1, 2, 5, 10));
	JPanel plyr = new JPanel(new GridLayout(3, 2, 7, 10));
	JPanel cards = new JPanel(new GridLayout(3, 2, 7, 10));

	int playerTotal = 0, dealerTotal = 0;

	public blackjackWindo() {
		super("Simple BlackJack");
		setSize(450, 230);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Container contentArea = getContentPane();
		contentArea.setBackground(Color.white);

		drawButton.addActionListener(this);
		standButton.addActionListener(this);
		newButton.addActionListener(this);
		// Add an event listener to buttons
		contentArea.add("North", plyr);
		contentArea.add("South", bank);
		contentArea.add("Center", cards);

		cards.add(textLabel);
		cards.add(player);
		cards.add(textLabel3);
		cards.add(player1);
		cards.add(player2);
		cards.add(player3);
		cards.add(player4);
		cards.add(player5);

		plyr.add(textLabel2);
		plyr.add(dealer);
		plyr.add(textLabel4);
		plyr.add(player6);
		plyr.add(player7);
		plyr.add(player8);
		plyr.add(player9);

		bank.add(drawButton);
		bank.add(standButton);
		bank.add(newButton);
		bank.add(drawcount);
		standButton.setEnabled(false);

		setContentPane(contentArea);
	}

	public void actionPerformed(ActionEvent event) {
		int card;
		
		if (event.getSource() == drawButton) {
			standButton.setEnabled(true);
			drawcounter++;
			drawcount.setText("Total Draws =" + drawcounter);
			if (playerTotal < 22) {

				Stringcard = Drawcard();
				card = carddraw();
				if (playerTotal > 10 && card ==11){
					card = 1;
				}

				playerTotal += card;
				

				if (playerTotal < 22) {
					player.setText("" + playerTotal);
				} else {
					player.setText(" Bust ");
					standButton.setEnabled(false);
					drawButton.setEnabled(false);
				}
				if (drawcounter == 1) {
					player1.setText("    " + Stringcard);
				}
				if (drawcounter == 2) {
					player2.setText("    " + Stringcard);
				}
				if (drawcounter == 3) {
					player3.setText("    " + Stringcard);
				}
				if (drawcounter == 4) {
					player4.setText("    " + Stringcard);
				}

			}
		}
		
		if (event.getSource() == standButton) {
			// Code here will be executed when standButton is pressed
			drawButton.setEnabled(false);
			while (dealerTotal < 16) {
				counter++;
				Stringcard = Drawcard();
				card = carddraw();
				if (playerTotal > 10 && card ==11){
					card = 1;
				}
				dealerTotal += card;
				if (counter == 1) {
					player6.setText(Stringcard);
				} else if (counter == 2) {
					player7.setText(Stringcard);
				}
				else if (counter == 3) {
					player8.setText(Stringcard);
				}
				else if (counter == 4) {
					player9.setText(Stringcard);
				}

			}
			
			if (dealerTotal < 22) {
				dealer.setText("" + dealerTotal);
				if (playerTotal < dealerTotal)
					player.setText(playerTotal + " ,You Lose!!! ");
				else if (playerTotal == dealerTotal) {
					player.setText(playerTotal + " Draw :(");
				} else if (playerTotal > dealerTotal) {
					player.setText(playerTotal + " ,You Win!!! ");
				}
			} else {
				dealer.setText("Bust " + dealerTotal);
				player.setText(playerTotal + " ,You Win!!! ");
			}

		}

		if (event.getSource() == newButton) {
			System.out.println("");
			// Code here will be executed when newButton is pressed
			playerTotal = 0;
			dealerTotal = 0;
			dealer.setText("" + dealerTotal);
			player.setText("" + playerTotal);
			player1.setText("");
			player2.setText("");
			player3.setText("");
			player4.setText("");
			player5.setText("");
			player6.setText("");
			player7.setText("");
			player8.setText("");
			player9.setText("");
			player10.setText("");

			drawcounter = 0;
			drawcount.setText("Total Draws =" + drawcounter);
			drawButton.setEnabled(true);
			standButton.setEnabled(false);
			counter = 0;

		}
	}

	public static String Drawcard() {
		String Stringcard = "";

		int card = (int) RandomNumbers.GetRandom(13);

		if (card == 11) {
			Stringcard = "J";
		} else if (card == 12) {
			Stringcard = "Q";
		}

		else if (card == 13) {
			Stringcard = "K";
		}

		else if (card == 1) {
			Stringcard = "A";
		} else if (card < 11 && card > 1) {
			Stringcard = String.valueOf(card);
		}

		return Stringcard;

	}

	public static int carddraw() {

		int intcard = 0;
		if (Stringcard == "K") {

			intcard = 10;
		}

		else if (Stringcard == "Q") {

			intcard = 10;
		}

		else if (Stringcard == "J") {

			intcard = 10;
		}

		else if (Stringcard == "A") {

			intcard = 11;
		} else {
			intcard = Integer.valueOf(Stringcard);
		}

		return intcard;
	}
}

public class Blackjack {
	public static void main(String[] args) {
		blackjackWindo Win = new blackjackWindo();

	}
}
