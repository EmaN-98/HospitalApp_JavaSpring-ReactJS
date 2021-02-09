package ro.tuc.ds2020.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ro.tuc.ds2020.medication.MedicationService;
import ro.tuc.ds2020.medication.MedicationServiceImpl;

@EnableWebMvc
@Configuration
public class AppConfig {

    @Bean
    public MedicationService medicationService() {
        return new MedicationServiceImpl();
    }

    @Bean(name = "/MedicationService")
    public RemoteExporter exporter() {
        HttpInvokerServiceExporter hse = new HttpInvokerServiceExporter();
        hse.setService(medicationService());
        hse.setServiceInterface(MedicationService.class);
        return hse;
    }
}