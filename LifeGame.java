package com.directv.skyapgweb.apgweb;

public class LifeGame {

	public LifeGame() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args)
    {
        int rows = 25, columns = 10;
 
        int[][] inputGrid = { 
        	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 0, 0, 0, 1, 0, 1, 0 },
            { 1, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
            { 1, 0, 1, 0, 1, 0, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 1, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
            { 1, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
            { 1, 1, 1, 1, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 0, 1, 0, 0 }
        };

        int nextGens = 1;
        int nextGrid[][] = inputGrid;
        while ( nextGens <= 5 ){
        	nextGrid = nextGeneration(nextGrid, nextGens++, rows, columns);
        }
        
        
    }
 
    static int[][] nextGeneration(int inputGrid[][], int run, int rows, int cols)
    {
        int[][] outputGrid = new int[rows][cols];
 
        for (int rowIndex = 1; rowIndex < rows - 1; rowIndex++)
        {
            for (int colIndex = 1; colIndex < cols - 1; colIndex++)
            {
                // sum of surrounding neighbors
                int sumOfSurroundingNbors = 0;
                for (int i = -1; i <= 1; i++) {
                	for (int j = -1; j <= 1; j++) {
                		sumOfSurroundingNbors += inputGrid[rowIndex + i][colIndex + j];
                	}
                }
                sumOfSurroundingNbors -= inputGrid[rowIndex][colIndex];
 
                //Rule is 0 if sum < 2 or > 3, and lives at 3 for next generation.
                if ((inputGrid[rowIndex][colIndex] == 1) && (sumOfSurroundingNbors < 2)) {
                	outputGrid[rowIndex][colIndex] = 0;
                } else if ((inputGrid[rowIndex][colIndex] == 1) && (sumOfSurroundingNbors > 3)) {
                	outputGrid[rowIndex][colIndex] = 0;
                } else if ((inputGrid[rowIndex][colIndex] == 0) && (sumOfSurroundingNbors == 3)) {
                	outputGrid[rowIndex][colIndex] = 1;
                } else {
                	outputGrid[rowIndex][colIndex] = inputGrid[rowIndex][colIndex];
                }
            }
        }
 
        System.out.println("Life Run # " + run);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
            	System.out.print(" " + outputGrid[i][j]);
            }
            System.out.println();
        }
        
        return outputGrid;
    }
}
