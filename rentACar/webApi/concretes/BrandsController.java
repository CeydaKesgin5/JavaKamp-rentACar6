package kodlama.io.rentACar.webApi.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation bilgilendirme
//Spring framework bu uygulamayı derlediğinde veya çalışırken RestController i görünce burasının erişim noktası olduğunu anlıyor.
@RequestMapping("/api/brands") //bu yöntem ile iletişim kuruyor
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;
    @Autowired //git parametrelerine bak---->brandService
    // git uygulamayı tara ---> kim bu brandService'yi implemente ediyor
    // BrandManager implemente ediyor. Onun new lenmiş halini bana ver
    // BrandManager brandManager=new BrandManager(new InMemoryBrandRepository()); anlamına geliyor
    @GetMapping()
    //@GetMapping("/getall") //www.kodlama.io/api/brands//getAll
    public List<GetAllBrandsResponse> getAll(){
        //IoC -->Inversion of Control -->sürekli new leme işleminden kurtarıyor//1 kere new liyor herkes onu kullanıyor
        // @Service anatasyonunu kullanarak

        return brandService.getAll();
    }
    @GetMapping("/{id}")

    public GetByIdBrandResponse getById(int id){

        return brandService.getById(id);
    }

    @PutMapping//güncelleme

    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);

    }


    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    //@PostMapping("/add")
    public void add(@RequestBody() CreateBrandRequest createBrandRequest){

        this.brandService.add(createBrandRequest);
    }
}
