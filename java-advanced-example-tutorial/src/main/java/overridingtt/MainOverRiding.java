package overridingtt;

public class MainOverRiding {

    public static void main(String[] args){
        Tiger tiger = new Tiger();
        tiger.eat();

        Dog dog = new Dog();
        dog.eat();
    }

    static class Animal{
        public String color = "brown";

        void eat(){
            System.out.println("Almost animal eats grass");
        }
    }

    static class Tiger extends  Animal{
         public String color = "white";

         @Override
         void eat(){
             System.out.println("Tiger eats meat");
         }
    }

    static class Dog extends  Animal{
        public String color = "white";

        void eat(){
            super.eat();
            System.out.println("Dog eats skeletal");
            super.eat();
        }
    }

}
