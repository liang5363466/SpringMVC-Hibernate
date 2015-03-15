<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
 ${pojo.generateAnnIdGenerator()}
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_${clazz.table.name}")
 @SequenceGenerator(name = "S_${clazz.table.name}", allocationSize = 1, initialValue = 1, sequenceName = "S_${clazz.table.name}")
<#-- if this is the id property (getter)-->
<#-- explicitly set the column name for this property-->
</#if>
</#if>

<#if c2h.isOneToOne(property)>
${pojo.generateOneToOneAnnotation(property, cfg)}
<#elseif c2h.isManyToOne(property)>
${pojo.generateManyToOneAnnotation(property)}
<#--TODO support optional and targetEntity ${pojo.generateJoinColumnsAnnotation(property, cfg)}-->    

<#elseif c2h.isCollection(property)>
${pojo.generateCollectionAnnotation(property, cfg)}
<#else>
${pojo.generateBasicAnnotation(property)}
${pojo.generateAnnColumnAnnotation(property)}
</#if>
</#if>