package product;

import java.util.List;

public interface ProductService {
	//서비스인터페이스에서는 메소드이름 xml내 id랑 동일할 필요 없음
	//그래도 헷갈리니까 DAO내 메소드이름이랑 동일하게 하기
	//DAO 에 있는 메소드 복붙해도될듯
	public List<ProductVO> productList();
	public ProductVO productOne(String prdNo);
	public void productInsert(ProductVO vo);
	public void productUpdate(ProductVO vo);
	public void productDelete(int prdStock);
}
