using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoatSimulator
{
    class Program
    {
        static void Main(string[] args)
        {

            char firstBoat = char.Parse(Console.ReadLine());
            char secondBoat = char.Parse(Console.ReadLine());
            int linesThatWillFollow = int.Parse(Console.ReadLine());
            int firstBoatMoves = 0;
            int secondBoatMoves = 0;

            for (int i = 1; i <= linesThatWillFollow; i++)
            {
                string moves = Console.ReadLine();

                if (i % 2 != 0)
                {
                    firstBoatMoves += moves.Length;
                }
                else if (i % 2 == 0)
                {
                    secondBoatMoves += moves.Length;
                }
                if (moves.Equals("UPGRADE"))
                {
                    int firstBoatNameSwap = (int)(firstBoat) + 3;
                    int secondBoatNameSwap = (int)(secondBoat) + 3;
                    firstBoat = (char)(firstBoatNameSwap);
                    secondBoat = (char)(secondBoatNameSwap);
                    firstBoatMoves -= moves.Length;
                    secondBoatMoves -= moves.Length;

                }
                if (firstBoatMoves >= 50 || secondBoatMoves >= 50)
                {
                    if (firstBoatMoves >= 50)
                    {
                        Console.WriteLine(firstBoat);
                        return;
                    }
                    else if (secondBoatMoves >= 50)
                    {
                        Console.WriteLine(secondBoat);
                        return;
                    }
                }

            }

            if (firstBoatMoves < 50 && secondBoatMoves < 50)
            {
                if (firstBoatMoves > secondBoatMoves)
                {
                    Console.WriteLine(firstBoat);
                    return;
                }
                else if (secondBoatMoves > firstBoatMoves)
                {
                    Console.WriteLine(secondBoat);
                    return;
                }
            }
        }
    }
}
