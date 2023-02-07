import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame {
    private Deck d;
    private Scanner s;
    private ArrayList<GoFishPlayer> players;
    private int handSize;

    public GoFishGame() {
        d = new Deck();
        players = new ArrayList<GoFishPlayer>();
        s = new Scanner(System.in);
        System.out.println("How many players?");
        int n = s.nextInt();
        s.nextLine();
        if (n < 4)
            handSize = 5;
        else
            handSize = 7;
        handSize = 25;
        for (int i = 0; i < n; i++) {
            System.out.println("Player name?");
            players.add(new GoFishPlayer(s.nextLine()));
        }
    }

    public void setupGame() {
        d.shuffle();
        for (int i = 0; i < handSize; i++)
            for (GoFishPlayer p: players)
                p.addCard(d.draw());
    }

    private void playerTurn(int playerID) {

        GoFishPlayer current = players.get(playerID);

        if (current.needNewCards())
            for (int i = 0; i < handSize; i++)
                if (d.getSize() > 0)
                    current.addCard(d.draw());

        if (! current.needNewCards()) {
            System.out.println(current.getName() + "'s turn");
            System.out.println();
            System.out.println(current);

            System.out.println("Who would you like to ask for cards from?");
            for (GoFishPlayer p : players)
                if (!p.getName().equals(current.getName()))
                    System.out.println(p.getName());
            String target = s.nextLine();
            int targetIndex = getNameIndex(target, current.getName());
            while (targetIndex == -1) {
                System.out.println("invalid player name");
                System.out.println("Who would you like to ask for cards from?");
                for (GoFishPlayer p : players)
                    if (!p.getName().equals(current.getName()))
                        System.out.println(p.getName());
                target = s.nextLine();
                targetIndex = getNameIndex(target, current.getName());
            }

            System.out.println("What card rank would you like to ask for?");
            String req = s.nextLine();
            while (!current.verifyRankRequest(req)) {
                System.out.println("Invalid request.");
                System.out.println("What card rank would you like to ask for?");
                req = s.nextLine();
            }

            ArrayList<Card> toTransfer = players.get(targetIndex).giveCards(req);
            if (toTransfer.size() > 0) {
                System.out.println("You got " + toTransfer.size() + " " + req + "s");
                for (Card c : toTransfer)
                    current.addCard(c);
                System.out.println("Go again!");
                playerTurn(playerID);
            }

            else {
                System.out.println("Go Fish!");
                if (d.getSize() > 0) {
                    Card newCard = d.draw();
                    System.out.println("You got a " + newCard.getRank());
                    current.addCard(newCard);

                    if (newCard.getRank().equals(req)) {
                        System.out.println("Go again!");
                        playerTurn(playerID);
                    }
                }
            }
        }
    }

    private int getNameIndex(String targetName, String selfName) {
        if (targetName.equals(selfName))
            return -1;
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getName().equals(targetName))
                return i;
        return -1;
    }

    public void playGame() {
        int currentPlayer = 0;
        while (!gameOver()) {
            System.out.println("Press enter for next player's turn");
            s.nextLine();
            playerTurn(currentPlayer);
            currentPlayer++;
            if (currentPlayer == players.size())
                currentPlayer = 0;
        }
    }

    private boolean gameOver() {
        int sets = 0;
        int hiScore = 0;
        String winner = "";
        for (GoFishPlayer p: players) {
            sets += p.getScore();
            if (p.getScore() > hiScore) {
                hiScore = p.getScore();
                winner = p.getName();
            }
            else if (p.getScore() == hiScore)
                winner += ", " + p.getName();
        }
        if (sets == 13) {
            System.out.println("Winner: " + winner);
            return true;
        }
        return false;
    }
}
