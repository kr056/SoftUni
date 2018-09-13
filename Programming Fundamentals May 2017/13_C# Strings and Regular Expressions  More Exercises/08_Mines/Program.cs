using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _08_Mines
{
    class Program
    {
        static void Main(string[] args)
        {
            //before \w{5}(?=<..>)
            //after 

            var input = Console.ReadLine();

            //var pattern = @"(?<=<).*?(?=>)";

            var startIndex = 0;
            var endIndex = 0;

            while ((startIndex = input.IndexOf("<", startIndex)) != -1 && (endIndex = input.IndexOf(">", startIndex)) != -1)
            {
                string mineChars = input.Substring(startIndex + 1, 2);
                int mineRange = Math.Abs(mineChars[0] - mineChars[1]);


                int leftFromMine = Math.Max(0, startIndex - mineRange);
                int rightFromMine = Math.Min(input.Length - 1, endIndex + mineRange);

                StringBuilder sb = new StringBuilder(input);

                for (int i = leftFromMine; i <= rightFromMine; i++)
                {
                    sb[i] = '_';
                }

                input = sb.ToString();
            }

            Console.WriteLine(input);

        }
    }
}
