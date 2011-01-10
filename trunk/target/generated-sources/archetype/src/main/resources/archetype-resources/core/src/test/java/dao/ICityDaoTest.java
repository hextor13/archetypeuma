#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import ${package}.dao.interfaces.ICityDao;
import ${package}.model.pojos.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ICityDao.java class test.
 *
 * @author jcisneros
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring/applicationContext-resources.xml",
        "classpath:/spring/applicationContext-dao.xml" })
public class ICityDaoTest {

    @Autowired
    private ICityDao cityDao;

    /**
     * Test of getAll method.
     */
    @Test
    public void testGetAllCache() {
        List<City> cities = cityDao.getAllCache();
        assertEquals(3, cities.size());
    }

    // Getters & Setters

    public void setCityDao(ICityDao cityDao) {
        this.cityDao = cityDao;
    }

}
