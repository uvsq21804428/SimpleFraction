public class Main
{
    public static void main(String[] args){
        Fraction f = new Fraction(1, 2);
        assert "1.0/2.0".equals(f.toString()) : "Erreur, la fraction ne s'affiche pas correctement !";
    }
}