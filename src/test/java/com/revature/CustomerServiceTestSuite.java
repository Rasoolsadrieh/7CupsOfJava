package com.revature;

import com.revature.movieapp.customer.Customer;
import com.revature.movieapp.customer.CustomerDao;
import com.revature.movieapp.customer.CustomerServices;
import com.revature.movieapp.util.exceptions.AuthenticationException;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CustomerServiceTestSuite {

    CustomerServices sut;
    CustomerDao mockCustomerDao;

    @BeforeEach
    public void testPrep(){
        // in order to specify and mock a dao
        mockCustomerDao = mock(CustomerDao.class);
        sut = new CustomerServices(mockCustomerDao);
    }

    @Test
    public void test_validateInput_givenValidCustomer_returnTrue(){

        // Arrange
       Customer trainer = new Customer("valid", "valid", "valid","valid","valid", 1);

        // Act
        boolean actualResult = sut.validateInput(trainer);

        // Assert
        Assertions.assertTrue(actualResult);

    }

    @Test
    public void test_create_givenValidUser_returnsCustomer(){
        // Arrange
        Customer customer = new Customer("valid", "valid", "valid", "valid", "valid", 1);
        // THe below code ensures that the services can continue execution and get expected results from the dao without any issues
        when(mockCustomerDao.save(customer)).thenReturn(customer);

        // Act
       Customer actualCustomer = sut.create(customer);

        // Assert
        Assertions.assertEquals("pie", actualCustomer.getFname());
        Assertions.assertEquals("pie", actualCustomer.getLname());
        Assertions.assertEquals("pie", actualCustomer.getPassword());
        Assertions.assertEquals("pie", actualCustomer.getEmail());
        Assertions.assertEquals("pie", actualCustomer.getDob());
        Assertions.assertEquals(1, actualCustomer.getBalance());
        // Mockito is verifying that the creation method was execute only once!
        verify(mockCustomerDao, times(1)).save(customer);
    }
    @Test
    public void test_create_givenInvalidUser_throwsInvalidRequestException(){
        // Arrange
       Customer customer = new Customer("pie", "", "pie","pie","pie",1);
        when(mockCustomerDao.save(customer)).thenReturn(customer);


        // Assert
        Assertions.assertThrows(InvalidRequestException.class, () -> { sut.create(customer); });
        verify(mockCustomerDao, times(0)).save(customer);
    }

    @Test
    public void test_create_givenRepeatedUserInformation_throwsInvalidRequestException(){
        Customer customer = new Customer("pie", "", "pie","pie","pie", 1);
        when(mockCustomerDao.existsById(customer.getEmail())).thenReturn(true);


        // Assert
        Assertions.assertThrows(InvalidRequestException.class, () -> { sut.create(customer);});
        verify(mockCustomerDao, times(0)).save(customer);
    }

    @Test
    public void test_authenticateTrainer_givenInvalidInformation_throwsAuthenticationException(){
       Customer customer = new Customer("pie", "", "pie","pie","pie",1);
        when(mockCustomerDao.authenticateCustomer(customer.getEmail(),customer.getPassword())).thenReturn(null);


        Assertions.assertThrows(AuthenticationException.class, () -> { sut.authenticateCustomer(customer.getEmail(), customer.getPassword());});
        verify(mockCustomerDao, times(1)).authenticateCustomer(customer.getEmail(), customer.getPassword());
    }

}
