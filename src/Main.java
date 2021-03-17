/*
 * Akshay Patel
 * 
 * CS 280
 * 
 * Recursive Descent Parsing
 * Consider the following BNF grammar:
		
		A -> I = E
		E -> P O P | P
		O -> + | - | * | / | **
		P -> I | L | UI | UL | (E)
		U -> + | - | !
		I -> C | CI
		C -> a | b | ... | y | z
		L -> D | DL
		D -> 0 | 1 | ... | 8 | 9
 * 
 */

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.String;

public class Main {
	
	
	//string from file

	public static String K = "";

	public static int i;

	
	//main function
public static void main(String[] args)
{
	
	
	//initalize for file

	String f_N = "input.txt";

	String l_t;

	File in = new File("input.txt");
    File out = new File("output.txt");

	try (Scanner scan = new Scanner(in);
	         PrintWriter pw = new PrintWriter(new FileWriter(out, true)))
	{

		FileReader fr = new FileReader(f_N);

		BufferedReader br = new BufferedReader(fr);

	while((l_t = br.readLine()) != null)
	{

		K = l_t;

		i=0;

		System.out.println("Input from file :" + l_t);

		if(GR_A ())
		{

			System.out.println("The string \"" + l_t + "\" is in the language.\n");
			
			pw.println(("The string \"" + l_t + "\" is in the language.\n"));
		}

		else
		{

			System.out.println("The string \"" + l_t + "\" is not in the language.\n");
			
			pw.println("The string \"" + l_t + "\" is not in the language.\n");
		}

	}

	br.close();

	}

	catch(IOException ex)
	{

	System.out.println("ERROR!!!\nFILE NOT FOUND.");

	}

}//End Main

		
private static boolean GR_A()
{

		if (GR_I())
		{

			if(i<K.length() && (K.charAt(i) == '='))
			{

				i++;

				if(GR_E ())
				{

					return true;

				}

			}

		}

		else if(GR_E())
		{

			return true;

		}

	return false;

}
	

private static boolean GR_E()
{

	if (GR_P())
	{

		if (GR_O ())
		{

			if (GR_P())
			{

				return true;

			}

		}

	}

	else if (GR_P())
	{

		return true;

	}

	return false;

}

private static boolean GR_O()
{

	if(i<K.length() && (K.charAt(i) == '+'))
	{

		i++;

		return true;

	}

	else if(i<K.length() && (K.charAt(i) == '-'))
	{

		i++;

		return true;

	}

	else if(i<K.length() && (K.charAt(i) == '/'))
	{

		i++;

		return true;

	}
	

	else if(i<K.length() && (K.charAt(i) == '*'))
	{

		i++;

		if(i<K.length() && (K.charAt(i) == '*'))
		{

			i++;

			return true;

		}

		return true;

	}

	return false;

}

private static boolean GR_P()
{

	if(GR_I())
	{

		return true;

	}

	else if(GR_L())
	{

		return true;

	}

	else if(GR_U() && GR_I())
	{

		return true;

	}

	else if(GR_U() && GR_L())
	{

		return true;

	}

	else if(i<K.length() && (K.charAt(i) == '('))
	{

		i++;

		if(GR_E())
		{

			if(i<K.length() && (K.charAt(i) == ')'))
			{

				i++;

				return true;

			}

		}

	}

	return false;

}

private static boolean GR_U()
{

	if(i<K.length() && (K.charAt(i) == '+' || K.charAt(i) == '-' || K.charAt(i)	== '!'))
	{

		i++;

		return true;

	}

	return false;

}

private static boolean GR_I()
{

	if(GR_C())
	{

		return true;

	}

	else if(GR_C() && GR_I())
	{

		return true;

	}

	return false;

}

private static boolean GR_C()
{

	if(i<K.length() && (K.charAt(i) >= 'a' && K.charAt(i) <= 'z'))
	{

		i++;

		return true;

	}

	return false;

}

private static boolean GR_L ()
{
	if(GR_D())
	{

		return true;

	}

	else if(GR_D() && GR_L())
	{

		return true;

	}

	return false;

}

private static boolean GR_D()
{

	if(i < K.length() && (K.charAt(i) >= '0' && K.charAt(i) <= '9'))
//	if(i < K.length() && Character.isDigit(K.charAt(i)))
	{

		i++;

		return true;

	}

	return false;

}

	

}//End Class
