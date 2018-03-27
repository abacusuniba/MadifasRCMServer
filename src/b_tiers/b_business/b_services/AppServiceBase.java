package b_tiers.b_business.b_services;

//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;

import java.lang.reflect.Method;

import a_main.RCMException;
import c_dto.Command;
//import c_dto.Command;
import b_tiers.b_business.a_businessDelegate.lookUpService.BusinessService;

public abstract class AppServiceBase implements BusinessService{
	
	
	
	@Override
	public Method getMethod(Command cmd) throws NoSuchMethodException{
		Method m=null;
		
		try {
			if (cmd.getDto()==null){
				m= this.getClass().getDeclaredMethod(cmd.getService().toString().toLowerCase(), null);
			}
			else{
				m= this.getClass().getDeclaredMethod(cmd.getService().toString().toLowerCase(), cmd.getDto().getClass());
			}
//		} catch (SecurityException e) {
		} catch (Exception e) {
			String lostMethod = cmd.getService().toString().toLowerCase();
			if (!lostMethod.equals("dimentica"))
			RCMException.showException(e);
		}
		
//		try {
//			m= this.getClass().getDeclaredMethod(cmd.getService().toString(), null);
//		} catch (NoSuchMethodException | SecurityException e) {
//			try {
//				m= this.getClass().getDeclaredMethod(cmd.getService().toString(), cmd.getDto().getClass());
//			} catch (NoSuchMethodException | SecurityException e1) {
//				e1.printStackTrace();
//			}
//		}
		
		return m;

	}

}
