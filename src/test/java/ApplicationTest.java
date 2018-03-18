import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class ApplicationTest {

    private List<Apple> apples;
    private int minWeightForHeavyApple = 100;


    @Before
    public void setup() {
        apples = new ArrayList<Apple>() {{
            add(new Apple(0, "green", 80));
            add(new Apple(1, "green", 120));
            add(new Apple(2, "green", 150));
            add(new Apple(3, "red", 80));
            add(new Apple(4, "red", 120));
        }};
    }

    @After
    public void teardown() {
        apples = null;
    }

    @Test
    public void getGreenApples(){
        List<Apple> greenApples = apples.stream()
                .filter((Apple apple) -> "green".equals(apple.getColor()))
                .collect(Collectors.toList());

        Assert.assertEquals(3, greenApples.size());

        List expectedIds = Arrays.asList(0,2,1).stream().sorted().collect(Collectors.toList());
        List actualIds = greenApples.stream().map(Apple::getId).sorted().collect(Collectors.toList());

        Assert.assertEquals(expectedIds, actualIds);
    }

    @Test
    public void getHeavyApples(){
        List<Apple> heavyApples = apples.stream()
                .filter((Apple apple) -> minWeightForHeavyApple <= apple.getWeight())
                .collect(Collectors.toList());

        Assert.assertEquals(3, heavyApples.size());

        List expectedIds = Arrays.asList(4,1,2).stream().sorted().collect(Collectors.toList());
        List actualIds = heavyApples.stream().map(Apple::getId).sorted().collect(Collectors.toList());

        Assert.assertEquals(expectedIds, actualIds);

    }

    @Test
    public void getHeaviestGreenApple(){
        Apple heaviestGreenApple = apples.stream()
                .filter((Apple apple) -> "green".equals(apple.getColor()))
                .max((apple1, apple2) -> Integer.compare(apple1.getWeight(), apple2.getWeight()))
                .get();

        Assert.assertEquals(2, heaviestGreenApple.getId());

        int expectedId = 2;
        int actualId = heaviestGreenApple.getId();

        Assert.assertEquals(expectedId, actualId);

    }

}
