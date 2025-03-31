import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private SalesItem salesIte1;
    private Comment comment, comment1;
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        salesIte1 = new SalesItem("kimia", 1000);
        salesIte1.addComment("kimia", "good good ", 7);
        comment = new Comment("Guy", "Good", 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }
    
    //Q15
    public void testAddCommentSameAuthor()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(false, salesIte1.addComment("James Duckling", " hdhdh", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    //Q16
    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 0);
        assertEquals(true, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", 5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }

    
    //Q16
    @Test
    public void addComment()
    {
        assertEquals(2, salesIte1.addComment("kimia", "good", 2));
        assertEquals(5, salesIte1.addComment("kimia", "good good ", 5));
    }


    
    //-Q19
    @Test
    public void findMostHelpfulComment()
    {
        assertEquals(3, salesIte1.addComment("kim", "badbad", 3));
        java.lang.String string1 = comment.getFullDetails();
        assertEquals(3, string1);
        assertEquals(3, comment.getAuthor());
        assertNull(comment.getAuthor());
    }
    
    //Q20
    @Test
    public void testWorksCorrrectly()
    {
        assertEquals(4, salesIte1.addComment("kim", "", 4));
        assertEquals(3, salesIte1.getPrice());
        java.lang.String string1 = comment.getFullDetails();
        assertEquals(3, string1);
    }
}









