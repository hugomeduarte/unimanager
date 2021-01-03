package pt.iade.unimanager.models;

public class Material {
    protected String name;
    protected MaterialState state;
    public Material(String name) {
        this.name=name;
        state= MaterialState.OK;
    }
    
    public String getName() {
        return name;
    }

    public MaterialState getState() {
        return state;
    }

    public void setState (MaterialState state) {
        this.state = state;
    }

}
