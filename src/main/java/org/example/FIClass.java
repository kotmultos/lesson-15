package org.example;

import java.util.Random;
import java.util.function.*;

public class FIClass {
    public boolean isOdd(int number) {
        Predicate<Integer> isOddPredicate = integer -> integer % 2 == 1;
        return isOddPredicate.test(number);
    }

    public void generateNumber(int topBound) {
        Random random = new Random();
        Consumer<Integer> generateNumberConsumer = x -> System.out.println(random.nextInt(0, x));
    }

    public DAYS_OF_WEEK getDayOfWeek() {
        Supplier<DAYS_OF_WEEK> supplyMonday = () -> DAYS_OF_WEEK.MON;
        return supplyMonday.get();
    }

    public long doubleToLong(double number) {
        Function<Double, Long> doubleToLongFunction = (x -> Long.valueOf(x.longValue()));
        return doubleToLongFunction.apply(number);
    }

    public int fibonacci(int number) {
        UnaryOperator<Integer> fibonacciUnaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return (integer == 0 || integer == 1) ? 1 : this.apply(integer - 1) + integer;
            }
        };
        return fibonacciUnaryOperator.apply(number);
    }

}

