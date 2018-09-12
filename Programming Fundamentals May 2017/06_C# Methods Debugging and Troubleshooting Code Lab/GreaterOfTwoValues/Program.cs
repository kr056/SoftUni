using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GreaterOfTwoValues
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();

            switch (type)
            {
                case "int":
                    int first = int.Parse(Console.ReadLine());
                    int second = int.Parse(Console.ReadLine());
                    int max = GetMax(first, second);
                    Console.WriteLine(max);
                    break;
                case "char":
                    char ch1 = char.Parse(Console.ReadLine());
                    char ch2 = char.Parse(Console.ReadLine());
                    char maxChar = GetMaxChar(ch1, ch2);
                    Console.WriteLine(maxChar);
                    break;
                case "string":
                    string str1 = Console.ReadLine();
                    string str2 = Console.ReadLine();
                    string maxString = GetMaxString(str1, str2);
                    Console.WriteLine(maxString);
                    break;
            }
        }

        static int GetMax(int first, int second)
        {
            if (first >= second)
            {
                return first;
            }
            else
            {
                return second;
            }
        }
        static char GetMaxChar(char ch1, char ch2)
        {
            if (ch1 >= ch2)
            {
                return ch1;
            }
            else
            {
                return ch2;
            }
        }
        static string GetMaxString(string str1, string str2)
        {
            if (str1.CompareTo(str2) >= 0)
            {
                return str1;
            }
            else
            {
                return str2;
            }
        }
    }
}
