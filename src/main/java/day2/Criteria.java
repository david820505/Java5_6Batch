package day2;

import java.util.ArrayList;
import java.util.List;

public class Criteria {
    private String name;
    private int size;
    private String type;
    protected boolean includeSubFolder;
    List<Criteria> children;

    public Criteria(String name, int size, boolean includeSubFolder, String type) {
        this.name = name;
        this.size = size;
        this.includeSubFolder = includeSubFolder;
        this.type = type;
        this.children = new ArrayList();
    }

    public int getSize() {
        return this.size;
    }
    public String getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    public void setChildren(Criteria criteria){
        children.add(criteria);
    }


}
