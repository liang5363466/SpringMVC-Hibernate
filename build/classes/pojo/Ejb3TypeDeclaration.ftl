<#if ejb3?if_exists>
<#if pojo.isComponent()>
@${pojo.importType("javax.persistence.Embeddable")}
<#else>
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
@${pojo.importType("javax.persistence.Entity")}(name="${clazz.table.name}"
<#if clazz.table.schema?exists>
    ,schema="${clazz.table.schema}"
</#if><#if clazz.table.catalog?exists>
    ,catalog="${clazz.table.catalog}"
</#if>
<#assign uniqueConstraint=pojo.generateAnnTableUniqueConstraint()>
<#if uniqueConstraint?has_content>
    , uniqueConstraints = ${uniqueConstraint} 
</#if>)
</#if>
</#if>