package org.example.rectangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Nested
    class Area {
        @Test
        void areaShouldBe_20_WhenLengthIs_5_AndBreadthIs_4() {
            Rectangle rectangle = new Rectangle(5, 4);

            double area = rectangle.area();

            assertEquals(20, area);
        }

        @Test
        void areaShouldBe_15_WhenLengthIs_5_AndBreadthIs_3() {
            Rectangle rectangle = new Rectangle(5, 3);

            double area = rectangle.area();

            assertEquals(15, area);
        }

        @Test
        void areaShouldBe_21_WhenLengthIs_7_AndBreadthIs_3() {
            Rectangle rectangle = new Rectangle(7, 3);

            double area = rectangle.area();

            assertEquals(21, area);
        }
    }

    @Nested
    class Perimeter {
        @Test
        void perimeterShouldBe_18_WhenLengthIs_5_AndBreadthIs_4() {
            Rectangle rectangle = new Rectangle(5, 4);

            double perimeter = rectangle.perimeter();

            assertEquals(18, perimeter);
        }

        @Test
        void perimeterShouldBe_16_WhenLengthIs_5_AndBreadthIs_3() {
            Rectangle rectangle = new Rectangle(5, 3);

            double perimeter = rectangle.perimeter();

            assertEquals(16, perimeter);
        }

        @Test
        void perimeterShouldBe_22_WhenLengthIs_8_AndBreadthIs_3() {
            Rectangle rectangle = new Rectangle(8, 3);

            double perimeter = rectangle.perimeter();

            assertEquals(22, perimeter);
        }
    }

    @Nested
    class Square {
        @Test
        void areaShouldBe_4_WhenSideIs_2() {
            Rectangle square = Rectangle.getSquare(2);

            double area = square.area();

            assertEquals(4, area);
        }
    }
}
