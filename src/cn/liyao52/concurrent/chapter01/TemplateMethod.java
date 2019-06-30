package cn.liyao52.concurrent.chapter01;

/**
 *  This is simple Template Method
 */
public class TemplateMethod {

    public final void print(String message){
        System.out.println("##################");
        wrapPrint(message);
        System.out.println("##################");

    }

    protected void wrapPrint(String message){

    }

    public static void main(String[] args) {
        new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }
        }.print("Hello Thread");

        new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        }.print("Hello Thread");

    }
}
