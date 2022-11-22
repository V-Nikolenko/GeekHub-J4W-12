package edu.geekhub.orcostat;

import edu.geekhub.orcostat.model.Orc;
import edu.geekhub.orcostat.model.Tank;
import edu.geekhub.orcostat.model.TrivialCollection;

public class OrcoStatService {
    private final TrivialCollection negativeAliveOrcs;
    private final TrivialCollection destroyedTanks;

    public OrcoStatService() {
        this.negativeAliveOrcs = new TrivialCollection();
        this.destroyedTanks = new TrivialCollection();
    }

    public int getNegativelyAliveOrcCount() {
        return negativeAliveOrcs.count();
    }

    public void addNegativelyAliveOrc(Orc orc) {
        negativeAliveOrcs.add(orc);
    }

    public int getDestroyedTanksCount() {
        return destroyedTanks.count();
    }

    public void addDestroyedTank(Tank tank) {
        destroyedTanks.add(tank);

        for (Object orc : tank.getEquipage().getData()) {
            negativeAliveOrcs.add(orc);
        }
    }

    public int getLosesInDollars() {
        int orcsSum = 0;
        for (Object orc : negativeAliveOrcs.getData()) {
            orcsSum += ((Orc) orc).getPrice();
        }

        final int tanksSum = 0;
        for (Object tank : destroyedTanks.getData()) {
            orcsSum += ((Tank) tank).getPrice();
        }

        return orcsSum + tanksSum;
    }
}
