
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_ByteFlip
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().Split(' ').Where(x => x.Length == 2).ToArray();

            for (int i = 0; i < input.Length; i++)
            {

                var check = input[i].ToCharArray();
                if (char.IsDigit(check[0]) && char.IsDigit(check[1]))
                {
                    int result = 0;
                    int num = int.Parse(input[i]);

                    while (num > 0)
                    {
                        result = result * 10 + num % 10;
                        num /= 10;

                    }

                    input[i] = result.ToString();
                    result = 0;

                }
            }

            var final = input.Reverse().ToList();

            for (int i = 0; i < final.Count; i++)
            {
                char[] charArray = final[i].ToCharArray();
                Console.Write(System.Convert.ToChar(System.Convert.ToUInt32(new string(charArray), 16)));
            }

            Console.WriteLine();

        }

    }

}


