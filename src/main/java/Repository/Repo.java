package Repository;
import Emtity.root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public class Repo {
    public interface UserRepository extends JpaRepository<root, Long>,
            JpaSpecificationExecutor<root> {
    }

}
