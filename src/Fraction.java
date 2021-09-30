public class Fraction
{
    //attributs
    private int numerator;
    private int denominator;

    //constructeur
    public Fraction(int _numerator, int _denominator){
        numerator = _numerator;
        denominator = _denominator;
    }

    //methodes
    public String toString(){
        return numerator + "/" + denominator;
    }
}