
public class Fraction
{
	//attributs
	private float numerateur;
	private float denominateur;

	//constructeur
	public Fraction(float numerateur,float denominateur)
	{
		this.numerateur=numerateur;
		this.denominateur=denominateur;
	}

	public String toString ()
	{
		return numerateur +"/"+ denominateur;
	}
}
