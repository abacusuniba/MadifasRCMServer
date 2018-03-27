package b_tiers.a_presentation.b_dispatcher.forms.controller;

import c_dto.a_abstract.DTOBase;

public interface IController {
	
	public void injectElement(DTOBase dto);
	
	public void reloadTables();
	
	public void discard();
	
	
}
