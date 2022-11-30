package org.example;

import java.util.Objects;
import java.util.function.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Predicate<Integer> isOdd = integer -> integer % 2 == 1;
        Predicate<Integer> isNegative = number -> number < 0;
        Predicate<Integer> isNotNull = number -> number == null;
        Predicate<Integer> isNotNull2 = Objects::isNull;

        System.out.println(isOdd.test(2));
        System.out.println(isOdd.test(3));
        System.out.println(isNegative.test(3));
        System.out.println(isNegative.test(-10));
        System.out.println(isNotNull.test(null));
        System.out.println(isNotNull.test(10));


        Cat cat = new Cat("Oleksandr", 20);
        Consumer<Cat> printCat = cat1 -> System.out.println(cat1.getName() + " : " + cat1.getAge() + " years");
        printCat.accept(cat);

        Consumer<Cat> printCat2 = cat1 -> System.out.println(cat1);
        Consumer<Cat> printCat3 = System.out::println;
        printCat2.accept(cat);
        printCat3.accept(cat);

        Supplier<IllegalArgumentException> supplier1 = () ->{ throw new IllegalArgumentException("exception"); };
//        Supplier<IllegalArgumentException> supplier2 = () ->{ new IllegalArgumentException("exception"); };
        Supplier<IllegalArgumentException> supplier3 = IllegalArgumentException::new;


//        IllegalArgumentException illegalArgumentException = supplier1.get();


        Function<Integer, String> function1 = (integer -> integer.toString());
        Function<Integer, String> function2 = (Object::toString);

        Function<Cat, Racoon> catToRacoon = cat1 -> new Racoon(cat1.getName(), cat1.getAge());
        Racoon racoon = catToRacoon.apply(cat);
        System.out.println(racoon);

        UnaryOperator<Double> squareRoot1 = x -> Math.sqrt(x);
        UnaryOperator<Double> squareRoot2 = Math::sqrt;
        System.out.println(squareRoot1.apply(4.0));
        System.out.println(squareRoot1.apply(-1.0));

        BinaryOperator<Integer> integerIntegerBinaryOperator = (a, b) -> {
            String tmp = a.toString() + b.toString();
            return Integer.valueOf(tmp);
        };

        System.out.println(integerIntegerBinaryOperator.apply(10, 50));



    }

    public void print(Predicate<Integer> predicate, Integer integer) {
        System.out.println(predicate.test(integer));
    }
}
