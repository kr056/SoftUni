package PawInc;

public class CommandInterpreter {
    private AnimalCenterManager animalCenterManager;

    public CommandInterpreter(AnimalCenterManager animalCenterManager) {
        this.animalCenterManager = animalCenterManager;
    }

    public void interpretCommand(String[] data) {
        String cmdType = data[0];

        switch (cmdType) {
            case "RegisterCleansingCenter":
                animalCenterManager.registerCleansingCenter(data[1]);
                break;
            case "RegisterAdoptionCenter":
                animalCenterManager.registerAdoptionCenter(data[1]);
                break;
            case "RegisterCastrationCenter":
                animalCenterManager.registerCastrationCenter(data[1]);
                break;
            case "RegisterDog":
                animalCenterManager.registerDog(data[1], Integer.valueOf(data[2]), Integer.valueOf(data[3]), data[4]);
                break;
            case "RegisterCat":
                animalCenterManager.registerCat(data[1], Integer.valueOf(data[2]), Integer.valueOf(data[3]), data[4]);
                break;
            case "SendForCleansing":
                animalCenterManager.sendForCleansing(data[1], data[2]);
                break;
            case "SendForCastration":
                animalCenterManager.sendForCastration(data[1], data[2]);
                break;
            case "Cleanse":
                animalCenterManager.cleanse(data[1]);
                break;
            case "Castrate":
                animalCenterManager.castrate(data[1]);
                break;
            case "Adopt":
                animalCenterManager.adopt(data[1]);
                break;
            case "CastrationStatistics":
                animalCenterManager.castrationStatistics();
                break;
            default:
                break;
        }
    }
}
