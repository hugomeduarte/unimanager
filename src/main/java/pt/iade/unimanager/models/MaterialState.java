package pt.iade.unimanager.models;

public enum MaterialState {
    
OK (true), LENT(false), REPAIR(false), BROKEN(false), BLOCKEDf(false);
private boolean usable;

private MaterialState(boolean usable) {
    this.usable = usable;

}

public boolean isUsable() {

    return usable;
}








}
