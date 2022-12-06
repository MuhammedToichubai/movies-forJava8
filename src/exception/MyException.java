package exception;

public class MyException extends Exception{
    String massage;

    public MyException(){

    }

    public MyException(String massage) {
        this.massage = massage;
    }

}
