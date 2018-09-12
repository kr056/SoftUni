using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VariableInHexFormat
{
    class Program
    {
        static void Main(string[] args)
        {

            string num = Console.ReadLine();

            int convertNum = Convert.ToInt32(num, 16);

            Console.WriteLine(convertNum);

        }
    }
}
