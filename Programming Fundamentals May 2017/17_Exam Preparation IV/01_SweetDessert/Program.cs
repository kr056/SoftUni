using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_SweetDessert
{
    class Program
    {
        static void Main(string[] args)
        {

            decimal ivanchoMoney = decimal.Parse(Console.ReadLine());
            ulong guestNumber = ulong.Parse(Console.ReadLine());
            decimal bannanaPrice = decimal.Parse(Console.ReadLine());
            decimal eggPrice = decimal.Parse(Console.ReadLine());
            decimal berriesKgPrice = decimal.Parse(Console.ReadLine());

            var setCount = Math.Ceiling((decimal)guestNumber / 6);

            var totalPrice = setCount * (2 * bannanaPrice) + setCount * (4 * eggPrice) + setCount * ((decimal)0.2 * berriesKgPrice);

            if (totalPrice <= ivanchoMoney)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {totalPrice:f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {(totalPrice - ivanchoMoney):f2}lv more.");
            }
        }
    }
}
