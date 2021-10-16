package product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductDAO {
	//product-mapping.xml 각 태그의 id 값과 동일한 메소드 정의
	//resultType ProductVO 임, 리스트 전체 가져와야해서 List<ProductVO> 로 정의
	public List<ProductVO> productList();//resultType 있으면 리턴타입 명시, parameterType 없으면 매개변수도 필료없음
	public ProductVO productOne(String prdNo);
	public void productInsert(ProductVO vo);//resultType 없으면 void 
	public void productUpdate(ProductVO vo);
	public void productDelete(int prdStock);
	
}
