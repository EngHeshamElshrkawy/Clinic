public class Patient {
    String nameOfPatient;
    int fileNumber;
    int age;
    String history;

    public Patient(){
    
    }

    public Patient(String nameOfPatient, int fileNumber, int age, String history){
        this.nameOfPatient = nameOfPatient;
        this.fileNumber = fileNumber;
        this.age = age;
        this.history = history;
    }

    public void setPatientName(String nameOfPatient){
        this.nameOfPatient = nameOfPatient;
    }

    public void setFileNumber(int fileNumber){
        this.fileNumber = fileNumber;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setHistory(String history){
        this.history = history;
    }

    public String getPatientName(){
        return this.nameOfPatient;
    }

    public int getFileNumber(){
        return this.fileNumber;
    }

    public int getAge(){
        return this.age;
    }

    public String getHistory(){
        return this.history;
    }


}
