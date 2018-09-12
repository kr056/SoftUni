using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_JumpAround
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            Boolean canMove = true;
            var sum = nums[0];
            var indices = nums[0];

            while (canMove)
            {
                if (indices <= nums.Length - 1)
                {
                    sum += nums[indices];
                    if (indices + nums[indices] > nums.Length - 1)
                    {
                        indices -= nums[indices];
                        if (indices < 0)
                        {
                            canMove = false;
                        }
                    }
                    else
                    {
                        indices += nums[indices];
                    }
                }
                else
                {
                    canMove = false;
                }
            }

            Console.WriteLine(sum);
        }
    }
}
