using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int beginningofInterval = int.Parse(Console.ReadLine());
            int endofInterval = int.Parse(Console.ReadLine());
            int magicNumber = int.Parse(Console.ReadLine());

            int counter = 0;
            int tr = 0;

            for (int i = beginningofInterval; i <=endofInterval ; i++)
            {
                for (int j = beginningofInterval; j <=endofInterval; j++)
                {
                    counter++;
                    tr = i + j;
                    if ((i + j) == magicNumber)
                    {
                        Console.WriteLine($"Number found! {j} + {i} = {magicNumber}");
                        return;
                    }
                }
            }

            if ( tr != magicNumber)
            {
                Console.WriteLine($"{counter} combinations - neither equals {magicNumber}");
            }            

        }
    }
}
