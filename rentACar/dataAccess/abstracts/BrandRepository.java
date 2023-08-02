package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
//JpaRepository bize getAll, add,delete,findById gibi fonksiyonları sağlıyor
}
