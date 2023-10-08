package TMS.TASK.CRITERION;

public abstract class Criterion{

    protected String name;
    protected boolean isPrimitive;

    public Criterion(String name){
        this.name = name;
    }

    protected String getName(){return name;}

    protected boolean isPrimitive(){return isPrimitive;}
}
