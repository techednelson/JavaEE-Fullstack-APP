package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SElECT e FROM Employee e")
})
@Table(name = "employee")
public class Employee  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Pattern(regexp = "^\\b\\pL+(?:-\\pL+)*\\b")
    @Size(min = 3, max = 15)
    @NotNull
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "^\\b\\pL+(?:-\\pL+)*\\b")
    @Size(min = 3, max = 15)
    @NotNull
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    @Column(name = "birth_date")
    private String birthDate;

    @Pattern(regexp = "^\\d+")
    @Size(min = 10, max = 10)
    @NotNull
    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @NotNull
    @NotEmpty
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "^\\d+")
    @Size(max = 4)
    @NotNull
    @NotEmpty
    @Column(name = "salary")
    private String salary;

    @NotNull
    @NotEmpty
    @Column(name = "join_date")
    private String joinDate;

    @Embedded
    @Valid
    private Address address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_department_id", referencedColumnName = "department_id")
    private Department department;

    public Employee() { }

    public Employee(String firstName, String lastName, String birthDate, Address address, String phoneNumber, String email, String salary, Department department, String joinDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.joinDate = joinDate;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSalary() { return salary; }

    public void setSalary(String salary) { this.salary = salary; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    public String getJoinDate() { return joinDate; }

    public void setJoinDate(String joinDate) { this.joinDate = joinDate; }

}