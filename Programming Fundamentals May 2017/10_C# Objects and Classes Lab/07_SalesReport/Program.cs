using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_SalesReport
{
    class Sale
    {
        public string Town { get; set; }
        public string Product { get; set; }
        public decimal Price { get; set; }
        public decimal Quantity { get; set; }

    }
    class SalesByTown
    {
        public string Town { get; set; }
        public decimal Sales { get; set; }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var sales = ReadSales();

            var salesByTown = CalcSalesByTown(sales);

            foreach (var sale in salesByTown.OrderBy(entry => entry.Town))
            {
                Console.WriteLine($"{sale.Town} -> {sale.Sales:f2}");
            }
        }

        private static List<SalesByTown> CalcSalesByTown(Sale[] sales)
        {
            var salesByTown = new Dictionary<string, decimal>();
            foreach (var s in sales)
            {
                if (!salesByTown.ContainsKey(s.Town))
                {
                    salesByTown[s.Town] = 0;
                }
                salesByTown[s.Town] += s.Quantity * s.Price;
            }

            var salesList = salesByTown.Select(s => new SalesByTown()
            {
                Town = s.Key,
                Sales = s.Value
            }
            ).ToList();

            return salesList;
        }

        private static Sale[] ReadSales()
        {
            var count = int.Parse(Console.ReadLine());
            Sale[] sales = new Sale[count];
            for (int i = 0; i < count; i++)
            {
                var input = Console.ReadLine().Split();
                sales[i] = new Sale()
                {
                    Town = input[0],
                    Product = input[1],
                    Price = decimal.Parse(input[2]),
                    Quantity = decimal.Parse(input[3])

                };
            }
            return sales;
        }
    }
}
