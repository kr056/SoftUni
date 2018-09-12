using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MakeaWord
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            char symbol;
            string word = "";
            for (int i = 0; i < n; i++)
            {
                symbol = char.Parse(Console.ReadLine());
                word += symbol;
            }

            Console.WriteLine($"The word is: {word}");

        }
    }
}
