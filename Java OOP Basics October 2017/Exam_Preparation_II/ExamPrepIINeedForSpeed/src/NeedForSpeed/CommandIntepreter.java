package NeedForSpeed;

import NeedForSpeed.IO.OutputWriter;

public class CommandIntepreter {
    private CarManager carManager = new CarManager();
    private OutputWriter outputWriter = new OutputWriter();

    public void interpretCommand(String[] data) {
        String cmdType = data[0];
        switch (cmdType) {
            case "register":
                this.carManager.register(Integer.valueOf(data[1]), data[2], data[3], data[4], Integer.valueOf(data[5])
                        , Integer.valueOf(data[6]), Integer.valueOf(data[7]), Integer.valueOf(data[8]), Integer.valueOf(data[9]));
                break;
            case "check":
                String getCarInfo = this.carManager.check(Integer.valueOf(data[1]));
                OutputWriter.gatherAllForPrint(getCarInfo);
                break;
            case "open":
                if (data.length == 6) {
                    this.carManager.open(Integer.valueOf(data[1]), data[2], Integer.valueOf(data[3]), data[4], Integer.valueOf(data[5]));
                } else if (data.length == 7) {
                    this.carManager.open(Integer.valueOf(data[1]), data[2], Integer.valueOf(data[3]), data[4], Integer.valueOf(data[5])
                            , Integer.valueOf(data[6]));
                }
                break;
            case "participate":
                this.carManager.participate(Integer.valueOf(data[1]), Integer.valueOf(data[2]));
                break;
            case "start":
                String getRaceInfo = this.carManager.start(Integer.valueOf(data[1]));
                OutputWriter.gatherAllForPrint(getRaceInfo);
                break;
            case "park":
                this.carManager.park(Integer.valueOf(data[1]));
                break;
            case "unpark":
                this.carManager.unpark(Integer.valueOf(data[1]));
                break;
            case "tune":
                this.carManager.tune(Integer.valueOf(data[1]), data[2]);
                break;
            default:
                break;
        }
    }
}
