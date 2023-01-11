import java.util.ArrayList;

public class ArrayLists {
    public static void main(String [] args) {
        //-arrays have a limitation because their lengths have to be preset and
        //can't change
        //ArrayLists are similar to arrays, but the size can change dynamically
        //-while a program is running, you can add and remove objects from an
        //ArrayList
        //-ArrayLists can only hold objects, and not primitives (int, double, boolean)

        //declare and instantiate an empty ArrayList that holds Strings
        ArrayList<String> words = new ArrayList<String> ();

        //general format:
        //ArrayList<type> varName = new ArrayList<type> ();

        words.add("apple");
        words.add("banana");
        words.add("orange");

        //.size() instead of length
        for (int i = 0; i < words.size(); i++) {
            //.get() returns the object at the provided index
            System.out.println(words.get(i));
        }

        //same thing with for-each loop
        for (String word: words) {
            System.out.println(word);
        }

        //overloaded add method inserts the object into the specified index
        words.add(1, "mango");

        //can directly print out ArrayList
        System.out.println(words);

        //to change a value
        words.set(2, "grape");
        System.out.println(words);

        //remove orange - at index 3
        words.remove(3);
        System.out.println(words);

        words.add("melon");
        words.add("kiwi");
        System.out.println(words);


        //write code with a loop to remove all values from words
        //test by printing size of words and any remaining values after the loop

//        for (int i = 0; i < words.size(); i++)
//            words.remove(i);
//        System.out.println(words.size() + ": " + words);

        //as items are removed, the indices of the remaining items get updated so that
        //they're always 0 to size-1

        //if you remove from the end (right side), there aren't any items further to
        //the right to worry about shifting indices
//        for(int i = words.size()-1; i >= 0; i--)
//            words.remove(i);
//        System.out.println(words.size() + ": " + words);

        //keep removing from index 0 because there's always a value at that index as long
        //as there's something in the list
        //-save the initial size to remove the correct quantity of items
        int size = words.size();
        for (int i = 0; i < size; i++) {
            words.remove(0);
        }
        System.out.println(words.size() + ": " + words);

        //there IS an arraylist clear method, but it's not on the reference sheet
        //-better to practice with the remove method

        System.out.println();

        Deck d = new Deck();
        BlackJackPlayer b = new BlackJackPlayer("sasquatch");

        //add the top two cards from the deck
        //into the blackjackplayer's hand
        Card c1 = d.draw();
        b.addCard(c1);

        //d.draw() returns a Card object,
        //which can be directly passed to
        //b.addCard()
        b.addCard(d.draw());

        b.clearHand();

        Card c = new Card("spades", 1);
        b.addCard(c);
        b.addCard(c);

        Card c2 = new Card("spades", 12);
//        b.addCard(c2);
//        b.addCard(c2);

        //check the cards in the hand
        System.out.println(b);



    }
}
