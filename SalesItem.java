import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class represents sales items on an online e-commerce site (such as Amazon.com).
 * SalesItem objects store all information relevant to this item, including description,
 * price, customer comments, etc.
 * 
 * NOTE: The current version is incomplete! Currently, only code dealing with customer 
 * comments is here.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1 (2016.02.29)
 */
public class SalesItem
{
    private String name;
    private int price;  // in cents
    private ArrayList<Comment> comments;
    private Comment comment, comment1;
    
    /**
     * Create a new sales item.
     */
    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        comments = new ArrayList<>();
        comment = new Comment("Guy", "Good", 3);
        comment1 = new Comment("Girl", "Good", 4);
    }

    /**
     * Return the name of this item.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the price of this item.
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Return the number of customer comments for this item.
     */
    public int getNumberOfComments()
    {
        return comments.size();
    }
    
    /**
     * Add a comment to the comment list of this sales item. Return true if successful;
     * false if the comment was rejected.
     * 
     * The comment will be rejected if the same author has already left a comment, or
     * if the rating is invalid. Valid ratings are numbers between 1 and 5 (inclusive).
     */
    public boolean addComment(String author, String text, int rating)
    {
        if(ratingInvalid(rating)) {  // reject invalid ratings
            return false;
        }
        
        if(findCommentByAuthor(author) != null) {  // reject mutiple comments by same author
           return false;
        }
        
        comments.add(new Comment(author, text, rating));
        return true;
    }
    
    /**
     * Remove the comment stored at the index given. If the index is invalid, do nothing.
     */
    public void removeComment(int index)
    {
        if(index >=0 && index < comments.size()) { // if index is valid
            comments.remove(index);
        }
    }
    
    /**
     * Upvote the comment at 'index'. That is: count this comment as more helpful.
     * If the index is invalid, do nothing.
     */
    public void upvoteComment(int index)
    {
        if(index >=0 && index < comments.size()) { // if index is valid
            comments.get(index).upvote();
        }
    }
    
    /**
     * Downvote the comment at 'index'. That is: count this comment as less helpful.
     * If the index is invalid, do nothing.
     */
    public void downvoteComment(int index)
    {
        if(index >=0 && index < comments.size()) { // if index is valid
            comments.get(index).downvote();
        }
    }
    
    /**
     * Show all comments on screen. (Currently, for testing purposes: print to the terminal.
     * Modify later for web display.)
     */
    public void showInfo()
    {
        System.out.println("*** " + name + " ***");
        System.out.println("Price: " + priceString(price));
        System.out.println();
        System.out.println("Customer comments:");
        int i = 0;
        while (i < comments.size()) { //Q21 Replaced for-each loop with while loop
            System.out.println("-----------------");
            System.out.println(comments.get(i).getFullDetails());
            i++;
        }
        System.out.println();
        System.out.println("===========================================");
    }
    
    /**
     * Return the most helpful comment. The most useful comment is the one with the highest vote
     * balance. If there are multiple comments with equal highest balance, return any one of
     * them.
     */
    public Comment findMostHelpfulComment()
    { //Q29,30
      if (comments.isEmpty()) {
            return null; 
        }
      // Step 1: Find the highest vote count
      int highestVote = 0;
      for (Comment comment : comments) {
        if (comment.getVoteCount() > highestVote) {
            highestVote = comment.getVoteCount();
        }
      }

      // Step 2: Count how many comments have this highest vote count
      Comment best = null;
      int count = 0;
      for (Comment comment : comments) {
        if (comment.getVoteCount() == highestVote) {
            best = comment;
            count++;
        }
       }

      // Step 3: If more than one comment has the highest vote, return null
      if (count > 1) {
        return null;
      }

      return best;  //  Return the most helpful comment 
   }
    
    // Q10
    /**
     * Check whether the given rating is invalid. Return true if it is invalid.
     * Valid ratings are in the range [1..5].
     */
    private boolean ratingInvalid(int rating)
    {
        return rating < 1|| rating > 5;
    }
    
    /**
     * Find the comment by the author with the given name.
     * 
     * @return The comment if it exists; null if it doesn't.
     */
    private Comment findCommentByAuthor(String author)
    {
        int i = 0;
        while (i < comments.size()) {//Q21 Replaced for-each loop with while loop
            if (comments.get(i).getAuthor().equals(author)) {
                return comments.get(i);
            }
            i++;
        }
        return null;
    }
    
    /**
     * For a price given as an int, return a readable String representing the same price.
     * The price is given in whole cents. For example for price==12345, the following String
     * is returned: $123.45
     */
    private String priceString(int price)
    {
        int dollars = price / 100;
        int cents = price - (dollars*100);
        if(cents <= 9) {
            return "$" + dollars + ".0" + cents;  // include zero padding if necessary
        }
        else {
            return "$" + dollars + "." + cents;
        }
    }
}
