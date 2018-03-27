package b_tiers.b_business.a_businessDelegate.lookUpService;

import java.lang.reflect.Method;

import c_dto.Command;

public interface BusinessService {

	public Method getMethod (Command cmd) throws NoSuchMethodException;
	
}