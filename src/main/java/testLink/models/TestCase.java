package testLink.models;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
public class TestCase {
    public String name = "New test case" + Integer.valueOf((int) (Math.random()*1000)).toString();
    public String details = "some summary";
    public String preconditions = "some preconditions";
}
