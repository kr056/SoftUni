using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Character
{
    class Program
    {
        static void Main(string[] args)
        {

            string name = Console.ReadLine();
            int healthCurrent = int.Parse(Console.ReadLine());
            int healthMax = int.Parse(Console.ReadLine());
            int energyCurrent = int.Parse(Console.ReadLine());
            int energyMax = int.Parse(Console.ReadLine());

            Console.WriteLine($"Name: {name}");
            Console.Write("Health: |");
            Console.Write(drawing("|",healthCurrent));
            Console.Write(drawing(".", (healthMax - healthCurrent)));
            Console.WriteLine("|");

            Console.Write("Energy: |");
            Console.Write(drawing("|", energyCurrent));
            Console.Write(drawing(".", (energyMax - energyCurrent)));
            Console.WriteLine("|");







        }
        public static string drawing(string text, int repeatCount)
        {
            string a = "";
            for (int i = 0; i < repeatCount; i++)
            {
                a += text;
            }
            return a;
        }
    }
  

}
