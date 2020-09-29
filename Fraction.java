
public class Fraction
{
	//attributs
	private int numerateur;
	private int denominateur;
	
	//constructeur
	public Fraction(int numerateur,int denominateur)
	{
		this.numerateur=numerateur;
		this.denominateur=denominateur;
	}
	
	public String toString ()
	{
		return "Numerateur = " + numerateur + "\nDenominateur = " + denominateur;
	}
}
