package ConsoleApplication2;

import ConsoleApplication2.Program2;
import CS2JNet.System.StringSplitOptions;
import CS2JNet.System.StringSupport;

public class Program2   
{
    public static void main(String[] args) {
        Program2.SumOfArray4To4();
    }

    static void SumOfArray4To4() {
        String[][] array1 = new String[4, 4];
        int[][] array2 = new int[4, 4];
        String sLine;
        boolean bArraySizeisWrong = false;
        for (int i = 0;i < 4;i++)
        {
            System.out.println("Enter four numbers and press Enter");
            sLine = StringSupport.Trim(Console.ReadLine().toString());
            char[] delimiter1 = new char[]{ ' ' };
            String[] lineOfNumbers = StringSupport.Split(sLine, delimiter1, StringSplitOptions.RemoveEmptyEntries);
            if (lineOfNumbers.length != 4)
            {
                bArraySizeisWrong = true;
				throw new MyArraySizeException("Not correct quantity on numbers in array [4,4] in index row " + i);
                break;
            }
             
            for (int j = 0;j < 4;j++)
            {
                array1[i, j] = lineOfNumbers[j];
            }
        }
        int Sum = 0;
        boolean bAllInputsAreOK = true;
        if (!bArraySizeisWrong)
        {
            for (int i = 0;i < 4;i++)
            {
                for (int j = 0;j < 4;j++)
                {
					try
					{
						array2[i, j] = Convert.ToInt32(array1[i, j]);
                        Sum += array2[i, j];
					}
					catch(Exception e) {
						throw new MyArrayDataException("Not correct quantity on numbers in array [4,4] in index row " + i+ " "+e.GetMessage());
						bAllInputsAreOK = false;
                        break;
					} 
                }
            }
            if (bAllInputsAreOK)
                System.out.println("Total Sum is " + String.valueOf(Sum));           
        }
         
    }

}


