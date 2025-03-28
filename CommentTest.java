

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    private SalesItem salesIte1;

    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        salesIte1 = new SalesItem("ban", 1000);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    //Q18
    @Test
    public void checkRatings()
    {
        SalesItem salesIte2 = new SalesItem("kimia", 100);
        assertEquals(6, salesIte2.addComment("kimia", "good", 6));
        Comment comment1 = new Comment("kimia", "bad", 7);
        assertEquals(7, comment1.getRating());
        comment1.upvote();
        comment1.downvote();
    }
}



