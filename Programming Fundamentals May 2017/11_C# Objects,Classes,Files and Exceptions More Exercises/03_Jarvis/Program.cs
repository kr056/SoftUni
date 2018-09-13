using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_Jarvis
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Head> robotHead = new List<Head>();
            List<Torso> robotTorso = new List<Torso>();
            List<Arm> robotArms = new List<Arm>();
            List<Leg> robotLegs = new List<Leg>();

            ulong robotMaxEnergyCapacity = ulong.Parse(Console.ReadLine());

            var input = Console.ReadLine();

            long lastEnergyValueHead = 0;
            long lastEnergyValueTorso = 0;
            long lastEnergyValueArms = 0;
            long lastEnergyValueLegs = 0;

            while (input != "Assemble!")
            {
                var tokens = input.Split();

                string component = tokens[0];
                long energyConsumption = long.Parse(tokens[1]);

                switch (component)
                {
                    case "Head":
                        if (energyConsumption >= lastEnergyValueHead && robotHead.Count > 0)
                        {

                        }
                        else
                        {
                            if (energyConsumption < lastEnergyValueHead && robotHead.Count > 0)
                            {
                                robotHead.Remove(robotHead.First());
                            }

                            Head head = new Head
                            {
                                EnergyConsumption = energyConsumption,
                                IQ = int.Parse(tokens[2]),
                                SkinMaterial = tokens[3]

                            };

                            lastEnergyValueHead = energyConsumption;
                            robotHead.Add(head);
                        }
                        break;
                    case "Torso":
                        if (energyConsumption >= lastEnergyValueTorso && robotTorso.Count > 0)
                        {

                        }
                        else
                        {
                            if (energyConsumption < lastEnergyValueTorso && robotTorso.Count > 0)
                            {
                                robotTorso.Remove(robotTorso.First());
                            }

                            Torso torso = new Torso
                            {
                                EnergyConsumption = energyConsumption,
                                ProcessorSize = double.Parse(tokens[2]),
                                HousingMaterial = tokens[3]

                            };

                            lastEnergyValueTorso = energyConsumption;
                            robotTorso.Add(torso);
                        }
                        break;
                    case "Arm":
                        if (energyConsumption >= lastEnergyValueArms && robotArms.Count > 1)
                        {

                        }
                        else
                        {
                            if (energyConsumption < lastEnergyValueArms && robotArms.Count > 1)
                            {
                                robotArms.Remove(robotArms.First());
                            }

                            Arm arm = new Arm
                            {
                                EnergyConsumption = energyConsumption,
                                ArmReach = int.Parse(tokens[2]),
                                FingersCount = int.Parse(tokens[3])

                            };

                            robotArms.Add(arm);

                            if (robotArms.Count >= 1)
                            {
                                robotArms = robotArms.OrderByDescending(a => a.EnergyConsumption).ToList();
                                lastEnergyValueArms = robotArms[0].EnergyConsumption;
                            }
                        }
                        break;
                    case "Leg":
                        if (energyConsumption >= lastEnergyValueLegs && robotLegs.Count > 1)
                        {

                        }
                        else
                        {

                            if (energyConsumption < lastEnergyValueLegs && robotLegs.Count > 1)
                            {
                                robotLegs.Remove(robotLegs.First());
                            }

                            Leg leg = new Leg
                            {
                                EnergyConsumption = energyConsumption,
                                Strength = int.Parse(tokens[2]),
                                Speed = int.Parse(tokens[3])

                            };

                            robotLegs.Add(leg);

                            if (robotLegs.Count >= 1)
                            {
                                robotLegs = robotLegs.OrderByDescending(a => a.EnergyConsumption).ToList();
                                lastEnergyValueLegs = robotLegs[0].EnergyConsumption;

                            }
                        }
                        break;
                }
                input = Console.ReadLine();
            }

            var sumOfPartsEnergy = (ulong)(robotHead.Sum(a => a.EnergyConsumption)
               + robotTorso.Sum(a => a.EnergyConsumption)
                + robotArms.Sum(a => a.EnergyConsumption)
                + robotLegs.Sum(a => a.EnergyConsumption));

            bool partsCount = robotHead.Count == 1 && robotTorso.Count == 1
              && robotArms.Count == 2 && robotLegs.Count == 2;

            if (sumOfPartsEnergy > robotMaxEnergyCapacity)
            {
                Console.WriteLine("We need more power!");
            }
            else if (!partsCount)
            {
                Console.WriteLine("We need more parts!");
            }
            else
            {
                Console.WriteLine("Jarvis:");
                Console.WriteLine("#Head:");

                foreach (var item in robotHead)
                {
                    Console.WriteLine("###Energy consumption: {0}", item.EnergyConsumption);
                    Console.WriteLine("###IQ: {0}", item.IQ);
                    Console.WriteLine("###Skin material: {0}", item.SkinMaterial);
                }

                Console.WriteLine("#Torso:");

                foreach (var item in robotTorso)
                {
                    Console.WriteLine("###Energy consumption: {0}", item.EnergyConsumption);
                    Console.WriteLine("###Processor size: {0:f1}", item.ProcessorSize);
                    Console.WriteLine("###Corpus material: {0}", item.HousingMaterial);
                }

                foreach (var item in robotArms.OrderBy(a => a.EnergyConsumption))
                {
                    Console.WriteLine("#Arm:");
                    Console.WriteLine("###Energy consumption: {0}", item.EnergyConsumption);
                    Console.WriteLine("###Reach: {0}", item.ArmReach);
                    Console.WriteLine("###Fingers: {0}", item.FingersCount);
                }

                foreach (var item in robotLegs.OrderBy(a => a.EnergyConsumption))
                {
                    Console.WriteLine("#Leg:");
                    Console.WriteLine("###Energy consumption: {0}", item.EnergyConsumption);
                    Console.WriteLine("###Strength: {0}", item.Strength);
                    Console.WriteLine("###Speed: {0}", item.Speed);
                }
            }

        }
    }
    class Head
    {
        public long EnergyConsumption { get; set; }
        public int IQ { get; set; }
        public string SkinMaterial { get; set; }
    }
    class Torso
    {
        public long EnergyConsumption { get; set; }
        public double ProcessorSize { get; set; }
        public string HousingMaterial { get; set; }
    }
    class Arm
    {
        public long EnergyConsumption { get; set; }
        public int ArmReach { get; set; }
        public int FingersCount { get; set; }
    }
    class Leg
    {
        public long EnergyConsumption { get; set; }
        public int Strength { get; set; }
        public int Speed { get; set; }
    }
}
