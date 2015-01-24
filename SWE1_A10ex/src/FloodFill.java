//package at.jku.pervasive.swe14.UE12.recursion;

public class FloodFill {

	static int size = 20;
	static short image[][] = new short[size][size];	//image of size*size pixels
	static short borderColor = 0;	                //black color = border

	public static void floodFill (int x, int y, short color)
	{
		// check if pixel has to be colored
		if (image[x][y] == color || image[x][y] == borderColor) {

			return;
		}
		image[x][y] = color;

		// recursive calls
		// 2nd part in each of the 4 if-clauses: ok but not necessary -- 
		// will be checked anyway in the next recursion (anchor)
//		if  (y < (size-1) && image[x][y+1] != color) // top (i.e., above)
//			floodFill (x, y+1, color);
//
//		if  (y > 0 && image[x][y-1] != color) // bottom (i.e., below)
//			floodFill (x, y-1, color);
//
//		if  (x < (size-1) && image[x+1][y] != color) // right
//			floodFill (x+1, y, color);
//
//		if  (x > 0 && image[x-1][y] != color) // left
//			floodFill (x-1, y, color);
		
		if (y < size-1)
			floodFill (x, y+1, color);
		if (y > 0)
			floodFill (x, y-1, color);
		if (x < size-1)
			floodFill (x+1, y, color);
		if (x > 0)
			floodFill (x-1, y, color);		
	}


	public static void main (String[] args)
	{
		for (int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				image[i][j] = (short) 255; // color all pixels white
			}
			image[i][i] = (short) 0; // color the main diagonal in black (border)
		}

		floodFill(7, 1, (short) 127);	//fill the region with grey color

		// check - all cells below the main diagnoal should now be filled with color 127
		for (int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				System.out.print(image[i][j] + "  ");
			}	
			System.out.println();
		}
	}
}