public class Fraction
{
    //attributs
    private float numerator;
    private float denominator;

    //constructeur
    public Fraction(float _numerator, float _denominator){
        numerator = _numerator;
        denominator = _denominator;
    }

    //methodes
    public String toString(){
        return numerator + "/" + denominator;
    }
}