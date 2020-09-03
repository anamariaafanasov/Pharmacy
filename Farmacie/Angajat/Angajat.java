package Farmacie.Angajat;

public abstract class  Angajat {
    private String firstName;
    private String lastName;
    private int WorkingHoursPerDay;
    private int salary;

    public Angajat(){
        this("","",0,0);
    }
    public Angajat(String firstName, String lastName, int workingHoursPerDay, int salary) {
        firstName = firstName;
        lastName = lastName;
        WorkingHoursPerDay = workingHoursPerDay;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public int getWorkingHoursperDay() {
        return WorkingHoursPerDay;
    }

    public void setWorkingHoursperDay(int workingHoursPerDay) {
        WorkingHoursPerDay = workingHoursPerDay;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
