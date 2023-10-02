package ismgroup66_java;

public class Teacher {
    
    private String teacher;
    private String classid;

    public Teacher(String teacher, String classid) {
        this.teacher = teacher;
        this.classid = classid;
    }
    
    public String getTeacher() {
        return teacher;
    }
 
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassId() {
        return classid;
    }

    public void setClassId(String classid) {
        this.classid = classid;
    }

}