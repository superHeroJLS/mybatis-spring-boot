package tk.mybatis.springboot;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.ClassUtils;

/**
 * 用来修改bean的名字生成规则， 修改默认的名字生成规则， 让它们生成的名字不再重复。</br>
 * 原来的生成规则是小驼峰；修改之后的生成规则是小驼峰加序号
 * 
 * @author Administrator
 *
 */
public class MapperNameGenerator implements BeanNameGenerator {
	private Map<String, Integer> nameMap = new HashMap<>();

	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		String shortName = ClassUtils.getShortName(definition.getBeanClassName());
		String beanName = Introspector.decapitalize(shortName);
		if(nameMap.containsKey(beanName)) {
			int index = nameMap.get(beanName) + 1;
			nameMap.put(beanName, index);
			
			beanName += index;
		} else {
			nameMap.put(beanName, 1);
		}
		return beanName;
	}

}
