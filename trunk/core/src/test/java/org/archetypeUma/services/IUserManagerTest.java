package org.archetypeUma.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.dao.interfaces.IUserDao;
import org.archetypeUma.model.pojos.City;
import org.archetypeUma.model.pojos.User;
import org.archetypeUma.service.implementation.UserManagerImpl;
import org.archetypeUma.service.interfaces.IUserManager;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class IUserManagerTest {

    // Mock context
    private Mockery      context     = new Mockery();

    private IUserManager userManager = null;

    private IUserDao     userDao     = context.mock(IUserDao.class);
    private ICityDao     cityDao     = context.mock(ICityDao.class);

    @Before
    public void setUp() {
        userManager = new UserManagerImpl();
        userManager.setUserDao(userDao);
        userManager.setCityDao(cityDao);
    }

    @Test
    public void testGetAll() {
        final List<User> usuarios = new ArrayList<User>();
        usuarios.add(new User("jcisneros", "javier"));
        context.checking(new Expectations() {
            {
                one(userDao).getAll();
                will(returnValue(usuarios));
            }
        });
        assertEquals(userManager.getAll(), usuarios);
        context.assertIsSatisfied();
    }

    @Test
    public void testGetAllCity() {
        final List<City> cities = new ArrayList<City>();
        cities.add(new City("MA", "Málaga"));
        context.checking(new Expectations() {
            {
                one(cityDao).getAll();
                will(returnValue(cities));
            }
        });
        assertEquals(userManager.getAllCity(), cities);
        context.assertIsSatisfied();
    }

    // Getters && Setters

}
