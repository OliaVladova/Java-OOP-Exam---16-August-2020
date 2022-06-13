package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    ComputerManager computerManager;
    Computer computer;

    @Before
    public void setUp() {
        computer = new Computer("Acer", "Aspire 5", 1400);
        computerManager = new ComputerManager();
        computerManager.addComputer(computer);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionWhenTheCollectionIsModified() {
        computerManager.getComputers().clear();
    }
    @Test
    public void testShouldReturnSizeOfListCorrectly(){
        int count = computerManager.getCount();
        Assert.assertEquals(1,count);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldTrowExceptionWhenAddedComputerIsPresent(){
        Computer computerNew = new Computer("Acer", "Aspire 5", 1400);
        computerManager.addComputer(computerNew);
    }
    @Test
    public void testShouldRemoveComputerCorrectly(){
       Computer removed = computerManager.removeComputer("Acer", "Aspire 5");
       Assert.assertEquals(computer,removed);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldTrowExceptionWhenAComputerIsNotPresent(){
        computerManager.getComputer("HP", "Ultra");
    }
    @Test
    public void testShouldReturnAllComputerFromOneManufacturer(){
        Computer computerNew = new Computer("Acer", "Core i7", 2000);
        computerManager.addComputer(computerNew);
        List<Computer> computerTest = computerManager.getComputersByManufacturer("Acer");
        Assert.assertEquals(computer, computerTest.get(0));
    }


}