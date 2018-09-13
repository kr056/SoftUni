using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03_NetherRealms
{
    class Program
    {
        static void Main(string[] args)
        {
            var demons = new List<Demon>();

            var separators = new char[] { ' ', ',' };

            var input = Console.ReadLine().Split(separators, StringSplitOptions.RemoveEmptyEntries);

            long healthValue = 0;
            decimal damage = 0;

            for (int i = 0; i < input.Length; i++)
            {
                var name = input[i];
                var letters = input[i].ToCharArray();
                healthValue = GetHealthValue(letters);
                damage = GetDamage(name);

                var slashCount = 0;
                var starsCount = 0;

                for (int j = 0; j < letters.Length; j++)
                {
                    if (letters[j] == '*')
                    {
                        starsCount++;
                    }

                    if (letters[j] == '/')
                    {
                        slashCount++;
                    }
                }

                damage = damage * (decimal)Math.Pow(2, starsCount);

                for (int m = 0; m < slashCount; m++)
                {
                    damage = damage / 2;
                }

                Demon demon = new Demon()
                {
                    Name = name,
                    Health = healthValue,
                    Damage = damage
                };

                demons.Add(demon);
            }

            foreach (var demon in demons.OrderBy(x => x.Name))
            {
                Console.WriteLine($"{demon.Name} - {demon.Health} health, {demon.Damage:f2} damage");
            }

        }

        private static decimal GetDamage(string name)
        {
            var numbersInName = new List<decimal>();
            decimal sum = 0;

            name = name.Replace('.', ',');

            var pattern = @"-?\d+(\,\d+)?";

            var matches = Regex.Matches(name, pattern);

            foreach (Match match in matches)
            {
                var matchIndex = name.IndexOf($"{match}");

                var num = decimal.Parse(match.Value);
                numbersInName.Add(num);
            }

            sum = numbersInName.Sum();

            return sum;
        }

        private static long GetHealthValue(char[] letters)
        {
            long health = 0;
            for (int j = 0; j < letters.Length; j++)
            {
                var letter = letters[j];

                var isNotValid = char.IsDigit(letter) || letter == '+' || letter == '-'
                    || letter == '/' || letter == '*' || letter == '.';

                if (!isNotValid)
                {
                    health += (int)letter;
                }
            }
            return health;
        }
    }
    class Demon
    {
        public string Name { get; set; }
        public long Health { get; set; }
        public decimal Damage { get; set; }
    }

}
