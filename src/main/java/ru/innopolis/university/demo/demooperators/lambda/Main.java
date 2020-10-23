package ru.innopolis.university.demo.demooperators.lambda;

public class Main {

  public static void main(String[] args) {
//    demoEffFinal();

    MyStringModifier myStringModifier = new MyStringModifier();

    System.out.println(
        stringOp(
            myStringModifier::strReverse,
            "Hello, world!"
        )
    );
  }

  private static void demoEffFinal() {
    //  effectively final value
    int count = 5;

    //  Невалидная запись
//    count = 6;

    StringFunc intAdderLambda = (str) -> str + count;

    final StringFunc intAdderToString = new StringFunc() {
      @Override
      public String func(String str) {
        return str + count;
      }
    };
  }

  private static void demoMathodLink() {
    String str = "Hello, world!";

    //  1 способ
    StringFunc reverseUtilClass = new StringFunc() {
      @Override
      public String func(String str) {
        return new StringBuilder(str).reverse().toString();
      }
    };

    //  2 способ
    StringFunc reverseUtilLambda = (s) -> new StringBuilder(s).reverse().toString();

    //  3 способ
    System.out.println(
        stringOp(
            MyStringOps::strReverse,
            str
        )
    );
  }

  private static String stringOp(StringFunc sf, String input) {
    return sf.func(input);
  }
}
