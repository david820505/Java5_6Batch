package day2;

import java.util.ArrayList;
import java.util.List;

public class CountFiles {
    static int numOfFiles = 0;

    public static void main(String[] args) {
        Criteria c1 = new Criteria("Books", 32, true, "txt");
        Criteria c2 = new Criteria("Comic", 32, true, "txt");
        Criteria c3 = new Criteria("Math", 32, true, "txt");

        Criteria c41 = new Criteria("Heroe", 100, false, "txt");
        Criteria c42 = new Criteria("IronMan", 101, false, "pdf");
        Criteria c43 = new Criteria("IHateMath", 102, false, "pdf");
        c1.setChildren(c2);
        c1.setChildren(c3);
        c2.setChildren(c41);
        c2.setChildren(c42);
        c3.setChildren(c43);

        List<Criteria> path = new ArrayList<>();
        count(c1,path);
        System.out.println("--------------End--------------");
    }
    public static void count(Criteria criteria,List<Criteria> path){
        if(criteria == null)
            return;

        if(!criteria.includeSubFolder){
            StringBuilder sb = new StringBuilder("Root/");
            if(path.size() == 0) {
                sb.append(criteria.getName());
                sb.append(".");
                sb.append(criteria.getType());
            }else{
                for(int i = 0; i< path.size()-1; i++){
                    sb.append(path.get(i).getName());
                    sb.append("/");
                }
                sb.append(criteria.getName());
                sb.append(".");
                sb.append(criteria.getType());
            }

            System.out.println(sb.toString());
            return;
        }else {
            for(Criteria c: criteria.children){
                path.add(c);
                count(c,path);
                path.remove(path.size()-1);
            }
        }
    }
}
