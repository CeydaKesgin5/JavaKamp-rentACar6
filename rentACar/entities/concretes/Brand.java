package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="brands") //Tablo olarak "Table" a karşılık geliyorsun
@Data //GETTER SETTERLARI OLUŞTuRUYOR
@AllArgsConstructor //parametresiz constructer oluşturuyor
@NoArgsConstructor //parametresiz constructer oluşturuyor
@Entity //Sen bir veri tabanı varlığısın
public class Brand {
    @Id//primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) //ıd veri tabanı tarafından otomatik olarak arttırılıyor.
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;




}
