package overloadingtt;

public class CalculationOverLoading {
    public Integer add(){
        return (1 + 10);
    }

    public Integer add(int a, int b){
        return (a + b);
    }

    public Integer add(int a, int b, int c){
        return (a + b + c);
    }

}
