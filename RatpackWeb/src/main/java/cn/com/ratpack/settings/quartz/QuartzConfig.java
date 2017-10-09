package cn.com.ratpack.settings.quartz;

import cn.com.ratpack.Job.SampleJob;
import org.quartz.JobDetail;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.text.ParseException;

import static org.quartz.JobBuilder.newJob;
@Configurable
public class QuartzConfig {

    @Autowired
    @Bean
    public SchedulerFactoryBean SchedulerFactoryBean(DataSource dataSource) throws ParseException {

        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setDataSource(dataSource);

        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/config/quartz.properties"));
        try {
            propertiesFactoryBean.afterPropertiesSet();
            bean.setQuartzProperties(propertiesFactoryBean.getObject());
        } catch (IOException e) {
            e.printStackTrace();
        }
        bean.setSchedulerName("IPCC");
        bean.setStartupDelay(10);
        bean.setApplicationContextSchedulerContextKey("applicationContextKey");
        bean.setOverwriteExistingJobs(true);
        bean.setAutoStartup(true);

        JobDetail job = newJob(SampleJob.class).withDescription("任务描述").withIdentity("job1", "group1").storeDurably().build();

        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setName("trigger1");
        cronTrigger.setGroup("group1");
        // 每隔几秒执行一次
        cronTrigger.setCronExpression("*/5 * * * * ?");
        cronTrigger.setJobKey(job.getKey());

        bean.setTriggers(cronTrigger);
        bean.setJobDetails(job);

        return bean;
    }
}
