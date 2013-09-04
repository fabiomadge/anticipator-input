import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.lang.Math;

public class Logic
{
	
	private Window w;

	public Logic(){
		w = new Window(this);
	}

	//1:southwest; 2:se; 3:ne; 4:nw
	public void update(double x, double y){
		try{
			PrintWriter writer1 = new PrintWriter("1", "UTF-8");
			writer1.println(intensity(x, 1-y));
			writer1.close();
		}
		catch(FileNotFoundException e){}
		catch(UnsupportedEncodingException e){}
		try{
			PrintWriter writer2 = new PrintWriter("2", "UTF-8");
			writer2.println(intensity(1-x, 1-y));
			writer2.close();
		}
		catch(FileNotFoundException e){}
		catch(UnsupportedEncodingException e){}
		try{
			PrintWriter writer3 = new PrintWriter("3", "UTF-8");
			writer3.println(intensity(1-x, y));
			writer3.close();
		}
		catch(FileNotFoundException e){}
		catch(UnsupportedEncodingException e){}
		try{
			PrintWriter writer4 = new PrintWriter("4", "UTF-8");
			writer4.println(intensity(x, y));
			writer4.close();
		}
		catch(FileNotFoundException e){}
		catch(UnsupportedEncodingException e){}
	}

	public double intensity(double x, double y){
		double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2)); 
		//scale
		distance = distance / Math.sqrt(2);
		double intensity = 1-distance;

		return intensity;
	}
}