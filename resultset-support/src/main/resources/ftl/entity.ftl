package io.github.pleuvoir.bean;

import java.io.Serializable;


public class Vo implements Serializable {
	
	
	<#list columnExtendList as columnExtend>
	private ${columnExtend.convertedType} ${columnExtend.field};
	
	</#list>
	
	// getter and setter
	
	<#list columnExtendList as columnExtend>
	public ${columnExtend.convertedType} get${columnExtend.field?cap_first}() {
		return ${columnExtend.field};
	}
	public void set${columnExtend.field?cap_first}(${columnExtend.convertedType} ${columnExtend.field}) {
		this.${columnExtend.field} = ${columnExtend.field};
	}
	</#list>

	
	
}
	