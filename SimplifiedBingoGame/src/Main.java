import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final int NUMBERS_PER_CARD = 20;
        final int MAX_NUMBER_RANGE = 90;

        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", NUMBERS_PER_CARD, MAX_NUMBER_RANGE));
        players.add(new Player("Bob", NUMBERS_PER_CARD, MAX_NUMBER_RANGE));
        players.add(new Player("Charlie", NUMBERS_PER_CARD, MAX_NUMBER_RANGE));
        players.add(new Player("Diana", NUMBERS_PER_CARD, MAX_NUMBER_RANGE));
        players.add(new Player("Ethan", NUMBERS_PER_CARD, MAX_NUMBER_RANGE));
        players.add(new Player("Fiona", NUMBERS_PER_CARD, MAX_NUMBER_RANGE));

        Dealer dealer = new Dealer(MAX_NUMBER_RANGE);

        System.out.println("--- Starting Simplified Bingo Game ---");
        System.out.println("Total Players: " + players.size());
        System.out.println("--------------------------------------");

        boolean gameOver = false;
        while (dealer.hasNumbersLeft() && !gameOver) {
            int drawnNumber = dealer.drawNumber();
            System.out.println("Dealer drew: " + drawnNumber);

            for (Player player : players) {
                player.checkNumber(drawnNumber);

                if (player.hasWon()) {
                    System.out.println("\nBINGO! We have a winner!");
                    System.out.println("Winner Name: " + player.getName());
                    System.out.println("Winning Card: " + player.getCard().getNumbers());
                    gameOver = true;
                    break;
                }
            }
        }

        if (!gameOver) {
            System.out.println("No one won this round. Better luck next time!");
        }
    }
}

class Dealer {
    private final List<Integer> bag;
    private int currentIndex = 0;

    public Dealer(int maxRange) {
        this.bag = new ArrayList<>();
        for (int i = 0; i <= maxRange; i++) {
            bag.add(i);
        }
        Collections.shuffle(bag);
    }

    public int drawNumber() {
        return bag.get(currentIndex++);
    }

    public boolean hasNumbersLeft() {
        return currentIndex < bag.size();
    }
}

class Player {
    private final String name;
    private final Card card;

    public Player(String name, int size, int range) {
        this.name = name;
        this.card = new Card(size, range);
    }

    public void checkNumber(int number) {
        card.markNumber(number);
    }

    public boolean hasWon() {
        return card.isComplete();
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }
}

class Card {
    private final Set<Integer> numbers;
    private final Set<Integer> matchedNumbers;
    private final int totalRequired;

    public Card(int size, int range) {
        this.totalRequired = size;
        this.numbers = new HashSet<>();
        this.matchedNumbers = new HashSet<>();

        Random random = new Random();
        while (numbers.size() < size) {
            numbers.add(random.nextInt(range + 1));
        }
    }

    public void markNumber(int number) {
        if (numbers.contains(number)) {
            matchedNumbers.add(number);
        }
    }

    public boolean isComplete() {
        return matchedNumbers.size() == totalRequired;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
