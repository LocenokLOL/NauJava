package Configuration;

import java.util.ArrayList;
import java.util.List;

import Classes.Dish;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config
{
    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Dish> dishesContainer()
    {
        return new ArrayList<>();
    }
}

