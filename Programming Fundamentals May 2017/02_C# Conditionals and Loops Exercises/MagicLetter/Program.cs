using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MagicLetter
{
    class Program
    {
        static void Main(string[] args)
        {

            char firstCase = char.Parse(Console.ReadLine());
            char secondCase = char.Parse(Console.ReadLine());
            char thirdCase = char.Parse(Console.ReadLine());

            for (char i = firstCase; i <= secondCase; i++)
            {
                for (int j = firstCase; j <= secondCase; j++)
                {
                    for (int k = firstCase; k <= secondCase; k++)
                    {
                        char a = Convert.ToChar(i);
                        char b = Convert.ToChar(j);
                        char c = Convert.ToChar(k);

                        if (a == thirdCase || b == thirdCase || c == thirdCase)
                        {

                        }
                        else
                        {
                            Console.Write($"{a}{b}{c} ");
                        }
                    }
                }
            }

        }
    }
}
