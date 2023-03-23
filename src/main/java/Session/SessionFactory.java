package Session;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SessionFactory {
    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();


        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        return (SessionFactory) metadata.getSessionFactoryBuilder().build();
    }
}
