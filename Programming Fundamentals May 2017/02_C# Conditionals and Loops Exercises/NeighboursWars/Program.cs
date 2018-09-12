using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NeighboursWars
{
    class Program
    {
        static void Main(string[] args)
        {

            int damagePesho = int.Parse(Console.ReadLine());
            int damageGosho = int.Parse(Console.ReadLine());

            int healthPesho = 100;
            int healthGosho = 100;

            for (int i = 1; i < 200; i++)
            {

                // pesho atakuva
                if (i % 2 == 1)
                {
                    healthGosho -= damagePesho;
                    if (healthGosho <= 0)
                    {
                        Console.WriteLine($"Pesho won in {i}th round.");
                        return;
                    }
                    else if (healthPesho <= 0)
                    {
                        Console.WriteLine($"Gosho won in {i}th round.");
                        return;
                    }
                    Console.WriteLine($"Pesho used Roundhouse kick and reduced Gosho to {healthGosho} health.");
                }
                else if (i % 2 == 0)
                {
                    healthPesho -= damageGosho;
                    if (healthGosho <= 0)
                    {
                        Console.WriteLine($"Pesho won in {i}th round.");
                        return;
                    }
                    else if (healthPesho <= 0)
                    {
                        Console.WriteLine($"Gosho won in {i}th round.");
                        return;
                    }
                    Console.WriteLine($"Gosho used Thunderous fist and reduced Pesho to {healthPesho} health.");

                }

                if (i % 3 == 0)
                {
                    healthGosho += 10;
                    healthPesho += 10;
                }

            }

        }
    }
}
