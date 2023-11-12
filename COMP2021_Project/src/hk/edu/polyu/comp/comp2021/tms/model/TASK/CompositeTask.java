package hk.edu.polyu.comp.comp2021.tms.model.TASK;

import java.util.ArrayList;

public class CompositeTask extends Task{

    private ArrayList<Task> subTaskList;

    public CompositeTask(String name, String description){
        super(name, description);
        this.subTaskList = new ArrayList<>();
        isPrimitive = false;
    }

    public void addTask(Task task){subTaskList.add(task);}

    @Override
    public ArrayList<Task> getList(){return subTaskList;}

    @Override
    public String[] getNameArray(){
        String[] result = new String[subTaskList.size()];
        for(int i = 0;i< result.length;i++) result[i] = subTaskList.get(i).name;
        return result;
    }

    @Override
    public double getDuration() {
        double duration = 0;
        for(Task t : subTaskList) {
            double subTaskDuration = t.getDuration();
            if (duration < subTaskDuration) duration = subTaskDuration;
        }
        return duration;
    }

    @Override
    public String toString(){
        StringBuilder strB = new StringBuilder();
        strB.append("\nComposite Task: ");
        strB.append(super.toString());
        strB.append("\nSubtasks: ");
        if(subTaskList.isEmpty()) strB.append("No Subtasks.");
        for(Task t : subTaskList){
            strB.append(t.getName() + ",");
        }
        if(strB.charAt(strB.length()-1) == ',') strB.delete(strB.length()-1,strB.length());
        return strB.toString();
    }

}
