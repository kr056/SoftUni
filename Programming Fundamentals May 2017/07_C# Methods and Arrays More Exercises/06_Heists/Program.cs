using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_Heists
{
    class Program
    {
        static void Main(string[] args)
        {

            var JewelsAndGoldPrices = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var jewels = 0;
            var gold = 0;
            var totalEarings = 0;
            var totalExpenses = 0;

            while (true)
            {

                var LootAndExpenses = Console.ReadLine().Split(' ').ToList();

                if (LootAndExpenses[0] == "Jail" && LootAndExpenses[1] == "Time")
                {
                    if (totalEarings >= totalExpenses)
                    {
                        Console.WriteLine("Heists will continue. Total earnings: {0}.", totalEarings - totalExpenses);
                    }
                    else if (totalExpenses > totalEarings)
                    {
                        Console.WriteLine("Have to find another job. Lost: {0}.", totalExpenses - totalEarings);
                    }
                    break;
                }


                int expenses = int.Parse(LootAndExpenses[1]);
                char[] l = LootAndExpenses[0].ToCharArray();

                for (int i = 0; i < l.Length; i++)
                {
                    if (l[i] == '%')
                    {
                        jewels++;
                    }
                    else if (l[i] == '$')
                    {
                        gold++;
                    }
                    totalEarings = JewelsAndGoldPrices[0] * jewels + JewelsAndGoldPrices[1] * gold;

                }
                totalExpenses += expenses;

            }


        }
    }
}
