package com.zee.zee5app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingRepository extends PhysicalNamingStrategyStandardImpl {
private final static String POSTFIX="_TABLE";
//by default all the tables should be ended with name _table
@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		// TODO Auto-generated method stub
	if(identifier==null)
	{
		return null;
	}
		final String newName=identifier.getText()+POSTFIX;
		//get table name -if table annotation name is present it uses that
		//if table is not present is uses entity name else class name as entity
		return identifier.toIdentifier(newName);
	}
@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		if(name==null)
			return null;
		return Identifier.toIdentifier(name.getText().toLowerCase());
	}
}
