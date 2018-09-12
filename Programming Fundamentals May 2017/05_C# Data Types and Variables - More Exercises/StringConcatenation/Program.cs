using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringConcatenation
{
    class Program
    {
        static void Main(string[] args)
        {

            char delimeter = char.Parse(Console.ReadLine());
            string type = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());
            string result = "";

            for (int i = 1; i <= n; i++)
            {
                string word = Console.ReadLine();
                if (type.Equals("even"))
                {
                    if (i % 2 == 0)
                    {
                        result += word;
                        result += delimeter;
                    }
                }
                else if (type.Equals("odd"))
                {
                    if (i % 2 != 0)
                    {
                        result += word;
                        result += delimeter;
                    }
                }

            }

            Console.WriteLine(result.Remove(result.Length - 1));

        }
    }
}
