/**
 * User class to add technician variables
 * including constructors, getters, and setters
 * © November 1, 2017 author Sarah Bean
 */
package business;

import java.io.Serializable;

//Private variables for registration as new user

/**
 *
 * @author Sarah
 */
public class Tech implements Serializable {

    private int techId;
    private String firstName;
    private String lastName;
    private String password;

    //Zero Argument Constructor

    /**
     *
     */
    public Tech() {
        firstName = "";
        lastName = "";
        password = "";
    }

    //Constructor

    /**
     *
     * @param firstName
     * @param lastName
     * @param password
     */
    public Tech(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    //Get and set methods for all variables to be inputed    

    /**
     *
     * @return
     */
    public int getTechId() {
        return techId;
    }

    /**
     *
     * @param techId
     */
    public void setTechId(int techId) {
        this.techId = techId;

    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;

    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
