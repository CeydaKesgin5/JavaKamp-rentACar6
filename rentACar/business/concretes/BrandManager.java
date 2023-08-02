package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //BU SINIF BİR BUSNESS NESNESİDİR
@AllArgsConstructor
public class BrandManager implements BrandService {
   private BrandRepository brandRepository;
   private ModelMapperService modelMapperService;

    public BrandManager(BrandRepository brandRepository) {
        //injection
        super();
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand>brands=brandRepository.findAll();//içinde markaların olduğu liste
        /*List<GetAllBrandsResponse> brandsResponse=new ArrayList<GetAllBrandsResponse>();//boş liste

        //mapping işlemi
        for (Brand brand:brands){//ana listeyi dolaştık
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());

            brandsResponse.add(responseItem);

        }*/
        List<GetAllBrandsResponse> brandsResponse=
                brands.stream().map(brand-> this.modelMapperService.forResponse().
                        map(brand,GetAllBrandsResponse.class)).//her bir brand ı GetAllBrandsResponse.class a çevir
                        collect(Collectors.toList());//bunları topla List e çevir
        //stream elimizde liste varsa onu tek tek dolaşmamızı sağlıyor foreach ın yaptığını yapıyor.
        // Dolaşırken her bir brand için bir mapleme yap
        //yukarıdaki işlemin yaptığını yapıyor fakat işlem fazlalığından bizi kurtardı.
        return brandsResponse;
        //iş kuralları
        //findAll JpaRepository içinden gelen bir fonksiyon
    }



    @Override
    public void add(CreateBrandRequest createBrandRequest) {
       // Brand brand=new Brand();
        //brand.setName(createBrandRequest.getName());
        Brand brand =this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        //verinin olduğu kaynak createBrandRequest
        //createBrandRequest brand e çevirip veri tabanı nesnesine çeviriyoruz
        //yukarıdaki uzun işlemlerden bizi kurtardı
        this.brandRepository.save(brand);


        //veri tabanı brand den alınıyor
    }
    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }
    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand =this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
