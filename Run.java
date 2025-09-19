public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Johnny", 100);
        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }
    }
}
