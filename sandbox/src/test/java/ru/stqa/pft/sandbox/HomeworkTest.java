package ru.stqa.pft.sandbox;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

     public class HomeworkTest {
    @Test
         public void testDistance() {
        Point point3 = new Point(34, 10);
        Point point4 = new Point(3, 25);
        double val = point3.distance(point4);
        System.out.println("Расстояние между двумя точками: " + val);
      Assertions.assertThat(val).isEqualTo(34.438350715445125);


    }
}
