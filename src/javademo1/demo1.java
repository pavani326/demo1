package javademo1;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.function.Predicate;

import java.util.function.Consumer;


public class demo1 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(12, 20, 35, 46, 55, 68, 75);
        // consumer
        /* Consumer<Integer> c =new Consumer<Integer> ()
        {
        public void accept(Integer i)
        {
               System.out.println(i);
        }
        }; */
        // functional interface
       /* values.forEach(
                (i) ->
        {
            System.out.println(i);
        }
        ); */
        // lambda
        // values.forEach(i -> System.out.println(i));
        //method reference
        //  values.forEach(System.out::println) ;

        // method reference 2
     /*   values.forEach(demo1::doubleit);
    }
    public static void doubleit(int i ) {
        System.out.println(i * 2);
        */
        // map reduce
       /*
        int result = 0;
        for(int i : values) {
        result = result + i * 2;
        }
        System.out.println(values.stream().map(i -> i*2).reduce(0,(c,e) -> c+e));
         */

        //mapreduce in another way with binary interface
/*

        Stream s = values.stream();

        Stream s1 = s.map( new Function<Integer, Integer> ()

        {
            public Integer apply(Integer i)
            {
                return i*2;
            }
        });
        Integer result = (Integer)s1.reduce(0,new BinaryOperator<Integer>()
        {
            public Integer apply(Integer i , Integer j )
            {
                return i+j;
            }
        });
        System.out.println(result);;
        }
    }
*/

//binary operator using lambda
       /*
        Integer result = values.stream().map(i -> i * 2).reduce(0, (c, e) -> c + e);
        System.out.println(result);;

        */
        //sum method using stream api
        //   System.out.println(values.stream().map(i -> i * 2).reduce(0, Integer::sum));;

        // stream api reduce (interface predicate)

      /*  Predicate<Integer> p = new Predicate<Integer>()
        {
            public boolean test(Integer i)
            {
                return i % 5 == 0;
            }
        }  ;
        System.out.println(values.stream()
                .filter(p)
                .reduce(0,(c,e) -> c+e));
                */

        //find first or else function
        /*
        System.out.println(values.stream()
                .filter(i -> i % 5 == 0)
                .map(i -> i*2)
                .findFirst()
                .orElse(0));
                */

        //lazy evaluation

        System.out.println(values.stream()
                .filter(demo1::isDivisible)
                .map(demo1::mapDouble)
                .findFirst()
                .orElse(0));
    }
    public static boolean isDivisible(int i)

        {
            System.out.println("in isDvs" + i);
            return i % 5 == 0;
        }
        public static int mapDouble(int i)
        {
            System.out.println("in mapdouble" + i);
            return i*2;
        }

    }

