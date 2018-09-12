using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MasterNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            for (int i = 1; i <= num; i++)
            {
                if (isPalindrome(i) == true && sumOfDigits(i) == true && holdEven(i) == true)
                {
                    Console.WriteLine(i);
                }
            }

        }

        static bool isPalindrome(int num)
        {
            int reverse = 0;
            int backUp = num;
            while (num > 0)
            {
                int remainder = num % 10;
                reverse = (reverse * 10) + remainder;
                num = num / 10;
            }
            if (backUp == reverse)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        static bool sumOfDigits(int num)
        {


            int sum = 0;
            while (num > 0)
            {
                int lastDigit = num % 10;
                num = num / 10;
                sum += lastDigit;
            }
            if (sum % 7 == 0)
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        static bool holdEven(int num)
        {
            int evenCounter = 0;
            while (num > 0)
            {

                int lastDigit = num % 10;
                num = num / 10;
                if (lastDigit % 2 == 0)
                {
                    evenCounter++;

                }

            }
            if (evenCounter > 0)
            {
                return true;
            }
            else
            {
                return false;
            }

        }

    }
}
