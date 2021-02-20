
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import medication.MedicationBean;
import medication.MedicationService;

@Configuration
public class RunMedication {

	
    @Bean
    public MedicationBean medicationBean() {
        return new MedicationBean();
    }

    @Bean
    public HttpInvokerProxyFactoryBean exporter() {
        HttpInvokerProxyFactoryBean b = new HttpInvokerProxyFactoryBean();
        b.setServiceUrl("https://....herokuapp.com/...");
        b.setServiceInterface(MedicationService.class);
        return b;
    }

    public static void main(String[] args) {
    	
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RunMedication.class);
       
        MedicationBean bean = context.getBean(MedicationBean.class);
        bean.getMedicationPlan();
    }

}