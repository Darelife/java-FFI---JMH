public class InteropTest {
  static {
    System.loadLibrary("nativeLib"); // Load the C++ shared library
  }

  // Native method declaration
  public native int nativeAdd(int a, int b);

  // Regular Java method
  public int javaAdd(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    InteropTest test = new InteropTest();
    int a = 5, b = 10;

    System.out.println("Calling C++ function from Java: " + test.nativeAdd(a, b));
    System.out.println("Calling Java function: " + test.javaAdd(a, b));
  }
}
