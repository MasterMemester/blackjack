package blackjackpack;
public class DrawCard {
	static String Stringcard = Drawcard();

	public static void main(String[] args) throws java.io.IOException {

		int card = 0;
		int sum = 0;

		while (sum < 16) {
			Stringcard = Drawcard();
			card = carddraw();
			sum += card;

			System.out.print(" " + Stringcard + " ");
		}

		System.out.print("total= " + sum);
		if (sum > 21 && card == 11) {
			card = 1;
		} else if (sum > 21) {
			System.out.print(" bust ");
		}

	}

	public static String Drawcard() {
		String Stringcard = "";

		int card = (int) RandomNumbers.GetRandom(13);

		if (card == 11) {
			Stringcard = "J";
		} 
		else if (card == 12) {
			Stringcard = "Q";
		}

		else if (card == 13) {
			Stringcard = "K";
		}

		else if (card == 1) {
			Stringcard = "A";
		} 
		else if (card < 11 && card > 1) {
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
