package com.xuewuzhijing.springboot.system.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Aspect
@Configuration
public class TransactionAdviceConfig{
    @Autowired
    private DataSourceTransactionManager transactionManager;
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com..service.impl.*.*(..))";

    @Bean
    public TransactionInterceptor txAdvice(){
        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
        /* transactiondefinition 定义事务的隔离级别 PROPAGATION_REQUIRED事务传播级别1，支持当前事务，如果当前没有事务，就新建一个事务*/
        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
        /* transactiondefinition 定义事务的隔离级别 PROPAGATION_REQUIRED事务传播级别1，支持当前事务，如果当前没有事务，就新建一个事务*/
        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        /*只读事务，不做更新操作*/
        txAttr_REQUIRED_READONLY.setReadOnly(true);

        /*事务管理规则，声明具备事务管理的方法名*/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", txAttr_REQUIRED);
        source.addTransactionalMethod("insert*", txAttr_REQUIRED);
        source.addTransactionalMethod("save*", txAttr_REQUIRED);
        source.addTransactionalMethod("delete*", txAttr_REQUIRED);
        source.addTransactionalMethod("remove*", txAttr_REQUIRED);
        source.addTransactionalMethod("update*", txAttr_REQUIRED);
        source.addTransactionalMethod("exec*", txAttr_REQUIRED);
        source.addTransactionalMethod("set*", txAttr_REQUIRED);
        /*select,query开头的方法,开启只读,提高数据库访问性能*/
        source.addTransactionalMethod("get*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("select*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("query*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("find*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("search*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("list*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("is*", txAttr_REQUIRED_READONLY);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        /* 声明切点的面：切面就是通知和切入点的结合。通知和切入点共同定义了关于切面的全部内容——它的功能、在何时和何地完成其功能*/
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        /*声明和设置需要拦截的方法,用切点语言描写*/
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        /*设置切面=切点pointcut+通知TxAdvice**/
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
