package com.ndsoft.cms.api;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
  
public class HibernateAwareObjectMapper extends ObjectMapper {
  
	private static final long serialVersionUID = -1766854448830422994L;

	public HibernateAwareObjectMapper() {
        //Hibernate4Module hm = new Hibernate4Module();
       // registerModule(hm);
    }
}