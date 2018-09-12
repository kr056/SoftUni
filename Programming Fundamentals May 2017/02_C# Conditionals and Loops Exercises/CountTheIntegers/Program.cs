using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CountTheIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = 0;
            int counter = 0;

            try
            {
                for (int i = 0; i < 100; i++)
                {
                    n = int.Parse(Console.ReadLine());
                    counter++;
                }            

            }
            catch (Exception)
            {
                Console.WriteLine(counter);
            }

        }
    }
}
