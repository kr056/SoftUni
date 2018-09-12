using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_ImmuneSystem
{
    class Program
    {
        static void Main(string[] args)
        {

            var immuneSystemInitialHealth = int.Parse(Console.ReadLine());
            double remainingHealth = immuneSystemInitialHealth;
            var line = Console.ReadLine();
            var sumOfVirusLetters = 0;
            var minutes = 0;
            var seconds = 0;

            var virusNames = new List<string>();

            while (line != "end")
            {
                var viruses = line.ToCharArray();

                for (int i = 0; i < viruses.Length; i++)
                {
                    sumOfVirusLetters += (int)(viruses[i]);
                }

                var virusStrength = sumOfVirusLetters / 3;


                var timeToDefeatVirus = virusStrength * line.Length;

                if (virusNames.Contains(line))
                {
                    timeToDefeatVirus /= 3;
                }

                minutes = timeToDefeatVirus / 60;
                seconds = timeToDefeatVirus % 60;

                Console.WriteLine($"Virus {line}: {virusStrength} => {timeToDefeatVirus} seconds");

                if (timeToDefeatVirus < remainingHealth)
                {
                    remainingHealth -= timeToDefeatVirus;

                    Console.WriteLine($"{line} defeated in {minutes}m {seconds}s.");
                    Console.WriteLine($"Remaining health: {remainingHealth}");

                    remainingHealth += (remainingHealth * 0.2);

                    if (remainingHealth >= immuneSystemInitialHealth)
                    {
                        remainingHealth = immuneSystemInitialHealth;
                    }

                    remainingHealth = (int)remainingHealth;
                }
                else
                {
                    Console.WriteLine("Immune System Defeated.");
                    return;
                }

                sumOfVirusLetters = 0;
                virusNames.Add(line);

                line = Console.ReadLine();
            }

            if (remainingHealth > 0)
            {
                Console.WriteLine($"Final Health: {remainingHealth}");
            }
        }
    }
}
