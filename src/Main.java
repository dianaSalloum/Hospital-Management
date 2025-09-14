import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1, "Taj", 27, "female", "123456789", "Oncologist", 1000.0, 3, 50.0);
        Staff staff1 = new Staff(1, "John", 20, "male", "987564321", "responsible of cleaning section", 200);
        Departement department1 = new Departement(1, "Oncology");
        Hospital hospital = new Hospital(List.of(doctor1), List.of(staff1), List.of(department1));
        boolean controller = true;
        while (controller) {
            System.out.println("press 1 if you want to add/remove a (doctor-patient-staff)");
            System.out.println("press 2 if you want to find a (doctor-patient-staff) by id");
            System.out.println("press 3 if you want to see the people:(doctors/staff/patients)in the hospital");
            System.out.println("press 4 if you want to add a department");
            System.out.println("press 5 if you want to add an -existing- doctor or a patient to a department");
            System.out.println("press 6 if you want to see all doctors/patients in a department");
            System.out.println("press 7 if you want to add/cancel an appointment");
            System.out.println("press 8 if you want to see the appointments that a doctor/patient has");
            System.out.println("press 9 if you want to pay a bill");
            System.out.println("press 10 if you want to see a patient/'s bills");
            System.out.println("press 0 to close the project!");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("if you want to add choose (1) if you want to remove choose (0)");
                    int test=scanner.nextInt();
                    if(test==1)
                    {
                        System.out.println("please choose-by number- what to add 1.Doctor 2.Patient 3.Staff");
                        int test01=scanner.nextInt();
                        if(test01==1){
                            System.out.println("enter the doctor/'s id");
                            int id=scanner.nextInt();
                            System.out.println("enter the doctor/'s name");
                            scanner.nextLine();
                            String name=scanner.nextLine();
                            System.out.println("enter the doctor/'s age");
                            int age=scanner.nextInt();
                            System.out.println("enter the doctor/'s gender");
                            scanner.nextLine();
                            String gender=scanner.nextLine();
                            System.out.println("enter the doctor/'s phone number");
                            String phone=scanner.nextLine();
                            System.out.println("enter the doctor/'s specialization");
                            String specialization=scanner.nextLine();
                            System.out.println("enter the doctor/'s salary");
                            double salary=scanner.nextDouble();
                            System.out.println("enter the years of experience");
                            int yearsOfExperience=scanner.nextInt();
                            System.out.println("enter the doctor/'s consultation fee");
                            double consultationFee=scanner.nextDouble();
                            hospital.addDoctor(id,name,age,gender,phone,specialization,salary,yearsOfExperience,consultationFee);
                        }
                        else if (test01==2){
                            System.out.println("enter the patient/'s id");
                            int id=scanner.nextInt();
                            System.out.println("enter the patient/'s name");
                            scanner.nextLine();
                            String name=scanner.nextLine();
                            System.out.println("enter the patient/'s age");
                            int age=scanner.nextInt();
                            System.out.println("enter the patient/'s gender");
                            scanner.nextLine();
                            String gender=scanner.nextLine();
                            System.out.println("enter the patient/'s phone number");
                            String phone=scanner.nextLine();
                            System.out.println("enter the medical history of this patient");
                            String medical=scanner.nextLine();
                            System.out.println("enter the patient/'s blood type");
                            String blood=scanner.nextLine();
                            System.out.println("enter the patient/'s address");
                            String address=scanner.nextLine();
                            hospital.addPatient(id,name,age,gender,phone,medical,blood,address);
                        }
                        else if(test01==3){
                            System.out.println("enter the staff/'s id");
                            int id=scanner.nextInt();
                            System.out.println("enter the staff/'s name");
                            scanner.nextLine();
                            String name=scanner.nextLine();
                            System.out.println("enter the staff/'s age");
                            int age=scanner.nextInt();
                            System.out.println("enter the staff/'s gender");
                            scanner.nextLine();
                            String gender=scanner.nextLine();
                            System.out.println("enter the staff/'s phone number");
                            String phone=scanner.nextLine();
                            System.out.println("enter the staff/'s position");
                            String position=scanner.nextLine();
                            System.out.println("enter the staff/'s salary");
                            double salary=scanner.nextDouble();
                            hospital.addStaff(id,name,age,gender,phone,position,salary);
                        }
                        else
                            System.out.println("wrong!!!!");
                        break;}
                    else if (test==0){
                        System.out.println("please choose-by number- what to remove 1.Doctor 2.Patient 3.Staff");
                        int test01=scanner.nextInt();
                        if(test01==1){
                            System.out.println("enter the doctor/'s id");
                            int id=scanner.nextInt();
                            hospital.removeDoctor(id);
                        }
                        else if (test01==2){
                            System.out.println("enter the patient/'s id");
                            int id=scanner.nextInt();
                            hospital.removePatient(id);
                        }
                        else if(test01==3){
                            System.out.println("enter the staff/'s id");
                            int id=scanner.nextInt();
                            hospital.removeStaff(id);
                        }
                        else
                            System.out.println("wrong!!!!");
                        break;}
                case 2:
                    System.out.println("choose by number what to find 1.Doctor 2.Patient 3.Staff");
                    int test02=scanner.nextInt();
                    if (test02==1){
                        System.out.println("enter the doctor/'s id");
                        int id=scanner.nextInt();
                        System.out.println(hospital.findDoctor(id));
                    }
                    else if (test02==2){
                        System.out.println("enter the patient/'s id");
                        int id =scanner.nextInt();
                        System.out.println(hospital.findPatient(id));
                    }
                    else if(test02==3){
                        System.out.println("enter the staff/'s id");
                        int id=scanner.nextInt();
                        System.out.println(hospital.findStaff(id));
                    }
                    else
                        System.out.println("wrong!!!!");
                    break;
                case 3:
                    System.out.println("choose 1.to see all people/2.to see all doctors/3.to see all patients/4.to see all staff");
                    int test03=scanner.nextInt();
                    if (test03==1)
                        System.out.println(hospital.getPeople());
                    else if(test03==2)
                        System.out.println(hospital.getDoctors());
                    else if(test03==3)
                        System.out.println(hospital.getPatients());
                    else if (test03==4)
                        System.out.println(hospital.getStaff());
                    else
                        System.out.println("wrong!!!!");
                    break;
                case 4:
                    System.out.println("enter the department id");
                    int id=scanner.nextInt();
                    System.out.println("enter the department/'s name");
                    scanner.nextLine();
                    String name=scanner.nextLine();
                    hospital.addDepartment(id,name);
                    break;
                case 5:
                    System.out.println("if you want to add: doctor press (1)/ patient press(2) ");
                    int test05=scanner.nextInt();
                    if(test05==1){
                        System.out.println("enter the department id");
                        int dep=scanner.nextInt();
                        System.out.println("enter the doctor/'s id");
                        int doc=scanner.nextInt();
                        hospital.addDoctorToDepartment(dep,doc);
                    }
                    else if(test05==2){
                        System.out.println("enter the department id");
                        int dep=scanner.nextInt();
                        System.out.println("enter the patient/'s id");
                        int idp=scanner.nextInt();
                        System.out.println("enter the patient/'s name");
                        scanner.nextLine();
                        String nameP=scanner.nextLine();
                        System.out.println("enter the patient/'s age");
                        int age=scanner.nextInt();
                        System.out.println("enter the patient/'s gender");
                        scanner.nextLine();
                        String gender=scanner.nextLine();
                        System.out.println("enter the patient/'s phone number");
                        String phone=scanner.nextLine();
                        System.out.println("enter the medical history of this patient");
                        String medical=scanner.nextLine();
                        System.out.println("enter the patient/'s blood type");
                        String blood=scanner.nextLine();
                        System.out.println("enter the patient/'s address");
                        String address=scanner.nextLine();
                        hospital.addPatientToDepartment(dep,idp,nameP,age,gender,phone,medical,blood,address);
                    }
                    else
                        System.out.println("wrong!!!!");
                    break;
                case 6:
                    System.out.println("if you want to see: doctors press (1)/ patients press(2) ");
                    int test06=scanner.nextInt();
                    if(test06==1){
                        System.out.println("enter the department/'s id");
                    int departmentId=scanner.nextInt();
                        System.out.println(hospital.doctorsInDepartment(departmentId));}
                    else if(test06==2){
                        System.out.println("enter the department/'s id");
                        int departmentId=scanner.nextInt();
                        System.out.println(hospital.patientsInDepartment(departmentId));
                    }
                    else
                        System.out.println("wrong!!!!");
                    break;
                case 7:
                    System.out.println("enter 1 if you want to add an appointment /press 0 if you want to cancel one");
                    int test07=scanner.nextInt();
                    if(test07==1){
                        System.out.println("enter the appointment/'s id");
                        int appointmentId=scanner.nextInt();
                        System.out.println("enter the day");
                        int day=scanner.nextInt();
                        System.out.println("enter the month");
                        int month=scanner.nextInt();
                        System.out.println("enter the year");
                        int year=scanner.nextInt();
                        System.out.println("enter the hour");
                        int hour=scanner.nextInt();
                        System.out.println("enter the minute");
                        int minute=scanner.nextInt();
                        LocalDateTime date=LocalDateTime.of(year,month,day,hour,minute);
                        System.out.println("enter the doctor/'s id");
                        int id1=scanner.nextInt();
                        System.out.println("enter the doctor/'s name");
                        scanner.nextLine();
                        String name1=scanner.nextLine();
                        System.out.println("enter the doctor/'s age");
                        int age=scanner.nextInt();
                        System.out.println("enter the doctor/'s gender");
                        scanner.nextLine();
                        String gender=scanner.nextLine();
                        System.out.println("enter the doctor/'s phone number");
                        String phone=scanner.nextLine();
                        System.out.println("enter the doctor/'s specialization");
                        String specialization=scanner.nextLine();
                        System.out.println("enter the doctor/'s salary");
                        double salary=scanner.nextDouble();
                        System.out.println("enter the years of experience");
                        int yearsOfExperience=scanner.nextInt();
                        System.out.println("enter the doctor/'s consultation fee");
                        double consultationFee=scanner.nextDouble();
                        Doctor d=new Doctor(id1,name1,age,gender,phone,specialization,salary,yearsOfExperience,consultationFee);
                        System.out.println("enter the patient/'s id");
                        int id2 =scanner.nextInt();
                        System.out.println("enter the patient/'s name");
                        scanner.nextLine();
                        String name2=scanner.nextLine();
                        System.out.println("enter the patient/'s age");
                        int age2=scanner.nextInt();
                        System.out.println("enter the patient/'s gender");
                        scanner.nextLine();
                        String gender2=scanner.nextLine();
                        System.out.println("enter the patient/'s phone number");
                        String phone2=scanner.nextLine();
                        System.out.println("enter the medical history of this patient");
                        String medical=scanner.nextLine();
                        System.out.println("enter the patient/'s blood type");
                        String blood=scanner.nextLine();
                        System.out.println("enter the patient/'s address");
                        String address=scanner.nextLine();
                        Patient p=new Patient(id2,name2,age2,gender2,phone2,medical,blood,address);
                        hospital.addAppointment(appointmentId,date,d,p);
                    }
                    else if(test07==0){
                        System.out.println("enter the id of the appointment you want to cancel");
                        int cancel=scanner.nextInt();
                        hospital.cancelAppointment(cancel);
                    }
                    else
                        System.out.println("wrong!!!!");
                    break;
                case 8:
                    System.out.println("choose (1)if you want to see the appointments that a doctor has and (2) for the patient");
                    int test08=scanner.nextInt();
                    if (test08==1){
                        System.out.println("enter the doctor/'s id");
                        int docId=scanner.nextInt();
                        System.out.println(hospital.doctorAppointments(docId));
                    }
                    else if(test08==2){
                        System.out.println("enter the patient/'s id");
                        int patId=scanner.nextInt();
                        System.out.println(hospital.patientAppointments(patId));
                    }
                    else
                        System.out.println("wrong!!!!");
                    break;
                case 9:
                    System.out.println("enter the bill/'s id");
                    int bill=scanner.nextInt();
                    System.out.println("enter the amount of money you will pay");
                    double pay=scanner.nextDouble();
                    hospital.payBill(bill,pay);
                    break;
                case 10:
                    System.out.println("enter the patient/'s id");
                    int i=scanner.nextInt();
                    System.out.println(hospital.patientBills(i));
                    break;
                case 0:
                    System.out.println("thank you! hope you found this useful!");
                    controller=false;
                    break;
                default:
                    System.out.println("you entered a wrong number try again please!!");
            }
        }
    }
}