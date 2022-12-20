package org.example;

import java.util.Random;
import java.util.function.*;

public class FIClass {
    public static boolean isOdd(int number) {
        Predicate<Integer> isOddPredicate = integer -> integer % 2 == 1;
        return isOddPredicate.test(number);
    }

    public static void generateNumber(int topBound) {
        Random random = new Random();
        Consumer<Integer> generateNumberConsumer = x -> System.out.print((x <= 0) ? 0 : random.nextInt(0, x));
        generateNumberConsumer.accept(topBound);
    }

    public static DAYS_OF_WEEK getDayOfWeek() {
        Supplier<DAYS_OF_WEEK> supplyMonday = () -> DAYS_OF_WEEK.MON;
        return supplyMonday.get();
    }

    public static long doubleToLong(double number) {
        Function<Double, Long> doubleToLongFunction = (x) -> {
            double fractionalPart = x % 1;
            double integralPart = x - fractionalPart;
            return (fractionalPart >= 0.4444444444444444444444444444444444444444444444444449) ? (long)(integralPart + 1) : (long)integralPart;
        };



        return doubleToLongFunction.apply(number);
    }

    public static int fibonacci(int number) {
        UnaryOperator<Integer> fibonacciUnaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return (integer == 0 ) ? 0 : (integer == 1) ? 1  : this.apply(integer - 1) + this.apply(integer - 2);
            }
        };
        return fibonacciUnaryOperator.apply(number);
    }

}

