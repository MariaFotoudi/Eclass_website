package ismgroup66_java;

public class Lesson {
    
    private int lessonnumber; //classid
    private String classid; //teacherid
    private String theory; //theory

    public Lesson(int lessonnumber, String classid, String theory) {
        this.lessonnumber = lessonnumber;
        this.classid = classid;
        this.theory = theory;
    }

    /* Getters and Setters */
    
    public int getLessonNum() {
        return lessonnumber;
    }
 
    public void setLessonNum(int lessonnumber) {
        this.lessonnumber = lessonnumber;
    }

    public String getClassId() {
        return classid;
    }

    public void setClassId(String classid) {
        this.classid = classid;
    }

    public String getTheory() {
        return theory;
    }
 
    public void setTheory(String theory) {
        this.theory = theory;
    }

}