using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace livedemo
{
    class Program
    {
        static void Main(string[] args)
        {

            string lang = Console.ReadLine();

            switch (lang)
            {
                case "USA":
                case "England":
                    Console.WriteLine("Ënglish");
                    break;
                case "Spain":
                case "Argentina":
                case "Mexico":
                    Console.WriteLine("Spanish");
                    break;
                default:
                    Console.WriteLine("unknown");
                    break;

            }

        }
    }
}
