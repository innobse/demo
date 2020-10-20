
public class Simple {

  private int a;
  private int b;

  public Simple(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public Simple() {
    this.a = 5;
    this.b = 6;
  }

  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }

  public void print() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
