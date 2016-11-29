package com.mogikanensoftware.scheduling.config;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.mogikanensoftware.scheduling.job.MyLoggingJob;

@Configuration
public class JobConfig {

	@Bean
	public JobDetailFactoryBean getLogginJob() {

		JobDetailFactoryBean jdFactoryBean = new JobDetailFactoryBean();
		jdFactoryBean.setJobClass(MyLoggingJob.class);
		return jdFactoryBean;
	}

	@Bean
	public SimpleTriggerFactoryBean getLoggingTrigger() {

		SimpleTriggerFactoryBean stFactoryBean = new SimpleTriggerFactoryBean();
		stFactoryBean.setJobDetail(this.getLogginJob().getObject());
		stFactoryBean.setStartDelay(5000);
		stFactoryBean.setRepeatInterval(10000);
		return stFactoryBean;
	}

	@Bean
	public SchedulerFactoryBean getQurtzSchedulerFactoryBean(){
		
		SchedulerFactoryBean scFactoryBean = new SchedulerFactoryBean();
		scFactoryBean.setTriggers(this.getLoggingTrigger().getObject());
		scFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
		scFactoryBean.setDataSource(this.getDataSource());
		return scFactoryBean;
		
	}
	
	private static final String TMP_DIR = System.getProperty("java.io.tmpdir");

    @Bean
    public DataSource getDataSource() {

    	JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:"+TMP_DIR+"/test");

        return ds;
    }
}
