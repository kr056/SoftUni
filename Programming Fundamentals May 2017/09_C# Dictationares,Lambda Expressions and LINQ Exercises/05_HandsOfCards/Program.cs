using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_HandsOfCards
{
    class Program
    {
        static void Main(string[] args)
        {
            var nameCards = new Dictionary<string, List<int>>();

            var line = Console.ReadLine();

            while (line != "JOKER")
            {
                var tokens = line.Split(':');

                var name = tokens[0];
                var cards = tokens[1].Split(", ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries)
                    .Select(CalculateCardValue)
                    .ToArray();

                if (!nameCards.ContainsKey(name))
                {
                    nameCards[name] = new List<int>();
                }
                nameCards[name].AddRange(cards);

                line = Console.ReadLine();

            }

            foreach (var nameCardsPerGo in nameCards)
            {
                var name1 = nameCardsPerGo.Key;
                var cards1 = nameCardsPerGo.Value;

                var totalCardSum = cards1.Distinct().Sum();

                Console.WriteLine("{0}: {1}", name1, totalCardSum);
            }
        }

        static int CalculateCardValue(string card)
        {
            var cardPowers = new Dictionary<string, int>();
            cardPowers["J"] = 11;
            cardPowers["Q"] = 12;
            cardPowers["K"] = 13;
            cardPowers["A"] = 14;

            for (int i = 2; i <= 10; i++)
            {
                cardPowers[i.ToString()] = i;
            }

            var cardTypes = new Dictionary<string, int>();
            cardTypes["S"] = 4;
            cardTypes["H"] = 3;
            cardTypes["D"] = 2;
            cardTypes["C"] = 1;

            var power = card.Substring(0, card.Length - 1);
            var type = card.Substring(card.Length - 1);

            var value = cardPowers[power] * cardTypes[type];

            return value;
        }
    }
}
