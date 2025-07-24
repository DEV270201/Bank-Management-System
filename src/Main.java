//1. you need to handle checked exceptions otherwise compiler will keep on throwing errors
//2. Use either throws or try{}catch{} to handle the errors
//3. Compiler wont force you to throw runtime errors but you should handle it otherwise you program execution will be interrupted
//4. when you place try{}finally{} -> finally will be executed even if you didn't handle the error (for runtime errors) but for compile time errors you need to handle it
//5. compiler will throw you an error if the catch block is trying to catch checked error even if it is not being thrown

public class Main {
    static void method1(int err) throws ClassNotFoundException{
        if(err == 3)
            throw new ClassNotFoundException();

        return;
    }

    static void method() {
        try{
          MyException m = new MyException("hello exception");
          String hello = m.getMessage();
            System.out.println(hello);
            m.printStackTrace();
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("hehehehe");
    }

    public static void main(String[] args) {
       method();
    }
}