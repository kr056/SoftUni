using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BalancedBrackets
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int openBracketCounter = 0;
            int closingBracketCounter = 0;
            string lastInput = "";
            for (int i = 0; i < n; i++)
            {
                string currentInput = Console.ReadLine();

                if (closingBracketCounter > openBracketCounter)
                {

                    Console.WriteLine("UNBALANCED");
                    return;
                }


                if (lastInput.Equals("(") && currentInput.Equals("("))
                {

                    Console.WriteLine("UNBALANCED");
                    return;
                }

                if (currentInput.Equals("("))
                {
                    openBracketCounter++;
                }

                if (currentInput.Equals(")"))
                {
                    closingBracketCounter++;
                }

                lastInput = currentInput;
            }

            if (openBracketCounter == closingBracketCounter)
            {

                Console.WriteLine("BALANCED");
            }
            else
            {

                Console.WriteLine("UNBALANCED");

            }
        }
    }
}
