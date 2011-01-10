#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.interfaces;

import ${package}.model.pojos.User;

/**
 *
 * @author jcisneros
 */
public interface IUserDao extends IBaseDao<User, Long> {

}
