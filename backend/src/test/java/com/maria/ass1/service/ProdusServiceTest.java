
package com.maria.ass1.service;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.products.Type;
import com.maria.ass1.repository.ProdusRepoditory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProdusServiceTest {
@Mock
private ProdusRepoditory produsRepository;
@InjectMocks
private  ProdusRepoditory produsService;

@Test
 public void addProdus(){

   Product produs =new Product("bratara Ana", 969.8, "foarte frumoasa", "aur", 10, 2, Type.BRACELET) ;
    when(produsRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(produs);
    Product created=produs;
    assertThat(created.getName()).isSameAs(produs.getName());
    assertThat(created.getPrice()).isSameAs(produs.getPrice());
    assertThat(created.getDescription()).isSameAs(produs.getDescription());
    assertThat(created.getMaterial()).isSameAs(produs.getMaterial());
    assertThat(created.getSize()).isSameAs(produs.getSize());
    verify(produsRepository).save(created);
    }
    @Test
    public void getProdusById(){

        Product produs =new Product("bratara Ana", 969.8, "foarte frumoasa", "aur", 10, 2, Type.BRACELET) ;
        Product created = null;
        try{
            created = produs;
        }catch (Exception e) {
            assertThat(created.getName()).isSameAs(produs.getName());
            assertThat(created.getPrice()).isSameAs(produs.getPrice());
            assertThat(created.getDescription()).isSameAs(produs.getDescription());
            assertThat(created.getMaterial()).isSameAs(produs.getMaterial());
            assertThat(created.getSize()).isSameAs(produs.getSize());
        }
    }

}
