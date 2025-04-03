package uk.protonull.civianmod.features;

public interface CivianItemStack {
    int DEFAULT_AMOUNT_DECORATION_COLOUR = -1;

    void civianmod$update();

    boolean civianmod$alwaysShowAmountDecoration();

    int civianmod$amountDecorationColour();
}
