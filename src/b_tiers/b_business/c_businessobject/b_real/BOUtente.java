package b_tiers.b_business.c_businessobject.b_real;


//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import a_main.RCMException;
import b_tiers.b_business.c_businessobject.a_abstract.NewBOBase;
import b_tiers.c_integration.a_dao.DAO;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.b_real.Administrator;
import c_dto.b_real.Employee;
import c_dto.b_real.Manager;
import c_dto.b_real.Utente;
import c_dto.c_enum.TipoUtente;
import d_utils.StringBuilderQuery;

public class BOUtente extends NewBOBase<Utente>{
	
	public void findUser(Utente u){
		
//		Iterator<Entry<Integer, DTOBase>> i = getMemory().entrySet().iterator();
//		
//		while(i.hasNext() & user==null){
////			user=(Utente) i.next().getValue();
//			
//			if (user.getUsername().equals(u) & user.getPassword().equals(p))
//				user=(Utente) getDao().read(user);
//			else
//				user=null;
//		}
		
		
		StringBuilderQuery query = new StringBuilderQuery(" select * from utente where username=? and password=?;");
		query.setValue(1, u.getUsername());
		query.setValue(2, u.getPassword());
		
		ResultSet rs = DAO.executeQuery(query.toString());
		try {
			if (rs.next()){
				
				TipoUtente t = TipoUtente.fromValue(rs.getInt("tipo"));
				
//				switch (t){
//				case Administrator:
//					u= new Administrator();
//					break;
//				case Manager:
//					u= new Manager();
//					break;
//				case Employee:
//					u= new Employee();
//					break;
//				}
				u.setId(rs.getLong("id"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				u.setTipoUtente(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RCMException.showException(e);
		}
		
	}

//	@Override
//	public void create(DTOBase o) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void read(DTOBase o) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public ArrayList<? extends DTOBase> readAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public void update(DTOBase o) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void delete(DTOBase o) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
