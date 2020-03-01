package test;

public class Test5 {

	public static void main(String[] args) {
		int[] a = {1, 2, 1};
		System.out.print(is121Array(a));
	}

	public static int is121Array(int[] a)
    {
        int is121 = 1;
        int fCount = 0, sCount = 0, twocount = 0;
        int precedingElement = 0;
        int changecount = 0;
        int beginElement = a[0];
        if (beginElement != 1) is121 = 0;
        for (int i = 0; i < a.length && is121 == 1; i++)
        {
            
            if (a[i] == 2)
                twocount++;

            if (precedingElement != a[i])
                changecount++;

            if (changecount == 1)
                if (a[i] == 1)
                    fCount++;
            if (changecount == 3)
                if (a[i] == 1)
                    sCount++;
            if (changecount > 3)
                is121 = 0;

            precedingElement = a[i];
        }
        if (twocount < 1)
            is121 = 0;
        if (fCount != sCount)
            is121 = 0;
        return is121;

    }
	
}
