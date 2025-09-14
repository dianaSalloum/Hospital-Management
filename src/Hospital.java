import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Person> people;
    private List<Doctor> doctors;
    private List<Patient>patients;
    private List<Staff>staff;
    private List<Appointment> appointments;
    private List<Departement> departments;
    private List<Bill>bills;
                                   //constructor
    //when creating a hospital there has to be doctors,staff and some departments but no Patients or Appointments or even bills!
    public Hospital(List<Doctor>doctors,List<Staff>staff,List<Departement>departments) {
      this.doctors=new ArrayList<>(doctors);
      this.staff=new ArrayList<>(staff);
      this.departments =new ArrayList<>(departments);
      this.patients=new ArrayList<>();
      this.people=new ArrayList<>();
      this.appointments=new ArrayList<>();
      this.bills=new ArrayList<>();
      for(Doctor d:doctors)
          people.add(d);
      for(Staff s:staff)
          people.add(s);
    }
                                    //adding methods
    public void addDoctor(int id, String name, int age, String gender, String phoneNumber, String specialization, double salary, int yearsOfExperience,double consultationFee) {
       Doctor d=new Doctor(id,name,age,gender,phoneNumber,specialization,salary, yearsOfExperience,consultationFee);
        doctors.add(d);
        people.add(d);
    }
    public void addPatient(int id,String name,int age,String gender,String phoneNumber,String medicalHistory,String bloodType,String address) {
       Patient p=new Patient(id,name,age,gender,phoneNumber,medicalHistory,bloodType,address);
        patients.add(p);
        people.add(p);
    }
    public void addStaff(int id,String name,int age,String gender,String phoneNumber,String position,double salaryWorker) {
        Staff s=new Staff(id,name,age,gender,phoneNumber,position,salaryWorker);
        staff.add(s);
        people.add(s);
    }
    public void addDepartment(int departmentId, String departmentName) {
        departments.add(new Departement(departmentId,departmentName));
    }
    //you cannot add a doctor who is not in the hospital to a department in the same hospital!..
    public void addDoctorToDepartment(int departmentId,int doctorId) {
        Departement d = findDepartement(departmentId);
        Doctor doc = findDoctor(doctorId);
        if (d != null) {
            if (doc == null) {
                System.out.println("cannot find this doctor!..check the id please/add the doctor to the hospital");
                return;
            }
            else {
                d.getDepartementDoctors().add(doc);
                return;
            }
        }
        System.out.println("this department is not exist!");
    }

    //you can add a patient who is not in the hospital to a department in it
    //the doctor is a static member in the hospital the patient is not!(that is why there has to be a doctor before adding)

    public void addPatientToDepartment(int departmentId,int patientId,String name,int age,String gender,String phoneNumber,String medicalHistory,String bloodType,String address) {
        Departement d = findDepartement(departmentId);
        Patient p = findPatient(patientId);
        if (d != null) {
            if (p == null) {
                addPatient(patientId, name, age, gender, phoneNumber, medicalHistory, bloodType, address);
                //p is null
                Patient p2=findPatient(patientId);
                d.getDepartementPatient().add(p2);
                patients.add(p2);
                people.add(p2);
                return;
            }
            else {
                d.getDepartementPatient().add(p);
                patients.add(p);
                people.add(p);
                return;
            }
        }
        System.out.println("this department is not exist!");
    }
    public void addAppointment(int appointmentId, LocalDateTime date, Doctor doctor, Patient patient) {
        Appointment aa=findAppointment(appointmentId);
        if(aa==null) {
            Appointment a = new Appointment(appointmentId, date, doctor, patient);
            Doctor d = findDoctor(a.getDoctor().getId());
            Patient p = findPatient(a.getPatient().getId());
            if (d != null) {
                if (p == null) {
                    patients.add(a.getPatient());
                    people.add(a.getPatient());
                    appointments.add(a);
                    addBill(appointmentId,doctor.getConsultationFee(),patient.getId());
                    return;
                }
                else{
                    appointments.add(a);
                    addBill(appointmentId,doctor.getConsultationFee(),patient.getId());
                return;}
            }
            System.out.println("wrong doctor!");
        }
        else
            System.out.println("this appointment is already taken!");
    }
    public void addBill(int billId,double amount,int patientId){
        Bill b=new Bill(billId,amount,patientId);
        bills.add(b);
    }
                                    //finding methods
    public Doctor findDoctor(int id) {
        for(Doctor doctor: doctors)
            if(id==doctor.getId())
                return doctor;
        return null;
    }
    public Patient findPatient(int id) {
        for(Patient patient:patients)
            if(id==patient.getId())
                return patient;
        return null;
    }
    public Staff findStaff(int id) {
        for (Staff staff1 : staff)
            if (id == staff1.getId())
                return staff1;
        return null;
    }
    public Departement findDepartement(int id){
        for (Departement department: departments)
            if (id==department.getDepartementId())
                return department;
        return null;
    }
    public Appointment findAppointment(int id){
        for (Appointment appointment:appointments)
            if (id==appointment.getAppointementId())
                return appointment;
        return null;

    }
    public Bill findBill(int id){
        for (Bill bill:bills)
            if(id==bill.getBillId())
                return bill;
        return null;
    }

                                  //removing methods
    public void removeDoctor(int id) {
        Doctor d=findDoctor(id);
        if(d==null)
            System.out.println("wrong doctor!");
        else{
            doctors.remove(d);
            people.remove(d);
        }
    }
    public void removePatient(int id) {
        Patient p = findPatient(id);
        if (p == null)
            System.out.println("wrong patient!");
        else {
            patients.remove(p);
            people.remove(p);
        }
    }
    public void removeStaff(int id) {
        Staff s = findStaff(id);
        if (s== null)
            System.out.println("wrong staff!");

        else {
            staff.remove(s);
            people.remove(s);
        }
    }
    public void cancelAppointment(int id){
        Appointment a=findAppointment(id);
        if(a==null)
            System.out.println("wrong appointment!");
        else
            appointments.remove(a);
    }
                       //appointments that a patient or a doctor has
    public List<Appointment> patientAppointments(int id) {
        List<Appointment> aP = new ArrayList<>();
        for (Appointment appointment : appointments)
            if (id == appointment.getPatient().getId())
                aP.add(appointment);
        return aP;
    }
    public List<Appointment> doctorAppointments(int id) {
        List<Appointment> aD = new ArrayList<>();
        for (Appointment appointment : appointments)
            if (id == appointment.getDoctor().getId())
                aD.add(appointment);
        return aD;
    }
                      //doctors and patients in a department
    public List <Doctor> doctorsInDepartment(int id){
        Departement d=findDepartement(id);
        return d.getDepartementDoctors();

    }
    public List<Patient> patientsInDepartment(int id){
        Departement d=findDepartement(id);
        return d.getDepartementPatient();
    }
                                         //paying a bill
    public void payBill(int billId,double paid){
        Bill b=findBill(billId);
        if(b==null)
            System.out.println("wrong bill!!");
        else {
            if(paid>b.getAmount()){
                double rest=paid-b.getAmount();
                b.setPaid(true);
                System.out.println("you paid more than the required amount, do not forget to take the rest:"+rest+"$ "+"please");
            }
            else if(paid==b.getAmount()){
                b.setPaid(true);
                System.out.println("the bill has been paid successfully!");
            }
            else {
                double newAmount=b.getAmount()-paid;
                b.setAmount(newAmount);
                System.out.println("there is"+newAmount+"$"+" remaining..");
            }
        }
    }

    public List<Bill> patientBills(int patientId){
        List<Bill>b=new ArrayList<>();
        for (Bill bill:bills )
            if(bill.getPatientId()==patientId)
                b.add(bill);
        return b;
    }

                                         //getters
    public List<Person> getPeople() {
        return people;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Departement> getDepartments() {
        return departments;
    }
}
