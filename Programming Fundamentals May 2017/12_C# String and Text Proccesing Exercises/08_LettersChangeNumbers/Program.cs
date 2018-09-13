using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_LettersChangeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
            decimal total = 0;

            for (int i = 0; i < input.Length; i++)
            {
                var charArr = input[i].ToCharArray();

                decimal num = GetNum(input[i]);

                var firstLetter = charArr[0];
                var lastLetter = charArr[charArr.Length - 1];
                var positionFirstLetter = char.ToUpper(firstLetter) % 32;
                var positionLastLetter = char.ToUpper(lastLetter) % 32;

                if (char.IsUpper(firstLetter))
                {
                    total += num / positionFirstLetter;
                }
                else
                {
                    total += num * positionFirstLetter;
                }

                if (char.IsUpper(lastLetter))
                {
                    total -= positionLastLetter;
                }
                else
                {
                    total += positionLastLetter;
                }
            }

            Console.WriteLine($"{total:f2}");
        }

        private static decimal GetNum(string str)
        {

            var arr = str.ToCharArray();
            string num = String.Empty;

            for (int i = 0; i < str.Length; i++)
            {
                if (char.IsDigit(arr[i]))
                {
                    num += arr[i];
                }
            }

            decimal parsedNum = decimal.Parse(num);

            return parsedNum;
        }
    }
}
