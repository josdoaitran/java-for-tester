package enumtt;

enum ColorEnum {
    RED("red"), GREEN("green"), BLUE("blue"), YELLOW("yellow");

    private String value;

    ColorEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
