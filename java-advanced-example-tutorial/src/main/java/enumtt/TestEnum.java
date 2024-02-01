package enumtt;

public class TestEnum {

    public static void main(String[] args){
        System.out.println("Test People Enum: " + PeopleEnum.JOHN) ;

        System.out.println("Test Color enum");
//      How to get a value of enum
        ColorEnum color = ColorEnum.BLUE;
        System.out.println("We can get value of enum: " + color.getValue());
        System.out.println("We can get name of enum: " + color.name());

        System.out.println("List of all enum name and value ");
        for (ColorEnum colorEnum: ColorEnum.values()){
            System.out.println(colorEnum.name() + " has value: " +colorEnum.getValue());
        }
    }
}
