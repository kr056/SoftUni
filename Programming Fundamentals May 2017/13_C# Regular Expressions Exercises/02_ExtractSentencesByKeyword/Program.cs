using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _02_ExtractSentencesByKeyword
{
    class Program
    {
        static void Main(string[] args)
        {

            var separtors = new char[] { '.', '!', '?' };
            var key = Console.ReadLine();
            var input = Console.ReadLine().Split(separtors);

            var pattern = $@"\b{key}\b";

            for (int i = 0; i < input.Length; i++)
            {
                if (Regex.IsMatch(input[i], pattern))
                {
                    Console.WriteLine(input[i]);
                }

            }

        }
    }
}
